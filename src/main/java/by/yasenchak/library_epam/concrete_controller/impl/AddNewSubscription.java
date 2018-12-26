package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.concrete_controller.EnumPages;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddNewSubscription implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        int bookId = Integer.parseInt(request.getParameter("book"));
        String type = request.getParameter("type");
        User user = (User) request.getSession().getAttribute("user");
        Subscription subscription = new Subscription(bookId, user.getUserId(), type, false);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SubscriptionService subscriptionService = serviceFactory.getSubscriptionService();
        try {
            subscriptionService.addNewSubscription(subscription);
            BookService bookService = serviceFactory.getBookService();
            List<Book> books = bookService.getAllBooks();
            request.setAttribute("books", books);
            page = EnumPages.MAIN_PAGE.getCode();
        } catch (ServiceException e) {
            page = EnumPages.ERROR_PAGE.getCode();
        }
        return page;
    }
}
