package cl.doman.anguila.shiro;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.db.query.UserSessionQuery;
import cl.doman.anguila.db.table.UserSession;
import cl.doman.db.QueryException;

public class CustomSessionDao implements SessionDAO {
  private UserSessionQuery userSessionQuery;
  static Logger log = LoggerFactory.getLogger(CustomSessionDao.class);

  public CustomSessionDao() throws NoSuchAlgorithmException {
    userSessionQuery = new UserSessionQuery();
  }

  protected Session storeSession(Serializable id, Session session) throws UnknownSessionException {
    // if (id == null) {
    // throw new NullPointerException("id argument cannot be null.");
    // }
    try {
      UserSession userSession = new UserSession();
      userSession.setId(id.toString());
      userSession.setLastAccessTime(new Date());
      userSessionQuery.update(userSession);
      return session;
    } catch (QueryException e) {
      throw new UnknownSessionException(e.getMessage(), e);
    }
  }

  public void update(Session session) throws UnknownSessionException {
    storeSession(session.getId(), session);
  }

  public void delete(Session session) {
    if (session == null) {
      throw new NullPointerException("session argument cannot be null.");
    }
    Serializable id = session.getId();
    if (id != null) {
      try {
        userSessionQuery.delete((UserSession) session);
      } catch (QueryException e) {
        throw new UnknownSessionException(e.getMessage(), e);
      }
    }
  }

  public Collection<Session> getActiveSessions() throws UnknownSessionException {
    try {
      Collection<UserSession> values = userSessionQuery.find();
      return (Collection<Session>) (Collection) values;
    } catch (QueryException e) {
      throw new UnknownSessionException(e.getMessage(), e);
    }
  }

  @Override
  public Serializable create(Session session) {
    UserSession userSession = (UserSession) session;
    String sessionId = UUID.randomUUID().toString();
    userSession.setId(sessionId);
    
    userSession.setStartTimestamp(new Date());
    
    storeSession(sessionId, session);
    return sessionId;
  }

  @Override
  public Session readSession(Serializable sessionId) throws UnknownSessionException {
    try {
      return userSessionQuery.get(sessionId.toString());
    } catch (QueryException e) {
      throw new UnknownSessionException(e.getMessage(), e);
    }
  }
}
