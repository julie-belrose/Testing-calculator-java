package org.example.utils;

import java.util.List;
import java.util.UUID;

public interface GenericCrud<T> {
    T save(T entity);
    T findById(UUID id);
    List<T> findAll();
    T update(T entity);
    boolean delete(UUID id);
}
