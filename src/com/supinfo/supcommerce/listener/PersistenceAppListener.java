package com.supinfo.supcommerce.listener;

import com.supinfo.supcommerce.util.PersistenceManager;
import org.apache.log4j.BasicConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Listener de fermeture de l'entity manager factory.
 */
@WebListener
public class PersistenceAppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		BasicConfigurator.configure();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		PersistenceManager.closeEntityManagerFactory();
	}
}
