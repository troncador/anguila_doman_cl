package cl.doman.anguila.action;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.db.query.UserQuery;
import cl.doman.anguila.db.table.User;
import cl.doman.anguila.db.table.UserGroup;
import cl.doman.db.QueryException;

public class UserAction {
  static Logger log = LoggerFactory.getLogger(UserAction.class);

    public boolean exist(String username) throws QueryException {
      UserQuery query = new UserQuery();
      return query.logicalExistByUsername(username);
    }
  
    public User get(String username) throws QueryException {
      UserQuery query = new UserQuery();
      return query.logicalGetByUsername(username);
    }
    
    public User create(String username, String password) throws QueryException {
      AuthenticationToken authenticationToken = 
          new UsernamePasswordToken(username, password);
      
      User user = new User();
      user.setCreation(new Date());
      
      DefaultPasswordService passwordService = new DefaultPasswordService();
      Object credential = authenticationToken.getCredentials();
      String encryptedPassword = passwordService.encryptPassword(credential);
      
      user.setPassword(encryptedPassword);
      user.setUsername(username);
            
      UserGroup group = new UserGroup();
      group.setId(1);
      user.setGroup(group);
      
      UserQuery query = new UserQuery();
      return query.save(user);
    }
    
    public void suspend(String username) throws QueryException {
      UserQuery query = new UserQuery();
      User user = query.logicalGetByUsername(username);
      user.setIsSuspended(true);
      query.save(user);
    }
    
    public void delete(User user) throws QueryException {
      UserQuery query = new UserQuery();
      user.setIsDeleted(true);
      query.update(user);
    }
    
    public void delete(String username) throws QueryException {
      UserQuery query = new UserQuery();
      User user = query.logicalGetByUsername(username);
      delete(user);
    }
    
    public void confirme(String username) {
        
    }
    
    public boolean authentificate(String username, String password) {
      Subject subject = SecurityUtils.getSubject();
      UsernamePasswordToken token = new UsernamePasswordToken(username, password);
      try {
        subject.login(token);
        return true;
      } catch (AuthenticationException e){
        return false;
      } catch (Exception e) {
        throw e;
      }
    }
    
    public boolean authentificateByRecovery(String username, String password) {
        return true;
    }
    
    public String aa(AuthenticationToken authenticationToken) {
        DefaultPasswordService passwordService = new DefaultPasswordService();
        String encryptedPassword = passwordService.encryptPassword(authenticationToken.getCredentials());
        return encryptedPassword;
    }
}
