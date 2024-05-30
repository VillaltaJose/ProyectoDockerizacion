package ec.edu.ups.ppw63.demo63.services;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class JaegerContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		JaegerConfig.initTracer();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) { }
}
