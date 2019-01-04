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

import java.util.List;

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

    @Override
    public List<Subscription> getUnconfirmedSubs() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        SubscriptionDAO subscriptionDAO = daoFactory.getSubscriptionDAO();
        try {
            return subscriptionDAO.getAllUnconfirmedSubscriptions();
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public Subscription getSubscriptionById(int idSubs) throws ServiceException {
        if(idSubs < 0){
            throw new ServiceException("Incorrect id");
        }
        try {
            return DAOFactory.getInstance().getSubscriptionDAO().getSubscriptionById(idSubs);
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void confirmSubscription(Subscription subscription) throws ServiceException {
        if(subscription == null){
            throw new ServiceException("Incorrect subs");
        }
        try {
            DAOFactory.getInstance().getSubscriptionDAO().confirmSubscription(subscription);
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public List<Subscription> getCurrentSubs() throws ServiceException {
        try {
            return DAOFactory.getInstance().getSubscriptionDAO().getCurrentSubscription();
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void confirmReturnBook(int idSubs) throws ServiceException {
        try {
            DAOFactory.getInstance().getSubscriptionDAO().confirmReturnBook(idSubs);
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public List<Subscription> getCurrentUserSubs(int userId) throws ServiceException {
        try {
            return DAOFactory.getInstance().getSubscriptionDAO().getCurrentUserSubs(userId);
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void renewSubscription(int idSubs) throws ServiceException {
        try {
            DAOFactory.getInstance().getSubscriptionDAO().renewSubscription(idSubs);
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problems with SQL", e);
        }
    }

    @Override
    public List<Subscription> getRenewSubs() throws ServiceException {
        try {
            return DAOFactory.getInstance().getSubscriptionDAO().getAllRenewSubscription();
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public List<Subscription> getUserRenewSubs(int idUser) throws ServiceException {
        try {
            return DAOFactory.getInstance().getSubscriptionDAO().getUserRenewSubs(idUser);
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void agreeRenew(Subscription subscription) throws ServiceException {
        try {
            DAOFactory.getInstance().getSubscriptionDAO().confirmRenewSubs(subscription);
        } catch (SubscriptionDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void rejectRenew(int idSubs) throws ServiceException {
        try {
            DAOFactory.getInstance().getSubscriptionDAO().rejectRenewSubs(idSubs);
        } catch (SubscriptionDAOException e) {
            throw new  ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public List<Subscription> getUserConfirmedSubs(int idUser) throws ServiceException {
        try {
            return DAOFactory.getInstance().getSubscriptionDAO().getUserConfirmedSubs(idUser);
        } catch (SubscriptionDAOException e) {
            throw new  ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public List<Subscription> getUserRejectedSubs(int idUser) throws ServiceException {
        try {
            return DAOFactory.getInstance().getSubscriptionDAO().getUserRejectedSubs(idUser);
        } catch (SubscriptionDAOException e) {
            throw new  ServiceException("Problem with SQL", e);
        }
    }
}
