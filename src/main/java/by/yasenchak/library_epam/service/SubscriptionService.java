package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;

public interface SubscriptionService {
    Book subsriptionBook(User user, int bookId) throws ServiceException;
}
