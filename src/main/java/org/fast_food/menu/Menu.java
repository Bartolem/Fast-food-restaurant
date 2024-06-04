package org.fast_food.menu;

import org.fast_food.product.*;
import org.fast_food.product.burger.ClassicBurger;
import org.fast_food.product.burger.GourmetBurger;
import org.fast_food.product.burger.SpicyBurger;
import org.fast_food.product.burger.UniqueFlavorBurger;
import org.fast_food.user_interface.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.List;

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

    private static Map<String, ImageIcon> loadImages(String[] imageNames, String path) {
        Map<String, ImageIcon> imageIconMap = new HashMap<>();
        ClassLoader classLoader = Menu.class.getClassLoader();

        Arrays.stream(imageNames).forEach(
                name -> {
                    try {
                        // Load the image using the class loader
                        String pathName = path + name;
                        URL imgURL = classLoader.getResource(pathName);
                        if (imgURL != null) {
                            ImageIcon icon = new ImageIcon(imgURL);
                            imageIconMap.put(pathName, icon);
                        } else {
                            System.err.println("Couldn't find file: " + pathName);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
        );
        return imageIconMap;
    }

    public static Map<String, ImageIcon> getClassicBurgerImages() {
        String path = "images/burgers/classic/";
        String[] imageNames = {
                "classic_1.png", "classic_2.png", "classic_3.png", "classic_4.png",
                "classic_5.png", "classic_6.png", "classic_7.png", "classic_8.png",
                "classic_9.png", "classic_10.png", "classic_11.png", "classic_12.png",
                "classic_13.png", "classic_14.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getGourmetBurgerImages() {
        String path = "images/burgers/gourmet/";
        String[] imageNames = {
                "gourmet_1.png", "gourmet_2.png", "gourmet_3.png", "gourmet_4.png",
                "gourmet_5.png", "gourmet_6.png", "gourmet_7.png", "gourmet_8.png",
                "gourmet_9.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getSpicyBurgerImages() {
        String path = "images/burgers/spicy/";
        String[] imageNames = {
                "spicy_1.png", "spicy_2.png", "spicy_3.png", "spicy_4.png",
                "spicy_5.png", "spicy_6.png", "spicy_7.png", "spicy_8.png",
                "spicy_9.png", "spicy_10.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getUniqueFlavorBurgerImages() {
        String path = "images/burgers/unique/";
        String[] imageNames = {
                "unique_1.png", "unique_2.png", "unique_3.png", "unique_4.png",
                "unique_5.png", "unique_6.png", "unique_7.png", "unique_8.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getFrenchFriesImages() {
        String path = "images/fries/";
        String[] imageNames = {
                "fries_1.png", "fries_2.png", "fries_3.png", "fries_4.png",
                "fries_5.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getColdDrinksImages() {
        String path = "images/drinks/cold_drinks/";
        String[] imageNames = {
                "cold_1.png", "cold_2.png", "cold_3.png", "cold_4.png",
                "cold_5.png", "cold_6.png", "cold_7.png", "cold_8.png",
                "cold_9.png", "cold_10.png", "cold_11.png", "cold_12.png",
                "cold_13.png", "cold_14.png", "cold_15.png", "cold_16.png",
                "cold_17.png", "cold_18.png", "cold_19.png", "cold_20.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getHotDrinksImages() {
        String path = "images/drinks/hot_drinks/";
        String[] imageNames = {
                "hot_1.png", "hot_2.png", "hot_3.png", "hot_4.png",
                "hot_5.png", "hot_6.png", "hot_7.png", "hot_8.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getComboMealsImages() {
        String path = "images/combo/";
        String[] imageNames = {
                "combo_1.png", "combo_2.png", "combo_3.png", "combo_4.png",
                "combo_5.png", "combo_6.png", "combo_7.png", "combo_8.png",
                "combo_9.png", "combo_10.png", "combo_11.png", "combo_12.png",
                "combo_13.png", "combo_14.png", "combo_15.png", "combo_16.png",
                "combo_17.png", "combo_18.png", "combo_19.png", "combo_20.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getSideDishesImages() {
        String path = "images/side/";
        String[] imageNames = {
                "side_1.png", "side_2.png", "side_3.png", "side_4.png"
        };

        return loadImages(imageNames, path);
    }

    public static Map<String, ImageIcon> getDessertsImages() {
        String path = "images/desserts/";
        String[] imageNames = {
                "dessert_1.png", "dessert_2.png", "dessert_3.png", "dessert_4.png",
                "dessert_5.png", "dessert_6.png", "dessert_7.png", "dessert_8.png",
                "dessert_9.png", "dessert_10.png", "dessert_11.png", "dessert_12.png"
        };

        return loadImages(imageNames, path);
    }
}
