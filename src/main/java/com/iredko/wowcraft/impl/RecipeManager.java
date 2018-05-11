package com.iredko.wowcraft.impl;

import com.iredko.wowcraft.abstr.AbstractGenericManager;
import com.iredko.wowcraft.entities.Recipe;
import com.iredko.wowcraft.intr.RecipeManagerInterface;
import org.springframework.stereotype.Component;

@Component
public class RecipeManager extends AbstractGenericManager<Recipe, RecipeDao> implements RecipeManagerInterface {
    public RecipeManager(RecipeDao tDAO) {
        super(tDAO);
    }
}
