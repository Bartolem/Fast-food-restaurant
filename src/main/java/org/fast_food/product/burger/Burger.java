package org.fast_food.product.burger;

import org.fast_food.product.Product;

import java.util.List;

public interface Burger<T> extends Product {
    List<T> getIngredients();
    double getSpicinessLevel();
    double getPopularityRating();
}
