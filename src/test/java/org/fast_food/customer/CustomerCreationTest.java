package org.fast_food.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerCreationTest {

    @Test
    void testCreateCustomerAccount() {
        Customer customer = CustomerCreation.createCustomerAccount("Paulina", "paola5@gmial.com", "345 511 942");
        assertTrue(CustomerManagement.getCustomers().containsKey(customer.getId()));
        assertTrue(CustomerManagement.getCustomers().containsValue(customer));
        assertEquals(CustomerManagement.getCustomer(customer.getId()), customer);
    }
}