package org.fast_food.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.fast_food.product.Side.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideTest {
    @Test
    void testGetNameForDifferentSideMeals() {
        assertEquals(ONION_RINGS.getName(), "Onion Rings");
        assertEquals(SALAD.getName(), "Side Salad");
        assertEquals(QUINOA_SALAD.getName(), "Quinoa Salad");
        assertEquals(GREEK_SALAD.getName(), "Greek Salad");
    }

    @Test
    void testGetPriceForDifferentSideMeals() {
        assertEquals(ONION_RINGS.getPrice(), BigDecimal.valueOf(4.79));
        assertEquals(SALAD.getPrice(), BigDecimal.valueOf(3.99));
        assertEquals(QUINOA_SALAD.getPrice(), BigDecimal.valueOf(4.79));
        assertEquals(GREEK_SALAD.getPrice(), BigDecimal.valueOf(4.99));
    }

    @Test
    void testGetDescriptionForDifferentSideMeals() {
        assertEquals(ONION_RINGS.getDescription(), "Thick-cut onion rings coated in a seasoned batter and fried to a golden brown.");
        assertEquals(SALAD.getDescription(), "Fresh mixed greens, cherry tomatoes, cucumber slices, and shredded carrots, served with your choice of dressing.");
        assertEquals(QUINOA_SALAD.getDescription(), "A refreshing salad made with cooked quinoa, mixed greens, diced vegetables, and a zesty vinaigrette dressing.");
        assertEquals(GREEK_SALAD.getDescription(), "A traditional Greek salad featuring crisp lettuce, juicy tomatoes, cucumber slices, red onions, Kalamata olives, and feta cheese, drizzled with olive oil and oregano.");
    }

    @Test
    void testGetCaloriesForDifferentSideMeals() {
        assertEquals(ONION_RINGS.getCalories(), 420);
        assertEquals(SALAD.getCalories(), 120);
        assertEquals(QUINOA_SALAD.getCalories(), 180);
        assertEquals(GREEK_SALAD.getCalories(), 280);
    }

    @Test
    void testSideMealsContainsAllValues() {
        assertEquals(List.of(ONION_RINGS, SALAD, QUINOA_SALAD, GREEK_SALAD), List.of(Side.values()));
    }

    @Test
    void testValueOfDifferentSideMeals() {
        assertEquals(ONION_RINGS, Side.valueOf("ONION_RINGS"));
        assertEquals(SALAD, Side.valueOf("SALAD"));
        assertEquals(QUINOA_SALAD, Side.valueOf("QUINOA_SALAD"));
        assertEquals(GREEK_SALAD, Side.valueOf("GREEK_SALAD"));
    }
}
