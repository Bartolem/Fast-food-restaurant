package org.fast_food.product;

public enum Dessert implements Product {
    SWEET_CORNBREAD("Sweet Cornbread", 3.99, "Indulge in the rich sweetness of cornbread with a hint of honey, baked to perfection for a delightful treat.", 250),
    SWEET_NANAMI_BARS("Sweet Nanami Bars", 5.49, "Satisfy your sweet tooth with these decadent Nanami bars, featuring layers of chocolate, custard, and coconut on a crumbly base.", 320),
    MANGO_SLICES("Mango Slices", 2.99, "Enjoy the tropical flavor of ripe mango slices, perfect as a refreshing snack or dessert option.", 80),
    SWEET_RED_DATE_CAKE("Sweet Red Date Cake", 4.79, "Treat yourself to the rich and moist sweetness of red date cake, infused with the unique flavor of Chinese red dates.", 300),
    SWEET_OIL_TEA_CAKE("Sweet Oil Tea Cake", 3.99, "Indulge in the soft and fluffy texture of oil tea cake, subtly sweetened for a delightful tea-time treat.", 220),
    CHERRY_WHITE_CHOCOLATE("Cherry White Chocolate", 6.99, "Delight in the luxurious combination of tart cherries and creamy white chocolate, creating a harmonious blend of flavors.", 380),
    CHOCOLATE_CHILI_CAKE("Chocolate Chili Cake", 5.89, "Experience a burst of flavor with this unique cake featuring rich chocolate infused with a hint of spicy chili for a tantalizing taste sensation.", 350),
    CANTONESE_SPONGE_CAKE("Cantonese Sponge Cake", 4.99, "Enjoy the light and airy texture of Cantonese sponge cake, delicately flavored for a delightful dessert option.", 200),
    CARMEL_PEANUT_PANCAKES("Carmel Peanut Pancakes", 7.29, "Indulge in fluffy pancakes drizzled with rich caramel sauce and topped with crunchy peanuts, offering a decadent twist on a classic breakfast.", 450),
    CHOCOLATE_CAKE("Chocolate Cake", 6.49, "Satisfy your chocolate cravings with this moist and decadent chocolate cake, layered with creamy frosting for the ultimate dessert experience.", 400),
    KIWI_DESSERT("Kiwi Dessert", 3.49, "Refresh your palate with the vibrant sweetness of kiwi fruit, served in a refreshing and light dessert option.", 120),
    MACAROONS("Macaroons", 8.99, "Indulge in these delicate and colorful French macaroons, featuring a crispy shell and a creamy filling in a variety of flavors.", 280);

    private static final Type TYPE = Type.DESSERT;
    private final String name;
    private final double price;
    private final String description;
    private final int calories;

    Dessert(String name, double price, String description, int calories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}
