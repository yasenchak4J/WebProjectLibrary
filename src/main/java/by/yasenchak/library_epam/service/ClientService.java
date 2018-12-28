package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;

import java.util.List;

public interface ClientService {
    User signIn(String login, String password) throws ServiceException;
    boolean registration(User user) throws ServiceException;
    List<User> getAllUsers() throws ServiceException;
    void deleteUser(int userId) throws ServiceException;
    void updateUserRole(int userId, int newRole) throws ServiceException;
}
