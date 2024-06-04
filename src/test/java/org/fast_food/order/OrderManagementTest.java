package org.fast_food.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementTest {
    Order order = new Order(null);

    @Test
    void testGetOrders() {
        assertNotNull(OrderManagement.getOrders());
    }

    @Test
    void testAddOrder() {
        OrderManagement.addOrder(order);
        assertTrue(OrderManagement.getOrders().contains(order));
    }

    @Test
    void testRemoveOrder() {
        OrderManagement.removeOrder(order);
        assertFalse(OrderManagement.getOrders().contains(order));
    }

    @Test
    void testProcessOrder() {
        OrderManagement.processOrder(order);
        assertEquals(order.getStatus(), OrderStatus.PROCESSING);
    }

    @Test
    void testCompleteOrder() {
        OrderManagement.processOrder(order);
        OrderManagement.completeOrder(order);
        assertEquals(order.getStatus(), OrderStatus.COMPLETED);
    }

    @Test
    void testCancelOrder() {
        OrderManagement.cancelOrder(order);
        assertEquals(order.getStatus(), OrderStatus.CANCELED);
    }
}