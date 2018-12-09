package by.yasenchak.library_epam.controller;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.CommandHelper;
import by.yasenchak.library_epam.logic.EnumPages;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class controller extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String page = null;
        String commandName = req.getParameter("action");
        if(commandName == null){
            commandName = "getAllBook";
            Command command = CommandHelper.getInstance().getCommand(commandName);
            if(session != null && session.getAttribute("user") != null){
                User user = (User) session.getAttribute("user");
                if(user.getRole() == 1){
                    page = EnumPages.MAIN_PAGE.getCode();
                }
            } else {
                page = EnumPages.MAIN_PAGE.getCode();
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(page);
            requestDispatcher.forward(req, resp);
        } else{
            Command command = CommandHelper.getInstance().getCommand(commandName);
            String response = command.execute(req);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(response);
            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("action");
        Command command = CommandHelper.getInstance().getCommand(commandName);
        String response = command.execute(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(response);
        requestDispatcher.forward(req, resp);
    }
}
