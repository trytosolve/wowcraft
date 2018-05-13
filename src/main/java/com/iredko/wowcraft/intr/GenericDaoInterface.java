package com.iredko.wowcraft.intr;

import java.util.List;

//TODO не нужно в имени интерфейса писать Interface. Это и так ясно :)
public interface GenericDaoInterface<T> {

    public List<T> findAll();

    public T update(T object);

    public T findById(Integer id);

    public void delete(T object);

    public void insert(T object);

    public boolean exist(Integer id);

}
