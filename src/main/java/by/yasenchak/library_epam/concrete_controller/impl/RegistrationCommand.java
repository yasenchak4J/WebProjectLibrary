package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.service.ClientService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private static final String USER_REGISTRATED = "User has been registrated!";
    private static final String USER_EXIST = "User already exist";
    
    @Override
    public String execute(HttpServletRequest request){
        String responsePage;
        String login = request.getParameter(RequestParameter.LOGIN.getCode());
        String password = request.getParameter(RequestParameter.PASSWORD.getCode());
        User user = new User();
        user.setName(login);
        user.setPassword(password);
        user.setRole(1);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            boolean isReg = clientService.registration(user);
            if(isReg){
                responsePage = Page.USER_AUTH.getCode();
                request.setAttribute(RequestParameter.REGISTRATION.getCode(), USER_REGISTRATED);
            }else{
                responsePage = Page.USER_AUTH.getCode();
                request.setAttribute(RequestParameter.REGISTRATION.getCode(), USER_EXIST);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            responsePage = Page.AUTH_FAILS.getCode();
        }
        return responsePage;
    }
}
