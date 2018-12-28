package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GoToConfirmSubs implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int idSubs = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
        try {
            request.setAttribute(RequestParameter.SUBS.getCode(), ServiceFactory.getInstance().getSubscriptionService().getSubscriptionById(idSubs));
            return Page.CONCRETE_SUBS.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
