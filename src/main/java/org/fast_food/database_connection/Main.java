package org.fast_food.database_connection;

import org.fast_food.customer.CustomerManagement;

public class Main {
    public static void main(String[] args) {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

//        System.out.println(customerDAO.get(UUID.fromString("5b34dae2-6b4c-4ca4-ae1b-39eb4c615083")));
//        Customer john = customerDAO.get(UUID.fromString("5b34dae2-6b4c-4ca4-ae1b-39eb4c615083"));
//        john.setName("John");
//        customerDAO.update(john);


        System.out.println(customerDAO.getAll());
        System.out.println(CustomerManagement.getCustomers());
    }
}
