package cl.doman.mmedio.db.query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.QueryException;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.db.query.dao.PreparePredicate;
import cl.doman.mmedio.db.table.Admin;
import cl.doman.mmedio.db.table.Admin_;




public class AdminQuery extends EntityDaoCriteria<Admin,Integer> implements Existance<Admin,Integer>{
	protected static final Integer PAGE_SIZE = 10;
	static Logger log = LoggerFactory.getLogger(AdminQuery.class);

	@Override
	public SingularAttribute<? super Admin,Integer> getPK() {
		return Admin_.id;
	}
	
	public AdminQuery(){
		super(Admin.class);
	}
	
	public boolean existByUsername(final String mail) throws QueryException{
		return this.exist(mail,Admin_.username);
	}
	
	public Admin getByUsername(final String username) throws QueryException {
		PreparePredicate<Admin> preparePredicate = new PreparePredicate<Admin>() {
			@Override
			public Predicate getPredicate(Root<Admin> root,
					CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get(Admin_.username), username);
			}
		};
		return this.get(preparePredicate);
	}
	
	public boolean check(final String username, final String password) throws QueryException {
		PreparePredicate<Admin> preparePredicate = new PreparePredicate<Admin>() {
			@Override
			public Predicate getPredicate(Root<Admin> root,
					CriteriaBuilder criteriaBuilder) {
				
				Predicate usernamePredicate = criteriaBuilder.equal(root.get(Admin_.username), username);
				Predicate passwordPredicate = criteriaBuilder.equal(root.get(Admin_.password), password);
				
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

	public String getPasswordByUsername(final String username) throws QueryException {
		PreparePredicate<Admin> preparePredicate = new PreparePredicate<Admin>() {
			@Override
			public Predicate getPredicate(Root<Admin> root,
					CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get(Admin_.username), username);
			}
		};
		return this.getColumn(preparePredicate,Admin_.password,String.class);
	}
}
