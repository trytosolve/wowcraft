package com.iredko.wowcraft.abstr;

import com.iredko.wowcraft.intr.GenericManagerInterface;

import javax.transaction.Transactional;
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
    @Transactional
    public T update(T object) {
        return tDAO.update(object);
    }

    @Override
    public T findById(Integer id) {
        return  tDAO.findById(id);
    }

    @Override
    @Transactional
    public void delete(T object) {
        tDAO.delete(object);
    }

    @Override
    @Transactional
    public void insert(T object) {
        tDAO.insert(object);
    }

    @Override
    public boolean exist(Integer id) {
        return tDAO.exist(id);
    }
}
