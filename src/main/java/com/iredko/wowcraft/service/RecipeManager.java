package com.iredko.wowcraft.service;

import com.iredko.wowcraft.DAO.recipe.RecipeDAO;
import com.iredko.wowcraft.DAO.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Map;

@Component
public class RecipeManager extends AbstractManager<Recipe, RecipeDAO> implements GenericManager<Recipe> {

    @Autowired
    private ReagentManager reagentManager;

    public RecipeManager(RecipeDAO tDAO) {
        super(tDAO);
    }


    @Transactional
    public void saveChanges(Integer id, String name, Map<Integer, Integer> reagentsCountMap) {
        Recipe recipe = findById(id);
        recipe.getReagents().clear();
        for (Map.Entry<Integer, Integer> entry : reagentsCountMap.entrySet()) {
            recipe.addReagent(reagentManager.findById(entry.getKey()),entry.getValue());
        }
        recipe.setName(name);
        update(recipe);
    }


    @Transactional
    public void addRecipe(String name, Map<Integer, Integer> reagentsCountMap) {
        Recipe recipe = new Recipe(name);
        for (Map.Entry<Integer, Integer> entry : reagentsCountMap.entrySet()) {
            recipe.addReagent(reagentManager.findById(entry.getKey()),entry.getValue());
        }
        update(recipe);
    }

}
