package org.fast_food.product.burger;

import org.fast_food.product.Side;
import org.fast_food.product.burger.ingredient.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.fast_food.product.burger.UniqueFlavorBurger.*;
import static org.junit.jupiter.api.Assertions.*;

public class UniqueFlavorBurgerTest {
    @Test
    void testGetNameForDifferentBurgerTypes() {
        assertEquals(BREAKFAST.getName(), "Breakfast Burger");
        assertEquals(MOZZARELLA.getName(), "Mozzarella Burger");
        assertEquals(SPINACH.getName(), "Spinach and Artichoke Burger");
        assertEquals(BLUEBERRY_BBQ_BACON.getName(), "Blueberry BBQ Bacon");
        assertEquals(SWEAT_POTATO.getName(), "Sweet Potato Burger");
        assertEquals(SMOKED_SALMON.getName(), "Smoked Salmon Burger");
        assertEquals(PEANUT_BANANA.getName(), "Peanut Banana Bacon Burger");
        assertEquals(ONION_RINGS.getName(), "Onion Rings Burger");
    }

    @Test
    void testGetPriceForDifferentBurgerTypes() {
        assertEquals(BREAKFAST.getPrice(), BigDecimal.valueOf(8.99));
        assertEquals(MOZZARELLA.getPrice(), BigDecimal.valueOf(8.99));
        assertEquals(SPINACH.getPrice(), BigDecimal.valueOf(10.49));
        assertEquals(BLUEBERRY_BBQ_BACON.getPrice(), BigDecimal.valueOf(11.99));
        assertEquals(SWEAT_POTATO.getPrice(), BigDecimal.valueOf(9.99));
        assertEquals(SMOKED_SALMON.getPrice(), BigDecimal.valueOf(12.99));
        assertEquals(PEANUT_BANANA.getPrice(), BigDecimal.valueOf(10.79));
        assertEquals(ONION_RINGS.getPrice(), BigDecimal.valueOf(11.49));
    }
    @Test
    void testGetIngredientsForDifferentBurgerTypes() {
        assertTrue(BREAKFAST.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.BACON, Ingredient.FRIED_EGG, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.PRETZEL)));
        assertTrue(MOZZARELLA.getIngredients().containsAll(List.of(Patty.BEEF, Cheese.MOZZARELLA, Sauce.MARINARA, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO)));
        assertTrue(SPINACH.getIngredients().containsAll(List.of(Patty.SPINACH_ARTICHOKE, Cheese.GOAT_CHEESE, Ingredient.GRILLED_PEPPERS, Ingredient.ARUGULA, Bun.WHOLE_GRAIN)));
        assertTrue(BLUEBERRY_BBQ_BACON.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.BACON, Ingredient.CARAMELIZED_ONIONS, Cheese.CHEDDAR, Ingredient.BLUEBERRY, Sauce.BLUEBERRY_BBQ, Bun.POTATO)));
        assertTrue(SWEAT_POTATO.getIngredients().containsAll(List.of(Patty.SWEAT_POTATO, Ingredient.AVOCADO, Ingredient.LETTUCE, Sauce.CHIPOTLE_MAYO, Bun.WHOLE_GRAIN)));
        assertTrue(SMOKED_SALMON.getIngredients().containsAll(List.of(Patty.SMOKED_SALMON, Sauce.DILL, Ingredient.CUCUMBER, Ingredient.ARUGULA, Bun.BRIOCHE)));
        assertTrue(PEANUT_BANANA.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.PEANUT_BUTTER, Ingredient.BANANA, Ingredient.BACON, Sauce.HONEY, Bun.ENGLISH_MUFFIN)));
        assertTrue(ONION_RINGS.getIngredients().containsAll(List.of(Patty.BEEF, Side.ONION_RINGS, Sauce.BBQ_SAUCE, Cheese.CHEDDAR, Ingredient.LETTUCE, Bun.PRETZEL)));
    }

    @Test
    void testGetCaloriesForDifferentBurgerTypes() {
        assertEquals(BREAKFAST.getCalories(), 780);
        assertEquals(MOZZARELLA.getCalories(), 820);
        assertEquals(SPINACH.getCalories(), 690);
        assertEquals(BLUEBERRY_BBQ_BACON.getCalories(), 850);
        assertEquals(SWEAT_POTATO.getCalories(), 580);
        assertEquals(SMOKED_SALMON.getCalories(), 620);
        assertEquals(PEANUT_BANANA.getCalories(), 790);
        assertEquals(ONION_RINGS.getCalories(), 780);
    }

    @Test
    void testGetSpicinessLevelForDifferentBurgerTypes() {
        assertEquals(BREAKFAST.getSpicinessLevel(), 2);
        assertEquals(MOZZARELLA.getSpicinessLevel(), 1);
        assertEquals(SPINACH.getSpicinessLevel(), 1);
        assertEquals(BLUEBERRY_BBQ_BACON.getSpicinessLevel(), 1);
        assertEquals(SWEAT_POTATO.getSpicinessLevel(), 1);
        assertEquals(SMOKED_SALMON.getSpicinessLevel(), 1);
        assertEquals(PEANUT_BANANA.getSpicinessLevel(), 1);
        assertEquals(ONION_RINGS.getSpicinessLevel(), 1);
    }

    @Test
    void testGetPopularityRatingForDifferentBurgerTypes() {
        assertEquals(BREAKFAST.getPopularityRating(), 4);
        assertEquals(MOZZARELLA.getPopularityRating(), 3.6);
        assertEquals(SPINACH.getPopularityRating(), 3.8);
        assertEquals(BLUEBERRY_BBQ_BACON.getPopularityRating(), 4.5);
        assertEquals(SWEAT_POTATO.getPopularityRating(), 4.1);
        assertEquals(SMOKED_SALMON.getPopularityRating(), 4.2);
        assertEquals(PEANUT_BANANA.getPopularityRating(), 4.3);
        assertEquals(ONION_RINGS.getPopularityRating(), 4.2);
    }

    @Test
    void testGetDescriptionForDifferentBurgerTypes() {
        assertEquals(BREAKFAST.getDescription(), "Start your day right with this hearty breakfast burger featuring a juicy beef patty, crispy bacon, a perfectly fried egg, and fresh lettuce and tomato.");
        assertEquals(MOZZARELLA.getDescription(), "Indulge in the cheesy goodness of melted mozzarella cheese atop a juicy beef patty, complemented by tangy marinara sauce, lettuce, and tomato.");
        assertEquals(SPINACH.getDescription(), "A vegetarian delight featuring a flavorful spinach and artichoke patty, creamy goat cheese, roasted red peppers, and arugula, served on a wholesome whole grain bun.");
        assertEquals(BLUEBERRY_BBQ_BACON.getDescription(), "Experience a burst of sweet and savory flavors with this unique burger featuring blueberry BBQ sauce, crispy bacon, melted cheddar cheese, and caramelized onions atop a juicy beef patty.");
        assertEquals(SWEAT_POTATO.getDescription(), "Dive into a wholesome and hearty sweet potato burger, made with a savory sweet potato and black bean patty, creamy avocado slices, crisp lettuce, and zesty chipotle mayo, all served on a nutritious whole wheat bun.");
        assertEquals(SMOKED_SALMON.getDescription(), "Elevate your burger experience with this gourmet option featuring a succulent smoked salmon patty, creamy dill sauce, crisp cucumber slices, and peppery arugula, all nestled on a toasted brioche bun for a taste of luxury.");
        assertEquals(PEANUT_BANANA.getDescription(), "Embark on a flavor adventure with this unconventional burger featuring a juicy beef patty topped with creamy peanut butter, caramelized bananas, crispy bacon, and a drizzle of honey, all sandwiched between two toasted English muffins.");
        assertEquals(ONION_RINGS.getDescription(), "Indulge in crunchy perfection with this mouthwatering burger featuring a juicy beef patty topped with crispy beer-battered onion rings, tangy BBQ sauce, melted cheddar cheese, and crisp lettuce, all served on a toasted pretzel bun for a satisfying crunch.");
    }

    @Test
    void testClassicBurgerContainsAllValues() {
        assertTrue(List.of(BREAKFAST, MOZZARELLA, SPINACH, BLUEBERRY_BBQ_BACON, SWEAT_POTATO, SMOKED_SALMON, PEANUT_BANANA, ONION_RINGS).containsAll(List.of(UniqueFlavorBurger.values())));
    }

    @Test
    void testValueOfDifferentBurgerTypes() {
        assertEquals(BREAKFAST, UniqueFlavorBurger.valueOf("BREAKFAST"));
        assertEquals(MOZZARELLA, UniqueFlavorBurger.valueOf("MOZZARELLA"));
        assertEquals(SPINACH, UniqueFlavorBurger.valueOf("SPINACH"));
        assertEquals(BLUEBERRY_BBQ_BACON, UniqueFlavorBurger.valueOf("BLUEBERRY_BBQ_BACON"));
        assertEquals(SWEAT_POTATO, UniqueFlavorBurger.valueOf("SWEAT_POTATO"));
        assertEquals(SMOKED_SALMON, UniqueFlavorBurger.valueOf("SMOKED_SALMON"));
        assertEquals(PEANUT_BANANA, UniqueFlavorBurger.valueOf("PEANUT_BANANA"));
        assertEquals(ONION_RINGS, UniqueFlavorBurger.valueOf("ONION_RINGS"));
    }
}
