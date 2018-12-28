package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.UserDAOException;
import by.yasenchak.library_epam.service.ClientService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private static final String EMPTY_PASSWORD = "";

    @Override
    public User signIn(String login, String password) throws ServiceException {
        if(login == null || login.isEmpty() || password == null || password.isEmpty()){
            throw new ServiceException("Incorrect login");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            User user = userDAO.signIn(login);
            if(BCrypt.checkpw(password, user.getPassword())) {
                user.setPassword(EMPTY_PASSWORD);
                return user;
            } else {
                return null;
            }
        } catch (UserDAOException e) {
            throw new ServiceException("Problem with sql", e);
        }
    }

    @Override
    public boolean registration(User user) throws ServiceException {
        if(user == null || user.getName().isEmpty() || user.getPassword().isEmpty()){
            throw new ServiceException("Incorrect user");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            boolean userNotExist = userDAO.userExist(user);
            if(userNotExist){
                String password = user.getPassword();
                password = BCrypt.hashpw(password, BCrypt.gensalt());
                user.setPassword(password);
                userDAO.registration(user);
                return true;
            } else {
                return false;
            }
        } catch (UserDAOException e) {
            throw new ServiceException("Problem with registration", e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            return userDAO.getAllUsers();
        } catch (UserDAOException e) {
            throw new ServiceException("SQL problem", e);
        }
    }

    @Override
    public void deleteUser(int userId) throws ServiceException {
        if(userId < 0){
            throw new ServiceException("Incorrect user");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            userDAO.deleteUser(userId);
        } catch (UserDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void updateUserRole(int userId, int newRole) throws ServiceException {
        if(userId < 0 && newRole < 0){
            throw new ServiceException("Incorrect user or role");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            userDAO.updateUserRole(userId, newRole);
        } catch (UserDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }
}
