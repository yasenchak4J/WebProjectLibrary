package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.database.ConnectionPoolImpl;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.RegistrationException;
import by.yasenchak.library_epam.exception.dao_exception.SignInException;

import java.sql.*;


public class SQLUserDAO implements UserDAO {

    public SQLUserDAO(){

    }


    @Override
    public User signIn(String login, String password) throws SignInException{
        String passwordUser = "", userName = "";
        User user = null;
        int role = 0;
        String SQLquery = "SELECT \"userName\", \"password\", \"role\" FROM users WHERE \"userName\" ='" + login + "';" ;
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(SQLquery)) {
            if(result.next()) {
                userName = result.getString("userName");
                passwordUser = result.getString("password");
                role = result.getInt("role");
            }
            if(password.equals(passwordUser)){
                user = new User(userName, passwordUser, role);
            }
        } catch (SQLException e) {
            throw new SignInException("Problem with authorization", e);
        }
        return user;
    }

    @Override
    public void registration(User user) throws RegistrationException
    {
        String SQLquery = "INSERT INTO users(\"userName\", \"password\", \"role\") VALUES('" + user.getName() + "', '" + user.getPassword() + "','" + user.getRole() + "');";
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQLquery);
        } catch (SQLException e) {
            throw new RegistrationException("Problem with Registration", e);
        }
    }
}
