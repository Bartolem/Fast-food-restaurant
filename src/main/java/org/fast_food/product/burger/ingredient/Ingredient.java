package org.fast_food.product.burger.ingredient;

public enum Ingredient implements IngredientI {
    BACON("Bacon"),
    LETTUCE("Lettuce"),
    TOMATO("Tomato"),
    ONION("Onion"),
    PICKLES("Pickles"),
    ONION_RINGS("Onion rings"),
    JALAPENOS("Jalapeños"),
    PINEAPPLE("Pineapple"),
    AVOCADO("Avocado"),
    SAUTEED_MUSHROOMS("Sauteed mushrooms"),
    GUACAMOLE("Guacamole"),
    ARUGULA("Arugula"),
    STEAK("Sliced steak"),
    GRILLED_PEPPERS("Grilled peppers"),
    CUCUMBER("Cucumber slices"),
    BANANA_PEPPERS("Banana peppers"),
    JALAPENO_POPPER_FILLING("Jalapeño popper filling"),
    CAJUN("Cajun spice blend"),
    FRIED_EGG("Fried Egg"),
    CARAMELIZED_ONIONS("Caramelized onions"),
    BLUEBERRY("Blueberry"),
    BANANA("Banana"),
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
