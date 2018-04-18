package ru.ulstu.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ulstu.entity.BaseEntity;
import ru.ulstu.util.PropertyManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileStore<T extends BaseEntity> extends PersistentStore<T> {
    private ObjectMapper mapper;
    private File storageFile;

    public FileStore(Class type) {
        super(type);
        this.mapper = new ObjectMapper();
        this.storageFile = new File(PropertyManager.getInstance().getFileStorage());
    }

    @Override
    public List<T> save(List<T> entities) throws IOException {
        mapper.writeValue(storageFile, entities);
        return entities;
    }

    @Override
    public T save(T entity) throws IOException {
        List<T> entities = readAll();
        entities.remove(entity);
        entity.setId(getGeneratedId(entities));
        entities.add(entity);
        save(entities);
        return entity;
    }

    private Long getGeneratedId(List<T> entities) {
        if (entities == null || entities.isEmpty()) {
            return 1L;
        }
        entities.sort(Comparator.comparing(BaseEntity::getId));
        Long lastId = entities.get(entities.size() - 1).getId();
        return lastId == null ? 1 : lastId + 1;
    }

    @Override
    public List<T> readAll() throws IOException {
        return mapper.readValue(storageFile, mapper.getTypeFactory().constructCollectionType(List.class, getType()));
    }


    public void reset() throws IOException {
        List<T> list = new ArrayList();
        save(list);
    }
}
