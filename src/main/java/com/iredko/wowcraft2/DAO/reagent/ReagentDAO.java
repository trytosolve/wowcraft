package com.iredko.wowcraft2.DAO.reagent;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ReagentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reagent> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Reagent> criteriaQuery = builder.createQuery(Reagent.class);
        Root<Reagent> root = criteriaQuery.from(Reagent.class);
        criteriaQuery.select(root);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Reagent merge(Reagent object) {
        return this.entityManager.merge(object);
    }

    public Reagent findById(Integer id) {
        return this.entityManager.find(Reagent.class,id);
    }

    public void delete(Reagent object) {
        this.entityManager.remove(this.entityManager.merge(object));
    }

    public void insert(Reagent object) {
        this.entityManager.persist(object);
    }

    public boolean exist(Integer id) {
        Reagent entity = this.entityManager.find(Reagent.class,id);
        return entity != null;
    }
}
