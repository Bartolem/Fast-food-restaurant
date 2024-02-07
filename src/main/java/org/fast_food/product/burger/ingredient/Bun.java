package org.fast_food.product.burger.ingredient;

public enum Bun implements IngredientI {
    PRETZEL("Pretzel bun"),
    WHOLE_WHEAT("Whole Wheat Bun"),
    BRIOCHE("Brioche Bun"),
    SESAME("Sesame Seed Bun"),
    POTATO("Potato Bun"),
    WHOLE_GRAIN("Whole grain bun"),
    ;

    private final String name;

    private Bun(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
