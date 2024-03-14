package org.fast_food.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.fast_food.product.ColdDrink.*;
import static org.junit.jupiter.api.Assertions.*;

public class ColdDrinkTest {
    @Test
    void testGetNameForDifferentColdDrinks() {
        assertEquals("Peanut Banana Smoothie", PEANUT_BUTTER_BANANA_SMOOTHIE.getName());
        assertEquals("Mango Smoothie", MANGO_SMOOTHIE.getName());
        assertEquals("Spinach Smoothie", SPINACH_SMOOTHIE.getName());
        assertEquals("Strawberry Smoothie", STRAWBERRY_SMOOTHIE.getName());
        assertEquals("Blueberry Smoothie", BLUEBERRY_SMOOTHIE.getName());
        assertEquals("Mulberry Smoothie", MULBERRY_SMOOTHIE.getName());
        assertEquals("Kiwi Smoothie", KIWI_SMOOTHIE.getName());
        assertEquals("Pineapple Smoothie", PINEAPPLE_SMOOTHIE.getName());
        assertEquals("Caramel Iced Coffee", CARAMEL_ICED_COFFEE.getName());
        assertEquals("Cookie Milkshake", MILKSHAKE_COOKIES_AND_CREAM.getName());
        assertEquals("Chocolate Milkshake", CHOCOLATE_MILKSHAKE.getName());
        assertEquals("Strawberry Milkshake", ColdDrink.STRAWBERRY_MILKSHAKE.getName());
        assertEquals("Banana Juice", BANANA_JUICE.getName());
        assertEquals("Orange Juice", ORANGE_JUICE.getName());
        assertEquals("Watermelon Juice", WATERMELON_JUICE.getName());
        assertEquals("Pineapple Piña Colada", PINEAPPLE_PINA_COLADA.getName());
        assertEquals("Cola Drink", COLA_DRINK.getName());
        assertEquals("Iced Tea", ICE_TEA.getName());
        assertEquals("Mint Cocktail", MINT_COCKTAIL.getName());
        assertEquals("Lemon Lime Soda", LEMON_LIME_SODA.getName());
    }

    @Test
    void testGetPriceForDifferentColdDrinks() {
        assertEquals(BigDecimal.valueOf(5.99), PEANUT_BUTTER_BANANA_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(7.49), MANGO_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(6.89), SPINACH_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(5.99), STRAWBERRY_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(6.79), BLUEBERRY_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(7.29), MULBERRY_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(7.09), KIWI_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(7.49), PINEAPPLE_SMOOTHIE.getPrice());
        assertEquals(BigDecimal.valueOf(3.99), CARAMEL_ICED_COFFEE.getPrice());
        assertEquals(BigDecimal.valueOf(6.49), MILKSHAKE_COOKIES_AND_CREAM.getPrice());
        assertEquals(BigDecimal.valueOf(5.99), CHOCOLATE_MILKSHAKE.getPrice());
        assertEquals(BigDecimal.valueOf(6.99), STRAWBERRY_MILKSHAKE.getPrice());
        assertEquals(BigDecimal.valueOf(3.49), BANANA_JUICE.getPrice());
        assertEquals(BigDecimal.valueOf(2.99), ORANGE_JUICE.getPrice());
        assertEquals(BigDecimal.valueOf(3.99), WATERMELON_JUICE.getPrice());
        assertEquals(BigDecimal.valueOf(7.99), PINEAPPLE_PINA_COLADA.getPrice());
        assertEquals(BigDecimal.valueOf(1.99), COLA_DRINK.getPrice());
        assertEquals(BigDecimal.valueOf(2.49), ICE_TEA.getPrice());
        assertEquals(BigDecimal.valueOf(2.29), MINT_COCKTAIL.getPrice());
        assertEquals(BigDecimal.valueOf(2.29), LEMON_LIME_SODA.getPrice());
    }

