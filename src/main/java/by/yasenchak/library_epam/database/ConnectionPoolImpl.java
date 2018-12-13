package by.yasenchak.library_epam.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionPoolImpl implements ConnectionPool {
    private static ConnectionPoolImpl instance = null;

    private ConnectionPoolImpl(){

    }

    public static ConnectionPoolImpl getInstance(){
        if (instance==null)
            instance = new ConnectionPoolImpl();
        return instance;
    }

    @Override
    public Connection getConnection() {
        Context ctx;
        Connection c = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/library");
            c = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
