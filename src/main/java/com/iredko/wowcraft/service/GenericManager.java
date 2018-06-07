package com.iredko.wowcraft.service;

import java.util.List;

public interface GenericManager<T> {

    public List<T> findAll();

    public T update(T object);

    public T findById(Integer id);

    public void delete(T object);

    public void insert(T object);

    public boolean exist(Integer id);
}
