package cl.doman.anguila.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.XMLConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.thymeleaf.TemplateEngine;

import ch.qos.logback.core.joran.spi.JoranException;
import cl.doman.anguila.db.i.table.ContactArea;
import cl.doman.anguila.db.i.table.Country;
import cl.doman.anguila.db.i.table.Status;
import cl.doman.anguila.db.query.BlogQuery;
import cl.doman.anguila.db.query.PageQuery;
import cl.doman.base.initializator.LogBackConfigLoader;
import cl.doman.base.initializator.LoggerInitializator;
import cl.doman.base.initializator.StackSystemInitializator;
import cl.doman.base.initializator.SystemInitializator;
import cl.doman.db.DatabaseInitializator;
import cl.doman.db.QueryException;
import cl.doman.db.server.PersistenceUnitFactory;


public class ServletContext implements ServletContextListener, ApplicationContextAware{
	static Logger log = LoggerFactory.getLogger(ServletContext.class);
	private static ApplicationContext ctx;
	static private TemplateEngine templateEngine;
	
	public static void init(){
		try {
                  
			String str = "/etc/troncador/mandomedio/config.xml";
			
			XMLConfiguration config = new XMLConfiguration();
			config.setFileName(str);
			config.load();
			
			
			SystemInitializator [] configurationArray = new SystemInitializator[]{
					new LoggerInitializator(),
					new DatabaseInitializator(BlogQuery.class)
			};
		
			new StackSystemInitializator(configurationArray).init(config);
			Status.init();
			Country.init();
			ContactArea.init();
		} catch (Exception e) {
			log.info(e.getMessage(),e);
			System.exit(-1);
		}	
	}
	
	/*
	public static void init(){
		try { 
			 new LogBackConfigLoader("/etc/troncador/mandomedio/logback.xml");
			 
			 FileInputStream fileInputStream 
				= new FileInputStream("/etc/troncador/mandomedio/persistence.properties");
			 Properties properties = new Properties();
			 properties.load(fileInputStream);
			 PersistenceUnitFactory.init(properties);
			 
			
			 PageQuery query = new PageQuery();
			 query.count();
			 
		} catch ( IOException e) {
			 System.err.print(e.getMessage()+"\n"+e.getStackTrace());
			 System.exit(1);
		} catch (JoranException e) {
			 System.err.print(e.getMessage()+"\n"+e.getStackTrace());
			System.exit(1);
		} catch (QueryException e) {
			 log.error(e.getMessage(),e);
			System.exit(1);;
		}
	}
*/
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext.init();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		log.info("destroy server");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
		
	}
	public static ApplicationContext getApplicationContext() {
	    return ctx;
	}
	
	public void setTemplateEngine(TemplateEngine templateEngine_){
		templateEngine = templateEngine_;
	}
	public static TemplateEngine getTemplateEngine(){
		return templateEngine;
	}
	
}
