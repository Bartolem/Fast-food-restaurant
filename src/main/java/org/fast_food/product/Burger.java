package org.fast_food.product;

import java.util.List;

public interface Burger extends Product {
    List<String> getIngredients();
    double getSpicinessLevel();
    double getPopularityRating();
}
