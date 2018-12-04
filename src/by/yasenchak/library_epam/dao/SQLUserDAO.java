package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.database.DataBaseConnection;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.RegistrationException;
import by.yasenchak.library_epam.exception.SignInException;

import java.sql.*;


public class SQLUserDAO implements UserDAO {
    private DataBaseConnection dbConn;

    public SQLUserDAO(){
        dbConn = new DataBaseConnection();
    }


    @Override
    public boolean signIn(String login, String password) throws SignInException{
        boolean auth = false;
        String SQLquery = "SELECT \"userName\", \"password\" FROM users WHERE \"userName\" ='" + login + "';" ;
        try(Connection conn = dbConn.getConnection(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(SQLquery)) {
            if(result.next()) {
                String userName = result.getString("userName");
                String passwordUser = result.getString("password");
                auth = password.equals(passwordUser);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new SignInException("Problem with authorization", e);
        }
        return auth;
    }

    @Override
    public void registration(User user) throws RegistrationException
    {
        String SQLquery = "INSERT INTO users(\"userName\", \"password\") VALUES('" + user.getName() + "', '" + user.getPassword() + "');";
        try(Connection conn = dbConn.getConnection(); Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQLquery);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RegistrationException("Problem with Registration", e);
        }
    }
}
