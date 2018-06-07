package com.iredko.wowcraft.DAO;

import java.util.List;

public interface GenericDAO<T> {

    public List<T> findAll();

    public T update(T object);

    public T findById(Integer id);

    public void delete(T object);

    public void insert(T object);

    public boolean exist(Integer id);

}
