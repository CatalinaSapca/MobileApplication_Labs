package ro.sapca.recipeapp.repository.recipeRepo;

import ro.sapca.recipeapp.domain.Recipe;


public interface RecipeRepository {

    Recipe findRecipeById(Long id);
    Iterable<Recipe> findAllRecipes();
    Iterable<Recipe> findAllRecipesOfUser(String username);
    Iterable<Recipe> findAllRecipesOfUserByName(String username, String recipeName);
    boolean save(Recipe recipe);
    boolean delete(Long id);
    boolean deleteRecipeOfUser(Long id, String username);
    boolean update(Recipe recipe);
}
