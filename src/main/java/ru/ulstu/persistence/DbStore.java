package ru.ulstu.persistence;

import ru.ulstu.entity.BaseEntity;

import java.util.List;

public class DbStore<T extends BaseEntity> extends PersistentStore<T> {

    public DbStore(Class type) {
        super(type);
    }

    @Override
    public List<T> save(List<T> entities) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public T save(T entity) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public List readAll() {
        throw new RuntimeException("not implemented yet");
    }
}
