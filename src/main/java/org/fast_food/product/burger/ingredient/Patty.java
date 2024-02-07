package org.fast_food.product.burger.ingredient;

public enum Patty implements IngredientI {
    BEEF("Beef patty"),
    VEGGIE("Vegetarian patty"),
    CHICKEN("Grilled chicken breast"),
    TURKEY("Turkey patty"),
    LAMB("Lamb patty"),
    SHRIMP("Shrimp patty"),
    BLACK_BEAN("Black bean patty"),
    SPINACH_ARTICHOKE("Spinach and artichoke patty"),
    SWEAT_POTATO("Sweet potato and black bean patty"),
    SMOKED_SALMON("Smoked salmon patty"),
    ;

    private final String name;

    private Patty(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
