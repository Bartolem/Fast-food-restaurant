package org.fast_food.product.burger;

import org.fast_food.product.burger.ingredient.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fast_food.product.burger.SpicyBurger.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpicyBurgerTest {
    @Test
    void testGetNameForDifferentBurgerTypes() {
        assertEquals(SPICY_SRIRACHA.getName(), "Spicy Sriracha Burger");
        assertEquals(JALAPENO_POPPER.getName(), "Jalapeño Popper Burger");
        assertEquals(BUFFALO_CHICKEN.getName(), "Buffalo Chicken Burger");
        assertEquals(CHIPOTLE_BLACK_BEAN.getName(), "Chipotle Black Bean Burger");
        assertEquals(CAJUN_SHRIMP.getName(), "Cajun Shrimp Burger");
        assertEquals(GHOST_PEPPER.getName(), "Ghost Pepper Burger");
        assertEquals(HOT_PEPPER_JACK.getName(), "Hot Pepper Jack Burger");
        assertEquals(FIERY_HABANERO.getName(), "Fiery Habanero Burger");
        assertEquals(SPICY_THAI.getName(), "Spicy Thai Chili Burger");
        assertEquals(INFERNO.getName(), "Inferno Triple Pepper Burger");
    }

    @Test
    void testGetPriceForDifferentBurgerTypes() {
        assertEquals(SPICY_SRIRACHA.getPrice(), 6.79);
        assertEquals(JALAPENO_POPPER.getPrice(), 7.09);
        assertEquals(BUFFALO_CHICKEN.getPrice(), 7.49);
        assertEquals(CHIPOTLE_BLACK_BEAN.getPrice(), 6.89);
        assertEquals(CAJUN_SHRIMP.getPrice(), 8.29);
        assertEquals(GHOST_PEPPER.getPrice(), 8.99);
        assertEquals(HOT_PEPPER_JACK.getPrice(), 7.89);
        assertEquals(FIERY_HABANERO.getPrice(), 8.49);
        assertEquals(SPICY_THAI.getPrice(), 7.79);
        assertEquals(INFERNO.getPrice(), 9.49);
    }
    @Test
    void testGetIngredientsForDifferentBurgerTypes() {
        assertTrue(SPICY_SRIRACHA.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.SRIRACHA_SAUCE, Cheese.PEPPER_JACK_CHEESE, Ingredient.TOMATO, Ingredient.LETTUCE, Bun.POTATO)));
        assertTrue(JALAPENO_POPPER.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.JALAPENO_POPPER_FILLING, Cheese.CREAM_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO)));
        assertTrue(BUFFALO_CHICKEN.getIngredients().containsAll( List.of(Patty.CHICKEN, Sauce.BUFFALO_SAUCE, Sauce.BLUE_CHEESE_DRESSING, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME)));
        assertTrue(CHIPOTLE_BLACK_BEAN.getIngredients().containsAll(List.of(Patty.BLACK_BEAN, Sauce.CHIPOTLE_MAYO, Cheese.PEPPER_JACK_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME)));
        assertTrue(CAJUN_SHRIMP.getIngredients().containsAll(List.of(Patty.SHRIMP, Ingredient.CAJUN, Sauce.REMOULADE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.WHOLE_WHEAT)));
        assertTrue(GHOST_PEPPER.getIngredients().containsAll(List.of(Patty.BEEF, Cheese.GHOST_PAPER_CHEESE, Sauce.GHOST_PEPPER_SAUCE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME)));
        assertTrue(HOT_PEPPER_JACK.getIngredients().containsAll(List.of(Patty.BEEF, Cheese.PEPPER_JACK_CHEESE, Ingredient.JALAPENOS, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.PRETZEL)));
        assertTrue(FIERY_HABANERO.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.HABANERO_SAUCE, Cheese.PEPPER_JACK_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.BRIOCHE)));
        assertTrue(SPICY_THAI.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.THAI_CHILI_SAUCE, Sauce.PEANUT_SAUCE, Ingredient.CUCUMBER, Ingredient.LETTUCE, Bun.BRIOCHE)));
        assertTrue(INFERNO.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.JALAPENOS, Ingredient.BANANA_PEPPERS, Cheese.GHOST_PAPER_CHEESE, Sauce.INFERNO_SAUCE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO)));
    }

    @Test
    void testGetCaloriesForDifferentBurgerTypes() {
        assertEquals(SPICY_SRIRACHA.getCalories(), 650);
        assertEquals(JALAPENO_POPPER.getCalories(), 700);
        assertEquals(BUFFALO_CHICKEN.getCalories(), 720);
        assertEquals(CHIPOTLE_BLACK_BEAN.getCalories(), 600);
        assertEquals(CAJUN_SHRIMP.getCalories(), 780);
        assertEquals(GHOST_PEPPER.getCalories(), 850);
        assertEquals(HOT_PEPPER_JACK.getCalories(), 800);
        assertEquals(FIERY_HABANERO.getCalories(), 820);
        assertEquals(SPICY_THAI.getCalories(), 790);
        assertEquals(INFERNO.getCalories(), 900);
    }

    @Test
    void testGetSpicinessLevelForDifferentBurgerTypes() {
        assertEquals(SPICY_SRIRACHA.getSpicinessLevel(), 4);
        assertEquals(JALAPENO_POPPER.getSpicinessLevel(), 3);
        assertEquals(BUFFALO_CHICKEN.getSpicinessLevel(), 4);
        assertEquals(CHIPOTLE_BLACK_BEAN.getSpicinessLevel(), 3);
        assertEquals(CAJUN_SHRIMP.getSpicinessLevel(), 4);
        assertEquals(GHOST_PEPPER.getSpicinessLevel(), 5);
        assertEquals(HOT_PEPPER_JACK.getSpicinessLevel(), 4);
        assertEquals(FIERY_HABANERO.getSpicinessLevel(), 5);
        assertEquals(SPICY_THAI.getSpicinessLevel(), 4);
        assertEquals(INFERNO.getSpicinessLevel(), 5);
    }

    @Test
    void testGetPopularityRatingForDifferentBurgerTypes() {
        assertEquals(SPICY_SRIRACHA.getPopularityRating(), 3.2);
        assertEquals(JALAPENO_POPPER.getPopularityRating(), 3.3);
        assertEquals(BUFFALO_CHICKEN.getPopularityRating(), 3.4);
        assertEquals(CHIPOTLE_BLACK_BEAN.getPopularityRating(), 3.1);
        assertEquals(CAJUN_SHRIMP.getPopularityRating(), 4.2);
        assertEquals(GHOST_PEPPER.getPopularityRating(), 4.4);
        assertEquals(HOT_PEPPER_JACK.getPopularityRating(), 3.8);
        assertEquals(FIERY_HABANERO.getPopularityRating(), 4.3);
        assertEquals(SPICY_THAI.getPopularityRating(), 3.7);
        assertEquals(INFERNO.getPopularityRating(), 4.4);
    }

    @Test
    void testGetDescriptionForDifferentBurgerTypes() {
        assertEquals(SPICY_SRIRACHA.getDescription(), "Heat things up with a spicy Sriracha-infused burger topped with pepper jack cheese.");
        assertEquals(JALAPENO_POPPER.getDescription(), "A fiery burger featuring jalapeño popper filling, cream cheese, and fresh lettuce and tomato.");
        assertEquals(BUFFALO_CHICKEN.getDescription(), "Enjoy the bold flavors of buffalo sauce and blue cheese dressing on a crispy chicken patty.");
        assertEquals(CHIPOTLE_BLACK_BEAN.getDescription(), "A spicy and satisfying black bean burger topped with chipotle mayo and melted pepper jack cheese.");
        assertEquals(CAJUN_SHRIMP.getDescription(), "Dive into a flavorful shrimp burger seasoned with Cajun spices and topped with remoulade sauce.");
        assertEquals(GHOST_PEPPER.getDescription(), "For the brave souls, a burger featuring the intense heat of ghost pepper cheese and sauce.");
        assertEquals(HOT_PEPPER_JACK.getDescription(), "Spice it up with hot pepper jack cheese, jalapeños, and a perfectly grilled beef patty.");
        assertEquals(FIERY_HABANERO.getDescription(), "Embrace the heat with a habanero-infused burger topped with spicy pepper jack cheese.");
        assertEquals(SPICY_THAI.getDescription(), "Take a flavorful journey with Thai chili and peanut sauces, complemented by fresh cucumber slices.");
        assertEquals(INFERNO.getDescription(), "A burger that brings the heat with jalapeños, banana peppers, ghost pepper cheese, and inferno sauce.");
    }

    @Test
    void testClassicBurgerContainsAllValues() {
        assertTrue(List.of(SPICY_SRIRACHA, JALAPENO_POPPER, BUFFALO_CHICKEN, CHIPOTLE_BLACK_BEAN, CAJUN_SHRIMP, GHOST_PEPPER, HOT_PEPPER_JACK, FIERY_HABANERO, SPICY_THAI, INFERNO).containsAll(List.of(SpicyBurger.values())));
    }

    @Test
    void testValueOfDifferentBurgerTypes() {
        assertEquals(SPICY_SRIRACHA, SpicyBurger.valueOf("SPICY_SRIRACHA"));
        assertEquals(JALAPENO_POPPER, SpicyBurger.valueOf("JALAPENO_POPPER"));
        assertEquals(BUFFALO_CHICKEN, SpicyBurger.valueOf("BUFFALO_CHICKEN"));
        assertEquals(CHIPOTLE_BLACK_BEAN, SpicyBurger.valueOf("CHIPOTLE_BLACK_BEAN"));
        assertEquals(CAJUN_SHRIMP, SpicyBurger.valueOf("CAJUN_SHRIMP"));
        assertEquals(GHOST_PEPPER, SpicyBurger.valueOf("GHOST_PEPPER"));
        assertEquals(HOT_PEPPER_JACK, SpicyBurger.valueOf("HOT_PEPPER_JACK"));
        assertEquals(FIERY_HABANERO, SpicyBurger.valueOf("FIERY_HABANERO"));
        assertEquals(SPICY_THAI, SpicyBurger.valueOf("SPICY_THAI"));
        assertEquals(INFERNO, SpicyBurger.valueOf("INFERNO"));
    }
}
