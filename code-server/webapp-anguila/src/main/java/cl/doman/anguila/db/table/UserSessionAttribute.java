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
@Table(name = "user_session_attribute")
@NamedQuery(name = "UserSessionAttribute.findAll", query = "SELECT u FROM UserSessionAttribute u")
public class UserSessionAttribute implements Serializable, BaseTable<String> {
  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String value;
  
  public UserSessionAttribute() {}

  @Id
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
