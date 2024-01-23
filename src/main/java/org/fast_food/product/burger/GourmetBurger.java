package org.fast_food.product.burger;

import java.util.List;

public enum GourmetBurger implements Burger {
    BLUE_CHEESE_BURGER("Blue Cheese Burger", 6.99, List.of("Beef patty", "Blue cheese", "Lettuce", "Tomato", "Onion"), "A gourmet delight featuring a succulent beef patty topped with rich and tangy blue cheese, fresh lettuce, tomato, and onion.", 680, 1, 3.3),
    AVOCADO_RANCH_BURGER("Avocado Ranch Burger", 7.29, List.of("Beef patty", "Avocado", "Ranch dressing", "Lettuce", "Tomato"), "Indulge in the creamy goodness of avocado and the zesty flavor of ranch dressing on a perfectly grilled beef patty.", 720, 1, 3.5),
    TRUFFLE_MUSHROOM_BURGER("Truffle Mushroom Burger", 7.49, List.of("Beef patty", "Truffle oil", "Swiss cheese", "Sauteed mushrooms", "Lettuce"), "A gourmet experience with truffle-infused mushrooms, Swiss cheese, and a juicy beef patty for a rich and earthy taste.", 780, 1, 3.8),
    GUACAMOLE_BACON_BURGER("Guacamole Bacon Burger", 7.79, List.of("Beef patty", "Guacamole", "Bacon", "Lettuce", "Tomato"), "Savor the combination of creamy guacamole, crispy bacon, and a perfectly grilled beef patty.", 800, 1, 3.6),
    BBQ_RANCH_BACON_BURGER("BBQ Ranch Bacon Burger", 7.69, List.of("Beef patty", "BBQ sauce", "Ranch dressing", "Bacon", "Lettuce"), "A delicious fusion of BBQ and ranch flavors with the added crunch of bacon.", 830, 1, 4.2),
    CAJUN_SPICED_BURGER("Cajun Spiced Burger", 6.89, List.of("Beef patty", "Cajun spice blend", "Pepper jack cheese", "Lettuce", "Tomato"), "A spicy kick with Cajun seasoning and melted pepper jack cheese for a flavor-packed burger.", 690, 3.5, 4.1),
    PESTO_TURKEY_BURGER("Pesto Turkey Burger", 7.19, List.of("Turkey patty", "Pesto sauce", "Mozzarella cheese", "Arugula", "Tomato"), "A lighter option with a turkey patty, topped with fresh pesto, melted mozzarella, arugula, and tomato.", 660, 1, 3.7),
    PHILLY_CHEESE_STEAK_BURGER("Philly Cheese Steak Burger", 8.29, List.of("Beef patty", "Sliced steak", "Provolone cheese", "Grilled peppers and onions"), "A burger inspired by the classic Philly cheese steak, featuring sliced steak, provolone cheese, and grilled peppers and onions.", 820, 1, 3.9),
    MEDITERRANEAN_LAMB_BURGER("Mediterranean Lamb Burger", 8.49, List.of("Lamb patty", "Feta cheese", "Tzatziki sauce", "Lettuce", "Tomato"), "A flavorful lamb burger topped with crumbled feta, cool tzatziki sauce, and fresh lettuce and tomato.", 900, 1, 3.6);

    private final String name;
    private final double price;
    private final List<String> ingredients;
    private final String description;
    private final int calories;
    private final double spicinessLevel;
    private final double popularityRating;

    GourmetBurger(String name, double price, List<String> ingredients, String description, int calories, double spicinessLevel, double popularityRating) {
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
    public List<String> getIngredients() {
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
