package org.fast_food.product;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fast_food.product.FrenchFries.*;
import static org.junit.jupiter.api.Assertions.*;

class FrenchFriesTest {

    @Test
    void testGetNameForDifferentFriesTypes() {
        assertEquals(REGULAR.getName(), "Regular Fries");
        assertEquals(CURLY.getName(), "Curly Fries");
        assertEquals(SWEET_POTATO.getName(), "Sweet Potato Fries");
        assertEquals(LOADED_FRIES.getName(), "Loaded Fries");
        assertEquals(GARLIC_PARMESAN.getName(), "Garlic Parmesan Fries");
    }

    @Test
    void testGetPriceForDifferentFriesTypes() {
        assertEquals(REGULAR.getPrice(), 2.99);
        assertEquals(CURLY.getPrice(), 3.49);
        assertEquals(SWEET_POTATO.getPrice(), 3.99);
        assertEquals(LOADED_FRIES.getPrice(), 4.99);
        assertEquals(GARLIC_PARMESAN.getPrice(), 4.49);
    }

    @Test
    void testGetDescriptionForDifferentFriesTypes() {
        assertEquals(REGULAR.getDescription(), "Crispy and classic fries made from perfectly golden potatoes, lightly seasoned with salt.");
        assertEquals(CURLY.getDescription(), "Fun and curly fries with a delightful blend of spices, adding a twist to your regular fry experience.");
        assertEquals(SWEET_POTATO.getDescription(), "Oven-baked sweet potato fries with a hint of cinnamon, offering a slightly sweet and savory flavor.");
        assertEquals(LOADED_FRIES.getDescription(), "A hearty serving of regular fries topped with crispy bacon, melted cheese, tangy sour cream, and fresh green onions.");
        assertEquals(GARLIC_PARMESAN.getDescription(), "Irresistible fries seasoned with garlic powder, grated Parmesan cheese, and fresh parsley for a savory experience.");
    }

    @Test
    void testGetCaloriesForDifferentFriesTypes() {
        assertEquals(REGULAR.getCalories(), 220);
        assertEquals(CURLY.getCalories(), 250);
        assertEquals(SWEET_POTATO.getCalories(), 200);
        assertEquals(LOADED_FRIES.getCalories(), 480);
        assertEquals(GARLIC_PARMESAN.getCalories(), 300);
    }

    @Test
    void testFrenchFriesContainsAllValues() {
        assertTrue(List.of(REGULAR, CURLY, SWEET_POTATO, LOADED_FRIES, GARLIC_PARMESAN).containsAll(List.of(FrenchFries.values())));
    }

    @Test
    void testValueOfDifferentBurgerTypes() {
        assertEquals(REGULAR, FrenchFries.valueOf("REGULAR"));
        assertEquals(CURLY, FrenchFries.valueOf("CURLY"));
        assertEquals(SWEET_POTATO, FrenchFries.valueOf("SWEET_POTATO"));
        assertEquals(LOADED_FRIES, FrenchFries.valueOf("LOADED_FRIES"));
        assertEquals(GARLIC_PARMESAN, FrenchFries.valueOf("GARLIC_PARMESAN"));
    }
}