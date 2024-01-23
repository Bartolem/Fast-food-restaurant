package org.fast_food.product.burger;

import java.util.List;

public enum ClassicBurger implements Burger {
    CLASSIC_BURGER("Classic Burger", 4.99, List.of("Beef patty", "Lettuce", "Tomato", "Pickles", "Onions"), "The classic cheeseburger with a juicy beef patty, melted cheese, and fresh vegetables.", 570, 1, 4.7),
    CLASSIC_CHEESEBURGER("Classic Cheeseburger", 5.19, List.of("Beef patty", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "The classic burger with a juicy beef patty and fresh vegetables.", 650, 1, 4.5),
    BACON_BURGER("Bacon Burger", 5.49, List.of("Beef patty", "Bacon", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "A mouthwatering burger featuring crispy bacon on top of a delicious beef patty.", 800, 2, 4.8),
    VEGGIE_BURGER("Veggie Burger", 4.79, List.of("Vegetarian patty", "Lettuce", "Tomato", "Pickles", "Onions", "Mayonnaise"), "A meat-free option loaded with fresh vegetables and a tasty vegetarian patty.", 440, 1, 4.1),
    CHICKEN_BURGER("Chicken Burger", 5.29, List.of("Grilled chicken breast", "Lettuce", "Tomato", "Pickles", "Onions", " Mayonnaise"), "A grilled chicken burger with crisp veggies and mayo for a delightful flavor.", 550, 1, 4.3),
    TURKEY_BURGER("Turkey Burger", 5.49, List.of("Turkey patty", "Lettuce", "Tomato", "Onions", "Cranberry sauce"), "A healthier option with a turkey patty and a touch of sweet cranberry sauce.", 550, 1, 4.0),
    BBQ_BURGER("BBQ Burger", 5.99, List.of("Beef patty", "BBQ sauce", "Onion rings", "Lettuce"), "A savory BBQ-infused burger with melted cheddar and crispy onion rings.", 680, 1.5, 4.3),
    JALAPENO_BURGER("Jalapeño Burger", 5.59, List.of("Beef patty", "Pepper jack cheese", "Jalapeños", "Lettuce", "Tomato"), "A spicy delight with pepper jack cheese and a kick of jalapeños.", 640, 3, 3.8),
    TERIYAKI_BURGER("Teriyaki Burger", 5.89, List.of("Beef patty", "Teriyaki sauce", "Pineapple", "Lettuce", "Tomato"), "A flavorful burger with a sweet and tangy teriyaki glaze and a hint of pineapple.", 600, 1, 4.2),
    DOUBLE_BURGER("Double Burger", 6.29, List.of("Two beef patties", "Lettuce", "Tomato", "Pickles", "Onions"), "A hearty and indulgent burger for the ultimate burger enthusiast. This Double Burger features not one, but two succulent beef patties. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.", 950, 1, 4.4),
    DOUBLE_CHEESEBURGER("Double Cheeseburger", 6.49,  List.of("Two beef patties", "Double cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "A hearty and indulgent burger for the ultimate cheese enthusiast. This Double Cheeseburger features not one, but two succulent beef patties and topped with double cheese. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.", 1000, 1, 4.4),
    DOUBLE_BACON_BURGER("Double Bacon Burger", 6.99, List.of("Two beef patties", "Bacon", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "For the ultimate bacon lover – double beef and crispy bacon.", 1120, 2, 4.6),
    DOUBLE_BACON_CHEESEBURGER("Double Bacon Cheeseburger", 7.19, List.of("Two beef patties", "Bacon", "Double cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "For the ultimate bacon and cheese lover – double beef, double cheese, and crispy bacon.", 1280, 2, 4.5);

    private final String name;
    private final double price;
    private final List<String> ingredients;
    private final String description;
    private final int calories;
    private final double spicinessLevel;
    private final double popularityRating;

    ClassicBurger(String name, double price, List<String> ingredients, String description, int calories, double spicinessLevel, double popularityRating) {
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
    public List<String> getIngredients() {
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
