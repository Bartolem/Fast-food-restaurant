package org.fast_food.product;

import java.math.BigDecimal;

public enum FrenchFries implements Product {
    REGULAR("Regular Fries", BigDecimal.valueOf(2.99), "Crispy and classic fries made from perfectly golden potatoes, lightly seasoned with salt.", 220),
    CURLY("Curly Fries", BigDecimal.valueOf(3.49), "Fun and curly fries with a delightful blend of spices, adding a twist to your regular fry experience.", 250),
    SWEET_POTATO("Sweet Potato Fries", BigDecimal.valueOf(3.99), "Oven-baked sweet potato fries with a hint of cinnamon, offering a slightly sweet and savory flavor.", 200),
    LOADED_FRIES("Loaded Fries", BigDecimal.valueOf(4.99), "A hearty serving of regular fries topped with crispy bacon, melted cheese, tangy sour cream, and fresh green onions.", 480),
    GARLIC_PARMESAN("Garlic Parmesan Fries", BigDecimal.valueOf(4.49), "Irresistible fries seasoned with garlic powder, grated Parmesan cheese, and fresh parsley for a savory experience.", 300)
    ;

    public static final Type TYPE = Type.FRENCH_FRIES;
    private final String name;
    private final BigDecimal price;
    private final String description;
    private final int calories;

    FrenchFries(String name, BigDecimal price, String description, int calories) {
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
