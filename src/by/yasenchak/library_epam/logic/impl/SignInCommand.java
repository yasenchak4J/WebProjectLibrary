package by.yasenchak.library_epam.logic.impl;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.EnumPages;
import by.yasenchak.library_epam.service.ClientService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request){
        String responsePage = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            User user = clientService.signIn(login, password);
            request.setAttribute("user", user);
            responsePage = EnumPages.MAIN_PAGE.getCode();
        } catch (ServiceException e) {
            responsePage = EnumPages.AUTH_FAILS.getCode();
        }
        return responsePage;
    }
}
