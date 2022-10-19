package ro.sapca.recipeapp.domain;

public class Recipe {

    private static Long nextId = 0L;
    private Long id;
    private String name;
    private int preparationTimeInMinutes;
    private int cookingTimeInMinutes;
    private int servings;
    private String ingredients;
    private String description;
    private int kcalPer100;
    private String creatorUsername;

    private String image;

    public Recipe(Long id, String name, int preparationTimeInMinutes, int cookingTimeInMinutes, int servings, String ingredients, String description) {
        this.id = id;
        this.name = name;
        this.preparationTimeInMinutes = preparationTimeInMinutes;
        this.cookingTimeInMinutes = cookingTimeInMinutes;
        this.servings = servings;
        this.ingredients = ingredients;
        this.description = description;
    }

    public Recipe(String name, int preparationTimeInMinutes, int cookingTimeInMinutes, int servings, int kcalPer100, String ingredients, String description, String creatorUsername, String image) {
        nextId++;
        this.id = nextId;
        this.name = name;
        this.preparationTimeInMinutes = preparationTimeInMinutes;
        this.cookingTimeInMinutes = cookingTimeInMinutes;
        this.servings = servings;
        this.kcalPer100 = kcalPer100;
        this.ingredients = ingredients;
        this.description = description;
        this.creatorUsername = creatorUsername;
        this.image = image;
    }

    public Recipe(Long id, String name, int preparationTimeInMinutes, int cookingTimeInMinutes, int servings, String ingredients, String description, int kcalPer100, String creatorUsername) {
        this.id = id;
        this.name = name;
        this.preparationTimeInMinutes = preparationTimeInMinutes;
        this.cookingTimeInMinutes = cookingTimeInMinutes;
        this.servings = servings;
        this.ingredients = ingredients;
        this.description = description;
        this.kcalPer100 = kcalPer100;
        this.creatorUsername = creatorUsername;
    }

    public Recipe(Long id, String name, int preparationTimeInMinutes, int cookingTimeInMinutes, int servings, String ingredients, String description, int kcalPer100, String creatorUsername, String image) {
        this.id = id;
        this.name = name;
        this.preparationTimeInMinutes = preparationTimeInMinutes;
        this.cookingTimeInMinutes = cookingTimeInMinutes;
        this.servings = servings;
        this.ingredients = ingredients;
        this.description = description;
        this.kcalPer100 = kcalPer100;
        this.creatorUsername = creatorUsername;
        this.image = image;
    }

    public static Long getNextId() {
        return nextId;
    }

    public Long getId() {
        return id;
    }

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

    public static void setNextId(Long nextId) {
        Recipe.nextId = nextId;
    }

    public void setId(Long id) {
        this.id = id;
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

    //---

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }







}
