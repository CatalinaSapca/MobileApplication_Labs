package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.model.Recipe;
import server.service.IRecipeService;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    private IRecipeService recipeService;

    @GetMapping({"/recipes"})
    public List<Recipe> recipes() {
        return recipeService.findAllRecipes();
    }

    @PostMapping("/save")
    public Recipe save(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return recipe;
    }

    @PutMapping("/update")
    public Recipe update(@RequestBody Recipe recipe) {
        System.out.println("update5");
        recipeService.update(recipe);
        return recipe;
    }

    @DeleteMapping("/delete")
    public int delete(@RequestBody int recipeId) {
        System.out.println("delete5");
        System.out.println(recipeId);
        recipeService.delete(recipeId);
        return recipeId;
    }
}
