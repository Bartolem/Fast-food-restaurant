package org.fast_food.product.burger;

import org.fast_food.product.Type;
import org.fast_food.product.burger.ingredient.*;

import java.math.BigDecimal;
import java.util.List;

public enum GourmetBurger implements Burger<IngredientI> {
    BLUE_CHEESE("Blue Cheese Burger", BigDecimal.valueOf(6.99), List.of(Patty.BEEF, Cheese.BLUE_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.ONION, Bun.POTATO), "A gourmet delight featuring a succulent beef patty topped with rich and tangy blue cheese, fresh lettuce, tomato, and onion.", 680, 1, 3.3),
    AVOCADO_RANCH("Avocado Ranch Burger", BigDecimal.valueOf(7.29), List.of(Patty.BEEF, Ingredient.AVOCADO, Sauce.RANCH_DRESSING, Ingredient.TOMATO, Ingredient.ONION, Bun.WHOLE_GRAIN), "Indulge in the creamy goodness of avocado and the zesty flavor of ranch dressing on a perfectly grilled beef patty.", 720, 1, 3.5),
    TRUFFLE_MUSHROOM("Truffle Mushroom Burger", BigDecimal.valueOf(7.49), List.of(Patty.BEEF, Sauce.TRUFFLE_OIL, Cheese.SWISS_CHEESE, Ingredient.SAUTEED_MUSHROOMS, Ingredient.LETTUCE, Bun.WHOLE_GRAIN), "A gourmet experience with truffle-infused mushrooms, Swiss cheese, and a juicy beef patty for a rich and earthy taste.", 780, 1, 3.8),
    GUACAMOLE_BACON("Guacamole Bacon Burger", BigDecimal.valueOf(7.79), List.of(Patty.BEEF, Ingredient.GUACAMOLE, Ingredient.BACON,Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME), "Savor the combination of creamy guacamole, crispy bacon, and a perfectly grilled beef patty.", 800, 1, 3.6),
    BBQ_RANCH_BACON("BBQ Ranch Bacon Burger", BigDecimal.valueOf(7.69), List.of(Patty.BEEF, Sauce.BBQ_SAUCE, Sauce.RANCH_DRESSING, Ingredient.BACON, Ingredient.TOMATO, Bun.BRIOCHE), "A delicious fusion of BBQ and ranch flavors with the added crunch of bacon.", 830, 1, 4.2),
    CAJUN_SPICED("Cajun Spiced Burger", BigDecimal.valueOf(6.89), List.of(Patty.BEEF, Ingredient.CAJUN, Cheese.PEPPER_JACK_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO), "A spicy kick with Cajun seasoning and melted pepper jack cheese for a flavor-packed burger.", 690, 3.5, 4.1),
    PESTO_TURKEY("Pesto Turkey Burger", BigDecimal.valueOf(7.19), List.of(Patty.TURKEY, Sauce.PESTO, Cheese.MOZZARELLA, Ingredient.ARUGULA, Ingredient.TOMATO, Bun.SESAME), "A lighter option with a turkey patty, topped with fresh pesto, melted mozzarella, arugula, and tomato.", 660, 1, 3.7),
    PHILLY_CHEESE_STEAK("Philly Cheese Steak Burger", BigDecimal.valueOf(8.29), List.of(Patty.BEEF, Ingredient.STEAK, Cheese.PROVOLONE_CHEESE, Ingredient.GRILLED_PEPPERS, Ingredient.ONION, Bun.PRETZEL), "A burger inspired by the classic Philly cheese steak, featuring sliced steak, provolone cheese, and grilled peppers and onions.", 820, 1, 3.9),
    MEDITERRANEAN_LAMB("Mediterranean Lamb Burger", BigDecimal.valueOf(8.49), List.of(Patty.LAMB, Cheese.FETA_CHEESE, Sauce.TZATZIKI, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.WHOLE_GRAIN), "A flavorful lamb burger topped with crumbled feta, cool tzatziki sauce, and fresh lettuce and tomato.", 900, 1, 3.6);

    public static final Type TYPE = Type.BURGER;
    private final String name;
    private final BigDecimal price;
    private final List<IngredientI> ingredients;
    private final String description;
    private final int calories;
    private final double spicinessLevel;
    private final double popularityRating;

    GourmetBurger(String name, BigDecimal price, List<IngredientI> ingredients, String description, int calories, double spicinessLevel, double popularityRating) {
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
    public BigDecimal getPrice() {
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
