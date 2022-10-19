package server.service;

import org.springframework.stereotype.Service;
import server.model.Recipe;

import java.util.List;

@Service
public interface IRecipeService {
    List<Recipe> findAllRecipes();
    void save(Recipe recipe);
    void update(Recipe recipe);
    void delete(int recipeId);
}
