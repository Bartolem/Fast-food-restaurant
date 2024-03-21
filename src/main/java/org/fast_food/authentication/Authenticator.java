package org.fast_food.authentication;

import org.fast_food.customer.Customer;
import org.fast_food.database_connection.CustomerDAOImpl;

import java.sql.SQLException;
import java.util.Arrays;

public class Authenticator {
    private static final CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    public static Customer login(String email, char[] password) throws SQLException {
        Customer customer = verifyEmail(email);

        if (customer != null) {
            String hashedPassword = customerDAO.getCustomerPassword(customer);
            if (PasswordHashingUtil.verifyPassword(new String(password), hashedPassword)) {
                return customer;
            }
        }

        return null;
    }

    private static Customer verifyEmail(String email) throws SQLException {
        return customerDAO.getCustomerByEmail(email);
    }
}
