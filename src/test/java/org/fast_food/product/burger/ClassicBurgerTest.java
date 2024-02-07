package org.fast_food.product.burger;

import org.fast_food.product.burger.ingredient.Cheese;
import org.fast_food.product.burger.ingredient.Ingredient;
import org.fast_food.product.burger.ingredient.Sauce;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fast_food.product.burger.ClassicBurger.*;
import static org.junit.jupiter.api.Assertions.*;

class ClassicBurgerTest {
    @Test
    void testGetNameForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getName(), "Classic Burger");
        assertEquals(CLASSIC_CHEESEBURGER.getName(), "Classic Cheeseburger");
        assertEquals(BACON.getName(), "Bacon Burger");
        assertEquals(VEGGIE.getName(), "Veggie Burger");
        assertEquals(CHICKEN.getName(), "Chicken Burger");
        assertEquals(TURKEY.getName(), "Turkey Burger");
        assertEquals(BBQ.getName(), "BBQ Burger");
        assertEquals(JALAPENO.getName(), "Jalapeño Burger");
        assertEquals(TERIYAKI.getName(), "Teriyaki Burger");
        assertEquals(DOUBLE_BURGER.getName(), "Double Burger");
        assertEquals(DOUBLE_CHEESEBURGER.getName(), "Double Cheeseburger");
        assertEquals(DOUBLE_BACON.getName(), "Double Bacon Burger");
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getName(), "Double Bacon Cheeseburger");
    }

    @Test
    void testGetPriceForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getPrice(), 4.99);
        assertEquals(CLASSIC_CHEESEBURGER.getPrice(), 5.19);
        assertEquals(BACON.getPrice(), 5.49);
        assertEquals(VEGGIE.getPrice(), 4.79);
        assertEquals(CHICKEN.getPrice(), 5.29);
        assertEquals(TURKEY.getPrice(), 5.49);
        assertEquals(BBQ.getPrice(), 5.99);
        assertEquals(JALAPENO.getPrice(), 5.59);
        assertEquals(TERIYAKI.getPrice(), 5.89);
        assertEquals(DOUBLE_BURGER.getPrice(), 6.29);
        assertEquals(DOUBLE_CHEESEBURGER.getPrice(), 6.49);
        assertEquals(DOUBLE_BACON.getPrice(), 6.99);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getPrice(), 7.19);
    }
    @Test
    void testGetIngredientsForDifferentBurgerTypes() {
        assertTrue(CLASSIC_BURGER.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION)));
        assertTrue(CLASSIC_CHEESEBURGER.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION)));
        assertTrue(BACON.getIngredients().containsAll( List.of(Ingredient.BEEF_PATTY, Ingredient.BACON, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION)));
        assertTrue(VEGGIE.getIngredients().containsAll(List.of(Ingredient.VEGGIE_PATTY, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Sauce.MAYO)));
        assertTrue(CHICKEN.getIngredients().containsAll(List.of(Ingredient.CHICKEN, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Sauce.MAYO)));
        assertTrue(TURKEY.getIngredients().containsAll(List.of(Ingredient.TURKEY, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.ONION, Sauce.CRANBERRY_SAUCE)));
        assertTrue(BBQ.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Sauce.BBQ_SAUCE, Ingredient.ONION_RINGS, Ingredient.LETTUCE)));
        assertTrue(JALAPENO.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Cheese.PEPPER_JACK_CHEESE, Ingredient.JALAPENOS, Ingredient.LETTUCE, Ingredient.TOMATO)));
        assertTrue(TERIYAKI.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Sauce.TERIYAKI_SAUCE, Ingredient.TOMATO, Ingredient.LETTUCE, Ingredient.PINEAPPLE, Ingredient.TOMATO)));
        assertTrue(DOUBLE_BURGER.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Ingredient.BEEF_PATTY, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION)));
        assertTrue(DOUBLE_CHEESEBURGER.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Ingredient.BEEF_PATTY, Cheese.CHEESE, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION)));
        assertTrue(DOUBLE_BACON.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Ingredient.BEEF_PATTY, Ingredient.BACON, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION)));
        assertTrue(DOUBLE_BACON_CHEESEBURGER.getIngredients().containsAll(List.of(Ingredient.BEEF_PATTY, Ingredient.BEEF_PATTY, Ingredient.BACON, Cheese.CHEESE, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION)));

    }

    @Test
    void testGetCaloriesForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getCalories(), 570);
        assertEquals(CLASSIC_CHEESEBURGER.getCalories(), 650);
        assertEquals(BACON.getCalories(), 800);
        assertEquals(VEGGIE.getCalories(), 440);
        assertEquals(CHICKEN.getCalories(), 550);
        assertEquals(TURKEY.getCalories(), 550);
        assertEquals(BBQ.getCalories(), 680);
        assertEquals(JALAPENO.getCalories(), 640);
        assertEquals(TERIYAKI.getCalories(), 600);
        assertEquals(DOUBLE_BURGER.getCalories(), 950);
        assertEquals(DOUBLE_CHEESEBURGER.getCalories(), 1000);
        assertEquals(DOUBLE_BACON.getCalories(), 1120);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getCalories(), 1280);
    }

    @Test
    void testGetSpicinessLevelForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getSpicinessLevel(), 1);
        assertEquals(CLASSIC_CHEESEBURGER.getSpicinessLevel(), 1);
        assertEquals(BACON.getSpicinessLevel(), 2);
        assertEquals(VEGGIE.getSpicinessLevel(), 1);
        assertEquals(CHICKEN.getSpicinessLevel(), 1);
        assertEquals(TURKEY.getSpicinessLevel(), 1);
        assertEquals(BBQ.getSpicinessLevel(), 1.5);
        assertEquals(JALAPENO.getSpicinessLevel(), 3);
        assertEquals(TERIYAKI.getSpicinessLevel(), 1);
        assertEquals(DOUBLE_BURGER.getSpicinessLevel(), 1);
        assertEquals(DOUBLE_CHEESEBURGER.getSpicinessLevel(), 1);
        assertEquals(DOUBLE_BACON.getSpicinessLevel(), 2);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getSpicinessLevel(), 2);
    }

    @Test
    void testGetPopularityRatingForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getPopularityRating(), 4.7);
        assertEquals(CLASSIC_CHEESEBURGER.getPopularityRating(), 4.5);
        assertEquals(BACON.getPopularityRating(), 4.8);
        assertEquals(VEGGIE.getPopularityRating(), 4.1);
        assertEquals(CHICKEN.getPopularityRating(), 4.3);
        assertEquals(TURKEY.getPopularityRating(), 4.0);
        assertEquals(BBQ.getPopularityRating(), 4.3);
        assertEquals(JALAPENO.getPopularityRating(), 3.8);
        assertEquals(TERIYAKI.getPopularityRating(), 4.2);
        assertEquals(DOUBLE_BURGER.getPopularityRating(), 4.4);
        assertEquals(DOUBLE_CHEESEBURGER.getPopularityRating(), 4.4);
        assertEquals(DOUBLE_BACON.getPopularityRating(), 4.6);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getPopularityRating(), 4.5);
    }

    @Test
    void testGetDescriptionForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getDescription(), "The classic cheeseburger with a juicy beef patty, melted cheese, and fresh vegetables.");
        assertEquals(CLASSIC_CHEESEBURGER.getDescription(), "The classic burger with a juicy beef patty and fresh vegetables.");
        assertEquals(BACON.getDescription(), "A mouthwatering burger featuring crispy bacon on top of a delicious beef patty.");
        assertEquals(VEGGIE.getDescription(), "A meat-free option loaded with fresh vegetables and a tasty vegetarian patty.");
        assertEquals(CHICKEN.getDescription(), "A grilled chicken burger with crisp veggies and mayo for a delightful flavor.");
        assertEquals(TURKEY.getDescription(), "A healthier option with a turkey patty and a touch of sweet cranberry sauce.");
        assertEquals(BBQ.getDescription(), "A savory BBQ-infused burger with melted cheddar and crispy onion rings.");
        assertEquals(JALAPENO.getDescription(), "A spicy delight with pepper jack cheese and a kick of jalapeños.");
        assertEquals(TERIYAKI.getDescription(), "A flavorful burger with a sweet and tangy teriyaki glaze and a hint of pineapple.");
        assertEquals(DOUBLE_BURGER.getDescription(), "A hearty and indulgent burger for the ultimate burger enthusiast. This Double Burger features not one, but two succulent beef patties. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.");
        assertEquals(DOUBLE_CHEESEBURGER.getDescription(), "A hearty and indulgent burger for the ultimate cheese enthusiast. This Double Cheeseburger features not one, but two succulent beef patties and topped with double cheese. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.");
        assertEquals(DOUBLE_BACON.getDescription(), "For the ultimate bacon lover – double beef and crispy bacon.");
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getDescription(), "For the ultimate bacon and cheese lover – double beef, double cheese, and crispy bacon.");
    }

    @Test
    void testClassicBurgerContainsAllValues() {
        assertTrue(List.of(CLASSIC_BURGER, CLASSIC_CHEESEBURGER, BACON, VEGGIE, CHICKEN, TURKEY, BBQ, JALAPENO, TERIYAKI, DOUBLE_BURGER, DOUBLE_CHEESEBURGER, DOUBLE_BACON, DOUBLE_BACON_CHEESEBURGER).containsAll(List.of(ClassicBurger.values())));
    }

    @Test
    void testValueOfDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER, ClassicBurger.valueOf("CLASSIC_BURGER"));
        assertEquals(CLASSIC_CHEESEBURGER, ClassicBurger.valueOf("CLASSIC_CHEESEBURGER"));
        assertEquals(BACON, ClassicBurger.valueOf("BACON_BURGER"));
        assertEquals(VEGGIE, ClassicBurger.valueOf("VEGGIE_BURGER"));
        assertEquals(CHICKEN, ClassicBurger.valueOf("CHICKEN_BURGER"));
        assertEquals(TURKEY, ClassicBurger.valueOf("TURKEY_BURGER"));
        assertEquals(BBQ, ClassicBurger.valueOf("BBQ_BURGER"));
        assertEquals(JALAPENO, ClassicBurger.valueOf("JALAPENO_BURGER"));
        assertEquals(TERIYAKI, ClassicBurger.valueOf("TERIYAKI_BURGER"));
        assertEquals(DOUBLE_BURGER, ClassicBurger.valueOf("DOUBLE_BURGER"));
        assertEquals(DOUBLE_CHEESEBURGER, ClassicBurger.valueOf("DOUBLE_CHEESEBURGER"));
        assertEquals(DOUBLE_BACON, ClassicBurger.valueOf("DOUBLE_BACON_BURGER"));
        assertEquals(DOUBLE_BACON_CHEESEBURGER, ClassicBurger.valueOf("DOUBLE_BACON_CHEESEBURGER"));
    }
}