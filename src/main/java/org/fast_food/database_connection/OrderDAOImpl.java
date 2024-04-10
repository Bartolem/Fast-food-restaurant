package org.fast_food.database_connection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fast_food.customer.Customer;
import org.fast_food.customer.CustomerManagement;
import org.fast_food.order.Order;
import org.fast_food.order.OrderManagement;
import org.fast_food.order.OrderStatus;
import org.fast_food.product.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public Order get(UUID id) throws SQLException {
        Order order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("SELECT id, status, creation_date, total_price, customer_id, content, total_price_after_discount, discount FROM orders WHERE id = ?");
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                UUID orderId = (UUID) resultSet.getObject("id");
                OrderStatus status = (OrderStatus) resultSet.getObject("status");
                LocalDateTime creationDate = (LocalDateTime) resultSet.getObject("creation_date");
                BigDecimal totalPrice = resultSet.getBigDecimal("total_price");
                Customer customer = (Customer) resultSet.getObject("customer");

                Map<Product, Integer> content = (Map<Product, Integer>) resultSet.getBlob("content");
                BigDecimal totalPriceAfterDiscount = resultSet.getBigDecimal("total_price_after_discount");
                BigDecimal discount = resultSet.getBigDecimal("discount");

                order = new Order(orderId, status, creationDate, content, totalPrice, totalPriceAfterDiscount, discount, customer);
                OrderManagement.addOrder(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert resultSet != null;
            DatabaseConnector.closeResultSet(resultSet);
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }
        return order;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Order order) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Order order) throws SQLException {
        int result;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnector.connect();
            Customer customer = order.getCustomer();

            if (customer == null) {
                preparedStatement = connection.prepareStatement("INSERT INTO orders (status, creation_date, id, total_price, content, total_price_after_discount, discount) VALUES (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setBigDecimal(6, order.getTotalPriceAfterDiscount());
                preparedStatement.setBigDecimal(7, order.getDiscount());
            } else {
                preparedStatement = connection.prepareStatement("INSERT INTO orders (status, creation_date, id, total_price, customer_id, content, total_price_after_discount, discount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setObject(6, customer.getId());
                preparedStatement.setBigDecimal(7, order.getTotalPriceAfterDiscount());
                preparedStatement.setBigDecimal(8, order.getDiscount());
            }

            preparedStatement.setString(1, order.getStatus().toString());
            preparedStatement.setObject(2, order.getDate());
            preparedStatement.setObject(3, order.getId());
            preparedStatement.setBigDecimal(4, order.getTotalPrice());

            ObjectMapper objectMapper = new ObjectMapper();
            String jacksonData = objectMapper.writeValueAsString(order.getContent());

            preparedStatement.setString(5, jacksonData);




            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } finally {
            assert preparedStatement != null;
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return result;
    }

    @Override
    public int update(Order order) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Order order) throws SQLException {
        return 0;
    }
}
