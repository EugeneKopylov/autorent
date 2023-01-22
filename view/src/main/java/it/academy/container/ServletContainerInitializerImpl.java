package it.academy.container;

import it.academy.config.Config;
import it.academy.security.WebSecurityConfig;
import it.academy.service.ServiceContextConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

@Component
public class ServletContainerInitializerImpl implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);
        context.register(Config.class);
        context.register(ServiceContextConfig.class);
        context.register(WebSecurityConfig.class);

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

        final ServletRegistration.Dynamic servletRegistration =
                ctx.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("*.html");
        servletRegistration.addMapping("*.jpg");
        servletRegistration.addMapping("*.view");
        servletRegistration.addMapping("*.action");
        servletRegistration.addMapping("/");

    }

}