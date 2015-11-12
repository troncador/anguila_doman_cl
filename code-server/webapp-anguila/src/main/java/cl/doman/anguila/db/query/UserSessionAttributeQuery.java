package cl.doman.anguila.db.query;

import javax.persistence.metamodel.SingularAttribute;

import cl.doman.anguila.db.table.UserSession;
import cl.doman.anguila.db.table.UserSessionAttribute;
import cl.doman.anguila.db.table.UserSessionAttribute_;
import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.query.dao.EntityDaoCriteria;

public class UserSessionAttributeQuery extends EntityDaoCriteria<UserSessionAttribute, String> 
  implements Existance<UserSessionAttribute, String>{

  public UserSessionAttributeQuery() throws ClassCastException {
    super(UserSessionAttribute.class);
  }

  @Override
  public SingularAttribute<? super UserSessionAttribute, String> getPK() {
    return UserSessionAttribute_.id;
  }

  @Override
  public String convert(String id) throws ConvertException {
    return id;
  }

}
