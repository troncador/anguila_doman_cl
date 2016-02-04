package cl.doman.anguila.action;

import java.io.IOException;
import java.util.Date;

import cl.doman.anguila.db.table.SystemDeploy;
import cl.doman.anguila.init.ConfigInitializator;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;

public class SystemAction {
  
  public void init() throws QueryException, IOException{
    StandardQuery<SystemDeploy> query = new StandardQuery<SystemDeploy>(SystemDeploy.class);

    SystemDeploy systemDeploy = new SystemDeploy();
   
    String version = ConfigInitializator.getProperties("application.version");
    
    systemDeploy.setVersion(version);
    systemDeploy.setStartup(new Date());
    
    query.save(systemDeploy);
  }
  
}
