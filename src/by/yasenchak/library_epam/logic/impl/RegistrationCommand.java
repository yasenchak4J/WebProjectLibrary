package by.yasenchak.library_epam.logic.impl;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.EnumPages;
import by.yasenchak.library_epam.service.ClientService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request){
        String response = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(login);
        user.setPassword(password);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            clientService.registration(user);
            response = EnumPages.LIBRARY.getCode();
        } catch (ServiceException e) {
            response = EnumPages.AUTH_FAILS.getCode();
        }
        return response;
    }
}
