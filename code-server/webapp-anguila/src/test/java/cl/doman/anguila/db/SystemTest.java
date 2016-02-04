package cl.doman.anguila.db;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.action.SystemAction;
import cl.doman.anguila.action.UserAction;
import cl.doman.anguila.db.query.UserQuery;
import cl.doman.anguila.db.table.User;
import cl.doman.anguila.init.ConfigInitializator;
import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.QueryException;

public class SystemTest {
  static Logger log = LoggerFactory.getLogger(SystemTest.class);
  
  private boolean isInit = false;

  public void init() throws Exception {
    if (!isInit) {
      String str =
          "/home/troncador/work/java/project/anguila.doman.cl/tools/docker/init-docker/etc.doman/config.xml";
      new ConfigInitializator(str).init();
      isInit = true;
    }
  }
  
  @Test
  public void test() throws Exception {
    init();

    SystemAction action = new SystemAction();
    action.init();
  }
}
