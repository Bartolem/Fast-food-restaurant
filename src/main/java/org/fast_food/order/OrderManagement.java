package org.fast_food.order;

public class OrderManagement {
    private final Order order;

    public OrderManagement(Order order) {
        this.order = order;
    }

    public void processOrder() {
        order.process();
    }

    public void completeOrder() {
        order.complete();
    }

    public void cancelOrder() {
        order.cancel();
    }

}
