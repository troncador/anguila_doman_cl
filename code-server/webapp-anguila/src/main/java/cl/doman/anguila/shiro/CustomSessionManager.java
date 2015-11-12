package cl.doman.anguila.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SessionManager;

public class CustomSessionManager implements SessionManager {

  @Override
  public Session getSession(SessionKey sessionKey) throws SessionException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Session start(SessionContext sessionContext) {
    // TODO Auto-generated method stub
    return null;
  }

}
