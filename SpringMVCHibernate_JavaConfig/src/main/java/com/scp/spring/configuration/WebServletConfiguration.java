package com.scp.spring.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		System.out.println("inside onstartup method");
		
		 AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
	        webCtx.register(SpringConfig.class);
	        webCtx.setServletContext(ctx);
	        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
		
		
		// Create the 'root' Spring application context
        //AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        //rootContext.register(SpringConfig.class);
 
        // Manage the lifecycle of the root application context
        //container.addListener(new ContextLoaderListener(rootContext));
 
        // Create the dispatcher servlet's Spring application context
       // AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        //dispatcherServlet.register(SpringMVCXmlConfig.class);
             
        // Register and map the dispatcher servlet
        //ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
        //dispatcher.setLoadOnStartup(1);
        //dispatcher.addMapping("/");
		
	}

}