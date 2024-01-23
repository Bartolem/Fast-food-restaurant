package org.fast_food.product;

import org.junit.jupiter.api.Test;

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

    }

    @Test
    void getIngredients() {
    }

    @Test
    void getCalories() {
    }

    @Test
    void getSpicinessLevel() {
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