    @Test
    void testGetDescriptionForDifferentColdDrinks() {
        assertEquals("Indulge in the creamy blend of peanut butter, ripe bananas, and rich chocolate, creating a decadent and satisfying smoothie.", PEANUT_BUTTER_BANANA_SMOOTHIE.getDescription());
        assertEquals("Refresh your taste buds with the tropical sweetness of ripe mango blended into a smooth and creamy drink.", MANGO_SMOOTHIE.getDescription());
        assertEquals("Boost your energy with this nutritious blend of fresh spinach, sweet fruits, and a hint of citrus, delivering a healthy and revitalizing drink.", SPINACH_SMOOTHIE.getDescription());
        assertEquals("Savor the sweetness of ripe strawberries blended to perfection, creating a refreshing and delightful beverage.", STRAWBERRY_SMOOTHIE.getDescription());
        assertEquals("Dive into the antioxidant-rich goodness of blueberries in this smooth and velvety drink, bursting with fruity flavor.", BLUEBERRY_SMOOTHIE.getDescription());
        assertEquals("Enjoy the unique and slightly tart taste of mulberries in this creamy and satisfying smoothie, packed with vitamins and nutrients.", MULBERRY_SMOOTHIE.getDescription());
        assertEquals("Experience the tangy sweetness of fresh kiwi fruit blended into a cool and invigorating beverage, perfect for a hot day.", KIWI_SMOOTHIE.getDescription());
        assertEquals("Transport yourself to the tropics with the tropical flavors of ripe pineapple in this refreshing and hydrating smoothie.", PINEAPPLE_SMOOTHIE.getDescription());
        assertEquals("Indulge in the rich and creamy flavors of caramel blended with chilled coffee, providing a sweet and refreshing pick-me-up.", CARAMEL_ICED_COFFEE.getDescription());
        assertEquals("Treat yourself to the classic combination of creamy vanilla ice cream blended with chunks of chocolate cookies, creating a decadent and indulgent milkshake.", MILKSHAKE_COOKIES_AND_CREAM.getDescription());
        assertEquals("Indulge in the rich and velvety smoothness of chocolate ice cream blended into a thick and creamy milkshake, perfect for chocolate lovers.", CHOCOLATE_MILKSHAKE.getDescription());
        assertEquals("Elevate your milkshake experience with luscious strawberry flavor, topped with fluffy marshmallows and chocolate sticks for an extra indulgent touch.", STRAWBERRY_MILKSHAKE.getDescription());
        assertEquals("Quench your thirst with the natural sweetness of freshly squeezed banana juice, providing a refreshing and nutritious beverage option.", BANANA_JUICE.getDescription());
        assertEquals("Start your day with a burst of vitamin C from freshly squeezed orange juice, delivering tangy citrus flavor in every sip.", ORANGE_JUICE.getDescription());
        assertEquals("Stay hydrated with the juicy goodness of watermelon juice, offering a refreshing and hydrating option for hot summer days.", WATERMELON_JUICE.getDescription());
        assertEquals("Transport yourself to a tropical paradise with this classic cocktail featuring the sweet flavors of pineapple and coconut, blended with rum for a refreshing and indulgent drink.", PINEAPPLE_PINA_COLADA.getDescription());
        assertEquals("Enjoy the timeless and refreshing taste of cola, served chilled over ice for a classic beverage choice.", COLA_DRINK.getDescription());
        assertEquals("Cool off with a refreshing glass of iced tea, brewed to perfection and served with a lemon wedge for a touch of citrus flavor.", ICE_TEA.getDescription());
        assertEquals("Refresh your palate with the invigorating flavors of fresh mint in this cooling cocktail, perfect for a hot summer day or as a palate cleanser between meals.", MINT_COCKTAIL.getDescription());
        assertEquals("Quench your thirst with the bubbly and tangy flavors of lemon and lime in this classic soda beverage, served ice-cold for maximum refreshment.", LEMON_LIME_SODA.getDescription());
    }

