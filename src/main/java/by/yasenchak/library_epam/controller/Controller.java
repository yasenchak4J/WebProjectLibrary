package by.yasenchak.library_epam.controller;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.concrete_controller.CommandHelper;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class Controller extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestParameter.ACTION.getCode());
        if(commandName != null){
            executeCommand(req, resp, commandName);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(Page.MAIN_PAGE.getCode());
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestParameter.ACTION.getCode());
        executeCommand(req, resp, commandName);
    }

    private void executeCommand(HttpServletRequest req, HttpServletResponse resp, String commandName) throws ServletException, IOException {
        Command command = CommandHelper.getInstance().getCommand(commandName);
        String response = command.execute(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(response);
        requestDispatcher.forward(req, resp);
    }
}
