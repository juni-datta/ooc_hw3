package io.muzoo.ooc.hw3.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends AbstractRoutableHttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/signup.jsp");
        requestDispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            userService.addUser(username, password);
            response.sendRedirect("/login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            String error = "Failed to create account. Please try again.";

            request.setAttribute("error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/signup.jsp");
            requestDispatcher.include(request, response);
        }
    }

    @Override
    public String getPattern() {
        return "/signup";
    }
}
