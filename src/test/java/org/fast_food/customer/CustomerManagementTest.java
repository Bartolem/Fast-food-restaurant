package org.fast_food.customer;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagementTest {
    Customer customer = new Customer("Michał", "Obraz", "mica3@gmial.com", "pas123", "453 432 442");

    @Test
    void testGetCustomersNotNull() {
        assertNotNull(CustomerManagement.getCustomers());
    }

    @Test
    void testGetCustomer() {
        CustomerManagement.addCustomer(customer.getId(), customer);
        assertTrue(CustomerManagement.getCustomers().contains(customer));
        assertEquals(CustomerManagement.getCustomer(customer.getId()), customer);
    }

    @Test
    void testAddCustomer() {
        CustomerManagement.addCustomer(customer.getId(), customer);
        assertNotNull(CustomerManagement.getCustomer(customer.getId()));
        assertTrue(CustomerManagement.getCustomers().contains(customer));
        assertEquals(CustomerManagement.getCustomer(customer.getId()), customer);
    }

    @Test
    void testRemoveCustomer() {
        CustomerManagement.removeCustomer(customer.getId());
        assertNull(CustomerManagement.getCustomer(customer.getId()));
        assertFalse(CustomerManagement.getCustomers().contains(customer.getId()));
        assertFalse(CustomerManagement.getCustomers().contains(customer));
    }
}