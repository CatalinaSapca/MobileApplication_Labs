package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.Recipe;
import server.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService implements IRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void update(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void delete(int recipeId) {
        recipeRepository.deleteById(recipeId);
    }






}
