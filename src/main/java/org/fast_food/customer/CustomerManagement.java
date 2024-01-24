package org.fast_food.customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerManagement {
    private static final Map<String, Customer> customers = new HashMap<>();

    public static Map<String, Customer> getCustomers() {
        return customers;
    }

    public static Customer getCustomer(String id) {
        return customers.get(id);
    }

    public static void addCustomer(String id, Customer customer) {
        customers.putIfAbsent(id, customer);
    }

    public static void removeCustomer(String id) {
        customers.remove(id);
    }
}
