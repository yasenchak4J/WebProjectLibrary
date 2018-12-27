package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.service.SubscriptionService;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddNewSubscription implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        int bookId = Integer.parseInt(request.getParameter(RequestParameter.BOOK.getCode()));
        String type = request.getParameter(RequestParameter.TYPE.getCode());
        User user = (User) request.getSession().getAttribute(RequestParameter.USER.getCode());
        Subscription subscription = new Subscription(bookId, user.getUserId(), type, false);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SubscriptionService subscriptionService = serviceFactory.getSubscriptionService();
        try {
            subscriptionService.addNewSubscription(subscription);
            BookService bookService = serviceFactory.getBookService();
            List<Book> books = bookService.getAllBooks();
            request.setAttribute(RequestParameter.BOOKS.getCode(), books);
            page = Page.MAIN_PAGE.getCode();
        } catch (ServiceException e) {
            page = Page.ERROR_PAGE.getCode();
        }
        return page;
    }
}
