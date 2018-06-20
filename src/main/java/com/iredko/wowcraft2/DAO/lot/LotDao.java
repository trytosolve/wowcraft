package com.iredko.wowcraft2.DAO.lot;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class LotDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Lot> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Lot> criteriaQuery = builder.createQuery(Lot.class);
        Root<Lot> root = criteriaQuery.from(Lot.class);
        criteriaQuery.select(root);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Lot merge(Lot object) {
        return this.entityManager.merge(object);
    }

    public Lot findById(Integer id) {
        return this.entityManager.find(Lot.class,id);
    }

    public void delete(Lot object) {
        this.entityManager.remove(this.entityManager.merge(object));
    }

    public void insert(Lot object) {
        this.entityManager.persist(object);
    }

    public boolean exist(Integer id) {
        Lot entity = this.entityManager.find(Lot.class,id);
        return entity != null;
    }
}
