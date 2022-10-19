package server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private int preparationTimeInMinutes;
    private int cookingTimeInMinutes;
    private int servings;
    private String ingredients;
    private String description;
    private int kcalPer100;
    private String creatorUsername;

//    public Recipe(Long id, String name, int preparationTimeInMinutes, int cookingTimeInMinutes, int servings, String ingredients, String description) {
//        this.name = name;
//        this.preparationTimeInMinutes = preparationTimeInMinutes;
//        this.cookingTimeInMinutes = cookingTimeInMinutes;
//        this.servings = servings;
//        this.ingredients = ingredients;
//        this.description = description;
//    }

    public Recipe(String name, int preparationTimeInMinutes, int cookingTimeInMinutes, int servings, int kcalPer100, String ingredients, String description, String creatorUsername) {
        this.name = name;
        this.preparationTimeInMinutes = preparationTimeInMinutes;
        this.cookingTimeInMinutes = cookingTimeInMinutes;
        this.servings = servings;
        this.kcalPer100 = kcalPer100;
        this.ingredients = ingredients;
        this.description = description;
        this.creatorUsername = creatorUsername;
    }

//    public Recipe(int id, String name, int preparationTimeInMinutes, int cookingTimeInMinutes, int servings, String ingredients, String description, int kcalPer100, String creatorUsername) {
//        this.id = id;
//        this.name = name;
//        this.preparationTimeInMinutes = preparationTimeInMinutes;
//        this.cookingTimeInMinutes = cookingTimeInMinutes;
//        this.servings = servings;
//        this.ingredients = ingredients;
//        this.description = description;
//        this.kcalPer100 = kcalPer100;
//        this.creatorUsername = creatorUsername;
//    }

    public String getName() {
        return name;
    }

    public int getPreparationTimeInMinutes() {
        return preparationTimeInMinutes;
    }

    public int getCookingTimeInMinutes() {
        return cookingTimeInMinutes;
    }

    public int getServings() {
        return servings;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public int getKcalPer100() {
        return kcalPer100;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreparationTimeInMinutes(int preparationTimeInMinutes) {
        this.preparationTimeInMinutes = preparationTimeInMinutes;
    }

    public void setCookingTimeInMinutes(int cookingTimeInMinutes) {
        this.cookingTimeInMinutes = cookingTimeInMinutes;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKcalPer100(int kcalPer100) {
        this.kcalPer100 = kcalPer100;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", preparationTimeInMinutes=" + preparationTimeInMinutes +
                ", cookingTimeInMinutes=" + cookingTimeInMinutes +
                ", servings=" + servings +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", kcalPer100=" + kcalPer100 +
                ", creatorUsername='" + creatorUsername + '\'' +
                '}';
    }

    @PostPersist
    public void postPersist() {

    }
}
