package org.fast_food.menu;

import org.fast_food.product.*;
import org.fast_food.product.burger.ClassicBurger;
import org.fast_food.product.burger.GourmetBurger;
import org.fast_food.product.burger.SpicyBurger;
import org.fast_food.product.burger.UniqueFlavorBurger;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Menu {
    private static final List<Product> CLASSIC_BURGER_LIST = List.of(ClassicBurger.values());
    private static final List<Product> GOURMET_BURGER_LIST = List.of(GourmetBurger.values());
    private static final List<Product> SPICY_BURGER_LIST = List.of(SpicyBurger.values());
    private static final List<Product> UNIQUE_FLAVOR_BURGER_LIST = List.of(UniqueFlavorBurger.values());
    private static final List<Product> FRENCH_FRIES_LIST = List.of(FrenchFries.values());
    private static final List<Product> COLD_DRINK_LIST = List.of(ColdDrink.values());
    private static final List<Product> HOT_DRINK_LIST = List.of(HotDrink.values());
    private static final List<Product> COMBO_MEALS_LIST = List.of(ComboMeal.values());
    private static final List<Product> SIDE_DISH_LIST = List.of(Side.values());
    private static final List<Product> DESSERT_LIST = List.of(Dessert.values());

    public static List<Product> getClassicBurgerList() {
        return CLASSIC_BURGER_LIST;
    }

    public static List<Product> getGourmetBurgerList() {
        return GOURMET_BURGER_LIST;
    }

    public static List<Product> getSpicyBurgerList() {
        return SPICY_BURGER_LIST;
    }

    public static List<Product> getUniqueFlavorBurgerList() {
        return UNIQUE_FLAVOR_BURGER_LIST;
    }

    public static List<Product> getFrenchFriesList() {
        return FRENCH_FRIES_LIST;
    }

    public static List<Product> getColdDrinkList() {
        return COLD_DRINK_LIST;
    }

    public static List<Product> getHotDrinkList() {
        return HOT_DRINK_LIST;
    }

    public static List<Product> getComboMealsList() {
        return COMBO_MEALS_LIST;
    }

    public static List<Product> getSideDishList() {
        return SIDE_DISH_LIST;
    }

    public static List<Product> getDessertList() {
        return DESSERT_LIST;
    }

    public static List<File> getClassicBurgerImages() {
        File[] images = new File("src/main/resources/images/burgers/classic").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getGourmetBurgerImages() {
        File[] images = new File("src/main/resources/images/burgers/gourmet").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getSpicyBurgerImages() {
        File[] images = new File("src/main/resources/images/burgers/spicy").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getUniqueFlavorBurgerImages() {
        File[] images = new File("src/main/resources/images/burgers/unique").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getFrenchFriesImages() {
        File[] images = new File("src/main/resources/images/fries").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getColdDrinksImages() {
        File[] images = new File("src/main/resources/images/drinks/cold_drinks").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getHotDrinksImages() {
        File[] images = new File("src/main/resources/images/drinks/hot_drinks").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getComboMealsImages() {
        File[] images = new File("src/main/resources/images/combo").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getSideDishesImages() {
        File[] images = new File("src/main/resources/images/side").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getDessertsImages() {
        File[] images = new File("src/main/resources/images/desserts").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    // Comparator used for sorting file names including numerical values
    static class NaturalOrderComparator implements Comparator<File> {
        public int compare(File o1, File o2) {
            String[] parts1 = o1.getName().split("_");
            String[] parts2 = o2.getName().split("_");

            // Assuming the numerical part is always at the end
            String numericPart1 = parts1[parts1.length - 1].replaceAll("\\D", "");
            String numericPart2 = parts2[parts2.length - 1].replaceAll("\\D", "");

            return Integer.compare(Integer.parseInt(numericPart1), Integer.parseInt(numericPart2));
        }
    }
}
