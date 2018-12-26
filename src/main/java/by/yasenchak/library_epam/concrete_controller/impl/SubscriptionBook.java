package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.concrete_controller.EnumPages;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;

public class SubscriptionBook implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        User user = (User) request.getSession().getAttribute("user");
        int idBook = Integer.parseInt(request.getParameter("book"));
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SubscriptionService subscriptionService = serviceFactory.getSubscriptionService();
        try {
            Book book = subscriptionService.subsriptionBook(user, idBook);
            request.setAttribute("book", book);
            page = EnumPages.SUBS_PAGE.getCode();
        } catch (ServiceException e) {
            e.printStackTrace();
            page = EnumPages.USER_AUTH.getCode();
        }
        return page;
    }
}
