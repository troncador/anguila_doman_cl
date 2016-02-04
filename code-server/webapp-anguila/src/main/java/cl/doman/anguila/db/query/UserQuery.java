package cl.doman.anguila.db.query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.db.table.User;
import cl.doman.anguila.db.table.User_;
import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.QueryException;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.db.query.dao.PreparePredicate;

public class UserQuery extends EntityDaoCriteria<User, Integer>implements Existance<User, Integer> {
  static Logger log = LoggerFactory.getLogger(UserQuery.class);

  @Override
  public SingularAttribute<? super User, Integer> getPK() {
    return User_.id;
  }

  public UserQuery() {
    super(User.class);
  }
  
  abstract class LogicalPreparePredicate implements PreparePredicate<User>{
    abstract Predicate getLogicalPredicate(Root<User> root, CriteriaBuilder criteriaBuilder);
    public final Predicate getPredicate(Root<User> root, CriteriaBuilder criteriaBuilder){
      Predicate isNotDeleted = criteriaBuilder.equal(root.get(User_.isDeleted), false);
      Predicate predicate = getLogicalPredicate(root, criteriaBuilder);
      return criteriaBuilder.and(predicate, isNotDeleted);
    }
  }
  
  private PreparePredicate<User> byUsername(String username){
    return new PreparePredicate<User>() {
      @Override
      public Predicate getPredicate(Root<User> root, CriteriaBuilder criteriaBuilder) {
        Predicate isNotDeleted = criteriaBuilder.notEqual(root.get(User_.isDeleted), true);
        Predicate isUsername = criteriaBuilder.equal(root.get(User_.username), username);
        return criteriaBuilder.and(isUsername, isNotDeleted);
      }
    };
  }
  
  public boolean logicalExistByUsername(String username) throws QueryException {
    return this.exist(byUsername(username));
  }

  public User logicalGetByUsername(final String username) throws QueryException {
    return this.get(byUsername(username));
  }

  public String logicalGetPasswordByUsername(final String username) throws QueryException {
    return this.getColumn(byUsername(username), User_.password, String.class);
  }

  public boolean logicalCheck(final String username, final String password) throws QueryException {
    PreparePredicate<User> preparePredicate = new LogicalPreparePredicate() {
      @Override
      public Predicate getLogicalPredicate(Root<User> root, CriteriaBuilder criteriaBuilder) {

        Predicate usernamePredicate = criteriaBuilder.equal(root.get(User_.username), username);
        Predicate passwordPredicate = criteriaBuilder.equal(root.get(User_.password), password);

        return criteriaBuilder.and(usernamePredicate, passwordPredicate);
      }
    };
    return this.exist(preparePredicate);
  }

  @Override
  public Integer convert(String id) throws ConvertException {
    try {
      return Integer.parseInt(id);
    } catch (NumberFormatException e) {
      throw new ConvertException();
    }
  }
}
