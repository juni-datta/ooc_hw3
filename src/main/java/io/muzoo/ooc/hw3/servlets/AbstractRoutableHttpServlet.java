package io.muzoo.ooc.hw3.servlets;

import io.muzoo.ooc.hw3.security.SecurityService;
import io.muzoo.ooc.hw3.security.User;
import io.muzoo.ooc.hw3.security.UserService;

import javax.servlet.http.HttpServlet;

public abstract class AbstractRoutableHttpServlet extends HttpServlet implements Routable {
    protected SecurityService securityService;
    protected UserService userService;

    public void setSecurityService(SecurityService securityService){
        this.securityService = securityService;
    }

    public void setUserService(UserService userService){
        this.userService = userService;
    }



}
