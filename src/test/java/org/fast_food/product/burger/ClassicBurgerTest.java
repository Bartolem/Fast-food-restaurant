package org.fast_food.product.burger;

import org.fast_food.product.Side;
import org.fast_food.product.burger.ingredient.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
        assertEquals(FISH.getName(), "Fish Burger");
    }

    @Test
    void testGetPriceForDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER.getPrice(), BigDecimal.valueOf(4.99));
        assertEquals(CLASSIC_CHEESEBURGER.getPrice(), BigDecimal.valueOf(5.19));
        assertEquals(BACON.getPrice(), BigDecimal.valueOf(5.49));
        assertEquals(VEGGIE.getPrice(), BigDecimal.valueOf(4.79));
        assertEquals(CHICKEN.getPrice(), BigDecimal.valueOf(5.29));
        assertEquals(TURKEY.getPrice(), BigDecimal.valueOf(5.49));
        assertEquals(BBQ.getPrice(), BigDecimal.valueOf(5.99));
        assertEquals(JALAPENO.getPrice(), BigDecimal.valueOf(5.59));
        assertEquals(TERIYAKI.getPrice(), BigDecimal.valueOf(5.89));
        assertEquals(DOUBLE_BURGER.getPrice(), BigDecimal.valueOf(6.29));
        assertEquals(DOUBLE_CHEESEBURGER.getPrice(), BigDecimal.valueOf(6.49));
        assertEquals(DOUBLE_BACON.getPrice(), BigDecimal.valueOf(6.99));
        assertEquals(DOUBLE_BACON_CHEESEBURGER.getPrice(), BigDecimal.valueOf(7.19));
        assertEquals(FISH.getPrice(), BigDecimal.valueOf(6.49));
    }
    @Test
    void testGetIngredientsForDifferentBurgerTypes() {
        assertTrue(CLASSIC_BURGER.getIngredients().containsAll(List.of(Patty.BEEF, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME)));
        assertTrue(CLASSIC_CHEESEBURGER.getIngredients().containsAll(List.of(Patty.BEEF, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME)));
        assertTrue(BACON.getIngredients().containsAll( List.of(Patty.BEEF, Ingredient.BACON, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME)));
        assertTrue(VEGGIE.getIngredients().containsAll(List.of(Patty.VEGGIE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Sauce.MAYO, Bun.WHOLE_GRAIN)));
        assertTrue(CHICKEN.getIngredients().containsAll(List.of(Patty.CHICKEN, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Sauce.MAYO, Bun.SESAME)));
        assertTrue(TURKEY.getIngredients().containsAll(List.of(Patty.TURKEY, Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.ONION, Sauce.CRANBERRY_SAUCE, Bun.BRIOCHE)));
        assertTrue(BBQ.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.BBQ_SAUCE, Side.ONION_RINGS, Ingredient.LETTUCE, Bun.SESAME)));
        assertTrue(JALAPENO.getIngredients().containsAll(List.of(Patty.BEEF, Cheese.PEPPER_JACK_CHEESE, Ingredient.JALAPENOS, Ingredient.LETTUCE, Ingredient.TOMATO, Bun.POTATO)));
        assertTrue(TERIYAKI.getIngredients().containsAll(List.of(Patty.BEEF, Sauce.TERIYAKI_SAUCE, Ingredient.TOMATO, Ingredient.LETTUCE, Ingredient.PINEAPPLE, Ingredient.TOMATO, Bun.SESAME)));
        assertTrue(DOUBLE_BURGER.getIngredients().containsAll(List.of(Patty.BEEF, Patty.BEEF, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME)));
        assertTrue(DOUBLE_CHEESEBURGER.getIngredients().containsAll(List.of(Patty.BEEF, Patty.BEEF, Cheese.CHEESE, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME)));
        assertTrue(DOUBLE_BACON.getIngredients().containsAll(List.of(Patty.BEEF, Patty.BEEF, Ingredient.BACON, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.SESAME)));
        assertTrue(DOUBLE_BACON_CHEESEBURGER.getIngredients().containsAll(List.of(Patty.BEEF, Patty.BEEF, Ingredient.BACON, Cheese.CHEESE, Cheese.CHEESE, Ingredient.LETTUCE,  Ingredient.TOMATO, Ingredient.PICKLES, Ingredient.ONION, Bun.BRIOCHE)));
        assertEquals(FISH.getIngredients(), List.of(Patty.FISH_FILLET, Cheese.CHEESE, Ingredient.LETTUCE, Ingredient.TOMATO, Sauce.TATAR, Bun.SESAME));
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
        assertEquals(FISH.getCalories(), 480);
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
        assertEquals(FISH.getSpicinessLevel(), 1);
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
        assertEquals(FISH.getPopularityRating(), 4.4);
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
        assertEquals(FISH.getDescription(), "A delicious fish fillet served on a soft sesame bun with lettuce, tartar sauce, and tomatoes.");
    }

    @Test
    void testClassicBurgerContainsAllValues() {
        assertEquals(List.of(CLASSIC_BURGER, CLASSIC_CHEESEBURGER, BACON, VEGGIE, CHICKEN, TURKEY, BBQ, JALAPENO, TERIYAKI, DOUBLE_BURGER, DOUBLE_CHEESEBURGER, DOUBLE_BACON, DOUBLE_BACON_CHEESEBURGER, FISH), List.of(ClassicBurger.values()));
    }

    @Test
    void testValueOfDifferentBurgerTypes() {
        assertEquals(CLASSIC_BURGER, ClassicBurger.valueOf("CLASSIC_BURGER"));
        assertEquals(CLASSIC_CHEESEBURGER, ClassicBurger.valueOf("CLASSIC_CHEESEBURGER"));
        assertEquals(BACON, ClassicBurger.valueOf("BACON"));
        assertEquals(VEGGIE, ClassicBurger.valueOf("VEGGIE"));
        assertEquals(CHICKEN, ClassicBurger.valueOf("CHICKEN"));
        assertEquals(TURKEY, ClassicBurger.valueOf("TURKEY"));
        assertEquals(BBQ, ClassicBurger.valueOf("BBQ"));
        assertEquals(JALAPENO, ClassicBurger.valueOf("JALAPENO"));
        assertEquals(TERIYAKI, ClassicBurger.valueOf("TERIYAKI"));
        assertEquals(DOUBLE_BURGER, ClassicBurger.valueOf("DOUBLE_BURGER"));
        assertEquals(DOUBLE_CHEESEBURGER, ClassicBurger.valueOf("DOUBLE_CHEESEBURGER"));
        assertEquals(DOUBLE_BACON, ClassicBurger.valueOf("DOUBLE_BACON"));
        assertEquals(DOUBLE_BACON_CHEESEBURGER, ClassicBurger.valueOf("DOUBLE_BACON_CHEESEBURGER"));
        assertEquals(FISH, ClassicBurger.valueOf("FISH"));
    }
}