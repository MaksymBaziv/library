package com.max.dao;

import java.util.List;

public interface BaseDAO<T> {

    long save(T t);

    void update(T t);

    void deleteById(long id);

    T findById(long id);

    List<T> findAll();
}