    @Test
    void testGetCaloriesForDifferentColdDrinks() {
        assertEquals(380, PEANUT_BUTTER_BANANA_SMOOTHIE.getCalories());
        assertEquals(220, MANGO_SMOOTHIE.getCalories());
        assertEquals(180, SPINACH_SMOOTHIE.getCalories());
        assertEquals(250, STRAWBERRY_SMOOTHIE.getCalories());
        assertEquals(230, BLUEBERRY_SMOOTHIE.getCalories());
        assertEquals(260, MULBERRY_SMOOTHIE.getCalories());
        assertEquals(200, KIWI_SMOOTHIE.getCalories());
        assertEquals(220, PINEAPPLE_SMOOTHIE.getCalories());
        assertEquals(150, CARAMEL_ICED_COFFEE.getCalories());
        assertEquals(550, MILKSHAKE_COOKIES_AND_CREAM.getCalories());
        assertEquals(500, CHOCOLATE_MILKSHAKE.getCalories());
        assertEquals(520, STRAWBERRY_MILKSHAKE.getCalories());
        assertEquals(170, BANANA_JUICE.getCalories());
        assertEquals(120, ORANGE_JUICE.getCalories());
        assertEquals(100, WATERMELON_JUICE.getCalories());
        assertEquals(350, PINEAPPLE_PINA_COLADA.getCalories());
        assertEquals(140, COLA_DRINK.getCalories());
        assertEquals(80, ICE_TEA.getCalories());
        assertEquals(200, MINT_COCKTAIL.getCalories());
        assertEquals(160, LEMON_LIME_SODA.getCalories());
    }

    @Test
    void testValueOfDifferentColdDrinks() {
        assertEquals(PEANUT_BUTTER_BANANA_SMOOTHIE, ColdDrink.valueOf("PEANUT_BUTTER_BANANA_SMOOTHIE"));
        assertEquals(MANGO_SMOOTHIE, ColdDrink.valueOf("MANGO_SMOOTHIE"));
        assertEquals(SPINACH_SMOOTHIE, ColdDrink.valueOf("SPINACH_SMOOTHIE"));
        assertEquals(STRAWBERRY_SMOOTHIE, ColdDrink.valueOf("STRAWBERRY_SMOOTHIE"));
        assertEquals(BLUEBERRY_SMOOTHIE, ColdDrink.valueOf("BLUEBERRY_SMOOTHIE"));
        assertEquals(MULBERRY_SMOOTHIE, ColdDrink.valueOf("MULBERRY_SMOOTHIE"));
        assertEquals(KIWI_SMOOTHIE, ColdDrink.valueOf("KIWI_SMOOTHIE"));
        assertEquals(PINEAPPLE_SMOOTHIE, ColdDrink.valueOf("PINEAPPLE_SMOOTHIE"));
        assertEquals(CARAMEL_ICED_COFFEE, ColdDrink.valueOf("CARAMEL_ICED_COFFEE"));
        assertEquals(MILKSHAKE_COOKIES_AND_CREAM, ColdDrink.valueOf("MILKSHAKE_COOKIES_AND_CREAM"));
        assertEquals(CHOCOLATE_MILKSHAKE, ColdDrink.valueOf("CHOCOLATE_MILKSHAKE"));
        assertEquals(STRAWBERRY_MILKSHAKE, ColdDrink.valueOf("STRAWBERRY_MILKSHAKE"));
        assertEquals(BANANA_JUICE, ColdDrink.valueOf("BANANA_JUICE"));
        assertEquals(ORANGE_JUICE, ColdDrink.valueOf("ORANGE_JUICE"));
        assertEquals(WATERMELON_JUICE, ColdDrink.valueOf("WATERMELON_JUICE"));
        assertEquals(PINEAPPLE_PINA_COLADA, ColdDrink.valueOf("PINEAPPLE_PINA_COLADA"));
        assertEquals(COLA_DRINK, ColdDrink.valueOf("COLA_DRINK"));
        assertEquals(ICE_TEA, ColdDrink.valueOf("ICE_TEA"));
        assertEquals(MINT_COCKTAIL, ColdDrink.valueOf("MINT_COCKTAIL"));
        assertEquals(LEMON_LIME_SODA, ColdDrink.valueOf("LEMON_LIME_SODA"));
    }
}
