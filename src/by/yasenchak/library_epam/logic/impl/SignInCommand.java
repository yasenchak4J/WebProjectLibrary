package by.yasenchak.library_epam.logic.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.EnumPages;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ClientService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request){
        String responsePage = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        ClientService clientService = serviceFactory.getClientService();
        try {
            User user = clientService.signIn(login, password);
            List<Book> books = bookService.getAllBooks();
            System.out.println(books.size());
            request.setAttribute("books", books);
            request.getSession().setAttribute("user", user);
            if(user.getRole() == 1){
                responsePage = EnumPages.MAIN_PAGE.getCode();
            }else if(user.getRole() == 0){

                responsePage = EnumPages.ADMIN_PAGE.getCode();
            }

        } catch (ServiceException e) {
            responsePage = EnumPages.AUTH_FAILS.getCode();
        }
        return responsePage;
    }
}
