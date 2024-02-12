package org.fast_food.product;

import org.fast_food.product.burger.ingredient.IngredientI;

public enum Side implements Product, IngredientI {
    ONION_RINGS("Onion Rings", 4.79, "Thick-cut onion rings coated in a seasoned batter and fried to a golden brown.", 420),
    SALAD ("Side Salad", 3.99, "Fresh mixed greens, cherry tomatoes, cucumber slices, and shredded carrots, served with your choice of dressing.", 120),
    QUINOA_SALAD("Quinoa Salad", 4.79, "A refreshing salad made with cooked quinoa, mixed greens, diced vegetables, and a zesty vinaigrette dressing.", 180),
    GREEK_SALAD("Greek Salad", 4.99, "A traditional Greek salad featuring crisp lettuce, juicy tomatoes, cucumber slices, red onions, Kalamata olives, and feta cheese, drizzled with olive oil and oregano.", 280);
    ;

    public static final Type TYPE = Type.SIDE_DISH;
    private final String name;
    private final double price;
    private final String description;
    private final int calories;

    Side(String name, double price, String description, int calories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
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
    public String getDescription() {
        return description;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}
