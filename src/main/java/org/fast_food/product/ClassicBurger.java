package org.fast_food.product;

import java.util.Arrays;
import java.util.List;

public enum ClassicBurger {
    CLASSIC_BURGER("Classic Burger", 4.99, Arrays.asList("Beef patty", "Lettuce", "Tomato", "Pickles", "Onions"), "The classic cheeseburger with a juicy beef patty, melted cheese, and fresh vegetables."),
    CLASSIC_CHEESEBURGER("Classic Cheeseburger", 5.19, Arrays.asList("Beef patty", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "The classic burger with a juicy beef patty and fresh vegetables."),
    BACON_BURGER("Bacon Burger", 5.49, Arrays.asList("Beef patty", "Bacon", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "A mouthwatering burger featuring crispy bacon on top of a delicious beef patty."),
    VEGGIE_BURGER("Veggie Burger", 4.79, Arrays.asList("Vegetarian patty", "Lettuce", "Tomato", "Pickles", "Onions", "Mayonnaise"), "A meat-free option loaded with fresh vegetables and a tasty vegetarian patty."),
    CHICKEN_BURGER("Chicken Burger", 5.29, Arrays.asList("Grilled chicken breast", "Lettuce", "Tomato", "Pickles", "Onions", " Mayonnaise"), "A grilled chicken burger with crisp veggies and mayo for a delightful flavor."),
    TURKEY_BURGER("Turkey Burger", 5.49, Arrays.asList("Turkey patty", "Lettuce", "Tomato", "Onions", "Cranberry sauce"), "A healthier option with a turkey patty and a touch of sweet cranberry sauce."),
    JALAPENO_BURGER("Jalapeño Burger", 5.59, Arrays.asList("Beef patty", "Pepper jack cheese", "Jalapeños", "Lettuce", "Tomato"), "A spicy delight with pepper jack cheese and a kick of jalapeños."),
    TERIYAKI_BURGER("Teriyaki Burger", 5.89, Arrays.asList("Beef patty", "Teriyaki sauce", "Pineapple", "Lettuce", "Tomato"), "A flavorful burger with a sweet and tangy teriyaki glaze and a hint of pineapple."),
    DOUBLE_BURGER("Double Burger", 6.29, Arrays.asList("Two beef patties", "Lettuce", "Tomato", "Pickles", "Onions"), "A hearty and indulgent burger for the ultimate burger enthusiast. This Double Burger features not one, but two succulent beef patties. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions."),
    DOUBLE_CHEESEBURGER("Double Cheeseburger", 6.49,  Arrays.asList("Two beef patties", "Double cheese", "Lettuce", "Tomato", "Pickles", "Onions"), "A hearty and indulgent burger for the ultimate cheese enthusiast. This Double Cheeseburger features not one, but two succulent beef patties and topped with double cheese. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.");

    private final String name;
    private final double price;
    private final List<String> ingredients;
    private final String description;

    ClassicBurger(String name, double price, List<String> ingredients, String description) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.description = description;
    }
}
