package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.SubscriptionDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.SubscriptionDAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLSubscriptionDAO implements SubscriptionDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String ADD_NEW_SUBSCRIPTION = "INSERT INTO subscriptions (id_book, id_user, type, active) VALUES (?,?,?,?);";

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
}
