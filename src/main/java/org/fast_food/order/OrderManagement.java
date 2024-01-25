package org.fast_food.order;

import org.fast_food.product.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    private final static List<Order> orders = new ArrayList<>();

    public static List<Order> getOrders() {
        return orders;
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static void removeOrder(Order order) {
        orders.remove(order);
    }
    public static void processOrder(Order order) {
        order.process();
    }

    public static void completeOrder(Order order) {
        order.complete();
    }

    public static void cancelOrder(Order order) {
        order.cancel();
    }

}
