package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;

import cl.doman.anguila.db.query.UserSessionQuery;
import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.util.Collection;
import java.util.Date;


/**
 * The persistent class for the user_session database table.
 * 
 */
@Entity
@Table(name = "user_session")
@NamedQuery(name = "UserSession.findAll", query = "SELECT u FROM UserSession u")
public class UserSession implements Serializable, BaseTable<String>, ValidatingSession {
  private static final long serialVersionUID = 1L;
  private String host;
  private Date startTimestamp;
  private Date lastAccessTime;
  private Long timeout;
  private String agent;
  private int uid;
  private String id;
  
  public UserSession() {}

  @Id
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }

  @Override
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creation")
  public Date getStartTimestamp() {
    return startTimestamp;
  }

  public void setStartTimestamp(Date startTimestamp) {
    this.startTimestamp = startTimestamp;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modification")
  public Date getLastAccessTime() {
    return this.lastAccessTime;
  }

  public void setLastAccessTime(Date lastAccessTime) {
    this.lastAccessTime = lastAccessTime;
  }

  @Override
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }
  
  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }
  
  public int getUid() {
    return this.uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  @Override
  @Transient
  public long getTimeout() throws InvalidSessionException {
    return timeout;
  }

  @Override
  public void setTimeout(long maxIdleTimeInMillis) throws InvalidSessionException {
    this.timeout = maxIdleTimeInMillis;
  }

  @Override
  public void touch() throws InvalidSessionException {
    UserSessionQuery query = new UserSessionQuery();
  }

  @Override
  public void stop() throws InvalidSessionException {
    // TODO Auto-generated method stub

  }

  @Override
  public Collection<Object> getAttributeKeys() throws InvalidSessionException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getAttribute(Object key) throws InvalidSessionException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setAttribute(Object key, Object value) throws InvalidSessionException {
    // TODO Auto-generated method stub

  }

  @Override
  public Object removeAttribute(Object key) throws InvalidSessionException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isValid() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public void validate() throws InvalidSessionException {
    // TODO Auto-generated method stub
    
  }

}
