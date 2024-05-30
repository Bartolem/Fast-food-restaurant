package org.fast_food.points_manager;

import org.fast_food.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.fast_food.points_manager.PointsManager.*;

class PointsManagerTest {
    Customer customer;
    BigDecimal orderPrice;

    @BeforeEach
    void initialize() {
        customer = new Customer("Leopold", "China", "chinal@gddf.com", "dada", "242424");
        orderPrice = new BigDecimal(100);
    }

    @Test
    void testAwardPointsToCustomer() {
        awardPointsToCustomer(customer, orderPrice);
        assertEquals(customer.getPoints(), orderPrice.intValue() * 10);
    }

    @Test
    void testCalculateDiscountPercent() {
        assertEquals(calculateDiscountPercent(calculateDiscount(customer, orderPrice), orderPrice), BigDecimal.ZERO);

        customer.setPoints(1000);
        assertEquals(calculateDiscountPercent(calculateDiscount(customer, orderPrice), orderPrice), BigDecimal.TEN);

        customer.setPoints(MAX_POINTS);
        assertEquals(calculateDiscountPercent(calculateDiscount(customer, orderPrice), orderPrice), BigDecimal.valueOf(60.0));
    }

    @Test
    void testCalculateDiscount() {
        assertEquals(calculateDiscount(customer, orderPrice), BigDecimal.ZERO);

        customer.setPoints(1000);
        assertEquals(calculateDiscount(customer, orderPrice), BigDecimal.TEN);

        customer.setPoints(MAX_POINTS);
        assertEquals(calculateDiscount(customer, orderPrice), BigDecimal.valueOf(60.0));
    }

    @Test
    void testCalculatePoints() {
        assertEquals(calculatePoints(orderPrice), orderPrice.intValue() * 10);

        orderPrice = BigDecimal.valueOf(600);
        assertEquals(calculatePoints(orderPrice), orderPrice.intValue() * 10);

        orderPrice = BigDecimal.valueOf(10_000);
        assertEquals(calculatePoints(orderPrice), MAX_POINTS);
    }

    @Test
    void testApplyDiscount() {
        assertEquals(applyDiscount(customer, orderPrice, calculateDiscount(customer, orderPrice)), BigDecimal.valueOf(100));

        customer.setPoints(1000);
        assertEquals(applyDiscount(customer, orderPrice, calculateDiscount(customer, orderPrice)), BigDecimal.valueOf(90));

        customer.setPoints(6000);
        assertEquals(applyDiscount(customer, orderPrice, calculateDiscount(customer, orderPrice)), BigDecimal.valueOf(40));

        customer.setPoints(MAX_POINTS);
        assertEquals(applyDiscount(customer, orderPrice, calculateDiscount(customer, orderPrice)), BigDecimal.valueOf(40.0));
    }
}