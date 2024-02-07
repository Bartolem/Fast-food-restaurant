package org.fast_food.menu;

import org.fast_food.product.FrenchFries;
import org.fast_food.product.Product;
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

    public static List<File> getClassicBurgerImages() {
        File[] images = new File("src/main/resources/images/classic").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getGourmetBurgerImages() {
        File[] images = new File("src/main/resources/images/gourmet").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getSpicyBurgerImages() {
        File[] images = new File("src/main/resources/images/spicy").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getUniqueFlavorBurgerImages() {
        File[] images = new File("src/main/resources/images/unique").listFiles();
        Arrays.sort(Objects.requireNonNull(images), new NaturalOrderComparator());
        return List.of(images);
    }

    public static List<File> getFrenchFriesImages() {
        File[] images = new File("src/main/resources/images/fries").listFiles();
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
