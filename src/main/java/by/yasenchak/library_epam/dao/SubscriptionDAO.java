package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.exception.dao_exception.SubscriptionDAOException;

import java.util.List;


public interface SubscriptionDAO {
    void addNewSubscription(Subscription subscription) throws SubscriptionDAOException;
    List<Subscription> getAllUnconfirmedSubscriptions() throws SubscriptionDAOException;
    Subscription getSubscriptionById(int idSubs) throws SubscriptionDAOException;
    void confirmSubscription(Subscription subscription) throws SubscriptionDAOException;
    List<Subscription> getCurrentSubscription() throws  SubscriptionDAOException;
    void confirmReturnBook(int idSubs) throws SubscriptionDAOException;
    List<Subscription> getCurrentUserSubs(int idUser) throws SubscriptionDAOException;
}
