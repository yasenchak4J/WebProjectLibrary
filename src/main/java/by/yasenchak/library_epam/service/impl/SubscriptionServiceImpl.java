package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public Book subsriptionBook(User user, int bookId) throws ServiceException {
        if(user == null){
            throw new ServiceException("Invalid user");
        }
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        Book book = bookService.getBookByID(bookId);
        return book;
    }
}
