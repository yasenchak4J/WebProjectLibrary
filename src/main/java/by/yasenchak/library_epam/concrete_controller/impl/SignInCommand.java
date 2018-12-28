package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ClientService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SignInCommand implements Command {
    private static final String INCORRECT_LOGIN = "Incorrect login or password";

    @Override
    public String execute(HttpServletRequest request){
        String responsePage = null;
        String login = request.getParameter(RequestParameter.LOGIN.getCode());
        String password = request.getParameter(RequestParameter.PASSWORD.getCode());
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        ClientService clientService = serviceFactory.getClientService();
        try {
            User user = clientService.signIn(login, password);
            if(user == null){
                request.setAttribute(RequestParameter.ERROR.getCode(), INCORRECT_LOGIN);
                responsePage = Page.USER_AUTH.getCode();
            } else{
                request.getSession().setAttribute(RequestParameter.USER.getCode(), user);
                if(user.getRole() == 1){
                    List<Book> books = bookService.getAllBooks();
                    request.setAttribute(RequestParameter.BOOKS.getCode(), books);
                    responsePage = Page.MAIN_PAGE.getCode();
                }else if(user.getRole() == 0){
                    List<Book> books = bookService.getAllBooks();
                    request.setAttribute(RequestParameter.BOOKS.getCode(), books);
                    responsePage = Page.ADMIN_PAGE.getCode();
                } else if (user.getRole() == 2){
                    request.setAttribute(RequestParameter.UNC_SUBS.getCode(), serviceFactory.getSubscriptionService().getUnconfirmedSubs());
                    responsePage = Page.LIBRARIAN_PAGE.getCode();
                }
            }
        } catch (ServiceException e) {
            responsePage = Page.AUTH_FAILS.getCode();
        }
        return responsePage;
    }
}
