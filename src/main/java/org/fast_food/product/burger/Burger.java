package org.fast_food.product.burger;

import org.fast_food.product.Product;
import org.fast_food.product.burger.ingredient.IngredientI;

import java.util.List;

public interface Burger extends Product {
    List<IngredientI> getIngredients();
    double getSpicinessLevel();
    double getPopularityRating();
}
