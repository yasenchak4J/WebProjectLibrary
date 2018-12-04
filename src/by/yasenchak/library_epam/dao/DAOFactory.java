package by.yasenchak.library_epam.dao;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO sqlUser = new SQLUserDAO();
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public UserDAO getUserDAO(){
        return sqlUser;
    }
}
