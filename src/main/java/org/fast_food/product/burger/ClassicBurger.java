package org.fast_food.product.burger;

import org.fast_food.product.Side;
import org.fast_food.product.Type;
import org.fast_food.product.burger.ingredient.*;

import java.util.List;
import java.util.stream.Collectors;

public enum ClassicBurger implements Burger<IngredientI> {
    CLASSIC_BURGER("Classic Burger", 4.99, List.of(Patty.BEEF, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME), "The classic cheeseburger with a juicy beef patty, melted cheese, and fresh vegetables.", 570, 1, 4.7),
    CLASSIC_CHEESEBURGER("Classic Cheeseburger", 5.19, List.of(Patty.BEEF, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME), "The classic burger with a juicy beef patty and fresh vegetables.", 650, 1, 4.5),
    BACON("Bacon Burger", 5.49, List.of(Patty.BEEF, Ingredient.BACON, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME), "A mouthwatering burger featuring crispy bacon on top of a delicious beef patty.", 800, 2, 4.8),
    VEGGIE("Veggie Burger", 4.79, List.of(Patty.VEGGIE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Sauce.MAYO, Bun.WHOLE_GRAIN), "A meat-free option loaded with fresh vegetables and a tasty vegetarian patty.", 440, 1, 4.1),
    CHICKEN("Chicken Burger", 5.29, List.of(Patty.CHICKEN, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Sauce.MAYO, Bun.SESAME), "A grilled chicken burger with crisp veggies and mayo for a delightful flavor.", 550, 1, 4.3),
    TURKEY("Turkey Burger", 5.49, List.of(Patty.TURKEY, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.ONION, Sauce.CRANBERRY_SAUCE, Bun.BRIOCHE), "A healthier option with a turkey patty and a touch of sweet cranberry sauce.", 550, 1, 4.0),
    BBQ("BBQ Burger", 5.99, List.of(Patty.BEEF, Sauce.BBQ_SAUCE, Side.ONION_RINGS, Ingredient.LETTUCE, Bun.SESAME), "A savory BBQ-infused burger with melted cheddar and crispy onion rings.", 680, 1.5, 4.3),
    JALAPENO("Jalapeño Burger", 5.59, List.of(Patty.BEEF, Cheese.PEPPER_JACK_CHEESE, Ingredient.JALAPENOS, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO), "A spicy delight with pepper jack cheese and a kick of jalapeños.", 640, 3, 3.8),
    TERIYAKI("Teriyaki Burger", 5.89, List.of(Patty.BEEF, Sauce.TERIYAKI_SAUCE, Ingredient.TOMATO, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.PINEAPPLE, Bun.SESAME), "A flavorful burger with a sweet and tangy teriyaki glaze and a hint of pineapple.", 600, 1, 4.2),
    DOUBLE_BURGER("Double Burger", 6.29, List.of(Patty.BEEF, Patty.BEEF, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME), "A hearty and indulgent burger for the ultimate burger enthusiast. This Double Burger features not one, but two succulent beef patties. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.", 950, 1, 4.4),
    DOUBLE_CHEESEBURGER("Double Cheeseburger", 6.49,  List.of(Patty.BEEF, Patty.BEEF, Cheese.CHEESE, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME), "A hearty and indulgent burger for the ultimate cheese enthusiast. This Double Cheeseburger features not one, but two succulent beef patties and topped with double cheese. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.", 1000, 1, 4.4),
    DOUBLE_BACON("Double Bacon Burger", 6.99, List.of(Patty.BEEF, Patty.BEEF, Ingredient.BACON, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME), "For the ultimate bacon lover – double beef and crispy bacon.", 1120, 2, 4.6),
    DOUBLE_BACON_CHEESEBURGER("Double Bacon Cheeseburger", 7.19, List.of(Patty.BEEF, Patty.BEEF, Ingredient.BACON, Cheese.CHEESE, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.BRIOCHE), "For the ultimate bacon and cheese lover – double beef, double cheese, and crispy bacon.", 1280, 2, 4.5),
    FISH("Fish Burger", 6.49, List.of(Patty.FISH_FILLET, Cheese.CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Sauce.TATAR, Bun.SESAME), "A delicious fish fillet served on a soft sesame bun with lettuce, tartar sauce, and tomatoes.", 480, 1, 4.4);

    public static final Type TYPE = Type.BURGER;
    private final String name;
    private final double price;
    private final List<IngredientI> ingredients;
    private final String description;
    private final int calories;
    private final double spicinessLevel;
    private final double popularityRating;

    ClassicBurger(String name, double price, List<IngredientI> ingredients, String description, int calories, double spicinessLevel, double popularityRating) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.description = description;
        this.calories = calories;
        this.spicinessLevel = spicinessLevel;
        this.popularityRating = popularityRating;
    }

    @Override
    public Type getType() {
        return TYPE;
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
    public List<IngredientI> getIngredients() {
        return ingredients;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public double getSpicinessLevel() {
        return spicinessLevel;
    }

    @Override
    public double getPopularityRating() {
        return popularityRating;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
