package io.muzoo.ooc.hw3.servlets;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

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

        for (Class<? extends AbstractRoutableHttpServlet> servletClass: servletClasses){
            try {
                AbstractRoutableHttpServlet httpServlet = servletClass.newInstance();
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