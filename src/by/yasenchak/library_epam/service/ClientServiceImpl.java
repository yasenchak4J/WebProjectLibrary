package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.UserDAO;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.RegistrationException;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.SignInException;

public class ClientServiceImpl implements ClientService {
    @Override
    public void signIn(String login, String password) throws ServiceException {
        if(login == null || login.isEmpty()){
            throw new ServiceException("Incorrect login");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            if(!userDAO.signIn(login, password)){
                throw new ServiceException("Incorrect password");
            }
        } catch (SignInException e) {
            throw new ServiceException("Problem with sql", e);
        }
    }

    @Override
    public void registration(User user) throws ServiceException {
        if(user == null){
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
