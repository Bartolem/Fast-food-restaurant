package org.fast_food.product;

import org.fast_food.product.burger.ClassicBurger;
import org.fast_food.product.burger.GourmetBurger;
import org.fast_food.product.burger.SpicyBurger;
import org.fast_food.product.burger.UniqueFlavorBurger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComboMealTest {
    @Test
    void testGetNameForDifferentComboMeals() {
        assertEquals("Classic Combo Meal", ComboMeal.CLASSIC.getName());
        assertEquals("Gourmet Combo Meal", ComboMeal.GOURMET.getName());
        assertEquals("Tex-Mex Combo Meal", ComboMeal.TEX_MEX.getName());
        assertEquals("Spicy Combo Meal", ComboMeal.SPICY.getName());
        assertEquals("Inferno Combo Meal", ComboMeal.INFERNO.getName());
        assertEquals("BBQ Combo Meal", ComboMeal.BBQ.getName());
        assertEquals("Seafood Combo Meal", ComboMeal.SEAFOOD.getName());
        assertEquals("Fitness Combo Meal", ComboMeal.FITNESS.getName());
        assertEquals("Ultimate Combo Meal", ComboMeal.ULTIMATE.getName());
        assertEquals("Healthy Combo Meal", ComboMeal.HEALTHY.getName());
        assertEquals("Italian Inspired Combo Meal", ComboMeal.ITALIAN.getName());
        assertEquals("Southwestern Combo Meal", ComboMeal.SOUTHWESTERN.getName());
        assertEquals("Truffle Combo Meal", ComboMeal.TRUFFLE.getName());
        assertEquals("Tropical Twist Combo Meal", ComboMeal.TROPICAL_TWIST.getName());
        assertEquals("Mediterranean Combo Meal", ComboMeal.MEDITERRANEAN.getName());
        assertEquals("Farmhouse Combo Meal", ComboMeal.FARMHOUSE.getName());
        assertEquals("BBQ Bonanza Combo Meal", ComboMeal.BBQ_BONANZA.getName());
        assertEquals("Savory Seafood Combo Meal", ComboMeal.SAVORY_SEAFOOD.getName());
    }

    @Test
    void testGetPriceForDifferentComboMeals() {
        assertEquals(9.99, ComboMeal.CLASSIC.getPrice());
        assertEquals(12.99, ComboMeal.GOURMET.getPrice());
        assertEquals(10.49, ComboMeal.TEX_MEX.getPrice());
        assertEquals(9.99, ComboMeal.SPICY.getPrice());
        assertEquals(11.49, ComboMeal.INFERNO.getPrice());
        assertEquals(11.99, ComboMeal.BBQ.getPrice());
        assertEquals(12.99, ComboMeal.SEAFOOD.getPrice());
        assertEquals(9.49, ComboMeal.FITNESS.getPrice());
        assertEquals(13.99, ComboMeal.ULTIMATE.getPrice());
        assertEquals(10.49, ComboMeal.HEALTHY.getPrice());
        assertEquals(11.99, ComboMeal.ITALIAN.getPrice());
        assertEquals(10.49, ComboMeal.SOUTHWESTERN.getPrice());
        assertEquals(12.99, ComboMeal.TRUFFLE.getPrice());
        assertEquals(11.99, ComboMeal.TROPICAL_TWIST.getPrice());
        assertEquals(12.49, ComboMeal.MEDITERRANEAN.getPrice());
        assertEquals(11.99, ComboMeal.FARMHOUSE.getPrice());
        assertEquals(11.99, ComboMeal.BBQ_BONANZA.getPrice());
        assertEquals(13.49, ComboMeal.SAVORY_SEAFOOD.getPrice());
    }

    @Test
    void testGetDescriptionForDifferentComboMeals() {
        assertEquals("Classic Cheeseburger with Regular Fries and Cola Drink", ComboMeal.CLASSIC.getDescription());
        assertEquals("Blue Cheese Burger with Sweet Potato Fries and Pineapple Piña Colada", ComboMeal.GOURMET.getDescription());
        assertEquals("Jalapeño Burger with Regular Fries and Iced Tea", ComboMeal.TEX_MEX.getDescription());
        assertEquals("Spicy Sriracha Burger with Regular Fries and Mint Cocktail", ComboMeal.SPICY.getDescription());
        assertEquals("Inferno Burger with Regular Fries and Cola Drink", ComboMeal.INFERNO.getDescription());
        assertEquals("BBQ Burger with Garlic Parmesan Fries and Lemon Lime Soda", ComboMeal.BBQ.getDescription());
        assertEquals("Cajun Shrimp Burger with Sweet Potato Fries and Pineapple Smoothie", ComboMeal.SEAFOOD.getDescription());
        assertEquals("Grilled Chicken Burger with Side Salad and Watermelon Juice", ComboMeal.FITNESS.getDescription());
        assertEquals("Double Bacon Cheeseburger with Loaded Fries and Chocolate Milkshake", ComboMeal.ULTIMATE.getDescription());
        assertEquals("Turkey Burger with Quinoa Salad and Orange Juice", ComboMeal.HEALTHY.getDescription());
        assertEquals("Pesto Turkey Burger with Garlic Parmesan Fries and Caramel Iced Coffee", ComboMeal.ITALIAN.getDescription());
        assertEquals("Chipotle Black Bean Burger with Curly Fries and Lemon Lime Soda", ComboMeal.SOUTHWESTERN.getDescription());
        assertEquals("Truffle Mushroom Burger with Loaded Fries and Blueberry Smoothie", ComboMeal.TRUFFLE.getDescription());
        assertEquals("Hawaiian Teriyaki Burger with Sweet Potato Fries and Pineapple Piña Colada", ComboMeal.TROPICAL_TWIST.getDescription());
        assertEquals("Mediterranean Lamb Burger with Greek Salad and Orange Juice", ComboMeal.MEDITERRANEAN.getDescription());
        assertEquals("Turkey Burger with Sweet Cornbread with Jalapeño and Orange Juice", ComboMeal.FARMHOUSE.getDescription());
        assertEquals("BBQ Bonanza Burger with Onion Rings and Iced Tea", ComboMeal.BBQ_BONANZA.getDescription());
        assertEquals("Salmon Burger with Greek Salad and Mulberry Smoothie", ComboMeal.SAVORY_SEAFOOD.getDescription());
    }

    @Test
    void testGetCaloriesForDifferentComboMeals() {
        assertEquals(1120, ComboMeal.CLASSIC.getCalories());
        assertEquals(1180, ComboMeal.GOURMET.getCalories());
        assertEquals(1050, ComboMeal.TEX_MEX.getCalories());
        assertEquals(980, ComboMeal.SPICY.getCalories());
        assertEquals(1150, ComboMeal.INFERNO.getCalories());
        assertEquals(1250, ComboMeal.BBQ.getCalories());
        assertEquals(1080, ComboMeal.SEAFOOD.getCalories());
        assertEquals(850, ComboMeal.FITNESS.getCalories());
        assertEquals(1450, ComboMeal.ULTIMATE.getCalories());
        assertEquals(920, ComboMeal.HEALTHY.getCalories());
        assertEquals(1050, ComboMeal.ITALIAN.getCalories());
        assertEquals(970, ComboMeal.SOUTHWESTERN.getCalories());
        assertEquals(1350, ComboMeal.TRUFFLE.getCalories());
        assertEquals(1220, ComboMeal.TROPICAL_TWIST.getCalories());
        assertEquals(1280, ComboMeal.MEDITERRANEAN.getCalories());
        assertEquals(1100, ComboMeal.FARMHOUSE.getCalories());
        assertEquals(1230, ComboMeal.BBQ_BONANZA.getCalories());
        assertEquals(1150, ComboMeal.SAVORY_SEAFOOD.getCalories());
    }

    @Test
    void testGetIngredientsForDifferentComboMeals() {
        assertEquals(List.of(ClassicBurger.CLASSIC_CHEESEBURGER, FrenchFries.REGULAR, ColdDrink.COLA_DRINK), ComboMeal.CLASSIC.getIngredients());
        assertEquals(List.of(GourmetBurger.BLUE_CHEESE, FrenchFries.SWEET_POTATO, ColdDrink.PINEAPPLE_PINA_COLADA), ComboMeal.GOURMET.getIngredients());
        assertEquals(List.of(ClassicBurger.JALAPENO, FrenchFries.REGULAR, ColdDrink.ICE_TEA), ComboMeal.TEX_MEX.getIngredients());
        assertEquals(List.of(SpicyBurger.SPICY_SRIRACHA, FrenchFries.REGULAR, ColdDrink.MINT_COCKTAIL), ComboMeal.SPICY.getIngredients());
        assertEquals(List.of(SpicyBurger.INFERNO, FrenchFries.REGULAR, ColdDrink.COLA_DRINK), ComboMeal.INFERNO.getIngredients());
        assertEquals(List.of(ClassicBurger.BBQ, FrenchFries.GARLIC_PARMESAN, ColdDrink.LEMON_LIME_SODA), ComboMeal.BBQ.getIngredients());
        assertEquals(List.of(SpicyBurger.CAJUN_SHRIMP, FrenchFries.SWEET_POTATO, ColdDrink.PINEAPPLE_SMOOTHIE), ComboMeal.SEAFOOD.getIngredients());
        assertEquals(List.of(ClassicBurger.CHICKEN, Side.SALAD, ColdDrink.WATERMELON_JUICE), ComboMeal.FITNESS.getIngredients());
        assertEquals(List.of(ClassicBurger.DOUBLE_BACON_CHEESEBURGER, FrenchFries.LOADED_FRIES, ColdDrink.CHOCOLATE_MILKSHAKE), ComboMeal.ULTIMATE.getIngredients());
        assertEquals(List.of(ClassicBurger.TURKEY, Side.QUINOA_SALAD, ColdDrink.ORANGE_JUICE), ComboMeal.HEALTHY.getIngredients());
        assertEquals(List.of(GourmetBurger.PESTO_TURKEY, FrenchFries.GARLIC_PARMESAN, ColdDrink.CARAMEL_ICED_COFFEE), ComboMeal.ITALIAN.getIngredients());
        assertEquals(List.of(SpicyBurger.CHIPOTLE_BLACK_BEAN, FrenchFries.CURLY, ColdDrink.LEMON_LIME_SODA), ComboMeal.SOUTHWESTERN.getIngredients());
        assertEquals(List.of(GourmetBurger.TRUFFLE_MUSHROOM, FrenchFries.LOADED_FRIES, ColdDrink.BLUEBERRY_SMOOTHIE), ComboMeal.TRUFFLE.getIngredients());
        assertEquals(List.of(ClassicBurger.TERIYAKI, FrenchFries.SWEET_POTATO, ColdDrink.PINEAPPLE_PINA_COLADA), ComboMeal.TROPICAL_TWIST.getIngredients());
        assertEquals(List.of(GourmetBurger.MEDITERRANEAN_LAMB, Side.GREEK_SALAD, ColdDrink.ORANGE_JUICE), ComboMeal.MEDITERRANEAN.getIngredients());
        assertEquals(List.of(ClassicBurger.TURKEY, Dessert.SWEET_CORNBREAD, ColdDrink.ORANGE_JUICE), ComboMeal.FARMHOUSE.getIngredients());
        assertEquals(List.of(ClassicBurger.BBQ, Side.ONION_RINGS, ColdDrink.ICE_TEA), ComboMeal.BBQ_BONANZA.getIngredients());
        assertEquals(List.of(UniqueFlavorBurger.SMOKED_SALMON, Side.GREEK_SALAD, ColdDrink.MULBERRY_SMOOTHIE), ComboMeal.SAVORY_SEAFOOD.getIngredients());
    }

    @Test
    void testGetSpicinessLevelForDifferentComboMeals() {
        assertEquals(1, ComboMeal.CLASSIC.getSpicinessLevel());
        assertEquals(2, ComboMeal.GOURMET.getSpicinessLevel());
        assertEquals(3, ComboMeal.TEX_MEX.getSpicinessLevel());
        assertEquals(4, ComboMeal.SPICY.getSpicinessLevel());
        assertEquals(5, ComboMeal.INFERNO.getSpicinessLevel());
        assertEquals(2, ComboMeal.BBQ.getSpicinessLevel());
        assertEquals(2, ComboMeal.SEAFOOD.getSpicinessLevel());
        assertEquals(1, ComboMeal.FITNESS.getSpicinessLevel());
        assertEquals(3, ComboMeal.ULTIMATE.getSpicinessLevel());
        assertEquals(1, ComboMeal.HEALTHY.getSpicinessLevel());
        assertEquals(1, ComboMeal.ITALIAN.getSpicinessLevel());
        assertEquals(3, ComboMeal.SOUTHWESTERN.getSpicinessLevel());
        assertEquals(2, ComboMeal.TRUFFLE.getSpicinessLevel());
        assertEquals(1, ComboMeal.TROPICAL_TWIST.getSpicinessLevel());
        assertEquals(1, ComboMeal.MEDITERRANEAN.getSpicinessLevel());
        assertEquals(1, ComboMeal.FARMHOUSE.getSpicinessLevel());
        assertEquals(2, ComboMeal.BBQ_BONANZA.getSpicinessLevel());
        assertEquals(1, ComboMeal.SAVORY_SEAFOOD.getSpicinessLevel());
    }

    @Test
    void testGetPopularityRatingForDifferentComboMeals() {
        assertEquals(4.3, ComboMeal.CLASSIC.getPopularityRating());
        assertEquals(4.7, ComboMeal.GOURMET.getPopularityRating());
        assertEquals(4.0, ComboMeal.TEX_MEX.getPopularityRating());
        assertEquals(4.6, ComboMeal.SPICY.getPopularityRating());
        assertEquals(4.8, ComboMeal.INFERNO.getPopularityRating());
        assertEquals(4.4, ComboMeal.BBQ.getPopularityRating());
        assertEquals(4.2, ComboMeal.SEAFOOD.getPopularityRating());
        assertEquals(4.5, ComboMeal.FITNESS.getPopularityRating());
        assertEquals(4.9, ComboMeal.ULTIMATE.getPopularityRating());
        assertEquals(4.7, ComboMeal.HEALTHY.getPopularityRating());
        assertEquals(4.8, ComboMeal.ITALIAN.getPopularityRating());
        assertEquals(4.1, ComboMeal.SOUTHWESTERN.getPopularityRating());
        assertEquals(4.6, ComboMeal.TRUFFLE.getPopularityRating());
        assertEquals(4.4, ComboMeal.TROPICAL_TWIST.getPopularityRating());
        assertEquals(4.5, ComboMeal.MEDITERRANEAN.getPopularityRating());
        assertEquals(4.3, ComboMeal.FARMHOUSE.getPopularityRating());
        assertEquals(4.2, ComboMeal.BBQ_BONANZA.getPopularityRating());
        assertEquals(4.4, ComboMeal.SAVORY_SEAFOOD.getPopularityRating());
    }
}

