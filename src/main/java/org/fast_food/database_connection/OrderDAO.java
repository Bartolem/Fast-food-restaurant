package org.fast_food.database_connection;

import org.fast_food.order.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface OrderDAO extends DAO<Order> {
    List<Order> getAll(UUID customerID) throws SQLException;
}
