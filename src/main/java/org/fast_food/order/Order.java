package org.fast_food.order;

import org.fast_food.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Order {
    public final int MAX_QUANTITY_OF_PRODUCT_SAME_TYPE = 10;
    private final String id;
    private OrderStatus status;
    private final LocalDateTime date;
    private final Map<Product, Integer> content;
    private BigDecimal totalPrice;
    private BigDecimal totalPriceAfterDiscount;
    private BigDecimal discount;

    public Order() {
        this.id = generateUniqueId();
        this.status = OrderStatus.NEW;
        this.date = LocalDateTime.now();
        this.content = new HashMap<>();
        this.totalPrice =  BigDecimal.ZERO;
        this.totalPriceAfterDiscount =  BigDecimal.ZERO;
        this.discount = BigDecimal.ZERO;
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
            clear();
        }
    }

    public void clear() {
        if (!content.isEmpty()) {
            content.clear();
            totalPrice =  BigDecimal.ZERO;
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Set<Product> getProducts() {
        return content.keySet();
    }

    public Map<Product, Integer> getContent() {
        return content;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount.setScale(2, RoundingMode.HALF_UP);
    }

    public void  setTotalPriceAfterDiscount(BigDecimal priceAfterDiscount) {
        this.totalPriceAfterDiscount = priceAfterDiscount;
    }

    public BigDecimal getDiscount() {
        return discount.setScale(2, RoundingMode.HALF_UP);
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getFormattedTotalPrice() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(getTotalPrice());
    }

    public String getFormattedTotalPriceAfterDiscount() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(getTotalPriceAfterDiscount());
    }

    public String getFormattedDiscount() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(getDiscount());
    }

    public void addProduct(Product product, int quantity) {
        if (content.containsKey(product)) {
            content.replace(product, content.get(product) + quantity);
        } else {
            content.putIfAbsent(product, quantity);
        }
        totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    public void removeProduct(Product product, int quantity) {
        if (content.get(product) - quantity > 0) {
            content.replace(product, content.get(product) - quantity);
        } else {
            content.remove(product);
        }

        if (totalPrice.compareTo(product.getPrice().multiply(BigDecimal.valueOf(quantity))) < 0) {
            totalPrice = BigDecimal.valueOf(0);
        } else {
            totalPrice = totalPrice.subtract(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        }
    }

    public int getNumberOfProducts() {
        int numberOfProducts = 0;
        for (Integer num : content.values()) {
            numberOfProducts += num;
        }
        return numberOfProducts;
    }

    private String generateUniqueId() {
        return String.valueOf(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "Id: %s\nStatus: %s\nDate: %s\nContent: %s\nTotal: %s".formatted(id, status, date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)), content, totalPrice);
    }
}
