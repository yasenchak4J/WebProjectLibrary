package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.concrete_controller.EnumPages;

import javax.servlet.http.HttpServletRequest;

public class GoToAuth implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return EnumPages.USER_AUTH.getCode();
    }
}
