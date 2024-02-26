package org.fast_food.bill_receipt;

import org.fast_food.order.Order;
import org.fast_food.product.Product;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

public class BillReceiptGenerator {
    private final Map<Product, Integer> products;
    private final Order order;
    public BillReceiptGenerator(Order order) {
        this.order = order;
        this.products = order.getContent();
    }

    public String generateBillReceiptContent() {
        // Generate the bill receipt content as a string
        StringBuilder stringBuilder = new StringBuilder("%-35s\t%s\t%s\n".formatted("Product name", "Price", "Quantity"));
        int index = 1;
        for (Product product : products.keySet()) {
            stringBuilder.append("%d. %-35s\t%.2f\t%d\n".formatted(index, product.getName(), product.getPrice(), products.get(product)));
            index++;
        }
        stringBuilder.append("\nOrder date: %s\n".formatted(order.getDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))));
        stringBuilder.append("Discount: 0\n"); // TODO change 0 to actual discount value
        stringBuilder.append("Total price: %s".formatted(order.getTotalPrice()));
        return stringBuilder.toString();
    }

    public String generateBillReceiptComaSeparatedContent() {
        StringBuilder stringBuilder = new StringBuilder("Product name,Price,Quantity\n");
        for (Product product : products.keySet()) {
            stringBuilder.append("%s,%s,%d\n".formatted(product.getName(), product.getPrice(), products.get(product)));
        }
        return stringBuilder.toString();
    }
}
