package org.fast_food.product.burger.ingredient;

public enum Cheese implements IngredientI {
    CHEESE("Cheese"),
    BLUE_CHEESE("Blue cheese"),
    SWISS_CHEESE("Swiss cheese"),
    MOZZARELLA("Mozzarella cheese"),
    PROVOLONE_CHEESE("Provolone cheese"),
    FETA_CHEESE("Feta cheese"),
    PEPPER_JACK_CHEESE("Pepper jack cheese"),
    CREAM_CHEESE("Cream cheese"),
    GHOST_PAPER_CHEESE("Ghost pepper cheese");

    private final String name;

    Cheese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
