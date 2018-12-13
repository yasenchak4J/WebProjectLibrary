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
        String responsePage = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(login);
        user.setPassword(password);
        user.setRole(1);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            boolean isReg = clientService.registration(user);
            if(isReg){
                responsePage = EnumPages.USER_AUTH.getCode();
                request.setAttribute("registration", "User has been registrated!");
            }else{
                responsePage = EnumPages.USER_AUTH.getCode();
                request.setAttribute("registration", "User already exist");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            responsePage = EnumPages.AUTH_FAILS.getCode();
        }
        return responsePage;
    }
}
