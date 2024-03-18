package org.fast_food.database_connection;

import org.fast_food.customer.Customer;
import org.fast_food.customer.CustomerManagement;

import java.sql.*;
import java.util.List;
import java.util.UUID;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Customer get(UUID id) {
        Customer customer = null;

        try {
            Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");
                UUID customerId = (UUID) resultSet.getObject("id");

                CustomerManagement.addCustomer(customerId, new Customer(customerId, name, email, phoneNumber, points, creationDate));
                customer = CustomerManagement.getCustomer(customerId);

                DatabaseConnector.closePreparedStatement(preparedStatement);
                DatabaseConnector.closeConnection(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        try {
            Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, email, phone_number, points, creation_date FROM customers");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");
                UUID customerId = (UUID) resultSet.getObject("id");

                Customer customer = new Customer(customerId, name, email, phoneNumber, points, creationDate);
                CustomerManagement.addCustomer(customerId, customer);

                DatabaseConnector.closePreparedStatement(preparedStatement);
                DatabaseConnector.closeConnection(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return CustomerManagement.getCustomers().stream().toList();
    }

    @Override
    public int save(Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Customer customer) {
        int result;

        try {
            Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (id, name, email, phone_number, points, creation_date) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setObject(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setInt(5, customer.getPoints());
            preparedStatement.setDate(6, customer.getCreationDate());

            CustomerManagement.addCustomer(customer.getId(), customer);

            result = preparedStatement.executeUpdate();

            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return result;
    }

    @Override
    public int update(Customer customer) {
        int result;

        try {
            Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET name = ?, email = ?, phone_number = ?, points = ?");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setInt(4, customer.getPoints());

            result = preparedStatement.executeUpdate();

            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public int delete(Customer customer) {
        int result;

        try {
            Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");
            preparedStatement.setObject(1, customer.getId());

            CustomerManagement.removeCustomer(customer.getId());

            result = preparedStatement.executeUpdate();

            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return result;
    }
}
