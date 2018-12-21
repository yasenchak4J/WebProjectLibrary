package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.RegistrationException;
import by.yasenchak.library_epam.exception.dao_exception.SignInException;

import java.sql.*;


public class SQLUserDAO implements UserDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SIGN_IN = "SELECT \"userName\", \"password\", \"role\" FROM users WHERE \"userName\" = ? ;";
    private static final String REGISTRATION = "INSERT INTO users(\"userName\", \"password\", \"role\") VALUES(? , ?, ?);";
    private static final String SEARCH_USER_BY_LOGIN = "SELECT \"userName\" FROM users WHERE \"userName\" = ? ;";

    public SQLUserDAO(){

    }


    @Override
    public User signIn(String login) throws SignInException{
        String passwordUser = "", userName = "";
        int role = 0;
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(SIGN_IN)) {

            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                userName = result.getString("userName");
                passwordUser = result.getString("password");
                role = result.getInt("role");
            }
            return new User(userName, passwordUser, role);
        } catch (SQLException e) {
            throw new SignInException("Problem with authorization", e);
        } catch (ConnectionPoolException e) {
            throw new SignInException("Problems with connection pool", e);
        }
    }

    @Override
    public void registration(User user) throws RegistrationException
    {
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(REGISTRATION)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RegistrationException("Problem with Registration", e);
        } catch (ConnectionPoolException e) {
            throw new RegistrationException("Problems with connection pool", e);
        }
    }

    @Override
    public boolean userExist(User user) throws RegistrationException {
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(SEARCH_USER_BY_LOGIN)){

            boolean userNotExist;
            statement.setString(1, user.getName());
            ResultSet result = statement.executeQuery();
            userNotExist = !result.next();
            return userNotExist;
        } catch (SQLException e) {
            throw new RegistrationException("Problem with FindUser", e);
        } catch (ConnectionPoolException e) {
            throw new RegistrationException("Problems with connection pool", e);
        }
    }
}
