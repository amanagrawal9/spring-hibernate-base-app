package qa.qcri.rahar.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("qa.qcri.rahar.config");

		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new org.springframework.web.filter.CharacterEncodingFilter());
		encodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		
		servletContext.addListener(new ContextLoaderListener(context));
		
		/* Adding request listener */
		servletContext.addListener(new RequestContextListener());

		/* Configuring dispatcher servlet for spring mvc */
		ServletRegistration.Dynamic appServlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(context));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/*");
	}

}
