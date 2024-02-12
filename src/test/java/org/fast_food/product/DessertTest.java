package org.fast_food.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DessertTest {

    @Test
    void testGetNameForDifferentDesserts() {
        assertEquals("Sweet Cornbread", Dessert.SWEET_CORNBREAD.getName());
        assertEquals("Sweet Nanami Bars", Dessert.SWEET_NANAMI_BARS.getName());
        assertEquals("Mango Slices", Dessert.MANGO_SLICES.getName());
        assertEquals("Sweet Red Date Cake", Dessert.SWEET_RED_DATE_CAKE.getName());
        assertEquals("Sweet Oil Tea Cake", Dessert.SWEET_OIL_TEA_CAKE.getName());
        assertEquals("Cherry White Chocolate", Dessert.CHERRY_WHITE_CHOCOLATE.getName());
        assertEquals("Chocolate Chili Cake", Dessert.CHOCOLATE_CHILI_CAKE.getName());
        assertEquals("Cantonese Sponge Cake", Dessert.CANTONESE_SPONGE_CAKE.getName());
        assertEquals("Carmel Peanut Pancakes", Dessert.CARMEL_PEANUT_PANCAKES.getName());
        assertEquals("Chocolate Cake", Dessert.CHOCOLATE_CAKE.getName());
        assertEquals("Kiwi Dessert", Dessert.KIWI_DESSERT.getName());
        assertEquals("Macaroons", Dessert.MACAROONS.getName());
    }

    @Test
    void testGetPriceForDifferentDesserts() {
        assertEquals(3.99, Dessert.SWEET_CORNBREAD.getPrice());
        assertEquals(5.49, Dessert.SWEET_NANAMI_BARS.getPrice());
        assertEquals(2.99, Dessert.MANGO_SLICES.getPrice());
        assertEquals(4.79, Dessert.SWEET_RED_DATE_CAKE.getPrice());
        assertEquals(3.99, Dessert.SWEET_OIL_TEA_CAKE.getPrice());
        assertEquals(6.99, Dessert.CHERRY_WHITE_CHOCOLATE.getPrice());
        assertEquals(5.89, Dessert.CHOCOLATE_CHILI_CAKE.getPrice());
        assertEquals(4.99, Dessert.CANTONESE_SPONGE_CAKE.getPrice());
        assertEquals(7.29, Dessert.CARMEL_PEANUT_PANCAKES.getPrice());
        assertEquals(6.49, Dessert.CHOCOLATE_CAKE.getPrice());
        assertEquals(3.49, Dessert.KIWI_DESSERT.getPrice());
        assertEquals(8.99, Dessert.MACAROONS.getPrice());
    }

    @Test
    void testGetDescriptionForDifferentDesserts() {
        assertEquals("Indulge in the rich sweetness of cornbread with a hint of honey, baked to perfection for a delightful treat.", Dessert.SWEET_CORNBREAD.getDescription());
        assertEquals("Satisfy your sweet tooth with these decadent Nanami bars, featuring layers of chocolate, custard, and coconut on a crumbly base.", Dessert.SWEET_NANAMI_BARS.getDescription());
        assertEquals("Enjoy the tropical flavor of ripe mango slices, perfect as a refreshing snack or dessert option.", Dessert.MANGO_SLICES.getDescription());
        assertEquals("Treat yourself to the rich and moist sweetness of red date cake, infused with the unique flavor of Chinese red dates.", Dessert.SWEET_RED_DATE_CAKE.getDescription());
        assertEquals("Indulge in the soft and fluffy texture of oil tea cake, subtly sweetened for a delightful tea-time treat.", Dessert.SWEET_OIL_TEA_CAKE.getDescription());
        assertEquals("Delight in the luxurious combination of tart cherries and creamy white chocolate, creating a harmonious blend of flavors.", Dessert.CHERRY_WHITE_CHOCOLATE.getDescription());
        assertEquals("Experience a burst of flavor with this unique cake featuring rich chocolate infused with a hint of spicy chili for a tantalizing taste sensation.", Dessert.CHOCOLATE_CHILI_CAKE.getDescription());
        assertEquals("Enjoy the light and airy texture of Cantonese sponge cake, delicately flavored for a delightful dessert option.", Dessert.CANTONESE_SPONGE_CAKE.getDescription());
        assertEquals("Indulge in fluffy pancakes drizzled with rich caramel sauce and topped with crunchy peanuts, offering a decadent twist on a classic breakfast.", Dessert.CARMEL_PEANUT_PANCAKES.getDescription());
        assertEquals("Satisfy your chocolate cravings with this moist and decadent chocolate cake, layered with creamy frosting for the ultimate dessert experience.", Dessert.CHOCOLATE_CAKE.getDescription());
        assertEquals("Refresh your palate with the vibrant sweetness of kiwi fruit, served in a refreshing and light dessert option.", Dessert.KIWI_DESSERT.getDescription());
        assertEquals("Indulge in these delicate and colorful French macaroons, featuring a crispy shell and a creamy filling in a variety of flavors.", Dessert.MACAROONS.getDescription());
    }

    @Test
    void testGetCaloriesForDifferentDesserts() {
        assertEquals(250, Dessert.SWEET_CORNBREAD.getCalories());
        assertEquals(320, Dessert.SWEET_NANAMI_BARS.getCalories());
        assertEquals(80, Dessert.MANGO_SLICES.getCalories());
        assertEquals(300, Dessert.SWEET_RED_DATE_CAKE.getCalories());
        assertEquals(220, Dessert.SWEET_OIL_TEA_CAKE.getCalories());
        assertEquals(380, Dessert.CHERRY_WHITE_CHOCOLATE.getCalories());
        assertEquals(350, Dessert.CHOCOLATE_CHILI_CAKE.getCalories());
        assertEquals(200, Dessert.CANTONESE_SPONGE_CAKE.getCalories());
        assertEquals(450, Dessert.CARMEL_PEANUT_PANCAKES.getCalories());
        assertEquals(400, Dessert.CHOCOLATE_CAKE.getCalories());
        assertEquals(120, Dessert.KIWI_DESSERT.getCalories());
        assertEquals(280, Dessert.MACAROONS.getCalories());
    }
}

