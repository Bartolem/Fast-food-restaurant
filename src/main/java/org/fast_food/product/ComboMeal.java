package org.fast_food.product;

import org.fast_food.product.burger.*;

import java.util.List;

public enum ComboMeal implements Product, Burger<Product> {
    CLASSIC("Classic Combo Meal", 9.99, List.of(ClassicBurger.CLASSIC_CHEESEBURGER, FrenchFries.REGULAR, ColdDrink.COLA_DRINK), "Classic Cheeseburger with Regular Fries and Cola Drink", 1120, 1, 4.3),
    GOURMET("Gourmet Combo Meal", 12.99, List.of(GourmetBurger.BLUE_CHEESE, FrenchFries.SWEET_POTATO, ColdDrink.PINEAPPLE_PINA_COLADA), "Blue Cheese Burger with Sweet Potato Fries and Pineapple Piña Colada", 1180, 2, 4.7),
    TEX_MEX("Tex-Mex Combo Meal", 10.49, List.of(ClassicBurger.JALAPENO, FrenchFries.REGULAR, ColdDrink.ICE_TEA), "Jalapeño Burger with Regular Fries and Iced Tea", 1050, 3, 4.0),
    SPICY("Spicy Combo Meal", 9.99, List.of(SpicyBurger.SPICY_SRIRACHA, FrenchFries.REGULAR, ColdDrink.MINT_COCKTAIL), "Spicy Sriracha Burger with Regular Fries and Mint Cocktail", 980, 4, 4.6),
    INFERNO("Inferno Combo Meal", 11.49, List.of(SpicyBurger.INFERNO, FrenchFries.REGULAR, ColdDrink.COLA_DRINK), "Inferno Burger with Regular Fries and Cola Drink", 1150, 5, 4.8),
    BBQ("BBQ Combo Meal", 11.99, List.of(ClassicBurger.BBQ, FrenchFries.GARLIC_PARMESAN, ColdDrink.LEMON_LIME_SODA), "BBQ Burger with Garlic Parmesan Fries and Lemon Lime Soda", 1250, 2, 4.4),
    SEAFOOD("Seafood Combo Meal", 12.99, List.of(SpicyBurger.CAJUN_SHRIMP, FrenchFries.SWEET_POTATO, ColdDrink.PINEAPPLE_SMOOTHIE), "Cajun Shrimp Burger with Sweet Potato Fries and Pineapple Smoothie", 1080, 2, 4.2),
    FITNESS("Fitness Combo Meal", 9.49, List.of(ClassicBurger.CHICKEN, Side.SALAD, ColdDrink.WATERMELON_JUICE), "Grilled Chicken Burger with Side Salad and Watermelon Juice", 850, 1, 4.5),
    ULTIMATE("Ultimate Combo Meal", 13.99, List.of(ClassicBurger.DOUBLE_BACON_CHEESEBURGER, FrenchFries.LOADED_FRIES, ColdDrink.CHOCOLATE_MILKSHAKE), "Double Bacon Cheeseburger with Loaded Fries and Chocolate Milkshake", 1450, 3, 4.9),
    HEALTHY("Healthy Combo Meal", 10.49, List.of(ClassicBurger.TURKEY, Side.QUINOA_SALAD, ColdDrink.ORANGE_JUICE), "Turkey Burger with Quinoa Salad and Orange Juice", 920, 1, 4.7),
    ITALIAN("Italian Inspired Combo Meal", 11.99, List.of(GourmetBurger.PESTO_TURKEY, FrenchFries.GARLIC_PARMESAN, ColdDrink.CARAMEL_ICED_COFFEE), "Pesto Turkey Burger with Garlic Parmesan Fries and Caramel Iced Coffee", 1050, 1, 4.8),
    SOUTHWESTERN("Southwestern Combo Meal", 10.49, List.of(SpicyBurger.CHIPOTLE_BLACK_BEAN, FrenchFries.CURLY, ColdDrink.LEMON_LIME_SODA), "Chipotle Black Bean Burger with Curly Fries and Lemon Lime Soda", 970, 3, 4.1),
    TRUFFLE("Gourmet Combo Meal 2", 12.99, List.of(GourmetBurger.TRUFFLE_MUSHROOM, FrenchFries.LOADED_FRIES, ColdDrink.BLUEBERRY_SMOOTHIE), "Truffle Mushroom Burger with Loaded Fries and Blueberry Smoothie", 1350, 2, 4.6),
    TROPICAL_TWIST("Tropical Twist Combo Meal", 11.99, List.of(ClassicBurger.TERIYAKI, FrenchFries.SWEET_POTATO, ColdDrink.PINEAPPLE_PINA_COLADA), "Hawaiian Teriyaki Burger with Sweet Potato Fries and Pineapple Piña Colada", 1220, 1, 4.4),
    MEDITERRANEAN("Mediterranean Combo Meal", 12.49, List.of(GourmetBurger.MEDITERRANEAN_LAMB, Side.GREEK_SALAD, ColdDrink.ORANGE_JUICE), "Mediterranean Lamb Burger with Greek Salad and Orange Juice", 1280, 1, 4.5),
    FARMHOUSE("Farmhouse Combo Meal", 11.99, List.of(ClassicBurger.TURKEY, Dessert.SWEET_CORNBREAD, ColdDrink.ORANGE_JUICE), "Turkey Burger with Sweet Cornbread with Jalapeño and Orange Juice", 1100, 1, 4.3),
    BBQ_BONANZA("BBQ Bonanza Combo Meal", 11.99, List.of(ClassicBurger.BBQ, Side.ONION_RINGS, ColdDrink.ICE_TEA), "BBQ Bonanza Burger with Onion Rings and Iced Tea", 1230, 2, 4.2),
    SAVORY_SEAFOOD("Savory Seafood Combo Meal", 13.49, List.of(UniqueFlavorBurger.SMOKED_SALMON, Side.GREEK_SALAD, ColdDrink.MULBERRY_SMOOTHIE), "Salmon Burger with Greek Salad and Mulberry Smoothie", 1150, 1, 4.4);

    public static final Type TYPE = Type.COMBO_MEAL;
    private final String name;
    private final double price;
    private final List<Product> ingredients;
    private final String description;
    private final int calories;
    private final double spicinessLevel;
    private final double popularityRating;

    ComboMeal(String name, double price, List<Product> ingredients, String description, int calories, double spicinessLevel, double popularityRating) {
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
    public String getDescription() {
        return description;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public List<Product> getIngredients() {
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
