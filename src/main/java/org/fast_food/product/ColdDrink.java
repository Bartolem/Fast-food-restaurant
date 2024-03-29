package org.fast_food.product;

import java.math.BigDecimal;

public enum ColdDrink implements Product {
    PEANUT_BUTTER_BANANA_SMOOTHIE("Peanut Banana Smoothie", BigDecimal.valueOf(5.99), "Indulge in the creamy blend of peanut butter, ripe bananas, and rich chocolate, creating a decadent and satisfying smoothie.", 380),
    MANGO_SMOOTHIE("Mango Smoothie", BigDecimal.valueOf(7.49), "Refresh your taste buds with the tropical sweetness of ripe mango blended into a smooth and creamy drink.", 220),
    SPINACH_SMOOTHIE("Spinach Smoothie", BigDecimal.valueOf(6.89), "Boost your energy with this nutritious blend of fresh spinach, sweet fruits, and a hint of citrus, delivering a healthy and revitalizing drink.", 180),
    STRAWBERRY_SMOOTHIE("Strawberry Smoothie", BigDecimal.valueOf(5.99), "Savor the sweetness of ripe strawberries blended to perfection, creating a refreshing and delightful beverage.", 250),
    BLUEBERRY_SMOOTHIE("Blueberry Smoothie", BigDecimal.valueOf(6.79), "Dive into the antioxidant-rich goodness of blueberries in this smooth and velvety drink, bursting with fruity flavor.", 230),
    MULBERRY_SMOOTHIE("Mulberry Smoothie", BigDecimal.valueOf(7.29), "Enjoy the unique and slightly tart taste of mulberries in this creamy and satisfying smoothie, packed with vitamins and nutrients.", 260),
    KIWI_SMOOTHIE("Kiwi Smoothie", BigDecimal.valueOf(7.09), "Experience the tangy sweetness of fresh kiwi fruit blended into a cool and invigorating beverage, perfect for a hot day.", 200),
    PINEAPPLE_SMOOTHIE("Pineapple Smoothie", BigDecimal.valueOf(7.49), "Transport yourself to the tropics with the tropical flavors of ripe pineapple in this refreshing and hydrating smoothie.", 220),
    CARAMEL_ICED_COFFEE("Caramel Iced Coffee", BigDecimal.valueOf(3.99), "Indulge in the rich and creamy flavors of caramel blended with chilled coffee, providing a sweet and refreshing pick-me-up.", 150),
    MILKSHAKE_COOKIES_AND_CREAM("Cookie Milkshake", BigDecimal.valueOf(6.49), "Treat yourself to the classic combination of creamy vanilla ice cream blended with chunks of chocolate cookies, creating a decadent and indulgent milkshake.", 550),
    CHOCOLATE_MILKSHAKE("Chocolate Milkshake", BigDecimal.valueOf(5.99), "Indulge in the rich and velvety smoothness of chocolate ice cream blended into a thick and creamy milkshake, perfect for chocolate lovers.", 500),
    STRAWBERRY_MILKSHAKE("Strawberry Milkshake", BigDecimal.valueOf(6.99), "Elevate your milkshake experience with luscious strawberry flavor, topped with fluffy marshmallows and chocolate sticks for an extra indulgent touch.", 520),
    BANANA_JUICE("Banana Juice", BigDecimal.valueOf(3.49), "Quench your thirst with the natural sweetness of freshly squeezed banana juice, providing a refreshing and nutritious beverage option.", 170),
    ORANGE_JUICE("Orange Juice", BigDecimal.valueOf(2.99), "Start your day with a burst of vitamin C from freshly squeezed orange juice, delivering tangy citrus flavor in every sip.", 120),
    WATERMELON_JUICE("Watermelon Juice", BigDecimal.valueOf(3.99), "Stay hydrated with the juicy goodness of watermelon juice, offering a refreshing and hydrating option for hot summer days.", 100),
    PINEAPPLE_PINA_COLADA("Pineapple Piña Colada", BigDecimal.valueOf(7.99), "Transport yourself to a tropical paradise with this classic cocktail featuring the sweet flavors of pineapple and coconut, blended with rum for a refreshing and indulgent drink.", 350),
    COLA_DRINK("Cola Drink", BigDecimal.valueOf(1.99), "Enjoy the timeless and refreshing taste of cola, served chilled over ice for a classic beverage choice.", 140),
    ICE_TEA("Iced Tea", BigDecimal.valueOf(2.49), "Cool off with a refreshing glass of iced tea, brewed to perfection and served with a lemon wedge for a touch of citrus flavor.", 80),
    MINT_COCKTAIL("Mint Cocktail", BigDecimal.valueOf(2.29), "Refresh your palate with the invigorating flavors of fresh mint in this cooling cocktail, perfect for a hot summer day or as a palate cleanser between meals.", 200),
    LEMON_LIME_SODA("Lemon Lime Soda", BigDecimal.valueOf(2.29), "Quench your thirst with the bubbly and tangy flavors of lemon and lime in this classic soda beverage, served ice-cold for maximum refreshment.", 160);
    ;

    public static final Type TYPE = Type.DRINK_COLD;
    private final String name;
    private final BigDecimal price;
    private final String description;
    private final int calories;

    ColdDrink(String name, BigDecimal price, String description, int calories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }

    @Override
    public Type getType() {
        return TYPE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
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
