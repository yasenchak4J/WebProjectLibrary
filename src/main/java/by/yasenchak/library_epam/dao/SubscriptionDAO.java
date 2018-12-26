package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.exception.dao_exception.SubscriptionDAOException;


public interface SubscriptionDAO {
    void addNewSubscription(Subscription subscription) throws SubscriptionDAOException;
}
