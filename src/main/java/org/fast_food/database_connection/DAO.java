package org.fast_food.database_connection;

import java.util.List;
import java.sql.SQLException;
import java.util.UUID;

public interface DAO<T> {
    T get(UUID id) throws SQLException;

    List<T> getAll() throws SQLException;

    int save(T t) throws SQLException;

    int insert(T t) throws SQLException;

    int update(T t) throws SQLException;

    int delete(T t) throws SQLException;
}
