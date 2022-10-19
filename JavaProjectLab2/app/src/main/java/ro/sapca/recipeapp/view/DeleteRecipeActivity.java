package ro.sapca.recipeapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import ro.sapca.recipeapp.R;
import ro.sapca.recipeapp.domain.Recipe;
import ro.sapca.recipeapp.repository.recipeRepo.RecipeInMemoryRepository;

public class DeleteRecipeActivity extends AppCompatActivity {
    Recipe recipe = null;
    TextView recipeName, prepTime, cookTime, servings, kcal, ingredients, description;
    ImageView imageRecipe;

    Button deleteButton;
    Button updateButton;
    EditText cnp_input;
    Button editButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        this.context = getApplicationContext();
        refreshData();
        updateButton.setVisibility(View.VISIBLE);
        deleteButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }

    void refreshData() {
        if (recipe == null) {
            Long idRecipe = this.getIntent().getLongExtra("idRecipe", 1);
            this.recipe = RecipeInMemoryRepository.getRecipeInMemoryRepository().findRecipeById(idRecipe);
        }
        this.recipeName = findViewById(R.id.recipeNameField);
        this.prepTime = findViewById(R.id.prepTimeField);
        this.cookTime = findViewById(R.id.cookTimeField);
        this.servings = findViewById(R.id.servingField);
        this.kcal = findViewById(R.id.kcalField);
        this.ingredients = findViewById(R.id.ingredientsField);
        this.description = findViewById(R.id.descriptionField);

        this.imageRecipe = findViewById(R.id.imageViewRecipe);

//        this.editButton.setOnClickListener((view) -> {
//            LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.getApplicationContext().LAYOUT_INFLATER_SERVICE);
//
//            View popupView = inflater.inflate(R.layout.view_popup_cnp, null);
//
//            // create the popup window
//            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
//            int height = 900;
//            boolean focusable = true; // lets taps outside the popup also dismiss it
//            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//
//            popupWindow.setOnDismissListener(() -> {
//                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//                    }
//            );
//            // show the popup window
//            // which view you pass in doesn't matter, it is only used for the window tolken
//            popupWindow.showAtLocation(this.findViewById(R.id.main), Gravity.CENTER, 0, 0);
//            cnp_input = popupView.findViewById(R.id.cnpVerificare);
//            cnp_input.setFocusableInTouchMode(true);
//            cnp_input.requestFocus();
//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//            Button verifica = (Button) popupView.findViewById(R.id.buttonVerifica);
//            verifica.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    cnp_input = popupView.findViewById(R.id.cnpVerificare);
//                    String cnp = cnp_input.getText().toString().trim();
//                    System.out.println("Cnp reclamatie:" + reclamatie.cnp);
//                    System.out.println("Cnp inserat:" + cnp);
//                    Context myContext = getApplicationContext();
//                    if (reclamatie.cnp.equals(cnp)) {
//                        updateButton.setVisibility(View.VISIBLE);
//                        deleteButton.setVisibility(View.VISIBLE);
//                        editButton.setVisibility(View.INVISIBLE);
//                        popupWindow.dismiss();
//                    } else {
//                        popupWindow.dismiss();
//                        Toast.makeText(myContext, "Cnp gresit", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//
//            });
//        });
        this.deleteButton = findViewById(R.id.deleteButton);
        this.deleteButton.setOnClickListener(view -> {
            RecipeInMemoryRepository.getRecipeInMemoryRepository().delete(this.recipe.getId());
            Toast.makeText(getApplicationContext(), "Successfully deleted!", Toast.LENGTH_SHORT).show();
            finish();
        });
        this.updateButton = findViewById(R.id.updateButton);
        this.updateButton.setOnClickListener(view -> {
            Intent updateRecipeIntent = new Intent(view.getContext(), UpdateActivity.class);
            updateRecipeIntent.putExtra("idRecipe", recipe.getId());
            startActivity(updateRecipeIntent);

        });

        this.recipeName.setText("What is this?:  " + recipe.getName());
        this.prepTime.setText("preparation time: " + String.valueOf(recipe.getPreparationTimeInMinutes()) + " min");
        this.cookTime.setText("cooking time: " + String.valueOf(recipe.getCookingTimeInMinutes()) + " min");
        this.servings.setText("servings: " + String.valueOf(recipe.getServings()));
        this.kcal.setText(String.valueOf(recipe.getKcalPer100()) + "kcal/100gr");
        this.ingredients.setText("Ingredients: " + recipe.getIngredients());
        this.description.setText("Description: \n" + recipe.getDescription());


        Glide.with(context).load(recipe.getImage()).into(this.imageRecipe);

    }

}
