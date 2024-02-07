package org.fast_food.product.burger;

import org.fast_food.product.burger.ingredient.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fast_food.product.burger.GourmetBurger.*;
import static org.junit.jupiter.api.Assertions.*;

class GourmetBurgerTest {

    @Test
    void testGetNameForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE.getName(), "Blue Cheese Burger");
        assertEquals(AVOCADO_RANCH.getName(), "Avocado Ranch Burger");
        assertEquals(TRUFFLE_MUSHROOM.getName(), "Truffle Mushroom Burger");
        assertEquals(GUACAMOLE_BACON.getName(), "Guacamole Bacon Burger");
        assertEquals(BBQ_RANCH_BACON.getName(), "BBQ Ranch Bacon Burger");
        assertEquals(CAJUN_SPICED.getName(), "Cajun Spiced Burger");
        assertEquals(PESTO_TURKEY.getName(), "Pesto Turkey Burger");
        assertEquals(PHILLY_CHEESE_STEAK.getName(), "Philly Cheese Steak Burger");
        assertEquals(MEDITERRANEAN_LAMB.getName(), "Mediterranean Lamb Burger");
    }

    @Test
    void testGetPriceForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE.getPrice(), 6.99);
        assertEquals(AVOCADO_RANCH.getPrice(), 7.29);
        assertEquals(TRUFFLE_MUSHROOM.getPrice(), 7.49);
        assertEquals(GUACAMOLE_BACON.getPrice(), 7.79);
        assertEquals(BBQ_RANCH_BACON.getPrice(), 7.69);
        assertEquals(CAJUN_SPICED.getPrice(), 6.89);
        assertEquals(PESTO_TURKEY.getPrice(), 7.19);
        assertEquals(PHILLY_CHEESE_STEAK.getPrice(), 8.29);
        assertEquals(MEDITERRANEAN_LAMB.getPrice(), 8.49);
    }

    @Test
    void testGetIngredientsForDifferentBurgerTypes() {
        assertTrue(BLUE_CHEESE.getIngredients().containsAll(List.of(Patty.BEEF, Cheese.BLUE_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.ONION, Bun.POTATO)));
        assertTrue(AVOCADO_RANCH.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.AVOCADO, Sauce.RANCH_DRESSING, Ingredient.TOMATO, Ingredient.ONION, Bun.WHOLE_GRAIN)));
        assertTrue(TRUFFLE_MUSHROOM.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.TRUFFLE_OIL, Cheese.SWISS_CHEESE, Ingredient.SAUTEED_MUSHROOMS, Ingredient.LETTUCE, Bun.WHOLE_GRAIN)));
        assertTrue(GUACAMOLE_BACON.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.GUACAMOLE, Ingredient.BACON,Ingredient.LETTUCE, Ingredient.TOMATO, Bun.SESAME)));
        assertTrue(BBQ_RANCH_BACON.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.BBQ_SAUCE, Sauce.RANCH_DRESSING, Ingredient.BACON, Ingredient.TOMATO, Bun.BRIOCHE)));
        assertTrue(CAJUN_SPICED.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.CAJUN, Cheese.PEPPER_JACK_CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO)));
        assertTrue(PESTO_TURKEY.getIngredients().containsAll(List.of(Patty.TURKEY, Sauce.PESTO, Cheese.MOZZARELLA, Ingredient.ARUGULA, Ingredient.TOMATO, Bun.SESAME)));
        assertTrue(PHILLY_CHEESE_STEAK.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.STEAK, Cheese.PROVOLONE_CHEESE, Ingredient.GRILLED_PEPPERS, Ingredient.ONION, Bun.PRETZEL)));
        assertTrue(MEDITERRANEAN_LAMB.getIngredients().containsAll(List.of(Patty.LAMB, Cheese.FETA_CHEESE, Sauce.TZATZIKI, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.WHOLE_GRAIN)));
    }

    @Test
    void testGetCaloriesForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE.getCalories(), 680);
        assertEquals(AVOCADO_RANCH.getCalories(), 720);
        assertEquals(TRUFFLE_MUSHROOM.getCalories(), 780);
        assertEquals(GUACAMOLE_BACON.getCalories(), 800);
        assertEquals(BBQ_RANCH_BACON.getCalories(), 830);
        assertEquals(CAJUN_SPICED.getCalories(), 690);
        assertEquals(PESTO_TURKEY.getCalories(), 660);
        assertEquals(PHILLY_CHEESE_STEAK.getCalories(), 820);
        assertEquals(MEDITERRANEAN_LAMB.getCalories(), 900);
    }

    @Test
    void testGetDescriptionForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE.getDescription(), "A gourmet delight featuring a succulent beef patty topped with rich and tangy blue cheese, fresh lettuce, tomato, and onion.");
        assertEquals(AVOCADO_RANCH.getDescription(), "Indulge in the creamy goodness of avocado and the zesty flavor of ranch dressing on a perfectly grilled beef patty.");
        assertEquals(TRUFFLE_MUSHROOM.getDescription(), "A gourmet experience with truffle-infused mushrooms, Swiss cheese, and a juicy beef patty for a rich and earthy taste.");
        assertEquals(GUACAMOLE_BACON.getDescription(), "Savor the combination of creamy guacamole, crispy bacon, and a perfectly grilled beef patty.");
        assertEquals(BBQ_RANCH_BACON.getDescription(), "A delicious fusion of BBQ and ranch flavors with the added crunch of bacon.");
        assertEquals(CAJUN_SPICED.getDescription(), "A spicy kick with Cajun seasoning and melted pepper jack cheese for a flavor-packed burger.");
        assertEquals(PESTO_TURKEY.getDescription(), "A lighter option with a turkey patty, topped with fresh pesto, melted mozzarella, arugula, and tomato.");
        assertEquals(PHILLY_CHEESE_STEAK.getDescription(), "A burger inspired by the classic Philly cheese steak, featuring sliced steak, provolone cheese, and grilled peppers and onions.");
        assertEquals(MEDITERRANEAN_LAMB.getDescription(), "A flavorful lamb burger topped with crumbled feta, cool tzatziki sauce, and fresh lettuce and tomato.");
    }

    @Test
    void testGetSpicinessLevelForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE.getSpicinessLevel(), 1);
        assertEquals(AVOCADO_RANCH.getSpicinessLevel(), 1);
        assertEquals(TRUFFLE_MUSHROOM.getSpicinessLevel(), 1);
        assertEquals(GUACAMOLE_BACON.getSpicinessLevel(), 1);
        assertEquals(BBQ_RANCH_BACON.getSpicinessLevel(), 1);
        assertEquals(CAJUN_SPICED.getSpicinessLevel(), 3.5);
        assertEquals(PESTO_TURKEY.getSpicinessLevel(), 1);
        assertEquals(PHILLY_CHEESE_STEAK.getSpicinessLevel(), 1);
        assertEquals(MEDITERRANEAN_LAMB.getSpicinessLevel(), 1);
    }

    @Test
    void testGetPopularityRatingForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE.getPopularityRating(), 3.3);
        assertEquals(AVOCADO_RANCH.getPopularityRating(), 3.5);
        assertEquals(TRUFFLE_MUSHROOM.getPopularityRating(), 3.8);
        assertEquals(GUACAMOLE_BACON.getPopularityRating(), 3.6);
        assertEquals(BBQ_RANCH_BACON.getPopularityRating(), 4.2);
        assertEquals(CAJUN_SPICED.getPopularityRating(), 4.1);
        assertEquals(PESTO_TURKEY.getPopularityRating(), 3.7);
        assertEquals(PHILLY_CHEESE_STEAK.getPopularityRating(), 3.9);
        assertEquals(MEDITERRANEAN_LAMB.getPopularityRating(), 3.6);
    }

    @Test
    void testGourmetBurgerContainsAllValues() {
        assertTrue(List.of(BLUE_CHEESE, AVOCADO_RANCH, TRUFFLE_MUSHROOM, GUACAMOLE_BACON, BBQ_RANCH_BACON, CAJUN_SPICED, PESTO_TURKEY, PHILLY_CHEESE_STEAK, MEDITERRANEAN_LAMB).containsAll(List.of(GourmetBurger.values())));
    }

    @Test
    void testValueOfDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE, GourmetBurger.valueOf("BLUE_CHEESE"));
        assertEquals(AVOCADO_RANCH, GourmetBurger.valueOf("AVOCADO_RANCH"));
        assertEquals(TRUFFLE_MUSHROOM, GourmetBurger.valueOf("TRUFFLE_MUSHROOM"));
        assertEquals(GUACAMOLE_BACON, GourmetBurger.valueOf("GUACAMOLE_BACON"));
        assertEquals(BBQ_RANCH_BACON, GourmetBurger.valueOf("BBQ_RANCH_BACON"));
        assertEquals(CAJUN_SPICED, GourmetBurger.valueOf("CAJUN_SPICED"));
        assertEquals(PESTO_TURKEY, GourmetBurger.valueOf("PESTO_TURKEY"));
        assertEquals(PHILLY_CHEESE_STEAK, GourmetBurger.valueOf("PHILLY_CHEESE_STEAK"));
        assertEquals(MEDITERRANEAN_LAMB, GourmetBurger.valueOf("MEDITERRANEAN_LAMB"));
    }
}