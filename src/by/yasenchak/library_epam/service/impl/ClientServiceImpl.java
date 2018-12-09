package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.RegistrationException;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.SignInException;
import by.yasenchak.library_epam.service.ClientService;

public class ClientServiceImpl implements ClientService {
    @Override
    public User signIn(String login, String password) throws ServiceException {
        if(login == null || login.isEmpty() || password == null || password.isEmpty()){
            throw new ServiceException("Incorrect login");
        }
        User user;
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            user = userDAO.signIn(login, password);
            if(user == null){
                throw new ServiceException("Wrong login or password");
            }
        } catch (SignInException e) {
            throw new ServiceException("Problem with sql", e);
        }
        return user;
    }

    @Override
    public void registration(User user) throws ServiceException {
        if(user == null || user.getName().isEmpty() || user.getPassword().isEmpty()){
            throw new ServiceException("Incorrect user");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            userDAO.registration(user);
        } catch (RegistrationException e) {
            throw new ServiceException("Problem with registration", e);
        }
    }
}
