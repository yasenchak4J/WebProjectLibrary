package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.SubscriptionDAO;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.SubscriptionDAOException;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public Book subscriptionBook(User user, int bookId) throws ServiceException {
        if(user == null){
            throw new ServiceException("Invalid user");
        }
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        Book book = bookService.getBookByID(bookId);
        return book;
    }

    @Override
    public void addNewSubscription(Subscription subscription) throws ServiceException {
        if(subscription == null){
            throw new ServiceException("Invalid subscription");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        SubscriptionDAO subscriptionDAO = daoFactory.getSubscriptionDAO();
        try {
            subscriptionDAO.addNewSubscription(subscription);
        } catch (SubscriptionDAOException e) {
            e.printStackTrace();
            throw new ServiceException("Problem with sql", e);
        }
    }
}
