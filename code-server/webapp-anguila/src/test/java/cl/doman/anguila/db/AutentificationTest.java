package cl.doman.anguila.db;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.action.UserAction;
import cl.doman.anguila.db.query.UserQuery;
import cl.doman.anguila.db.table.User;
import cl.doman.anguila.init.ConfigInitializator;
import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.QueryException;

public class AutentificationTest {
  static Logger log = LoggerFactory.getLogger(AutentificationTest.class);
  
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
    String NAME = "a@a.cl"; 
    String PASSWORD = "qwerty";
 
    UserAction action = new UserAction();
    UserQuery query = new UserQuery();
    
    User user = null;
    if (!action.exist(NAME)) {
      user = action.create(NAME, PASSWORD);
    } else {
      user = action.get(NAME);
    }

    if(!action.authentificate(NAME, PASSWORD)){
      throw new SystemInitializatorException();
    }
    if (!action.exist(NAME)) {
      throw new SystemInitializatorException();
    }
    action.delete(user);
    
    Integer id = user.getId();
    user = query.get(id);
    
    if (action.exist(NAME)) {
      throw new SystemInitializatorException();
    }
    query.delete(user);
  }
}
