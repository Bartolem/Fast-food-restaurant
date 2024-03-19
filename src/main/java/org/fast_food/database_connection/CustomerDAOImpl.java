package org.fast_food.database_connection;

import org.fast_food.customer.Customer;
import org.fast_food.customer.CustomerManagement;

import java.sql.*;
import java.util.List;
import java.util.UUID;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Customer get(UUID id) throws SQLException {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("SELECT id, first_name, last_name, email, phone_number, points, creation_date FROM customers WHERE id = ?");
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");
                UUID customerId = (UUID) resultSet.getObject("id");

                CustomerManagement.addCustomer(customerId, new Customer(customerId, firstName, lastName, email, phoneNumber, points, creationDate));
                customer = CustomerManagement.getCustomer(customerId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            DatabaseConnector.closeResultSet(resultSet);
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return customer;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("SELECT id, first_name, last_name, email, phone_number, points, creation_date FROM customers");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");
                UUID customerId = (UUID) resultSet.getObject("id");

                Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber, points, creationDate);
                CustomerManagement.addCustomer(customerId, customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            DatabaseConnector.closeResultSet(resultSet);
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return CustomerManagement.getCustomers().stream().toList();
    }

    @Override
    public int save(Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Customer customer) throws SQLException {
        int result;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO customers (id, first_name, last_name, email, phone_number, points, creation_date) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setObject(1, customer.getId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setInt(5, customer.getPoints());
            preparedStatement.setDate(6, customer.getCreationDate());

            CustomerManagement.addCustomer(customer.getId(), customer);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return result;
    }

    @Override
    public int update(Customer customer) throws SQLException {
        int result;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("UPDATE customers SET first_name = ?, last_name = ?, email = ?, phone_number = ?, points = ?");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setInt(4, customer.getPoints());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return result;
    }

    @Override
    public int delete(Customer customer) throws SQLException {
        int result;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");
            preparedStatement.setObject(1, customer.getId());

            CustomerManagement.removeCustomer(customer.getId());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return result;
    }
}
