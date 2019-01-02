package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GoToProfile implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = (User) request.getSession().getAttribute(RequestParameter.USER.getCode());
        if(user.getRole() == 1){
            try {
                request.setAttribute(RequestParameter.CURRENT_USER_SUBS.getCode(), ServiceFactory.getInstance().getSubscriptionService().getCurrentUserSubs(user.getUserId()));
                page = Page.USER_PAGE.getCode();
            } catch (ServiceException e) {
                return Page.ERROR_PAGE.getCode();
            }
        }
        if(user.getRole() == 0){
            try {
                request.setAttribute(RequestParameter.BOOKS.getCode(), ServiceFactory.getInstance().getBookService().getAllBooks());
                page = Page.ADMIN_PAGE.getCode();
            } catch (ServiceException e) {
                return Page.ERROR_PAGE.getCode();
            }
        }
        return page;
    }
}
