package ru.ulstu.persistence;

import ru.ulstu.entity.BaseEntity;

import java.io.IOException;
import java.util.List;

public abstract class PersistentStore<T extends BaseEntity> {
    private Class type;

    protected PersistentStore(Class type) {
        this.type = type;
    }

    public abstract List<T> save(List<T> entities) throws IOException;

    public abstract T save(T entity) throws IOException;

    public abstract List<T> readAll() throws IOException;

    public Class getType() {
        return type;
    }
}
