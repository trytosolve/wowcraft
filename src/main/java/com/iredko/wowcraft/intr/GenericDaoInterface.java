package com.iredko.wowcraft.intr;

import com.iredko.wowcraft.entities.Reagent;

import java.util.List;

public interface GenericDaoInterface<T> {

    public List<T> findAll();

    public T update(T object);

    public T findById(Integer id);

    public void delete(T object);

    public void insert(T object);

    public boolean exist(Integer id);

}
