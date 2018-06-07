package com.iredko.wowcraft.DAO.recipe;

import com.iredko.wowcraft.DAO.AbstractDAO;
import com.iredko.wowcraft.DAO.GenericDAO;
import org.springframework.stereotype.Component;

@Component
public class RecipeDAO extends AbstractDAO<Recipe> implements GenericDAO<Recipe> {

    public RecipeDAO() {
        super(Recipe.class);
    }
}

