package io.muzoo.ooc.hw3.servlets;

import io.muzoo.ooc.hw3.security.SecurityService;

import javax.servlet.http.HttpServlet;

public abstract class AbstractRoutableHttpServlet extends HttpServlet implements Routable {
    protected SecurityService securityService;

    public void setSecurityService(SecurityService securityService){
        this.securityService = securityService;
    }



}
