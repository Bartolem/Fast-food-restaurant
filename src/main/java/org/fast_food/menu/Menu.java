package org.fast_food.menu;

import org.fast_food.product.Product;
import org.fast_food.product.burger.ClassicBurger;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Menu {
    private static final List<Product> CLASSIC_BURGER_LIST = List.of(ClassicBurger.values());

    public static List<Product> getClassicBurgerList() {
        return CLASSIC_BURGER_LIST;
    }

    public  static  List<File> getClassicBurgerImages() {
        File[] images = new File("src/main/resources/images/classic").listFiles();
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
