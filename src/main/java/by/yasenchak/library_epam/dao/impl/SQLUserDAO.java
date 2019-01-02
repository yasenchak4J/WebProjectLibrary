package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.UserDAOException;
import by.yasenchak.library_epam.utils.DataBaseField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLUserDAO implements UserDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SIGN_IN = "SELECT * FROM users WHERE \"userName\" = ? ;";
    private static final String REGISTRATION = "INSERT INTO users(\"userName\", \"password\", \"role\", \"userGender\", \"userFirstName\", \"userSurname\") VALUES(? , ?, ?, ?, ?, ?);";
    private static final String SEARCH_USER_BY_LOGIN = "SELECT \"userName\" FROM users WHERE \"userName\" = ? ;";
    private static final String GET_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USER = "DELETE FROM users WHERE \"idUsers\" = ?";
    private static final String UPDATE_USER_ROLE = "UPDATE users SET \"role\" = ? WHERE \"idUsers\" = ?";

    public SQLUserDAO(){

    }

    @Override
    public User signIn(String login) throws UserDAOException {
        String passwordUser = "", userName = "", gender ="", firstName="", lastName="";
        int role = 0, userId = -1;
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(SIGN_IN)) {
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                userName = result.getString(DataBaseField.USER_NAME.getCode());
                passwordUser = result.getString(DataBaseField.PASSWORD.getCode());
                role = result.getInt(DataBaseField.ROLE.getCode());
                userId = result.getInt(DataBaseField.ID_USERS.getCode());
                lastName = result.getString(DataBaseField.USER_LASTNAME.getCode());
                firstName = result.getString(DataBaseField.USER_FIRSTNAME.getCode());
                gender = result.getString(DataBaseField.USER_GENDER.getCode());
            }
            return new User(userName, passwordUser, role, userId, gender, firstName, lastName);
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
            statement.setString(4, user.getGender());
            statement.setString(5, user.getFirstName());
            statement.setString(6, user.getLastName());
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

    @Override
    public List<User> getAllUsers() throws UserDAOException {
        List<User> users = new ArrayList<>();
        try(Connection conn = connectionPool.takeConnection();
        Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(GET_ALL_USERS)){
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt(DataBaseField.ID_USERS.getCode()));
                user.setName(resultSet.getString(DataBaseField.USER_NAME.getCode()));
                user.setRole(resultSet.getInt(DataBaseField.ROLE.getCode()));
                user.setFirstName(resultSet.getString(DataBaseField.USER_FIRSTNAME.getCode()));
                user.setLastName(resultSet.getString(DataBaseField.USER_LASTNAME.getCode()));
                user.setGender(resultSet.getString(DataBaseField.USER_GENDER.getCode()));
                users.add(user);
            }
            return users;
        } catch (SQLException | ConnectionPoolException e) {
            throw new UserDAOException("Problem with getAllUsers", e);
        }
    }

    @Override
    public void deleteUser(int userId) throws UserDAOException {
        try (Connection conn = connectionPool.takeConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USER)){
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new UserDAOException("Problem with deleteUser", e);
        }
    }

    @Override
    public void updateUserRole(int userId, int newRole) throws UserDAOException {
        try (Connection conn = connectionPool.takeConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USER_ROLE)) {
            preparedStatement.setInt(1, newRole);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new UserDAOException("Problem with updateUserRole", e);
        }
    }
}
