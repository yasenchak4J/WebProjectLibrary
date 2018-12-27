package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;

import javax.servlet.http.HttpServletRequest;

public class GoToAddNewBook implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Page.ADD_NEW_BOOK.getCode();
    }
}
