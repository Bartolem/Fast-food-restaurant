package org.fast_food.order;

import org.fast_food.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    public final int MAX_QUANTITY_OF_PRODUCT_SAME_TYPE = 10;
    private final String id;
    private OrderStatus status;
    private final LocalDateTime date;
    private final List<Product> content;

    public Order() {
        this.id = generateUniqueId();
        this.status = OrderStatus.NEW;
        this.date = LocalDateTime.now();
        this.content = new ArrayList<>();
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

    public List<Product> getContent() {
        return content;
    }

    public void addProduct(Product product) {
        content.add(product);
    }

    public void removeProduct(Product product) {
        content.remove(product);
    }

    private String generateUniqueId() {
        return String.valueOf(UUID.randomUUID());
    }
}
