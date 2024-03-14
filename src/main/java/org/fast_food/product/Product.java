package org.fast_food.product;

import java.math.BigDecimal;

public interface Product {
    String getName();
    BigDecimal getPrice();
    String getDescription();
    int getCalories();
    Type getType();
}
