package cl.doman.anguila.init;

import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.action.UserAction;
import cl.doman.anguila.db.query.SystemQuery;
import cl.doman.anguila.db.query.UserQuery;
import cl.doman.anguila.db.query.UserSessionQuery;
import cl.doman.anguila.db.table.FileUpload;
import cl.doman.anguila.db.table.FileUploadAccess;
import cl.doman.anguila.db.table.SystemConfig;
import cl.doman.anguila.db.table.UserPassRestore;
import cl.doman.anguila.db.table.UserSession;
import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;

public class Init {
  static Logger log = LoggerFactory.getLogger(Init.class);

  public static void main(String arg[]) throws ConfigurationException, QueryException, SystemInitializatorException{
    String str = "/home/troncador/work/java/project/anguila.doman.cl/tools/docker/init-docker/etc.doman/config.xml";
    new ConfigInitializator(str).init();
    UserAction action = new UserAction();
    UserSessionQuery q = new UserSessionQuery();
    q.touch("fefbd890-2fa3-46d0-b28b-87cc5d3c6e8c");
    //action.authentificate("", "");
    //action.create("benjamin.almarza@gmail.com", "qwerty");
    //log.info(" "+ action.authentificate("benjamin.almarza@gmail.com", "qwerty"));
    //new StandardQuery<UserSession>(UserSession.class).find();
    
  }
}
