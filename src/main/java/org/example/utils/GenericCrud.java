package org.example.utils;

import java.util.List;

public interface GenericCrud<T> {
    T save(T entity);
    T findById(Long id);
    List<T> findAll();
    T update(T entity);
    boolean delete(Long id);
}
