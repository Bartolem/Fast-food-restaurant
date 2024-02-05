package org.fast_food.order;

import org.fast_food.product.Product;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    public final int MAX_QUANTITY_OF_PRODUCT_SAME_TYPE = 10;
    private final String id;
    private OrderStatus status;
    private final LocalDateTime date;
    private final Map<Product, Integer> content;
    private double totalPrice;

    public Order() {
        this.id = generateUniqueId();
        this.status = OrderStatus.NEW;
        this.date = LocalDateTime.now();
        this.content = new HashMap<>();
        this.totalPrice = 0;
    }

    public String getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void process() {
        if (status == OrderStatus.NEW) {
            this.status = OrderStatus.PROCESSING;
        }
    }

    public void complete() {
        if (status == OrderStatus.PROCESSING) {
            this.status = OrderStatus.COMPLETED;
        }
    }

    public void cancel() {
        if (status != OrderStatus.COMPLETED) {
            this.status = OrderStatus.CANCELED;
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Set<Product> getContent() {
        return content.keySet();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product, int quantity) {
        if (content.containsKey(product)) {
            content.replace(product, content.get(product) + 1);
        } else {
            content.putIfAbsent(product, quantity);
        }
        totalPrice += product.getPrice() * quantity;
    }

    public void removeProduct(Product product, int quantity) {
        if (content.get(product) - quantity > 0) {
            content.replace(product, content.get(product) - quantity);
        } else {
            content.remove(product);
        }

        if (totalPrice < product.getPrice() * quantity) {
            totalPrice = 0.0;
        } else {
            totalPrice -= product.getPrice() * quantity;
        }
    }

    private String generateUniqueId() {
        return String.valueOf(UUID.randomUUID());
    }
}
