package org.fast_food.product.burger.ingredient;

public enum Ingredient implements IngredientI {
    BEEF_PATTY("Beef patty"),
    BACON("Bacon"),
    LETTUCE("Lettuce"),
    TOMATO("Tomato"),
    ONION("Onion"),
    PICKLES("Pickles"),
    VEGGIE_PATTY("Vegetarian patty"),
    CHICKEN("Grilled chicken breast"),
    TURKEY("Turkey patty"),
    ONION_RINGS("Onion rings"),
    JALAPENOS("Jalapeños"),
    PINEAPPLE("Pineapple"),
    AVOCADO("Avocado"),
    SAUTEED_MUSHROOMS("Sauteed mushrooms"),
    GUACAMOLE("Guacamole"),
    ARUGULA("Arugula"),
    STEAK("Sliced steak"),
    GRILLED_PEPPERS("Grilled peppers"),
    LAMB_PATTY("Lamb patty"),
    SHRIMP_PATTY("Shrimp patty"),
    CUCUMBER("Cucumber slices"),
    BANANA_PEPPERS("Banana peppers"),
    JALAPENO_POPPER_FILLING("Jalapeño popper filling"),
    CAJUN("Cajun spice blend")
    ;

    private final String name;

    private Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
