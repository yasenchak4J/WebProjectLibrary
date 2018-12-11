package by.yasenchak.library_epam.logic.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.EnumPages;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditBook implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String response = null;
        Book book = new Book();
        book.setId(Integer.parseInt(request.getParameter("id")));
        book.setName(request.getParameter("name"));
        book.setPublisher(request.getParameter("publisher"));
        book.setPageCount(Integer.parseInt(request.getParameter("pageCount")));
        book.setiSBN(request.getParameter("isbn"));
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        try {
            bookService.editBook(book);
            List<Book> books = bookService.getAllBooks();
            request.setAttribute("books", books);
            response = EnumPages.ADMIN_PAGE.getCode();
        } catch (ServiceException e) {
            response = EnumPages.ERROR_PAGE.getCode();
        }
        return response;
    }
}
