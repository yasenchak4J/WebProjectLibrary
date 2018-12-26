package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.concrete_controller.EnumPages;
import by.yasenchak.library_epam.entity.User;

import javax.servlet.http.HttpServletRequest;

public class GoToProfile implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = (User) request.getSession().getAttribute("user");
        if(user.getRole() == 1){
            page = EnumPages.USER_PAGE.getCode();
        }
        if(user.getRole() == 0){
            page = EnumPages.ADMIN_PAGE.getCode();
        }
        return page;
    }
}
