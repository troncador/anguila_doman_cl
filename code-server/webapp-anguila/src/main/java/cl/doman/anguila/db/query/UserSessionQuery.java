package cl.doman.anguila.db.query;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.db.table.UserSession;
import cl.doman.anguila.db.table.UserSession_;
import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.QueryException;
import cl.doman.db.QueryExceptionKind;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.db.query.dao.PreparePredicate;

public class UserSessionQuery extends EntityDaoCriteria<UserSession, String>
    implements Existance<UserSession, String> {
  static Logger log = LoggerFactory.getLogger(UserSessionQuery.class);

  @Override
  public SingularAttribute<? super UserSession, String> getPK() {
    return UserSession_.id;
  }

  public UserSessionQuery() {
    super(UserSession.class);
  }

  @Override
  public String convert(String id) throws ConvertException {
    return id;
  }

  public void touch(String id) throws QueryException {
    UserSession session = this.get(id);
    EntityManager entityManager = getEntityManager();
    try {
      EntityTransaction entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      UserSession entityCommited = entityManager.merge(session);
      entityCommited.setLastAccessTime(new Date());
      entityTransaction.commit();
    } catch (Exception e) {
      throw new QueryException(e.getMessage(), e);
    } finally {
      entityManager.close();
    }

  }
}
