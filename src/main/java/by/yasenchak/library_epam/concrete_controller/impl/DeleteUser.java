package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ClientService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class DeleteUser implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        int userId = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
        System.out.println(userId);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            clientService.deleteUser(userId);
            request.setAttribute(RequestParameter.USERS.getCode(), clientService.getAllUsers());
            page = Page.All_USERS.getCode();
        } catch (ServiceException e) {
            page = Page.ERROR_PAGE.getCode();
        }
        return page;
    }
}
