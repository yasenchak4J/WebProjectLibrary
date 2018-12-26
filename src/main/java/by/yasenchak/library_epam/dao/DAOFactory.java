package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.dao.impl.SQLGenreDAO;
import by.yasenchak.library_epam.dao.impl.SQLLibraryDAO;
import by.yasenchak.library_epam.dao.impl.SQLSubscriptionDAO;
import by.yasenchak.library_epam.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final LibraryDAO sqlLibrary = new SQLLibraryDAO();
    private final UserDAO sqlUser = new SQLUserDAO();
    private final GenreDAO genreDAO = new SQLGenreDAO();
    private final SubscriptionDAO subscriptionDAO = new SQLSubscriptionDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public UserDAO getUserDAO(){
        return sqlUser;
    }

    public LibraryDAO getLibraryDAO(){
        return sqlLibrary;
    }

    public GenreDAO getGenreDAO(){
        return genreDAO;
    }

    public SubscriptionDAO getSubscriptionDAO(){
        return subscriptionDAO;
    }
}
