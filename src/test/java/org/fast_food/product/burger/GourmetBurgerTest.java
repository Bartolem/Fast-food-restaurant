package org.fast_food.product.burger;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fast_food.product.burger.GourmetBurger.*;
import static org.junit.jupiter.api.Assertions.*;

class GourmetBurgerTest {

    @Test
    void testGetNameForDifferentBurgerTypes() {
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
    void testGetPriceForDifferentBurgerTypes() {
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
    void testGetIngredientsForDifferentBurgerTypes() {
        assertTrue(BLUE_CHEESE_BURGER.getIngredients().containsAll(List.of("Beef patty", "Blue cheese", "Lettuce", "Tomato", "Onion")));
        assertTrue(AVOCADO_RANCH_BURGER.getIngredients().containsAll(List.of("Beef patty", "Avocado", "Ranch dressing", "Lettuce", "Tomato")));
        assertTrue(TRUFFLE_MUSHROOM_BURGER.getIngredients().containsAll(List.of("Beef patty", "Truffle oil", "Swiss cheese", "Sauteed mushrooms", "Lettuce")));
        assertTrue(GUACAMOLE_BACON_BURGER.getIngredients().containsAll(List.of("Beef patty", "Guacamole", "Bacon", "Lettuce", "Tomato")));
        assertTrue(BBQ_RANCH_BACON_BURGER.getIngredients().containsAll(List.of("Beef patty", "BBQ sauce", "Ranch dressing", "Bacon", "Lettuce")));
        assertTrue(CAJUN_SPICED_BURGER.getIngredients().containsAll(List.of("Beef patty", "Cajun spice blend", "Pepper jack cheese", "Lettuce", "Tomato")));
        assertTrue(PESTO_TURKEY_BURGER.getIngredients().containsAll(List.of("Turkey patty", "Pesto sauce", "Mozzarella cheese", "Arugula", "Tomato")));
        assertTrue(PHILLY_CHEESE_STEAK_BURGER.getIngredients().containsAll(List.of("Beef patty", "Sliced steak", "Provolone cheese", "Grilled peppers and onions")));
        assertTrue(MEDITERRANEAN_LAMB_BURGER.getIngredients().containsAll( List.of("Lamb patty", "Feta cheese", "Tzatziki sauce", "Lettuce", "Tomato")));
    }

    @Test
    void testGetCaloriesForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE_BURGER.getCalories(), 680);
        assertEquals(AVOCADO_RANCH_BURGER.getCalories(), 720);
        assertEquals(TRUFFLE_MUSHROOM_BURGER.getCalories(), 780);
        assertEquals(GUACAMOLE_BACON_BURGER.getCalories(), 800);
        assertEquals(BBQ_RANCH_BACON_BURGER.getCalories(), 830);
        assertEquals(CAJUN_SPICED_BURGER.getCalories(), 690);
        assertEquals(PESTO_TURKEY_BURGER.getCalories(), 660);
        assertEquals(PHILLY_CHEESE_STEAK_BURGER.getCalories(), 820);
        assertEquals(MEDITERRANEAN_LAMB_BURGER.getCalories(), 900);
    }

    @Test
    void testGetDescriptionForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE_BURGER.getDescription(), "A gourmet delight featuring a succulent beef patty topped with rich and tangy blue cheese, fresh lettuce, tomato, and onion.");
        assertEquals(AVOCADO_RANCH_BURGER.getDescription(), "Indulge in the creamy goodness of avocado and the zesty flavor of ranch dressing on a perfectly grilled beef patty.");
        assertEquals(TRUFFLE_MUSHROOM_BURGER.getDescription(), "A gourmet experience with truffle-infused mushrooms, Swiss cheese, and a juicy beef patty for a rich and earthy taste.");
        assertEquals(GUACAMOLE_BACON_BURGER.getDescription(), "Savor the combination of creamy guacamole, crispy bacon, and a perfectly grilled beef patty.");
        assertEquals(BBQ_RANCH_BACON_BURGER.getDescription(), "A delicious fusion of BBQ and ranch flavors with the added crunch of bacon.");
        assertEquals(CAJUN_SPICED_BURGER.getDescription(), "A spicy kick with Cajun seasoning and melted pepper jack cheese for a flavor-packed burger.");
        assertEquals(PESTO_TURKEY_BURGER.getDescription(), "A lighter option with a turkey patty, topped with fresh pesto, melted mozzarella, arugula, and tomato.");
        assertEquals(PHILLY_CHEESE_STEAK_BURGER.getDescription(), "A burger inspired by the classic Philly cheese steak, featuring sliced steak, provolone cheese, and grilled peppers and onions.");
        assertEquals(MEDITERRANEAN_LAMB_BURGER.getDescription(), "A flavorful lamb burger topped with crumbled feta, cool tzatziki sauce, and fresh lettuce and tomato.");
    }

    @Test
    void testGetSpicinessLevelForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE_BURGER.getSpicinessLevel(), 1);
        assertEquals(AVOCADO_RANCH_BURGER.getSpicinessLevel(), 1);
        assertEquals(TRUFFLE_MUSHROOM_BURGER.getSpicinessLevel(), 1);
        assertEquals(GUACAMOLE_BACON_BURGER.getSpicinessLevel(), 1);
        assertEquals(BBQ_RANCH_BACON_BURGER.getSpicinessLevel(), 1);
        assertEquals(CAJUN_SPICED_BURGER.getSpicinessLevel(), 3.5);
        assertEquals(PESTO_TURKEY_BURGER.getSpicinessLevel(), 1);
        assertEquals(PHILLY_CHEESE_STEAK_BURGER.getSpicinessLevel(), 1);
        assertEquals(MEDITERRANEAN_LAMB_BURGER.getSpicinessLevel(), 1);
    }

    @Test
    void testGetPopularityRatingForDifferentBurgerTypes() {
        assertEquals(BLUE_CHEESE_BURGER.getPopularityRating(), 3.3);
        assertEquals(AVOCADO_RANCH_BURGER.getPopularityRating(), 3.5);
        assertEquals(TRUFFLE_MUSHROOM_BURGER.getPopularityRating(), 3.8);
        assertEquals(GUACAMOLE_BACON_BURGER.getPopularityRating(), 3.6);
        assertEquals(BBQ_RANCH_BACON_BURGER.getPopularityRating(), 4.2);
        assertEquals(CAJUN_SPICED_BURGER.getPopularityRating(), 4.1);
        assertEquals(PESTO_TURKEY_BURGER.getPopularityRating(), 3.7);
        assertEquals(PHILLY_CHEESE_STEAK_BURGER.getPopularityRating(), 3.9);
        assertEquals(MEDITERRANEAN_LAMB_BURGER.getPopularityRating(), 3.6);
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}