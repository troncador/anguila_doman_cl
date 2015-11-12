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

public class UserQuery extends EntityDaoCriteria<User,Integer> implements Existance<User,Integer>{
	static Logger log = LoggerFactory.getLogger(UserQuery.class);

	@Override
	public SingularAttribute<? super User, Integer> getPK() {
		return User_.id;
	}
	
	public UserQuery(){
		super(User.class);
	}
	
	public boolean logicalExistByUsername(String username) throws QueryException{
		return this.exist(username, User_.username);
	}
	
	public User logicalGetByUsername(final String username) throws QueryException {
		PreparePredicate<User> preparePredicate = new PreparePredicate<User>() {
			@Override
			public Predicate getPredicate(Root<User> root,
					CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get(User_.username), username);
			}
		};
		return this.get(preparePredicate);
	}
	
	   public String logicalGetPasswordByUsername(final String username) throws QueryException {
	        PreparePredicate<User> preparePredicate = new PreparePredicate<User>() {
	            @Override
	            public Predicate getPredicate(Root<User> root,
	                    CriteriaBuilder criteriaBuilder) {
	                return criteriaBuilder.equal(root.get(User_.username), username);
	            }
	        };
	        return this.getColumn(preparePredicate, User_.password, String.class);
	    }
       public boolean logicalExist(final String username) throws QueryException {
         PreparePredicate<User> preparePredicate = new PreparePredicate<User>() {
             @Override
             public Predicate getPredicate(Root<User> root,
                     CriteriaBuilder criteriaBuilder) {    
                 Predicate notDeleted = criteriaBuilder.equal(root.get(User_.isDeleted), 0);
                 return criteriaBuilder.and(notDeleted) ; 
             }
         };
         return this.exist(preparePredicate);
     }
	   
	   
	public boolean logicalCheck(final String username, final String password) throws QueryException {
		PreparePredicate<User> preparePredicate = new PreparePredicate<User>() {
			@Override
			public Predicate getPredicate(Root<User> root,
					CriteriaBuilder criteriaBuilder) {
				
				Predicate usernamePredicate = criteriaBuilder.equal(root.get(User_.username), username);
				Predicate passwordPredicate = criteriaBuilder.equal(root.get(User_.password), password);
				
				return criteriaBuilder.and(usernamePredicate,passwordPredicate);
			}
		};
		return this.exist(preparePredicate);
	}
	
	@Override
	public Integer convert(String id) throws ConvertException {
		try{
			return Integer.parseInt(id);
		} catch (NumberFormatException e){
			throw new ConvertException();
		}
	}
}
