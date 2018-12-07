package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.dao.impl.SQLLibraryDAO;
import by.yasenchak.library_epam.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final LibraryDAO sqlLibrary = new SQLLibraryDAO();
    private final UserDAO sqlUser = new SQLUserDAO();

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
}
