package org.fast_food.product;

import org.fast_food.product.burger.ClassicBurger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fast_food.product.burger.ClassicBurger.*;
import static org.junit.jupiter.api.Assertions.*;

class ClassicBurgerTest {
    @Test
    void getName() {
        assertEquals(CLASSIC_BURGER.getName(), "Classic Burger");
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
        assertEquals(CLASSIC_BURGER.getPrice(), 4.99);
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
        assertTrue(CLASSIC_BURGER.getIngredients().containsAll(List.of("Beef patty", "Lettuce", "Tomato", "Pickles", "Onions")));
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
        assertEquals(CLASSIC_BURGER.getCalories(), 570);
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
        assertEquals(CLASSIC_BURGER.getSpicinessLevel(), 1);
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
        assertEquals(CLASSIC_BURGER.getPopularityRating(), 4.7);
        assertEquals(ClassicBurger.CLASSIC_CHEESEBURGER.getPopularityRating(), 4.5);
        assertEquals(ClassicBurger.BACON_BURGER.getPopularityRating(), 4.8);
        assertEquals(ClassicBurger.VEGGIE_BURGER.getPopularityRating(), 4.1);
        assertEquals(ClassicBurger.CHICKEN_BURGER.getPopularityRating(), 4.3);
        assertEquals(ClassicBurger.TURKEY_BURGER.getPopularityRating(), 4.0);
        assertEquals(ClassicBurger.BBQ_BURGER.getPopularityRating(), 4.3);
        assertEquals(ClassicBurger.JALAPENO_BURGER.getPopularityRating(), 3.8);
        assertEquals(ClassicBurger.TERIYAKI_BURGER.getPopularityRating(), 4.2);
        assertEquals(ClassicBurger.DOUBLE_BURGER.getPopularityRating(), 4.4);
        assertEquals(ClassicBurger.DOUBLE_CHEESEBURGER.getPopularityRating(), 4.4);
        assertEquals(ClassicBurger.DOUBLE_BACON_BURGER.getPopularityRating(), 4.6);
        assertEquals(ClassicBurger.DOUBLE_BACON_CHEESEBURGER.getPopularityRating(), 4.5);
    }

    @Test
    void getDescription() {
        assertEquals(CLASSIC_BURGER.getDescription(), "The classic cheeseburger with a juicy beef patty, melted cheese, and fresh vegetables.");
        assertEquals(ClassicBurger.CLASSIC_CHEESEBURGER.getDescription(), "The classic burger with a juicy beef patty and fresh vegetables.");
        assertEquals(ClassicBurger.BACON_BURGER.getDescription(), "A mouthwatering burger featuring crispy bacon on top of a delicious beef patty.");
        assertEquals(ClassicBurger.VEGGIE_BURGER.getDescription(), "A meat-free option loaded with fresh vegetables and a tasty vegetarian patty.");
        assertEquals(ClassicBurger.CHICKEN_BURGER.getDescription(), "A grilled chicken burger with crisp veggies and mayo for a delightful flavor.");
        assertEquals(ClassicBurger.TURKEY_BURGER.getDescription(), "A healthier option with a turkey patty and a touch of sweet cranberry sauce.");
        assertEquals(ClassicBurger.BBQ_BURGER.getDescription(), "A savory BBQ-infused burger with melted cheddar and crispy onion rings.");
        assertEquals(ClassicBurger.JALAPENO_BURGER.getDescription(), "A spicy delight with pepper jack cheese and a kick of jalapeños.");
        assertEquals(ClassicBurger.TERIYAKI_BURGER.getDescription(), "A flavorful burger with a sweet and tangy teriyaki glaze and a hint of pineapple.");
        assertEquals(ClassicBurger.DOUBLE_BURGER.getDescription(), "A hearty and indulgent burger for the ultimate burger enthusiast. This Double Burger features not one, but two succulent beef patties. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.");
        assertEquals(ClassicBurger.DOUBLE_CHEESEBURGER.getDescription(), "A hearty and indulgent burger for the ultimate cheese enthusiast. This Double Cheeseburger features not one, but two succulent beef patties and topped with double cheese. Complemented by fresh lettuce, ripe tomatoes, pickles, and onions.");
        assertEquals(ClassicBurger.DOUBLE_BACON_BURGER.getDescription(), "For the ultimate bacon lover – double beef and crispy bacon.");
        assertEquals(ClassicBurger.DOUBLE_BACON_CHEESEBURGER.getDescription(), "For the ultimate bacon and cheese lover – double beef, double cheese, and crispy bacon.");
    }

    @Test
    void values() {
        assertTrue(List.of(ClassicBurger.values()).containsAll(List.of(CLASSIC_BURGER, CLASSIC_CHEESEBURGER, BACON_BURGER, VEGGIE_BURGER, CHICKEN_BURGER, TURKEY_BURGER, BBQ_BURGER, JALAPENO_BURGER, TERIYAKI_BURGER, DOUBLE_BURGER, DOUBLE_CHEESEBURGER, DOUBLE_BACON_BURGER, DOUBLE_BACON_CHEESEBURGER)));
    }

    @Test
    void valueOf() {
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