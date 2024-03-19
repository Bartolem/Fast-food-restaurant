package org.fast_food.customer;

public class CustomerCreation {
    public static Customer createCustomerAccount(String firstName, String lastName, String email, String phoneNumber) {
        Customer customer = new Customer(firstName, lastName, email, phoneNumber);
        CustomerManagement.addCustomer(customer.getId(), customer);
        return customer;
    }
}
