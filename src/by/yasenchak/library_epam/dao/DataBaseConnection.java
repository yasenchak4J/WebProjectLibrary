package by.yasenchak.library_epam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection  {

    private final String URL = "jdbc:postgresql://localhost:5432/libraryepam";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(URL, user, password);
        return connection;
    }

}
