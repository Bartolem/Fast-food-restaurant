package org.fast_food.menu;

import org.fast_food.product.burger.ClassicBurger;

import java.util.List;

public class Menu {
    private static final List<ClassicBurger> CLASSIC_BURGER_LIST = List.of(ClassicBurger.values());

    public static List<ClassicBurger> getClassicBurgerList() {
        return CLASSIC_BURGER_LIST;
    }
}
