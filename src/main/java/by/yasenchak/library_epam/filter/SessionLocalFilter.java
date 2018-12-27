package by.yasenchak.library_epam.filter;

import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})

public class SessionLocalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter(RequestParameter.SESSION_LOCALE.getCode()) != null) {
            req.getSession().setAttribute(RequestParameter.LANG.getCode(), req.getParameter(RequestParameter.SESSION_LOCALE.getCode()));
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}