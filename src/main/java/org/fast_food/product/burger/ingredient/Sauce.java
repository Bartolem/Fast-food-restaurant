package org.fast_food.product.burger.ingredient;

public enum Sauce implements IngredientI {
    MAYO("Mayonnaise"),
    CRANBERRY_SAUCE("Cranberry sauce"),
    BBQ_SAUCE("BBQ sauce"),
    TERIYAKI_SAUCE("Teriyaki sauce"),
    TZATZIKI("Tzatziki sauce"),
    PESTO("Pesto sauce"),
    TRUFFLE_OIL("Truffle oil"),
    RANCH_DRESSING("Ranch dressing"),
    BLUE_CHEESE_DRESSING("Blue cheese dressing"),
    BUFFALO_SAUCE("Buffalo sauce"),
    CHIPOTLE_MAYO("Chipotle mayonnaise"),
    REMOULADE("Remoulade sauce"),
    GHOST_PEPPER_SAUCE("Ghost pepper sauce"),
    HABANERO_SAUCE("Habanero sauce"),
    PEANUT_SAUCE("Peanut sauce"),
    THAI_CHILI_SAUCE("Thai chili sauce"),
    INFERNO_SAUCE("Inferno sauce"),
    SRIRACHA_SAUCE("Sriracha sauce"),
    MARINARA("Marinara sauce"),
    BLUEBERRY_BBQ("Blueberry BBQ sauce"),
    DILL("Dill sauce"),
    PEANUT_BUTTER("Creamy peanut butter"),
    HONEY("Honey"),
    TATAR("Tatar sauce");

    private final String name;

    Sauce(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
