package by.yasenchak.library_epam.database;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
}
