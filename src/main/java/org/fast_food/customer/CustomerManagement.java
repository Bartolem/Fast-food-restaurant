package org.fast_food.customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomerManagement {
    private static final Map<UUID, Customer> customers = new HashMap<>();

    public static Collection<Customer> getCustomers() {
        return customers.values();
    }

    public static Customer getCustomer(UUID id) {
        return customers.get(id);
    }

    public static void addCustomer(UUID id, Customer customer) {
        customers.putIfAbsent(id, customer);
    }

    public static void removeCustomer(UUID id) {
        customers.remove(id);
    }
}
