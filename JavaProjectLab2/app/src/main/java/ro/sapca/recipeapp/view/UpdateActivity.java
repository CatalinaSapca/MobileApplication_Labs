package ro.sapca.recipeapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ro.sapca.recipeapp.R;
import ro.sapca.recipeapp.domain.Recipe;
import ro.sapca.recipeapp.repository.recipeRepo.RecipeInMemoryRepository;


public class UpdateActivity extends AppCompatActivity {
    TextView recipeName, prepTime, cookTime, servings, kcal, ingredients, description;

    Recipe recipe;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        this.recipe = RecipeInMemoryRepository.getRecipeInMemoryRepository().findRecipeById(this.getIntent().getLongExtra("isRecipe", 1));

        this.recipeName = findViewById(R.id.recipeNameUpdate);
        this.prepTime = findViewById(R.id.prepTimeUpdate);
        this.cookTime = findViewById(R.id.cookTimeUpdate);
        this.servings = findViewById(R.id.servingsUpdate);
        this.kcal = findViewById(R.id.kcalUpdate);
        this.ingredients = findViewById(R.id.ingredientsUpdate);
        this.description = findViewById(R.id.descriptionUpdate);

        recipeName.setText(recipe.getName());
        prepTime.setText(String.valueOf(recipe.getPreparationTimeInMinutes()));
        cookTime.setText(String.valueOf(recipe.getCookingTimeInMinutes()));
        servings.setText(String.valueOf(recipe.getServings()));
        kcal.setText(String.valueOf(recipe.getKcalPer100()));
        ingredients.setText(recipe.getIngredients());
        description.setText(recipe.getDescription());

        this.saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(view -> {
            if(!recipeName.getText().toString().equals(""))
                this.recipe.setName(recipeName.getText().toString());
            if(!prepTime.getText().toString().equals(""))
                this.recipe.setPreparationTimeInMinutes(Integer.parseInt(prepTime.getText().toString()));
            //TODO : add hete validations for all fields
            RecipeInMemoryRepository.getRecipeInMemoryRepository().update(recipe);
            finish();
        });

    }

    @Override
    public boolean onSupportNavigateUp(){
        System.out.println("Navigating up");
        Intent upIntent = this.getSupportParentActivityIntent();
        System.out.println(upIntent.toString());
        upIntent.putExtra("idRecipe", recipe.getId());
        setResult(Activity.RESULT_OK);
        finish();
        return super.onSupportNavigateUp();
    }
}
