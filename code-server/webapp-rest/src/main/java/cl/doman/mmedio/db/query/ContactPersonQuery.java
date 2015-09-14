package cl.doman.mmedio.db.query;

import java.util.List;

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
import cl.doman.db.query.dao.PrepareQueryAdapter;
import cl.doman.mmedio.db.table.ContactArea;
import cl.doman.mmedio.db.table.ContactPerson;
import cl.doman.mmedio.db.table.ContactPerson_;
import cl.doman.mmedio.db.table.Country;

public class ContactPersonQuery extends EntityDaoCriteria<ContactPerson, Integer> implements Existance<ContactPerson,Integer>{
	static Logger log =LoggerFactory.getLogger(ContactPersonQuery.class);
	static private String defaultMail = "igonzalez@mandomedio.com";
	
	
	public ContactPersonQuery() {
		super(ContactPerson.class);
	}

	
	@Override
	public Integer convert(String id) throws ConvertException {
		try{
			return Integer.parseInt(id);
		} catch (NumberFormatException  e){
			throw new ConvertException();
		}
	}

	@Override
	public SingularAttribute<ContactPerson, Integer> getPK() {
		return ContactPerson_.id;
	}

	public String getMail(final Country country,final ContactArea contactArea) throws QueryException{
		PreparePredicate<ContactPerson> preparePredicate = new PreparePredicate<ContactPerson>() {
			@Override
			public Predicate getPredicate(Root<ContactPerson> root,
					CriteriaBuilder criteriaBuilder) {
				
				Predicate [] predicate = new Predicate[]{
						criteriaBuilder.equal(root.get(ContactPerson_.contactArea), contactArea),
						criteriaBuilder.equal(root.get(ContactPerson_.country), country)
				};
				return  criteriaBuilder.and(predicate);
			}
		};
		PrepareQueryAdapter<ContactPerson> prepareQuery = new PrepareQueryAdapter<ContactPerson>(preparePredicate);
		List<String> mailList = this.findColumn(prepareQuery, ContactPerson_.mail, String.class);
		return mailList.isEmpty()?defaultMail:mailList.get(0);
	}

}
