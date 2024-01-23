package org.fast_food.product;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassicBurgerTest {
    @Test
    void getName() {
        assertEquals(ClassicBurger.CLASSIC_BURGER.getName(), "Classic Burger");
        assertEquals(ClassicBurger.CLASSIC_CHEESEBURGER.getName(), "Classic Cheeseburger");
        assertEquals(ClassicBurger.BACON_BURGER.getName(), "Bacon Burger");
        assertEquals(ClassicBurger.VEGGIE_BURGER.getName(), "Veggie Burger");
        assertEquals(ClassicBurger.CHICKEN_BURGER.getName(), "Chicken Burger");
        assertEquals(ClassicBurger.TURKEY_BURGER.getName(), "Turkey Burger");
        assertEquals(ClassicBurger.BBQ_BURGER.getName(), "BBQ Burger");
        assertEquals(ClassicBurger.JALAPENO_BURGER.getName(), "Jalapeño Burger");
        assertEquals(ClassicBurger.TERIYAKI_BURGER.getName(), "Teriyaki Burger");
        assertEquals(ClassicBurger.DOUBLE_BURGER.getName(), "Double Burger");
        assertEquals(ClassicBurger.DOUBLE_CHEESEBURGER.getName(), "Double Cheeseburger");
        assertEquals(ClassicBurger.DOUBLE_BACON_BURGER.getName(), "Double Bacon Burger");
        assertEquals(ClassicBurger.DOUBLE_BACON_CHEESEBURGER.getName(), "Double Bacon Cheeseburger");
    }

    @Test
    void getPrice() {
        assertEquals(ClassicBurger.CLASSIC_BURGER.getPrice(), 4.99);
        assertEquals(ClassicBurger.CLASSIC_CHEESEBURGER.getPrice(), 5.19);
        assertEquals(ClassicBurger.BACON_BURGER.getPrice(), 5.49);
        assertEquals(ClassicBurger.VEGGIE_BURGER.getPrice(), 4.79);
        assertEquals(ClassicBurger.CHICKEN_BURGER.getPrice(), 5.29);
        assertEquals(ClassicBurger.TURKEY_BURGER.getPrice(), 5.49);
        assertEquals(ClassicBurger.BBQ_BURGER.getPrice(), 5.99);
        assertEquals(ClassicBurger.JALAPENO_BURGER.getPrice(), 5.59);
        assertEquals(ClassicBurger.TERIYAKI_BURGER.getPrice(), 5.89);
        assertEquals(ClassicBurger.DOUBLE_BURGER.getPrice(), 6.29);
        assertEquals(ClassicBurger.DOUBLE_CHEESEBURGER.getPrice(), 6.49);
        assertEquals(ClassicBurger.DOUBLE_BACON_BURGER.getPrice(), 6.99);
        assertEquals(ClassicBurger.DOUBLE_BACON_CHEESEBURGER.getPrice(), 7.19);
    }

    @Test
    void getIngredients() {
        assertTrue(ClassicBurger.CLASSIC_BURGER.getIngredients().containsAll(List.of("Beef patty", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(ClassicBurger.CLASSIC_CHEESEBURGER.getIngredients().containsAll(List.of("Beef patty", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(ClassicBurger.BACON_BURGER.getIngredients().containsAll(List.of("Beef patty", "Bacon", "Cheese", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(ClassicBurger.VEGGIE_BURGER.getIngredients().containsAll(List.of("Vegetarian patty", "Lettuce", "Tomato", "Pickles", "Onions", "Mayonnaise")));
        assertTrue(ClassicBurger.CHICKEN_BURGER.getIngredients().containsAll(List.of("Grilled chicken breast", "Lettuce", "Tomato", "Pickles", "Onions", " Mayonnaise")));
        assertTrue(ClassicBurger.TURKEY_BURGER.getIngredients().containsAll(List.of("Turkey patty", "Lettuce", "Tomato", "Onions", "Cranberry sauce")));
        assertTrue(ClassicBurger.BBQ_BURGER.getIngredients().containsAll(List.of("Beef patty", "BBQ sauce", "Onion rings", "Lettuce")));
        assertTrue(ClassicBurger.JALAPENO_BURGER.getIngredients().containsAll(List.of("Beef patty", "Pepper jack cheese", "Jalapeños", "Lettuce", "Tomato")));
        assertTrue(ClassicBurger.TERIYAKI_BURGER.getIngredients().containsAll(List.of("Beef patty", "Teriyaki sauce", "Pineapple", "Lettuce", "Tomato")));
        assertTrue(ClassicBurger.DOUBLE_BURGER.getIngredients().containsAll(List.of("Two beef patties", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(ClassicBurger.DOUBLE_CHEESEBURGER.getIngredients().containsAll(List.of("Two beef patties", "Double cheese", "Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(ClassicBurger.DOUBLE_BACON_BURGER.getIngredients().containsAll(List.of("Two beef patties", "Bacon", "Cheese","Lettuce", "Tomato", "Pickles", "Onions")));
        assertTrue(ClassicBurger.DOUBLE_BACON_CHEESEBURGER.getIngredients().containsAll(List.of("Two beef patties", "Bacon", "Double cheese", "Lettuce", "Tomato", "Pickles", "Onions")));

    }

    @Test
    void getCalories() {
        assertEquals(ClassicBurger.CLASSIC_BURGER.getCalories(), 570);
        assertEquals(ClassicBurger.CLASSIC_CHEESEBURGER.getCalories(), 650);
        assertEquals(ClassicBurger.BACON_BURGER.getCalories(), 800);
        assertEquals(ClassicBurger.VEGGIE_BURGER.getCalories(), 440);
        assertEquals(ClassicBurger.CHICKEN_BURGER.getCalories(), 550);
        assertEquals(ClassicBurger.TURKEY_BURGER.getCalories(), 550);
        assertEquals(ClassicBurger.BBQ_BURGER.getCalories(), 680);
        assertEquals(ClassicBurger.JALAPENO_BURGER.getCalories(), 640);
        assertEquals(ClassicBurger.TERIYAKI_BURGER.getCalories(), 600);
        assertEquals(ClassicBurger.DOUBLE_BURGER.getCalories(), 950);
        assertEquals(ClassicBurger.DOUBLE_CHEESEBURGER.getCalories(), 1000);
        assertEquals(ClassicBurger.DOUBLE_BACON_BURGER.getCalories(), 1120);
        assertEquals(ClassicBurger.DOUBLE_BACON_CHEESEBURGER.getCalories(), 1280);
    }

    @Test
    void getSpicinessLevel() {
        assertEquals(ClassicBurger.CLASSIC_BURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.CLASSIC_CHEESEBURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.BACON_BURGER.getSpicinessLevel(), 2);
        assertEquals(ClassicBurger.VEGGIE_BURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.CHICKEN_BURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.TURKEY_BURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.BBQ_BURGER.getSpicinessLevel(), 1.5);
        assertEquals(ClassicBurger.JALAPENO_BURGER.getSpicinessLevel(), 3);
        assertEquals(ClassicBurger.TERIYAKI_BURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.DOUBLE_BURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.DOUBLE_CHEESEBURGER.getSpicinessLevel(), 1);
        assertEquals(ClassicBurger.DOUBLE_BACON_BURGER.getSpicinessLevel(), 2);
        assertEquals(ClassicBurger.DOUBLE_BACON_CHEESEBURGER.getSpicinessLevel(), 2);
    }

    @Test
    void getPopularityRating() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}