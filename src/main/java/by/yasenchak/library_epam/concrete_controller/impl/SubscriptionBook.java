package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.service.SubscriptionService;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class SubscriptionBook implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        User user = (User) request.getSession().getAttribute(RequestParameter.USER.getCode());
        int idBook = Integer.parseInt(request.getParameter(RequestParameter.BOOK.getCode()));
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SubscriptionService subscriptionService = serviceFactory.getSubscriptionService();
        try {
            Book book = subscriptionService.subscriptionBook(user, idBook);
            request.setAttribute(RequestParameter.BOOK.getCode(), book);
            page = Page.SUBS_PAGE.getCode();
        } catch (ServiceException e) {
            e.printStackTrace();
            page = Page.USER_AUTH.getCode();
        }
        return page;
    }
}
