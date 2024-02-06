package org.fast_food.product.burger.ingredient;

import org.fast_food.product.burger.Burger;

import java.util.List;

public enum SpicyBurger implements Burger {
    SPICY_SRIRACHA_BURGER("Spicy Sriracha Burger", 6.79, List.of(Ingredient.BEEF_PATTY, Sauce.SRIRACHA_SAUCE, Cheese.PEPPER_JACK_CHEESE, Ingredient.TOMATO, Ingredient.LETTUCE), "Heat things up with a spicy Sriracha-infused burger topped with pepper jack cheese.", 650, 4, 3.2),
    JALAPENO_POPPER_BURGER("Jalapeño Popper Burger", 7.09, List.of(Ingredient.BEEF_PATTY, Ingredient.JALAPENO_POPPER_FILLING, Cheese.CREAM_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO), "A fiery burger featuring jalapeño popper filling, cream cheese, and fresh lettuce and tomato.", 700, 3, 3.3),
    ;

    private final String name;
    private final double price;
    private final List<IngredientI> ingredients;
    private final String description;
    private final int calories;
    private final double spicinessLevel;
    private final double popularityRating;

    SpicyBurger(String name, double price, List<IngredientI> ingredients, String description, int calories, double spicinessLevel, double popularityRating) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.description = description;
        this.calories = calories;
        this.spicinessLevel = spicinessLevel;
        this.popularityRating = popularityRating;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public List<IngredientI> getIngredients() {
        return null;
    }

    @Override
    public double getSpicinessLevel() {
        return 0;
    }

    @Override
    public double getPopularityRating() {
        return 0;
    }
}
