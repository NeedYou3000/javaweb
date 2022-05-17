package com.laptrinhjavaweb.springconfig;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.HashSet;

public class WebIntializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        createAppRootContext(servletContext);

        addSitemeshFilterToServletContext(servletContext);

        registerDispatcherServlet(servletContext);

        //remove cookie tracking mode in url
        HashSet<SessionTrackingMode> set = new HashSet<SessionTrackingMode>();
        set.add(SessionTrackingMode.COOKIE);
        servletContext.setSessionTrackingModes(set);
    }

    private void createAppRootContext(ServletContext servletContext) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfiguration.class);

        // Manage the life-cycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

    private void addSitemeshFilterToServletContext(ServletContext servletContext) {
        FilterRegistration.Dynamic sitemesh = servletContext.addFilter("sitemesh", new MySitemeshFilter());
        EnumSet<DispatcherType> sitemeshDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        sitemesh.addMappingForUrlPatterns(sitemeshDispatcherTypes, true, "/*");
    }

    private void registerDispatcherServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(
                new AnnotationConfigWebApplicationContext()));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
