package by.yasenchak.library_epam.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection  {

    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String PASSWORD = "postgres";
        String URL = "jdbc:postgresql://localhost:5432/epamlibrary";
        String USER = "postgres";
        String DB_DRIVER = "org.postgresql.Driver";
        Class.forName(DB_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

}
