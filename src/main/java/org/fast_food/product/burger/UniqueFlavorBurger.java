package org.fast_food.product.burger;

import org.fast_food.product.burger.ingredient.*;

import java.util.List;

public enum UniqueFlavorBurger implements Burger {
    BREAKFAST("Breakfast Burger", 8.99, List.of(Patty.BEEF, Ingredient.BACON, Ingredient.FRIED_EGG, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.PRETZEL), "Start your day right with this hearty breakfast burger featuring a juicy beef patty, crispy bacon, a perfectly fried egg, and fresh lettuce and tomato.", 780, 2, 4),
    MOZZARELLA("Mozzarella Burger", 8.99, List.of(Patty.BEEF, Cheese.MOZZARELLA, Sauce.MARINARA, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO), "Indulge in the cheesy goodness of melted mozzarella cheese atop a juicy beef patty, complemented by tangy marinara sauce, lettuce, and tomato.", 820, 1, 3.6),
    SPINACH("Spinach and Artichoke Burger", 10.49, List.of(Patty.SPINACH_ARTICHOKE, Cheese.GOAT_CHEESE, Ingredient.GRILLED_PEPPERS, Ingredient.ARUGULA, Bun.WHOLE_GRAIN), "A vegetarian delight featuring a flavorful spinach and artichoke patty, creamy goat cheese, roasted red peppers, and arugula, served on a wholesome whole grain bun.", 690, 1, 3.8),
    BLUEBERRY_BBQ_BACON("Blueberry BBQ Bacon", 11.99, List.of(Patty.BEEF, Ingredient.BACON, Ingredient.CARAMELIZED_ONIONS, Cheese.CHEDDAR, Ingredient.BLUEBERRY, Sauce.BLUEBERRY_BBQ, Bun.POTATO), "Experience a burst of sweet and savory flavors with this unique burger featuring blueberry BBQ sauce, crispy bacon, melted cheddar cheese, and caramelized onions atop a juicy beef patty.", 850, 1, 4.5),
    SWEAT_POTATO("Sweet Potato Burger", 9.99, List.of(Patty.SWEAT_POTATO, Ingredient.AVOCADO, Ingredient.LETTUCE, Sauce.CHIPOTLE_MAYO, Bun.WHOLE_GRAIN), "Dive into a wholesome and hearty sweet potato burger, made with a savory sweet potato and black bean patty, creamy avocado slices, crisp lettuce, and zesty chipotle mayo, all served on a nutritious whole wheat bun.", 580, 1, 4.1),
    SMOKED_SALMON("Smoked Salmon Burger", 12.99, List.of(Patty.SMOKED_SALMON, Sauce.DILL, Ingredient.CUCUMBER, Ingredient.ARUGULA, Bun.BRIOCHE), "Elevate your burger experience with this gourmet option featuring a succulent smoked salmon patty, creamy dill sauce, crisp cucumber slices, and peppery arugula, all nestled on a toasted brioche bun for a taste of luxury.", 620, 1, 4.2),
    PEANUT_BANANA("Peanut Banana Bacon Burger", 10.79, List.of(Patty.BEEF, Sauce.PEANUT_BUTTER, Ingredient.BANANA, Ingredient.BACON, Sauce.HONEY, Bun.ENGLISH_MUFFIN), "Embark on a flavor adventure with this unconventional burger featuring a juicy beef patty topped with creamy peanut butter, caramelized bananas, crispy bacon, and a drizzle of honey, all sandwiched between two toasted English muffins.", 790, 1, 4.3),
    ONION_RINGS("Onion Rings Burger", 11.49, List.of(Patty.BEEF, Ingredient.ONION_RINGS, Sauce.BBQ_SAUCE, Cheese.CHEDDAR, Ingredient.LETTUCE, Bun.PRETZEL), "Indulge in crunchy perfection with this mouthwatering burger featuring a juicy beef patty topped with crispy beer-battered onion rings, tangy BBQ sauce, melted cheddar cheese, and crisp lettuce, all served on a toasted pretzel bun for a satisfying crunch.", 780, 1, 4.2)
    ;

    private final String name;
    private final double price;
    private final List<IngredientI> ingredients;
    private final String description;
    private final int calories;
    private final double spicinessLevel;
    private final double popularityRating;

    UniqueFlavorBurger(String name, double price, List<IngredientI> ingredients, String description, int calories, double spicinessLevel, double popularityRating) {
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
