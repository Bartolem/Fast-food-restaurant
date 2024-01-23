package org.fast_food.product.burger;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fast_food.product.burger.ClassicBurger.*;
import static org.junit.jupiter.api.Assertions.*;

class ClassicBurgerTest {
    @Test
    void testGetNameForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getName(), "Classic Burger");
        assertEquals(CLASSIC_CHEESEBURGER.getName(), "Classic Cheeseburger");
        assertEquals(BACON_BURGER.getName(), "Bacon Burger");
        assertEquals(VEGGIE_BURGER.getName(), "Veggie Burger");
        assertEquals(CHICKEN_BURGER.getName(), "Chicken Burger");
        assertEquals(TURKEY_BURGER.getName(), "Turkey Burger");
        assertEquals(BBQ_BURGER.getName(), "BBQ Burger");
        assertEquals(JALAPENO_BURGER.getName(), "Jalapeño Burger");
        assertEquals(TERIYAKI_BURGER.getName(), "Teriyaki Burger");
        assertEquals(DOUBLE_BURGER.getName(), "Double Burger");
        assertEquals(DOUBLE_CHEESEBURGER.getName(), "Double Cheeseburger");
        assertEquals(DOUBLE_BACON_BURGER.getName(), "Double Bacon Burger");
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getName(), "Double Bacon Cheeseburger");
    }

    @Test
    void testGetPriceForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getPrice(), 4.99);
        assertEquals(CLASSIC_CHEESEBURGER.getPrice(), 5.19);
        assertEquals(BACON_BURGER.getPrice(), 5.49);
        assertEquals(VEGGIE_BURGER.getPrice(), 4.79);
        assertEquals(CHICKEN_BURGER.getPrice(), 5.29);
        assertEquals(TURKEY_BURGER.getPrice(), 5.49);
        assertEquals(BBQ_BURGER.getPrice(), 5.99);
        assertEquals(JALAPENO_BURGER.getPrice(), 5.59);
        assertEquals(TERIYAKI_BURGER.getPrice(), 5.89);
        assertEquals(DOUBLE_BURGER.getPrice(), 6.29);
        assertEquals(DOUBLE_CHEESEBURGER.getPrice(), 6.49);
        assertEquals(DOUBLE_BACON_BURGER.getPrice(), 6.99);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getPrice(), 7.19);
    }
    @Test
    void testGetIngredientsForDifferentBurgerTypes() {
        assertTrue(CLASSIC_BURGER.getIngredients().containsAll(List.of("Beef patty", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(CLASSIC_CHEESEBURGER.getIngredients().containsAll(List.of("Beef patty", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(BACON_BURGER.getIngredients().containsAll(List.of("Beef patty", "Bacon", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(VEGGIE_BURGER.getIngredients().containsAll(List.of("Vegetarian patty", "Lettuce", "Tomato", "Pickles", "Onions", "Mayonnaise")));
        assertTrue(CHICKEN_BURGER.getIngredients().containsAll(List.of("Grilled chicken breast", "Lettuce", "Tomato", "Pickles", "Onions", " Mayonnaise")));
        assertTrue(TURKEY_BURGER.getIngredients().containsAll(List.of("Turkey patty", "Lettuce", "Tomato", "Onions", "Cranberry sauce")));
        assertTrue(BBQ_BURGER.getIngredients().containsAll(List.of("Beef patty", "BBQ sauce", "Onion rings", "Lettuce")));
        assertTrue(JALAPENO_BURGER.getIngredients().containsAll(List.of("Beef patty", "Pepper jack cheese", "Jalapeños", "Lettuce", "Tomato")));
        assertTrue(TERIYAKI_BURGER.getIngredients().containsAll(List.of("Beef patty", "Teriyaki sauce", "Pineapple", "Lettuce", "Tomato")));
        assertTrue(DOUBLE_BURGER.getIngredients().containsAll(List.of("Two beef patties", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(DOUBLE_CHEESEBURGER.getIngredients().containsAll(List.of("Two beef patties", "Double cheese", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(DOUBLE_BACON_BURGER.getIngredients().containsAll(List.of("Two beef patties", "Bacon", "Cheese","Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(DOUBLE_BACON_CHEESEBURGER.getIngredients().containsAll(List.of("Two beef patties", "Bacon", "Double cheese", "Lettuce", "Tomato", "Pickles", "Onions")));

    }

    @Test
    void testGetCaloriesForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getCalories(), 570);
        assertEquals(CLASSIC_CHEESEBURGER.getCalories(), 650);
        assertEquals(BACON_BURGER.getCalories(), 800);
        assertEquals(VEGGIE_BURGER.getCalories(), 440);
        assertEquals(CHICKEN_BURGER.getCalories(), 550);
        assertEquals(TURKEY_BURGER.getCalories(), 550);
        assertEquals(BBQ_BURGER.getCalories(), 680);
        assertEquals(JALAPENO_BURGER.getCalories(), 640);
        assertEquals(TERIYAKI_BURGER.getCalories(), 600);
        assertEquals(DOUBLE_BURGER.getCalories(), 950);
        assertEquals(DOUBLE_CHEESEBURGER.getCalories(), 1000);
        assertEquals(DOUBLE_BACON_BURGER.getCalories(), 1120);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getCalories(), 1280);
    }

    @Test
    void testGetSpicinessLevelForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getSpicinessLevel(), 1);
        assertEquals(CLASSIC_CHEESEBURGER.getSpicinessLevel(), 1);
        assertEquals(BACON_BURGER.getSpicinessLevel(), 2);
        assertEquals(VEGGIE_BURGER.getSpicinessLevel(), 1);
        assertEquals(CHICKEN_BURGER.getSpicinessLevel(), 1);
        assertEquals(TURKEY_BURGER.getSpicinessLevel(), 1);
        assertEquals(BBQ_BURGER.getSpicinessLevel(), 1.5);
        assertEquals(JALAPENO_BURGER.getSpicinessLevel(), 3);
        assertEquals(TERIYAKI_BURGER.getSpicinessLevel(), 1);
        assertEquals(DOUBLE_BURGER.getSpicinessLevel(), 1);
        assertEquals(DOUBLE_CHEESEBURGER.getSpicinessLevel(), 1);
        assertEquals(DOUBLE_BACON_BURGER.getSpicinessLevel(), 2);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getSpicinessLevel(), 2);
    }

    @Test
    void testGetPopularityRatingForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getPopularityRating(), 4.7);
        assertEquals(CLASSIC_CHEESEBURGER.getPopularityRating(), 4.5);
        assertEquals(BACON_BURGER.getPopularityRating(), 4.8);
        assertEquals(VEGGIE_BURGER.getPopularityRating(), 4.1);
        assertEquals(CHICKEN_BURGER.getPopularityRating(), 4.3);
        assertEquals(TURKEY_BURGER.getPopularityRating(), 4.0);
        assertEquals(BBQ_BURGER.getPopularityRating(), 4.3);
        assertEquals(JALAPENO_BURGER.getPopularityRating(), 3.8);
        assertEquals(TERIYAKI_BURGER.getPopularityRating(), 4.2);
        assertEquals(DOUBLE_BURGER.getPopularityRating(), 4.4);
        assertEquals(DOUBLE_CHEESEBURGER.getPopularityRating(), 4.4);
        assertEquals(DOUBLE_BACON_BURGER.getPopularityRating(), 4.6);
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getPopularityRating(), 4.5);
    }

    @Test
    void testGetDescriptionForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getDescription(), "The classic cheeseburger with a juicy beef patty, melted cheese, and fresh vegetables.");
        assertEquals(CLASSIC_CHEESEBURGER.getDescription(), "The classic burger with a juicy beef patty and fresh vegetables.");
        assertEquals(BACON_BURGER.getDescription(), "A mouthwatering burger featuring crispy bacon on top of a delicious beef patty.");
        assertEquals(VEGGIE_BURGER.getDescription(), "A meat-free option loaded with fresh vegetables and a tasty vegetarian patty.");
        assertEquals(CHICKEN_BURGER.getDescription(), "A grilled chicken burger with crisp veggies and mayo for a delightful flavor.");
        assertEquals(TURKEY_BURGER.getDescription(), "A healthier option with a turkey patty and a touch of sweet cranberry sauce.");
        assertEquals(BBQ_BURGER.getDescription(), "A savory BBQ-infused burger with melted cheddar and crispy onion rings.");
        assertEquals(JALAPENO_BURGER.getDescription(), "A spicy delight with pepper jack cheese and a kick of jalapeños.");
        assertEquals(TERIYAKI_BURGER.getDescription(), "A flavorful burger with a sweet and tangy teriyaki glaze and a hint of pineapple.");
        assertEquals(DOUBLE_BURGER.getDescription(), "A hearty and indulgent burger for the ultimate burger enthusiast. This Double Burger features not one, but two succulent beef patties. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.");
        assertEquals(DOUBLE_CHEESEBURGER.getDescription(), "A hearty and indulgent burger for the ultimate cheese enthusiast. This Double Cheeseburger features not one, but two succulent beef patties and topped with double cheese. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.");
        assertEquals(DOUBLE_BACON_BURGER.getDescription(), "For the ultimate bacon lover – double beef and crispy bacon.");
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getDescription(), "For the ultimate bacon and cheese lover – double beef, double cheese, and crispy bacon.");
    }

    @Test
    void testClassicBurgerContainsAllValues() {
        assertTrue(List.of(CLASSIC_BURGER, CLASSIC_CHEESEBURGER, BACON_BURGER, VEGGIE_BURGER, CHICKEN_BURGER, TURKEY_BURGER, BBQ_BURGER, JALAPENO_BURGER, TERIYAKI_BURGER, DOUBLE_BURGER, DOUBLE_CHEESEBURGER, DOUBLE_BACON_BURGER, DOUBLE_BACON_CHEESEBURGER).containsAll(List.of(ClassicBurger.values())));
    }

    @Test
    void testValueOfDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER, ClassicBurger.valueOf("CLASSIC_BURGER"));
        assertEquals(CLASSIC_CHEESEBURGER, ClassicBurger.valueOf("CLASSIC_CHEESEBURGER"));
        assertEquals(BACON_BURGER, ClassicBurger.valueOf("BACON_BURGER"));
        assertEquals(VEGGIE_BURGER, ClassicBurger.valueOf("VEGGIE_BURGER"));
        assertEquals(CHICKEN_BURGER, ClassicBurger.valueOf("CHICKEN_BURGER"));
        assertEquals(TURKEY_BURGER, ClassicBurger.valueOf("TURKEY_BURGER"));
        assertEquals(BBQ_BURGER, ClassicBurger.valueOf("BBQ_BURGER"));
        assertEquals(JALAPENO_BURGER, ClassicBurger.valueOf("JALAPENO_BURGER"));
        assertEquals(TERIYAKI_BURGER, ClassicBurger.valueOf("TERIYAKI_BURGER"));
        assertEquals(DOUBLE_BURGER, ClassicBurger.valueOf("DOUBLE_BURGER"));
        assertEquals(DOUBLE_CHEESEBURGER, ClassicBurger.valueOf("DOUBLE_CHEESEBURGER"));
        assertEquals(DOUBLE_BACON_BURGER, ClassicBurger.valueOf("DOUBLE_BACON_BURGER"));
        assertEquals(DOUBLE_BACON_CHEESEBURGER, ClassicBurger.valueOf("DOUBLE_BACON_CHEESEBURGER"));
    }
}