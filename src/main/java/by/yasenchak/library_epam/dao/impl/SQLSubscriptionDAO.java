package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.dao.SubscriptionDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.SubscriptionDAOException;
import by.yasenchak.library_epam.utils.DataBaseField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLSubscriptionDAO implements SubscriptionDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String ADD_NEW_SUBSCRIPTION = "INSERT INTO subscriptions (id_book, id_user, type, active) VALUES (?,?,?,?);";
    private static final String GET_UNCONFIRMED_SUBS = "SELECT s.type, s.id_subs, s.id_book, s.id_user, s.active, u.\"userName\", b.name, b.isbn FROM subscriptions s " +
            "LEFT JOIN users u ON (s.id_user = u.\"idUsers\") LEFT JOIN books b ON (s.id_book = b.id_book) WHERE s.active = false";
    private static final String GET_SUBS_BY_ID = "SELECT s.type, s.id_subs, s.id_book, s.id_user, s.active, u.\"userName\", b.name, b.isbn FROM subscriptions s " +
            "LEFT JOIN users u ON (s.id_user = u.\"idUsers\") LEFT JOIN books b ON (s.id_book = b.id_book) WHERE s.id_subs = ?";
    private static final String CONFIRM_SUBS = "UPDATE subscriptions SET active = true, \"dateIn\" = ?, \"dateOut\" = ? WHERE id_subs = ?";

    @Override
    public void addNewSubscription(Subscription subscription) throws SubscriptionDAOException {
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement pstmt = conn.prepareStatement(ADD_NEW_SUBSCRIPTION)){
            pstmt.setInt(1, subscription.getBookId());
            pstmt.setInt(2, subscription.getUserId());
            pstmt.setString(3, subscription.getType());
            pstmt.setBoolean(4, subscription.isActive());
            pstmt.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new SubscriptionDAOException("Problem with getAllSubscription", e);
        }
    }

    @Override
    public List<Subscription> getAllUnconfirmedSubscriptions() throws SubscriptionDAOException {
        try (Connection conn = connectionPool.takeConnection();
             Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(GET_UNCONFIRMED_SUBS)) {
            List<Subscription> subscriptions = new ArrayList<>();
            while (resultSet.next()){
                subscriptions.add(createSubs(resultSet));
            }
            return subscriptions;
        } catch (SQLException | ConnectionPoolException e) {
            throw new SubscriptionDAOException("Problem with getAllUncSubs", e);
        }
    }

    @Override
    public Subscription getSubscriptionById(int idSubs) throws SubscriptionDAOException {
        try (Connection conn = connectionPool.takeConnection();
             PreparedStatement statement = conn.prepareStatement(GET_SUBS_BY_ID)) {
            statement.setInt(1, idSubs);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return createSubs(resultSet);
            }else return null;
        } catch (SQLException | ConnectionPoolException e) {
            throw new SubscriptionDAOException("Problem with getSubscriptionById", e);
        }
    }

    @Override
    public void confirmSubscription(Subscription subscription) throws SubscriptionDAOException {
        try(Connection connection = connectionPool.takeConnection();
        PreparedStatement statement = connection.prepareStatement(CONFIRM_SUBS)){
            statement.setDate(1, Date.valueOf(subscription.getDateIn()));
            statement.setDate(2, Date.valueOf(subscription.getDateOut()));
            statement.setInt(3, subscription.getId());
            statement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
            throw new SubscriptionDAOException("Problem with confirmSubscription", e);
        }
    }

    private Subscription createSubs(ResultSet resultSet) throws SQLException{
        Subscription subscription = new Subscription();
        subscription.setId(resultSet.getInt(DataBaseField.ID_SUBS.getCode()));
        subscription.setBookId(resultSet.getInt(DataBaseField.ID_BOOK.getCode()));
        subscription.setUserId(resultSet.getInt(DataBaseField.ID_USER.getCode()));
        subscription.setActive(resultSet.getBoolean(DataBaseField.ACTIVE.getCode()));
        subscription.setType(resultSet.getString(DataBaseField.TYPE.getCode()));
        subscription.setBookName(resultSet.getString(DataBaseField.NAME.getCode()));
        subscription.setUserName(resultSet.getString(DataBaseField.USER_NAME.getCode()));
        subscription.setIsbn(resultSet.getString(DataBaseField.ISBN.getCode()));
        return subscription;
    }
}
