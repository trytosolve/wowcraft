package com.iredko.wowcraft2.service;

import com.iredko.wowcraft2.DAO.reagent.Reagent;
import com.iredko.wowcraft2.DAO.recipe.Recipe;
import com.iredko.wowcraft2.DAO.recipe.RecipeDAO;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeManager {

    RecipeDAO recipeDAO;

    public RecipeManager(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    @Transactional
    public List<RecipeInfoModel> findAll() {
        List<RecipeInfoModel> recipeInfoModels = new ArrayList<>();
        List<Recipe> recipes = recipeDAO.findAll();
        for (Recipe recipe : recipes) {
            recipeInfoModels.add(RecipeInfoModel.fromEntity(recipe));
        }
        return recipeInfoModels;
    }

    @Transactional
    public void merge(RecipeInfoModel recipeInfoModel) {
        recipeDAO.merge(Recipe.fromModel(recipeInfoModel));
    }

    @Transactional
    public RecipeInfoModel findById(Integer id) {
        return RecipeInfoModel.fromEntity(recipeDAO.findById(id));
    }

    @Transactional
    public void delete(RecipeInfoModel recipeInfoModel) {
        recipeDAO.delete(Recipe.fromModel(recipeInfoModel));
    }

    @Transactional
    public void insert(RecipeInfoModel recipeInfoModel) { recipeDAO.insert(Recipe.fromModel(recipeInfoModel)); }

    @Transactional
    public boolean exist(Integer id) {
        return recipeDAO.exist(id);
    }

    public List<RecipeInfoModel> findByReagent(ReagentInfoModel reagent) {
        List<RecipeInfoModel> recipeInfoModels = new ArrayList<>();
        List<Recipe> recipes = recipeDAO.findByReagent(Reagent.fromModel(reagent));
        for (Recipe recipe : recipes) {
            recipeInfoModels.add(RecipeInfoModel.fromEntity(recipe));
        }
        return recipeInfoModels;
    }
}
