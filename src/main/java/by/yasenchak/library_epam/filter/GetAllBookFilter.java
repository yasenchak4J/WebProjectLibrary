package by.yasenchak.library_epam.filter;


import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "GetAllBookFilter", urlPatterns = {"/"})
public class GetAllBookFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (javax.servlet.http.HttpServletRequest) servletRequest;
        if(req.getParameter("action") == null){
            try {
                List<Book> books = ServiceFactory.getInstance().getBookService().getAllBooks();
                req.setAttribute("books", books);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            filterChain.doFilter(req, servletResponse);
        }
    }
}
