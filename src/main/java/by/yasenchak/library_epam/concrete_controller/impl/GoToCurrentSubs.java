package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GoToCurrentSubs implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.setAttribute(RequestParameter.CURRENT_SUBS.getCode(), ServiceFactory.getInstance().getSubscriptionService().getCurrentSubs());
            return Page.CURRENT_SUBS.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
