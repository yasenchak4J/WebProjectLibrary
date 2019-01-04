package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GoToUserRenewSubs implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(RequestParameter.USER.getCode());
        try {
            request.setAttribute(RequestParameter.USER_RENEW_SUBS.getCode(), ServiceFactory.getInstance().getSubscriptionService().getUserRenewSubs(user.getUserId()));
            request.setAttribute(RequestParameter.USER_CONFIRM_RENEW.getCode(), ServiceFactory.getInstance().getSubscriptionService().getUserConfirmedSubs(user.getUserId()));
            request.setAttribute(RequestParameter.USER_REJECT_RENEW.getCode(), ServiceFactory.getInstance().getSubscriptionService().getUserRejectedSubs(user.getUserId()));
            return Page.USER_RENEW_SUBS.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
