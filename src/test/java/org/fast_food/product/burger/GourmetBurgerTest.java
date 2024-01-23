package org.fast_food.product.burger;

import org.junit.jupiter.api.Test;

import static org.fast_food.product.burger.ClassicBurger.*;
import static org.fast_food.product.burger.GourmetBurger.*;
import static org.junit.jupiter.api.Assertions.*;

class GourmetBurgerTest {

    @Test
    void getName() {
        assertEquals(BLUE_CHEESE_BURGER.getName(), "Blue Cheese Burger");
        assertEquals(AVOCADO_RANCH_BURGER.getName(), "Avocado Ranch Burger");
        assertEquals(TRUFFLE_MUSHROOM_BURGER.getName(), "Truffle Mushroom Burger");
        assertEquals(GUACAMOLE_BACON_BURGER.getName(), "Guacamole Bacon Burger");
        assertEquals(BBQ_RANCH_BACON_BURGER.getName(), "BBQ Ranch Bacon Burger");
        assertEquals(CAJUN_SPICED_BURGER.getName(), "Cajun Spiced Burger");
        assertEquals(PESTO_TURKEY_BURGER.getName(), "Pesto Turkey Burger");
        assertEquals(PHILLY_CHEESE_STEAK_BURGER.getName(), "Philly Cheese Steak Burger");
        assertEquals(MEDITERRANEAN_LAMB_BURGER.getName(), "Mediterranean Lamb Burger");
    }

    @Test
    void getPrice() {
        assertEquals(BLUE_CHEESE_BURGER.getPrice(), 6.99);
        assertEquals(AVOCADO_RANCH_BURGER.getPrice(), 7.29);
        assertEquals(TRUFFLE_MUSHROOM_BURGER.getPrice(), 7.49);
        assertEquals(GUACAMOLE_BACON_BURGER.getPrice(), 7.79);
        assertEquals(BBQ_RANCH_BACON_BURGER.getPrice(), 7.69);
        assertEquals(CAJUN_SPICED_BURGER.getPrice(), 6.89);
        assertEquals(PESTO_TURKEY_BURGER.getPrice(), 7.19);
        assertEquals(PHILLY_CHEESE_STEAK_BURGER.getPrice(), 8.29);
        assertEquals(MEDITERRANEAN_LAMB_BURGER.getPrice(), 8.49);
    }

    @Test
    void getDescription() {

    }

    @Test
    void getCalories() {
    }

    @Test
    void getIngredients() {
    }

    @Test
    void getSpicinessLevel() {
    }

    @Test
    void getPopularityRating() {
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}