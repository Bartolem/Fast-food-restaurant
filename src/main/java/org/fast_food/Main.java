package org.fast_food;

import org.fast_food.database_connection.OrderDAOImpl;
import org.fast_food.user_interface.UserInterface;
import java.awt.*;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Run this program on the Event Dispatch Thread (EDT)
        EventQueue.invokeLater(UserInterface::new);
    }
}