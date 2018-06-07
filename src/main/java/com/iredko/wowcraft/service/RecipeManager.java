package com.iredko.wowcraft.service;

import com.iredko.wowcraft.DAO.recipe.RecipeDAO;
import com.iredko.wowcraft.service.AbstractManager;
import com.iredko.wowcraft.DAO.recipe.Recipe;
import com.iredko.wowcraft.service.GenericManager;
import org.springframework.stereotype.Component;

@Component
public class RecipeManager extends AbstractManager<Recipe, RecipeDAO> implements GenericManager<Recipe> {
    public RecipeManager(RecipeDAO tDAO) {
        super(tDAO);
    }
}
