package cl.doman.anguila.init;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.action.UserAction;
import cl.doman.anguila.db.query.SystemQuery;
import cl.doman.anguila.db.query.UserQuery;
import cl.doman.anguila.db.table.SystemConfig_;
import cl.doman.anguila.db.table.User;
import cl.doman.anguila.db.table.User_;
import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.db.query.dao.PreparePredicate;

public class AutentificationTest {
  static Logger log = LoggerFactory.getLogger(AutentificationTest.class);
 
  public static void main(String arg[]) throws ConfigurationException, SystemInitializatorException, QueryException {
    String str = "/home/troncador/work/java/project/anguila.doman.cl/tools/docker/init-docker/etc.doman/config.xml";
    new ConfigInitializator(str).init();
    UserAction action = new UserAction();
//    User user = action.create("a@a.cl", "qwerty");
    SystemQuery query = new SystemQuery();
    try{
     if (query.exist("var1",SystemConfig_.name)){
       log.info("exist");
     } else {
       log.info("no exist");
     }
    } catch (Exception e) {
      throw new SystemInitializatorException(e.getMessage(),e);
    }
    
    StandardQuery<User> query2 = new StandardQuery<User>(User.class);
    try{
     if (query2.exist("var1",User_.username)){
       log.info("exist");
     } else {
       log.info("no exist");
     }
    } catch (Exception e) {
      throw new SystemInitializatorException(e.getMessage(),e);
    }
    
//  if( ! query.existByUsername("a@a.cl") ) {
//   // throw new SystemInitializatorException();
//  } 
    
//    if(!action.authentificate("a@a.cl", "qwerty")) {
//      //query.delete(user);
//      throw new SystemInitializatorException();
//    }
//    query.delete(user);
  }
}
