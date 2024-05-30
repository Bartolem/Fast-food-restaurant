package org.fast_food.product;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.math.BigDecimal;

public enum HotDrink implements Product {
    TEA("Tea", BigDecimal.valueOf(2.49), "Enjoy a comforting cup of classic tea, brewed to perfection for a soothing and aromatic beverage.", 0),
    GREEN_TEA("Green Tea", BigDecimal.valueOf(2.99), "Savor the delicate flavors of green tea, known for its subtle grassy notes and potential health benefits.", 0),
    CHAMOMILE_DRINK("Chamomile Drink", BigDecimal.valueOf(3.49), "Unwind with the calming and floral aroma of chamomile, perfect for relaxation and stress relief.", 0),
    ESPRESSO("Espresso", BigDecimal.valueOf(2.99), "Experience the bold and intense flavors of espresso, brewed to perfection for a quick and energizing pick-me-up.", 5),
    LATTE("Latte", BigDecimal.valueOf(4.49), "Indulge in the creamy richness of a latte, made with espresso and steamed milk for a smooth and comforting drink.", 150),
    CAPPUCCINO("Cappuccino", BigDecimal.valueOf(4.29), "Enjoy the perfect balance of espresso, steamed milk, and velvety foam in a classic cappuccino, delivering rich flavors and a frothy texture.", 120),
    MALTED_MILK("Malted Milk", BigDecimal.valueOf(3.99), "Delight in the nostalgic taste of malted milk, a creamy and sweet beverage reminiscent of childhood treats.", 200),
    HOT_CHOCOLATE("Hot Chocolate", BigDecimal.valueOf(3.79), "Indulge your sweet tooth with rich and velvety hot chocolate, made with premium cocoa for a decadent and comforting drink.", 180);

    public  static final Type TYPE = Type.DRINK_HOT;
    private final String name;
    private final BigDecimal price;
    private final String description;
    private final int calories;

    HotDrink(String name, BigDecimal price, String description, int calories) {
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

    @JsonCreator
    public static Product fromName(String name) {
        try {
            return HotDrink.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown hot drink: " + name);
        }
    }
}

