package ro.sapca.recipeapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import ro.sapca.recipeapp.R;

import java.util.List;

import ro.sapca.recipeapp.OnAdapterItemClickListener;
import ro.sapca.recipeapp.domain.Recipe;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private List<Recipe> recipes;
    Context context;

    private OnAdapterItemClickListener adapterItemClickListener = null;
    public CustomAdapter(Context context, List<Recipe> recipes, OnAdapterItemClickListener clickRecipe) {
        this.context = context;
        this.recipes = recipes;
        adapterItemClickListener = clickRecipe;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    //binduieste un element de la pozitia position
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.bindItem(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    //Contine un singur item
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Recipe recipe;
        TextView recipeName, prepTime, cookTime, servings, kcal;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.recipeName = itemView.findViewById(R.id.recipeName);
            this.prepTime = itemView.findViewById(R.id.prepTime);
            this.cookTime = itemView.findViewById(R.id.cookTime);
            this.servings = itemView.findViewById(R.id.servings);
            this.kcal = itemView.findViewById(R.id.kcal);
            this.image = itemView.findViewById(R.id.imageView);
        }

        //@SuppressLint("SetTextI18n")
        public void bindItem(Recipe recipe) {
            this.recipe = recipe;

            this.recipeName.setText(recipe.getName());
            this.prepTime.setText(recipe.getPreparationTimeInMinutes() + " min");
            this.cookTime.setText(recipe.getCookingTimeInMinutes() + " min");
            this.servings.setText(recipe.getServings() + " servings");
            this.kcal.setText(recipe.getKcalPer100() + "kcal/100g");
            Glide.with(context).load(recipe.getImage()).into(image);
        }

        //cand dai click pe item se deschide o pagina noua cu detaliile elementului
        @Override
        public void onClick(View view) {
            adapterItemClickListener.onAdapterItemClickListener(recipe);
        }
    }

}
