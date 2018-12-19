package by.yasenchak.library_epam.concrete_controller;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
}
