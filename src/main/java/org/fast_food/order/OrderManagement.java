package org.fast_food.order;

public class OrderManagement {
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
