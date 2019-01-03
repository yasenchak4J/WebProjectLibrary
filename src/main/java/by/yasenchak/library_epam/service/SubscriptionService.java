package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;

import java.util.List;

public interface SubscriptionService {
    Book subscriptionBook(User user, int bookId) throws ServiceException;
    void addNewSubscription(Subscription subscription) throws ServiceException;
    List<Subscription> getUnconfirmedSubs() throws ServiceException;
    Subscription getSubscriptionById(int idSubs) throws ServiceException;
    void confirmSubscription(Subscription subscription) throws ServiceException;
    List<Subscription> getCurrentSubs() throws ServiceException;
    void confirmReturnBook(int idSubs) throws ServiceException;
    List<Subscription> getCurrentUserSubs(int userId) throws ServiceException;
    void renewSubscription(int idSubs) throws ServiceException;
    List<Subscription> getRenewSubs() throws ServiceException;
}
