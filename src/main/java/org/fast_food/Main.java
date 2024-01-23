package org.fast_food;

import org.fast_food.product.ClassicBurger;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Bartolos fastfood!");
        System.out.println(Arrays.toString(ClassicBurger.values()));
    }
}