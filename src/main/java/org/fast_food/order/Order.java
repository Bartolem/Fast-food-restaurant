package org.fast_food.order;

import org.fast_food.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private OrderStatus status;
    private LocalDateTime date;
    private List<Product> content;

    public Order(String id, OrderStatus status) {
        this.id = id;
        this.status = status;
        this.date = LocalDateTime.now();
        this.content = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Product> getContent() {
        return content;
    }

    public void addProduct(Product product) {
        content.add(product);
    }

    public void removeProduct(Product product) {
        content.remove(product);
    }
}
