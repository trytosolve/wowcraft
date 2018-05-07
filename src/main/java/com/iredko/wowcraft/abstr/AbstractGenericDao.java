package com.iredko.wowcraft.abstr;

import com.iredko.wowcraft.intr.GenericDaoInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractGenericDao<T> implements GenericDaoInterface<T> {

    private final Class<T> type;

    private EntityManager entityManager;

    public AbstractGenericDao(Class<T> type,EntityManager entityManager) {
        super();
        this.type = type;
        this.entityManager=entityManager;
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        return this.entityManager.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public T update(T object) {
        return this.entityManager.merge(object);
    }

    @Override
    public T findById(Long id) {
        return this.entityManager.find(type,id);
    }

    @Override
    public void delete(T object) {
        this.entityManager.remove(this.entityManager.merge(object));
    }

    @Override
    public void insert(T object) {
        this.entityManager.persist(object);
    }

    @Override
    public boolean exist(Long id) {
        T entity = this.entityManager.find(this.type,id);
        return entity != null;
    }
}
