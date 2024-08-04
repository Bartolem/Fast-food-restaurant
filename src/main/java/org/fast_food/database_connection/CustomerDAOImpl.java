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
            preparedStatement = connection.prepareStatement("SELECT id, first_name, last_name, email, password, phone_number, points, creation_date FROM customers WHERE id = ?");
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                UUID customerId = (UUID) resultSet.getObject("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");

                CustomerManagement.addCustomer(customerId, new Customer(customerId, firstName, lastName, email, password, phoneNumber, points, creationDate));
                customer = CustomerManagement.getCustomer(customerId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert resultSet != null;
            DatabaseConnector.closeResultSet(resultSet);
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return customer;
    }

    @Override
    public Customer getCustomerByEmail(String email) throws SQLException {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("SELECT id, first_name, last_name, email, password, phone_number, points, creation_date FROM customers WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                UUID customerId = (UUID) resultSet.getObject("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String customerEmail = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");

                CustomerManagement.addCustomer(customerId, new Customer(customerId, firstName, lastName, customerEmail, password, phoneNumber, points, creationDate));
                customer = CustomerManagement.getCustomer(customerId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert resultSet != null;
            DatabaseConnector.closeResultSet(resultSet);
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return customer;
    }

    public Customer getCustomerByPhoneNumber(String phoneNumber) throws SQLException {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("SELECT id, first_name, last_name, email, password, phone_number, points, creation_date FROM customers WHERE phone_number = ?");
            preparedStatement.setString(1, phoneNumber);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                UUID customerId = (UUID) resultSet.getObject("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String customerEmail = resultSet.getString("email");
                String password = resultSet.getString("password");
                String customerPhoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");

                CustomerManagement.addCustomer(customerId, new Customer(customerId, firstName, lastName, customerEmail, password, customerPhoneNumber, points, creationDate));
                customer = CustomerManagement.getCustomer(customerId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert resultSet != null;
            DatabaseConnector.closeResultSet(resultSet);
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return customer;
    }

    @Override
    public String getCustomerPassword(Customer customer) throws SQLException {
        String password = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("SELECT password FROM customers WHERE id = ?");
            preparedStatement.setObject(1, customer.getId());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert resultSet != null;
            DatabaseConnector.closeResultSet(resultSet);
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return password;
    }


    @Override
    public List<Customer> getAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.connect();
            preparedStatement = connection.prepareStatement("SELECT id, first_name, last_name, email, password, phone_number, points, creation_date FROM customers");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UUID customerId = (UUID) resultSet.getObject("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_number");
                int points = resultSet.getInt("points");
                Date creationDate = resultSet.getDate("creation_date");

                Customer customer = new Customer(customerId, firstName, lastName, email, password, phoneNumber, points, creationDate);
                CustomerManagement.addCustomer(customerId, customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert resultSet != null;
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
            preparedStatement = connection.prepareStatement("INSERT INTO customers (id, first_name, last_name, email, password, phone_number, points, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setObject(1, customer.getId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPassword());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setInt(7, customer.getPoints());
            preparedStatement.setDate(8, customer.getCreationDate());

            CustomerManagement.addCustomer(customer.getId(), customer);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert preparedStatement != null;
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
            preparedStatement = connection.prepareStatement("UPDATE customers SET first_name = ?, last_name = ?, email = ?, password = ?, phone_number = ?, points = ? WHERE id = ?");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setInt(6, customer.getPoints());
            preparedStatement.setObject(7, customer.getId());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            assert preparedStatement != null;
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
            assert preparedStatement != null;
            DatabaseConnector.closePreparedStatement(preparedStatement);
            DatabaseConnector.closeConnection(connection);
        }

        return result;
    }
}
