package ro.sapca.recipeapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import ro.sapca.recipeapp.R;
import ro.sapca.recipeapp.domain.Recipe;
import ro.sapca.recipeapp.domain.User;
import ro.sapca.recipeapp.repository.recipeRepo.RecipeInMemoryRepository;


public class AddActivity extends AppCompatActivity {

    User currentUser = new User("catalina", "password", "Catalina", "Sapca", "0098");

    RecipeInMemoryRepository recipeRepository = RecipeInMemoryRepository.getRecipeInMemoryRepository();

    EditText recipeName, prepTime, cookTime, serving, kcal, ingredients, description, image;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        recipeName = findViewById(R.id.recipeNameAdd);
        prepTime = findViewById(R.id.prepTimeAdd);
        cookTime = findViewById(R.id.cookTimeAdd);
        serving = findViewById(R.id.servingsAdd);
        kcal = findViewById(R.id.kcalAdd);
        ingredients = findViewById(R.id.ingredientsAdd);
        description = findViewById(R.id.descriptionAdd);
        image = findViewById(R.id.imageAdd);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String recipeNamee = recipeName.getText().toString().trim();
                int prep = Integer.parseInt(prepTime.getText().toString());
                int cook = Integer.parseInt(cookTime.getText().toString());
                int serv = Integer.parseInt(serving.getText().toString());
                int kc = Integer.parseInt(kcal.getText().toString());
                String ingr = ingredients.getText().toString().trim();
                String descr = description.getText().toString().trim();
                String img = image.getText().toString().trim();

                Recipe recipe = new Recipe(recipeNamee, prep, cook, serv, kc, ingr, descr, currentUser.getUsername(), img);

                recipeRepository.save(recipe);
                System.out.println("Added recipe");
                Toast.makeText(getApplicationContext(), "Successfully added!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }







}