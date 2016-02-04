package cl.doman.anguila.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.XMLConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cl.doman.anguila.db.query.SystemQuery;
import cl.doman.base.initializator.LoggerInitializator;
import cl.doman.base.initializator.StackSystemInitializator;
import cl.doman.base.initializator.SystemInitializator;
import cl.doman.db.DatabaseInitializator;


public class ServletContext implements ServletContextListener {
  static Logger log = LoggerFactory.getLogger(ServletContext.class);

  public static void init() {
    try {

      String str = "/etc/troncador/mandomedio/config.xml";

      XMLConfiguration config = new XMLConfiguration();
      config.setFileName(str);
      config.load();

      SystemInitializator[] configurationArray = new SystemInitializator[] {
          new LoggerInitializator(), new DatabaseInitializator(SystemQuery.class)};

      new StackSystemInitializator(configurationArray).init(config);
    } catch (Exception e) {
      log.info(e.getMessage(), e);
      System.exit(-1);
    }
  }

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ServletContext.init();
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    log.info("destroy server");
  }
}
