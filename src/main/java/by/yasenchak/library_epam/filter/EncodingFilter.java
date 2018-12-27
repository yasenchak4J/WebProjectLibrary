package by.yasenchak.library_epam.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private FilterConfig filterConfig = null;
    private static final String UTF = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(UTF);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
