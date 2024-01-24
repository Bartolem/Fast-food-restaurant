package org.fast_food.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer = new Customer("Michał", "mica3@gmial.com", "453 432 442");

    @Test
    void testGetIdNotNull() {
        assertNotNull(customer.getId());
    }

    @Test
    void testGetName() {
        assertEquals(customer.getName(), "Michał");
    }

    @Test
    void testSetName() {
        String newName = "Mariusz";
        customer.setName(newName);
        assertEquals(customer.getName(), newName);
    }

    @Test
    void testSetNameWithEmptyString() {
        customer.setName("");
        assertEquals(customer.getName(), "Michał");
    }

    @Test
    void testGetEmail() {
        assertEquals(customer.getEmail(), "mica3@gmial.com");
    }

    @Test
    void testSetEmail() {
        String newEmail = "micalo102@gmial.com";
        customer.setEmail(newEmail);
        assertEquals(customer.getEmail(), newEmail);
    }

    @Test
    void testSetEmailWithEmptyString() {
        customer.setEmail("");
        assertEquals(customer.getEmail(), "mica3@gmial.com");
    }

    @Test
    void testGetPhoneNumber() {
        assertEquals(customer.getPhoneNumber(), "453 432 442");
    }

    @Test
    void testSetPhoneNumber() {
        String newNumber = "533 762 902";
        customer.setPhoneNumber(newNumber);
        assertEquals(customer.getPhoneNumber(), newNumber);
    }

    @Test
    void testSetPhoneNumberWithEmptyString() {
        customer.setPhoneNumber("");
        assertEquals(customer.getPhoneNumber(), "453 432 442");
    }

    @Test
    void testGetPointsIsPositiveNumber() {
        assertEquals(customer.getPoints(), 0);
    }

    @Test
    void testGetCreationDate() {
        assertNotNull(customer.getCreationDate());
    }

    @Test
    void testAddPoints() {
        customer.addPoints(150);
        assertEquals(customer.getPoints(), 150);

        customer.addPoints(-10);
        assertEquals(customer.getPoints(), 150);
    }

    @Test
    void testRemovePointsIsPositiveNumber() {
        customer.removePoints(20);
        customer.removePoints(-30);
        assertEquals(customer.getPoints(), 0);

        customer.addPoints(50);
        customer.removePoints(20);
        assertEquals(customer.getPoints(), 30);
    }
}