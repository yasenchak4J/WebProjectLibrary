package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class RenewSubscription implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(RequestParameter.USER.getCode());
        int id = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
        try {
            ServiceFactory.getInstance().getSubscriptionService().renewSubscription(id);
            request.setAttribute(RequestParameter.CURRENT_USER_SUBS.getCode(), ServiceFactory.getInstance().getSubscriptionService().getCurrentUserSubs(user.getUserId()));
            return Page.USER_PAGE.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
