package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
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
            page = Page.USER_PAGE.getCode();
        }
        if(user.getRole() == 0){
            page = Page.ADMIN_PAGE.getCode();
        }
        return page;
    }
}
