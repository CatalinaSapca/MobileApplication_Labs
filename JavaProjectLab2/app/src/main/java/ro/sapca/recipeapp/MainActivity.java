package ro.sapca.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ro.sapca.recipeapp.domain.Recipe;
import ro.sapca.recipeapp.domain.User;
import ro.sapca.recipeapp.repository.recipeRepo.RecipeInMemoryRepository;
import ro.sapca.recipeapp.repository.recipeRepo.RecipeRepository;
import ro.sapca.recipeapp.view.AddActivity;
import ro.sapca.recipeapp.view.CustomAdapter;
import ro.sapca.recipeapp.view.DeleteRecipeActivity;

public class MainActivity extends AppCompatActivity implements OnAdapterItemClickListener{

    User currentUser =  new User("catalina", "password", "Catalina", "Sapca", "0098");

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    //EditText cnp_input;
    // ArrayList<String> name, phone, day;
    CustomAdapter customAdapter;
    RecipeRepository recipeRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--added
        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.addRecipeButtonMain);
        add_button.setOnClickListener(new View.OnClickListener(){
            //pe butonul de plus, te duce pe pagina de add
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        this.DisplayData();

//        System.out.println("In Repo Main activity:");
//        recipeRepository.print();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    protected void onResume(){
        super.onResume();
        this.customAdapter.notifyDataSetChanged();

    }

    @Override
    public void onAdapterItemClickListener(Recipe recipe) {
        Intent deleteRecipeIntent = new Intent(getApplicationContext(), DeleteRecipeActivity.class);
        //trimitem id-ul reclamatiei in screenul de detele
        deleteRecipeIntent.putExtra("idRecipe", recipe.getId());
        deleteRecipeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Context myContext = getApplicationContext();
        myContext.startActivity(deleteRecipeIntent);
        System.out.println("Starting delete screen");
    }

    void DisplayData(){
        this.recipeRepository = RecipeInMemoryRepository.getRecipeInMemoryRepository();
        customAdapter = new CustomAdapter(MainActivity.this, (List<Recipe>) recipeRepository.findAllRecipesOfUser(currentUser.getUsername()), this);
        recyclerView.setAdapter(customAdapter);
    }


}