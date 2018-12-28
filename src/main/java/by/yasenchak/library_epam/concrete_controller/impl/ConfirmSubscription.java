package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class ConfirmSubscription implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Subscription subscription = new Subscription();
        subscription.setId(Integer.parseInt(request.getParameter(RequestParameter.ID.getCode())));
        subscription.setDateIn(request.getParameter(RequestParameter.DATE_IN.getCode()));
        subscription.setDateOut(request.getParameter(RequestParameter.DATE_OUT.getCode()));
        try {
            ServiceFactory.getInstance().getSubscriptionService().confirmSubscription(subscription);
            request.setAttribute(RequestParameter.UNC_SUBS.getCode(), ServiceFactory.getInstance().getSubscriptionService().getUnconfirmedSubs());
            return Page.LIBRARIAN_PAGE.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
