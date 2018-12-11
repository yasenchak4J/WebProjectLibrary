package by.yasenchak.library_epam.controller;


import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.CommandHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pages/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("action");
        Command command = CommandHelper.getInstance().getCommand(commandName);
        String response = command.execute(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(response);
        requestDispatcher.forward(req, resp);
    }
}
