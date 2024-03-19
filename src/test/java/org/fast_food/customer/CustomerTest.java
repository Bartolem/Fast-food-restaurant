package org.fast_food.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer = new Customer("Michał", "Obraz", "mica3@gmial.com", "pas123", "453 432 442");

    @Test
    void testGetIdNotNull() {
        assertNotNull(customer.getId());
    }

    @Test
    void testGetFirstName() {
        assertEquals(customer.getFirstName(), "Michał");
    }

    @Test
    void testGetLastName() {
        assertEquals(customer.getLastName(), "Obraz");
    }

    @Test
    void testSetFirstName() {
        String newName = "Mariusz";
        customer.setFirstName(newName);
        assertEquals(customer.getFirstName(), newName);
    }

    @Test
    void testSetLastName() {
        String newName = "Godło";
        customer.setLastName(newName);
        assertEquals(customer.getLastName(), newName);
    }

    @Test
    void testSetFirstNameWithEmptyString() {
        customer.setFirstName("");
        assertEquals(customer.getFirstName(), "Michał");
    }

    @Test
    void testSetLastNameWithEmptyString() {
        customer.setLastName("");
        assertEquals(customer.getLastName(), "Michał");
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