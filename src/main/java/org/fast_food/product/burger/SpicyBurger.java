package org.fast_food.product.burger;

import org.fast_food.product.burger.ingredient.*;

import java.util.List;

public enum SpicyBurger implements Burger {
    SPICY_SRIRACHA("Spicy Sriracha Burger", 6.79, List.of(Patty.BEEF, Sauce.SRIRACHA_SAUCE, Cheese.PEPPER_JACK_CHEESE, Ingredient.TOMATO, Ingredient.LETTUCE, Bun.POTATO), "Heat things up with a spicy Sriracha-infused burger topped with pepper jack cheese.", 650, 4, 3.2),
    JALAPENO_POPPER("Jalapeño Popper Burger", 7.09, List.of(Patty.BEEF, Ingredient.JALAPENO_POPPER_FILLING, Cheese.CREAM_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO), "A fiery burger featuring jalapeño popper filling, cream cheese, and fresh lettuce and tomato.", 700, 3, 3.3),
    BUFFALO_CHICKEN("Buffalo Chicken Burger", 7.49, List.of(Patty.CHICKEN, Sauce.BUFFALO_SAUCE, Sauce.BLUE_CHEESE_DRESSING, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME), "Enjoy the bold flavors of buffalo sauce and blue cheese dressing on a crispy chicken patty.", 720, 4, 3.4),
    CHIPOTLE_BLACK_BEAN("Chipotle Black Bean Burger", 6.89, List.of(Patty.BLACK_BEAN, Sauce.CHIPOTLE_MAYO, Cheese.PEPPER_JACK_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME), "A spicy and satisfying black bean burger topped with chipotle mayo and melted pepper jack cheese.", 600, 3, 3.1),
    CAJUN_SHRIMP("Cajun Shrimp Burger", 8.29, List.of(Patty.SHRIMP, Ingredient.CAJUN, Sauce.REMOULADE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.WHOLE_WHEAT), "Dive into a flavorful shrimp burger seasoned with Cajun spices and topped with remoulade sauce.", 780, 4, 4.2),
    GHOST_PEPPER("Ghost Pepper Burger", 8.99, List.of(Patty.BEEF, Cheese.GHOST_PAPER_CHEESE, Sauce.GHOST_PEPPER_SAUCE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME), "For the brave souls, a burger featuring the intense heat of ghost pepper cheese and sauce.", 850, 5, 4.4),
    HOT_PEPPER_JACK("Hot Pepper Jack Burger", 7.89, List.of(Patty.BEEF, Cheese.PEPPER_JACK_CHEESE, Ingredient.JALAPENOS, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.PRETZEL), "Spice it up with hot pepper jack cheese, jalapeños, and a perfectly grilled beef patty.", 800, 4, 3.8),
    FIERY_HABANERO("Fiery Habanero Burger", 8.49, List.of(Patty.BEEF, Sauce.HABANERO_SAUCE, Cheese.PEPPER_JACK_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.BRIOCHE), "Embrace the heat with a habanero-infused burger topped with spicy pepper jack cheese.", 820, 5, 4.3),
    SPICY_THAI("Spicy Thai Chili Burger", 7.79, List.of(Patty.BEEF, Sauce.THAI_CHILI_SAUCE, Sauce.PEANUT_SAUCE, Ingredient.CUCUMBER, Ingredient.LETTUCE, Bun.BRIOCHE), "Take a flavorful journey with Thai chili and peanut sauces, complemented by fresh cucumber slices.", 790, 4, 3.7),
    INFERNO("Inferno Triple Pepper Burger", 9.49, List.of(Patty.BEEF, Ingredient.JALAPENOS, Ingredient.BANANA_PEPPERS, Cheese.GHOST_PAPER_CHEESE, Sauce.INFERNO_SAUCE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO), "A burger that brings the heat with jalapeños, banana peppers, ghost pepper cheese, and inferno sauce.", 900, 5, 4.4)
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
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public List<IngredientI> getIngredients() {
        return ingredients;
    }

    @Override
    public double getSpicinessLevel() {
        return spicinessLevel;
    }

    @Override
    public double getPopularityRating() {
        return popularityRating;
    }
}
