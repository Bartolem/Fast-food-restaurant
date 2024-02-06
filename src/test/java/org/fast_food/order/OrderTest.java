package org.fast_food.order;

import org.fast_food.product.burger.ClassicBurger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order order = new Order();

    @Test
    void testGetIdNotNull() {
        assertNotNull(order.getId());
    }

    @Test
    void testGetStatusNEW() {
        assertEquals(order.getStatus(), OrderStatus.NEW);
    }

    @Test
    void testProcessOrder() {
        order.process();
        assertEquals(order.getStatus(), OrderStatus.PROCESSING);
    }

    @Test
    void testCompleteOrder() {
        order.process();
        order.complete();
        assertEquals(order.getStatus(), OrderStatus.COMPLETED);
    }

    @Test
    void testCancelOrder() {
        order.cancel();
        assertEquals(order.getStatus(), OrderStatus.CANCELED);
    }

    @Test
    void getDate() {
        assertNotNull(order.getDate());
    }

    @Test
    void testGetContentEmpty() {
        assertTrue(order.getContent().isEmpty());
    }

    @Test
    void addProduct() {
        order.addProduct(ClassicBurger.BACON_BURGER, 1);
        assertFalse(order.getContent().isEmpty());
        assertTrue(order.getContent().contains(ClassicBurger.BACON_BURGER));
    }

    @Test
    void removeProduct() {
        order.addProduct(ClassicBurger.BACON_BURGER, 1);
        assertFalse(order.getContent().isEmpty());
        assertTrue(order.getContent().contains(ClassicBurger.BACON_BURGER));

        order.removeProduct(ClassicBurger.BACON_BURGER, 1);
        assertTrue(order.getContent().isEmpty());
        assertFalse(order.getContent().contains(ClassicBurger.BACON_BURGER));
    }
}