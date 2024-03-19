package org.fast_food.database_connection;

import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

        System.out.println(customerDAO.get(UUID.fromString("d1446045-95c1-40f7-af5c-a688882298c3")));
        System.out.println(customerDAO.getAll());
    }
}
