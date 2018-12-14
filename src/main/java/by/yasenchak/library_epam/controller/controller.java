package by.yasenchak.library_epam.controller;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.CommandHelper;
import by.yasenchak.library_epam.logic.EnumPages;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@MultipartConfig
public class controller extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("action");
        if(commandName == null){
            commandName = "getAllBook";
        }
        executeCommand(req, resp, commandName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("action");
        executeCommand(req, resp, commandName);
    }

    private void executeCommand(HttpServletRequest req, HttpServletResponse resp, String commandName) throws ServletException, IOException {
        Command command = CommandHelper.getInstance().getCommand(commandName);
        String response = command.execute(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(response);
        requestDispatcher.forward(req, resp);
    }
}
