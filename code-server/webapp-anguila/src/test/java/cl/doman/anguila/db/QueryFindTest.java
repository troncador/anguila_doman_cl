package cl.doman.anguila.db;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.metamodel.SingularAttribute;

import org.junit.Test;

import cl.doman.anguila.db.table.User;
import cl.doman.anguila.db.table.User_;
import cl.doman.anguila.db.table.SystemConfig;
import cl.doman.anguila.db.table.SystemConfig_;
import cl.doman.anguila.db.table.SystemDeploy;
import cl.doman.anguila.db.table.SystemDeploy_;
import cl.doman.anguila.db.table.UserGroup;
import cl.doman.anguila.db.table.UserGroup_;
import cl.doman.anguila.init.ConfigInitializator;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.db.model.table.StandardTable;
import cl.doman.db.query.dao.PrepareLimit;
import cl.doman.db.query.dao.PrepareQuery;
import cl.doman.db.query.dao.PrepareQueryAdapter;

public class QueryFindTest {
  private boolean isInit = false;

  public void init() throws Exception {
    if (!isInit) {
      String str =
          "/home/troncador/work/java/project/anguila.doman.cl/tools/docker/init-docker/etc.doman/config.xml";
      new ConfigInitializator(str).init();
      isInit = true;
    }
  }

  class MapCreator<C>{
    Map<SingularAttribute<? super C,? extends Object>, Class< ? extends Object>> map;
    public MapCreator(){
      map =  new HashMap<SingularAttribute<? super C,? extends Object>, Class< ? extends Object>> ();
    }
    public <D extends Object> void add(SingularAttribute<? super C, D> att, Class<D> val) {
      map.put(att, val);
    }
    public Map<SingularAttribute<? super C, ? extends Object>, Class<? extends Object>> getMap(){
      return map;
    }
  }
  
  @Test
  public  void checkAUser() throws ClassCastException, Exception {
    init();
    MapCreator<User> map = new MapCreator<User> ();
    map.add(User_.password, String.class);
    map.add(User_.username, String.class);
//    map.add(User_.isSuspended, Byte.class);
//    map.add(User_.isDeleted, Byte.class);
    map.add(User_.id, Integer.class);
    checkTable(User.class, map);
  }
  
//  @Test
//  public  void checkUser() throws ClassCastException, Exception {
//    init();
//    MapCreator<BUser> map = new MapCreator<BUser> ();
//    map.add(BUser_.password, String.class);
//    map.add(BUser_.username, String.class);
////    map.add(User_.isSuspended, Byte.class);
////    map.add(User_.isDeleted, Byte.class);
//    map.add(BUser_.id, Integer.class);
//    checkTable(BUser.class, map);
//  }
  
  
  @Test
  public void checkSystem() throws ClassCastException, Exception {
    init();
    MapCreator<SystemConfig> map = new MapCreator<SystemConfig> ();
    map.add(SystemConfig_.name, String.class);
    map.add(SystemConfig_.value, String.class);
    map.add(SystemConfig_.id, Integer.class);
    checkTable(SystemConfig.class, map);
  }

  @Test
  public void checkUserGroup() throws ClassCastException, Exception {
    init();
    MapCreator<UserGroup> map = new MapCreator<UserGroup> ();
    map.add(UserGroup_.name, String.class);
    map.add(UserGroup_.description, String.class);
    map.add(UserGroup_.id, Integer.class);
    checkTable(UserGroup.class, map);
  }
  
  @Test
  public void checkSystemDeploy() throws ClassCastException, Exception {
    init();
    MapCreator<SystemDeploy> map = new MapCreator<SystemDeploy> ();
    map.add(SystemDeploy_.version, String.class);
    map.add(SystemDeploy_.startup, Date.class);
    map.add(SystemDeploy_.id, Integer.class);
    checkTable(SystemDeploy.class, map);
  }
  
//  @Test
//  public void checkUserSession() throws ClassCastException, Exception {
//    init();
//    MapCreator<UserSession> map = new MapCreator<UserSession> ();
//    map.add(UserSession_.agent, String.class);
//    map.add(UserSession_.host, String.class);
//    map.add(UserSession_.id, String.class);
//    checkTable(UserSession.class, map);
//  }
  
  public <P extends StandardTable> void checkTable(Class<P> clazzTable, MapCreator<P> mapCreator) throws Exception {
    StandardQuery<P> query = new StandardQuery<P>(clazzTable);
    Map<SingularAttribute<? super P, ? extends Object>, Class<? extends Object>> map = mapCreator.getMap();
    
    query.count();
    PrepareQuery<P> prepareQuery = new PrepareQueryAdapter<P>(new PrepareLimit() {
      @Override
      public Integer getMaxResults() {
        return 1;
      }

      @Override
      public Integer getFirstResult() {
        return 0;
      }
    });

    query.find();

    for (SingularAttribute attribute : mapCreator.getMap().keySet()) {
      Class clazz = map.get(attribute);
      query.findColumn(prepareQuery, attribute, clazz);
      query.findPK(prepareQuery, clazz);
      query.findMap(attribute, clazz);
    }
  }
}
