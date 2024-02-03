package org.fast_food.customer;

public class CustomerCreation {
    public static Customer createCustomerAccount(String name, String email, String phoneNumber) {
        Customer customer = new Customer(name, email, phoneNumber);
        CustomerManagement.addCustomer(customer.getId(), customer);
        return customer;
    }
}