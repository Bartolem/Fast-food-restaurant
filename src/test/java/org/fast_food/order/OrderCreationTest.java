package org.fast_food.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderCreationTest {

    @Test
    void testCreateOrder() {
        Order order = OrderCreation.createOrder();
        assertNotNull(order);
    }
}