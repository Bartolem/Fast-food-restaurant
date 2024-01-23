package org.fast_food.product.burger;

import org.fast_food.product.Product;

import java.util.List;

public interface Burger extends Product {
    List<String> getIngredients();
    double getSpicinessLevel();
    double getPopularityRating();
}
