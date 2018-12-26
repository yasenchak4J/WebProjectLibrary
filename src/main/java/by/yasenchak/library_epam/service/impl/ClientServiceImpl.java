package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.UserDAOException;
import by.yasenchak.library_epam.service.ClientService;
import org.mindrot.jbcrypt.BCrypt;

public class ClientServiceImpl implements ClientService {
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
                user.setPassword("");
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
}
