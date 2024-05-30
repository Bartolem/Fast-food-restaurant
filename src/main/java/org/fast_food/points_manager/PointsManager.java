package org.fast_food.points_manager;

import org.fast_food.customer.Customer;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PointsManager {
    protected static final int MAX_POINTS = 100_000;
    protected static final int MAX_DISCOUNT_PERCENT = 60;

    public static void awardPointsToCustomer(Customer customer, BigDecimal orderPrice) {
        int points = calculatePoints(orderPrice);

        if (customer.getPoints() + points <= MAX_POINTS) {
            customer.addPoints(points);
        } else {
            customer.setPoints(MAX_POINTS);
            JOptionPane.showMessageDialog(null, "You have reached the maximum amount of points!", "Reached points limit", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static BigDecimal calculateDiscountPercent(BigDecimal discount, BigDecimal orderPrice) {
        return discount.multiply(BigDecimal.valueOf(100)).divide(orderPrice, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal calculateDiscount(Customer customer, BigDecimal orderPrice) {
        BigDecimal discount = BigDecimal.valueOf(customer.getPoints() / 100);
        BigDecimal discount_percent = calculateDiscountPercent(discount, orderPrice);

        if (discount_percent.compareTo(BigDecimal.valueOf(MAX_DISCOUNT_PERCENT)) <= 0) {
            return discount;
        } else {
            return orderPrice.multiply(BigDecimal.valueOf(MAX_DISCOUNT_PERCENT / 100.0));
        }
    }

    public static int calculatePoints(BigDecimal orderPrice) {
        return 10 * orderPrice.intValue();
    }

    public static BigDecimal applyDiscount(Customer customer, BigDecimal orderPrice, BigDecimal discount) {
        customer.setPoints(customer.getPoints() - calculateDiscount(customer, orderPrice).intValue() * 100);
        return orderPrice.subtract(discount);
    }
}
