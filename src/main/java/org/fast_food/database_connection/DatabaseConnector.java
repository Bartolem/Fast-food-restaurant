package org.fast_food.database_connection;

import java.sql.*;

public class DatabaseConnector {
    private static String URL = "jdbc:postgresql://localhost/fast-food-db";
    private static String USER = "postgres";
    private static String PASSWORD = "admin";

    public static Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection open successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
            System.out.println("Database connection close successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }
}
