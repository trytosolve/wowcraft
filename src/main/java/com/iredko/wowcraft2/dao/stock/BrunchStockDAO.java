package com.iredko.wowcraft2.dao.stock;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class BrunchStockDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StockBrunch> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<StockBrunch> criteriaQuery = builder.createQuery(StockBrunch.class);
        Root<StockBrunch> root = criteriaQuery.from(StockBrunch.class);
        criteriaQuery.select(root);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    public StockBrunch merge(StockBrunch stockBrunch) {
        return this.entityManager.merge(stockBrunch);
    }

    public StockBrunch findById(Integer id) {
        return this.entityManager.find(StockBrunch.class,id);
    }

    public void delete(StockBrunch stockBrunch) {
        this.entityManager.remove(this.entityManager.merge(stockBrunch));
    }

    public void insert(StockBrunch stockBrunch) {
        this.entityManager.persist(stockBrunch);
    }

    public boolean exist(Integer id) {
        StockBrunch entity = this.entityManager.find(StockBrunch.class,id);
        return entity != null;
    }
}
