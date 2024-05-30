package org.fast_food.bill_receipt;

import org.fast_food.customer.Customer;
import org.fast_food.order.Order;
import org.fast_food.product.Product;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

public class BillReceiptGenerator {
    private final Map<Product, Integer> products;
    private final Order order;
    private final Customer customer;

    public BillReceiptGenerator(Order order) {
        this.order = order;
        this.products = order.getContent();
        this.customer = order.getCustomer();
    }

    public String generateBillReceiptContent() {
        // Generate the bill receipt content as a string
        StringBuilder stringBuilder = new StringBuilder("%-35s\t%s\t%s\n".formatted("Product name", "Price", "Quantity"));
        int index = 1;
        for (Product product : products.keySet()) {
            stringBuilder.append("%d. %-35s\t%.2f\t%d\n".formatted(index, product.getName(), product.getPrice(), products.get(product)));
            index++;
        }

        if (customer == null) {
            stringBuilder.append("\nCustomer:\tGuest (no account)\n");
        } else {
            stringBuilder.append("\nCustomer:\t%s %s\n".formatted(customer.getFirstName(), customer.getLastName()));
        }

        stringBuilder.append("Order Id:\t%s\n".formatted(order.getId()));
        stringBuilder.append("Order date:\t%s\n".formatted(order.getDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))));
        stringBuilder.append("Total price:\t%s\n".formatted(order.getFormattedTotalPrice()));
        stringBuilder.append("Discount:\t%s\n".formatted(order.getFormattedDiscount()));
        stringBuilder.append("Total price after discount:\t%s\n".formatted(order.getFormattedTotalPriceAfterDiscount()));
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
