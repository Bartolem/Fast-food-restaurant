package org.fast_food.menu;

import java.util.Comparator;

public class NaturalOrderComparator implements Comparator<String> {
    // Comparator used for sorting file names including numerical values
    public int compare(String o1, String o2) {
        String[] parts1 = o1.split("_");
        String[] parts2 = o2.split("_");

        // Assuming the numerical part is always at the end
        String numericPart1 = parts1[parts1.length - 1].replaceAll("\\D", "");
        String numericPart2 = parts2[parts2.length - 1].replaceAll("\\D", "");

        return Integer.compare(Integer.parseInt(numericPart1), Integer.parseInt(numericPart2));
    }
}
