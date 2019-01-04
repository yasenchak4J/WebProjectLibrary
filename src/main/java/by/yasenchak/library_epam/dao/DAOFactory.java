package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.dao.impl.*;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final LibraryDAO sqlLibrary = new SQLLibraryDAO();
    private final UserDAO sqlUser = new SQLUserDAO();
    private final GenreDAO genreDAO = new SQLGenreDAO();
    private final SubscriptionDAO subscriptionDAO = new SQLSubscriptionDAO();
    private final AuthorDAO authorDAO = new SQLAuthorDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public AuthorDAO getAuthorDAO(){
        return authorDAO;
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
