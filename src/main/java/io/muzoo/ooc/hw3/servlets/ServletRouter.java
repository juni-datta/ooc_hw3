package io.muzoo.ooc.hw3.servlets;

import io.muzoo.ooc.hw3.security.SecurityService;
import io.muzoo.ooc.hw3.security.UserService;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

public class ServletRouter {

    private final List<Class<? extends AbstractRoutableHttpServlet>> servletClasses = new ArrayList<>();

    {
        servletClasses.add(HomeServlet.class);
        servletClasses.add(LoginServlet.class);
        servletClasses.add(LogoutServlet.class);
    }
    public void init(Context context){
        UserService userService = new UserService();
        SecurityService securityService = new SecurityService();
        securityService.setUserService(userService);
        for (Class<? extends AbstractRoutableHttpServlet> servletClass: servletClasses){
            try {
                AbstractRoutableHttpServlet httpServlet = servletClass.newInstance();
                httpServlet.setSecurityService(securityService);
                Tomcat.addServlet(context, servletClass.getSimpleName(), httpServlet);
                context.addServletMapping(httpServlet.getPattern(), servletClass.getSimpleName());

            } catch (InstantiationException e){
                e.printStackTrace();
            } catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }

    }
}