package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;

public interface SubscriptionService {
    Book subscriptionBook(User user, int bookId) throws ServiceException;
    void addNewSubscription(Subscription subscription) throws ServiceException;
}
