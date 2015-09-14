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
import cl.doman.db.query.dao.PrepareQuery;
import cl.doman.db.query.dao.PrepareQueryAdapter;
import cl.doman.mmedio.db.table.ContactArea;
import cl.doman.mmedio.db.table.ContactMessage;
import cl.doman.mmedio.db.table.ContactMessage_;
import cl.doman.mmedio.db.table.ContactPerson;

public class ContactMessageQuery extends EntityDaoCriteria<ContactMessage, Integer> implements Existance<ContactMessage,Integer>{
	public static final long serialVersionUID = 1L;
	static Logger log =LoggerFactory.getLogger(ContactMessageQuery.class);
	public ContactMessageQuery() {
		super(ContactMessage.class);
	}

	

	public Integer convert(String id) throws ConvertException {
		try{
			return Integer.parseInt(id);
		} catch (NumberFormatException  e){
			throw new ConvertException();
		}
	}

	@Override
	public SingularAttribute<? super ContactMessage, Integer> getPK() {
		return ContactMessage_.id;
	}

}
