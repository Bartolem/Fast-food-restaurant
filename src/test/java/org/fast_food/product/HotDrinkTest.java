package org.fast_food.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotDrinkTest {

    @Test
    void testGetNameForDifferentHotDrinks() {
        assertEquals("Tea", HotDrink.TEA.getName());
        assertEquals("Green Tea", HotDrink.GREEN_TEA.getName());
        assertEquals("Chamomile Drink", HotDrink.CHAMOMILE_DRINK.getName());
        assertEquals("Espresso", HotDrink.ESPRESSO.getName());
        assertEquals("Latte", HotDrink.LATTE.getName());
        assertEquals("Cappuccino", HotDrink.CAPPUCCINO.getName());
        assertEquals("Malted Milk", HotDrink.MALTED_MILK.getName());
        assertEquals("Hot Chocolate", HotDrink.HOT_CHOCOLATE.getName());
    }

    @Test
    void testGetPriceForDifferentHotDrinks() {
        assertEquals(BigDecimal.valueOf(2.49), HotDrink.TEA.getPrice());
        assertEquals(BigDecimal.valueOf(2.99), HotDrink.GREEN_TEA.getPrice());
        assertEquals(BigDecimal.valueOf(3.49), HotDrink.CHAMOMILE_DRINK.getPrice());
        assertEquals(BigDecimal.valueOf(2.99), HotDrink.ESPRESSO.getPrice());
        assertEquals(BigDecimal.valueOf(4.49), HotDrink.LATTE.getPrice());
        assertEquals(BigDecimal.valueOf(4.29), HotDrink.CAPPUCCINO.getPrice());
        assertEquals(BigDecimal.valueOf(3.99), HotDrink.MALTED_MILK.getPrice());
        assertEquals(BigDecimal.valueOf(3.79), HotDrink.HOT_CHOCOLATE.getPrice());
    }

    @Test
    void testGetDescriptionForDifferentHotDrinks() {
        assertEquals("Enjoy a comforting cup of classic tea, brewed to perfection for a soothing and aromatic beverage.", HotDrink.TEA.getDescription());
        assertEquals("Savor the delicate flavors of green tea, known for its subtle grassy notes and potential health benefits.", HotDrink.GREEN_TEA.getDescription());
        assertEquals("Unwind with the calming and floral aroma of chamomile, perfect for relaxation and stress relief.", HotDrink.CHAMOMILE_DRINK.getDescription());
        assertEquals("Experience the bold and intense flavors of espresso, brewed to perfection for a quick and energizing pick-me-up.", HotDrink.ESPRESSO.getDescription());
        assertEquals("Indulge in the creamy richness of a latte, made with espresso and steamed milk for a smooth and comforting drink.", HotDrink.LATTE.getDescription());
        assertEquals("Enjoy the perfect balance of espresso, steamed milk, and velvety foam in a classic cappuccino, delivering rich flavors and a frothy texture.", HotDrink.CAPPUCCINO.getDescription());
        assertEquals("Delight in the nostalgic taste of malted milk, a creamy and sweet beverage reminiscent of childhood treats.", HotDrink.MALTED_MILK.getDescription());
        assertEquals("Indulge your sweet tooth with rich and velvety hot chocolate, made with premium cocoa for a decadent and comforting drink.", HotDrink.HOT_CHOCOLATE.getDescription());
    }

    @Test
    void testGetCaloriesForDifferentHotDrinks() {
        assertEquals(0, HotDrink.TEA.getCalories());
        assertEquals(0, HotDrink.GREEN_TEA.getCalories());
        assertEquals(0, HotDrink.CHAMOMILE_DRINK.getCalories());
        assertEquals(5, HotDrink.ESPRESSO.getCalories());
        assertEquals(150, HotDrink.LATTE.getCalories());
        assertEquals(120, HotDrink.CAPPUCCINO.getCalories());
        assertEquals(200, HotDrink.MALTED_MILK.getCalories());
        assertEquals(180, HotDrink.HOT_CHOCOLATE.getCalories());
    }
}

