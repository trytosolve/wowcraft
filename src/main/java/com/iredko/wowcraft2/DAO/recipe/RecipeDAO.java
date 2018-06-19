package com.iredko.wowcraft2.DAO.recipe;

import com.iredko.wowcraft2.DAO.reagent.Reagent;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class RecipeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Recipe> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Recipe> criteriaQuery = builder.createQuery(Recipe.class);
        Root<Recipe> root = criteriaQuery.from(Recipe.class);
        criteriaQuery.select(root);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }


    public List<Recipe> findByReagent(Reagent reagent) {
        TypedQuery<Recipe> query = entityManager.createNamedQuery("Recipe.findAllByReagentId", Recipe.class);
        query.setParameter("reagent", reagent);
        List<Recipe> recipes = query.getResultList();
        return recipes;
    }

    public Recipe merge(Recipe recipe) {
        return this.entityManager.merge(recipe);
    }

    public Recipe findById(Integer id) {
        return this.entityManager.find(Recipe.class,id);
    }

    public void delete(Recipe recipe) {
        this.entityManager.remove(this.entityManager.merge(recipe));
    }

    public void insert(Recipe recipe) {
        this.entityManager.persist(recipe);
    }

    public boolean exist(Integer id) {
        Recipe entity = this.entityManager.find(Recipe.class,id);
        return entity != null;
    }
}
