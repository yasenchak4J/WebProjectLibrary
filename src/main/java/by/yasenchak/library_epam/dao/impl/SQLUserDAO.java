package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.UserDAOException;

import java.sql.*;


public class SQLUserDAO implements UserDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SIGN_IN = "SELECT \"userName\", \"password\", \"role\", \"idUsers\" FROM users WHERE \"userName\" = ? ;";
    private static final String REGISTRATION = "INSERT INTO users(\"userName\", \"password\", \"role\") VALUES(? , ?, ?);";
    private static final String SEARCH_USER_BY_LOGIN = "SELECT \"userName\" FROM users WHERE \"userName\" = ? ;";

    public SQLUserDAO(){

    }


    @Override
    public User signIn(String login) throws UserDAOException {
        String passwordUser = "", userName = "";
        int role = 0, userId = -1;
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(SIGN_IN)) {

            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                userName = result.getString("userName");
                passwordUser = result.getString("password");
                role = result.getInt("role");
                userId = result.getInt("idUsers");
            }
            return new User(userName, passwordUser, role, userId);
        } catch (SQLException e) {
            throw new UserDAOException("Problem with authorization", e);
        } catch (ConnectionPoolException e) {
            throw new UserDAOException("Problems with connection pool", e);
        }
    }

    @Override
    public void registration(User user) throws UserDAOException
    {
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(REGISTRATION)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UserDAOException("Problem with Registration", e);
        } catch (ConnectionPoolException e) {
            throw new UserDAOException("Problems with connection pool", e);
        }
    }

    @Override
    public boolean userExist(User user) throws UserDAOException {
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(SEARCH_USER_BY_LOGIN)){

            boolean userNotExist;
            statement.setString(1, user.getName());
            ResultSet result = statement.executeQuery();
            userNotExist = !result.next();
            return userNotExist;
        } catch (SQLException e) {
            throw new UserDAOException("Problem with FindUser", e);
        } catch (ConnectionPoolException e) {
            throw new UserDAOException("Problems with connection pool", e);
        }
    }
}
