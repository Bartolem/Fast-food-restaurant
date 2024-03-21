package org.fast_food.database_connection;

import org.fast_food.customer.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends DAO<Customer> {
    Customer getCustomerByEmail(String email) throws SQLException;

    String getCustomerPassword(Customer customer) throws SQLException;
}
