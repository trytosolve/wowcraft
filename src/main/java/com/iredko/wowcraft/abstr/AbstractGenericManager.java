package com.iredko.wowcraft.abstr;

import com.iredko.wowcraft.intr.GenericManagerInterface;

import java.util.List;

public abstract class AbstractGenericManager<T, T_DAO extends AbstractGenericDao<T>> implements GenericManagerInterface<T>  {

    public AbstractGenericManager(T_DAO tDAO) {
        this.tDAO = tDAO;
    }

    private T_DAO tDAO;

    @Override
    public List<T> findAll() {
        return tDAO.findAll();
    }

    @Override
    public T update(T object) {
        return tDAO.update(object);
    }

    @Override
    public T findById(Long id) {
        return  tDAO.findById(id);
    }

    @Override
    public void delete(T object) {
        tDAO.delete(object);
    }

    @Override
    public void insert(T object) {
        tDAO.insert(object);
    }

    @Override
    public boolean exist(Long id) {
        return tDAO.exist(id);
    }
}
