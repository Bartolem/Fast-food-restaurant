package org.fast_food.points_manager;

import org.fast_food.customer.Customer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PointsManager {
    private static final int MAX_POINTS = 10_000;
    private static final int MAX_DISCOUNT_PERCENT = 60;

    public static void awardPointsToCustomer(Customer customer, BigDecimal orderPrice) {
        int points = calculatePoints(orderPrice);

        if (customer.getPoints() + points <= MAX_POINTS) {
            customer.addPoints(points);
        }
    }

    public static BigDecimal applyDiscount(Customer customer, BigDecimal orderPrice) {
        BigDecimal discount = calculateDiscount(customer);
        BigDecimal discount_percent = discount.multiply(BigDecimal.valueOf(100)).divide(orderPrice, RoundingMode.HALF_EVEN);

        if (discount_percent.compareTo(BigDecimal.valueOf(MAX_DISCOUNT_PERCENT)) <= 0) {
            customer.setPoints(customer.getPoints() - calculatePoints(orderPrice));
        } else {
            discount = orderPrice.multiply(BigDecimal.valueOf(MAX_DISCOUNT_PERCENT / 100.0));
            customer.setPoints(customer.getPoints() - calculatePoints(discount.multiply(BigDecimal.valueOf(10))));
        }
        return orderPrice.subtract(discount);
    }

    public static int calculatePoints(BigDecimal orderPrice) {
        return 10 * orderPrice.intValue();
    }

    public static BigDecimal calculateDiscount(Customer customer) {
        return BigDecimal.valueOf(customer.getPoints() / 100);
    }

    public static void main(String[] args) {
        Customer customer = new Customer("Leopold", "China", "chinal@gddf.com", "dada".toCharArray(), "242424");
        BigDecimal orderPrice = BigDecimal.valueOf(30);

//        awardPointsToCustomer(customer, orderPrice);
        BigDecimal totalCost = new BigDecimal(0);
        customer.setPoints(MAX_POINTS);
        System.out.println("Customer points: " + customer.getPoints());

        totalCost = applyDiscount(customer, orderPrice);
        System.out.println("Customer points: " + customer.getPoints());
        System.out.printf("total: %s$", totalCost);
    }
}
