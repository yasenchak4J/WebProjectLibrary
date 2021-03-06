package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.Subscription;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class AgreeRenew implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int idSubs = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
        String dateOut = request.getParameter(RequestParameter.DATE_OUT.getCode());
        Subscription subscription = new Subscription();
        subscription.setId(idSubs);
        subscription.setDateOut(dateOut);
        try {
            ServiceFactory.getInstance().getSubscriptionService().agreeRenew(subscription);
            request.setAttribute(RequestParameter.RENEW_SUBS.getCode(), ServiceFactory.getInstance().getSubscriptionService().getRenewSubs());
            return Page.RENEW_SUBS.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
