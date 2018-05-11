package com.iredko.wowcraft.impl;

import com.iredko.wowcraft.abstr.AbstractGenericDao;
import com.iredko.wowcraft.entities.Recipe;
import com.iredko.wowcraft.intr.RecipeDAOInterface;
import org.springframework.stereotype.Component;

@Component
public class RecipeDao extends AbstractGenericDao<Recipe> implements RecipeDAOInterface {

    public RecipeDao() {
        super(Recipe.class);
    }
}

