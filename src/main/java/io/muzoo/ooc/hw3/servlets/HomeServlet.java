package io.muzoo.ooc.hw3.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends AbstractRoutableHttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Object usernameObject = session.getAttribute("username");
        if (usernameObject != null && usernameObject instanceof String) {
            String username = (String) usernameObject;
            request.setAttribute("username", username);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/home.jsp");
            requestDispatcher.include(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }

    @Override
    public String getPattern() {
        return "/index.jsp";
    }
}