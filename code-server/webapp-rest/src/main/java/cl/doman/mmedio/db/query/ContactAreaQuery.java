package cl.doman.mmedio.db.query;

import javax.persistence.metamodel.SingularAttribute;

import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.mmedio.db.table.ContactArea;
import cl.doman.mmedio.db.table.ContactArea_;

public class ContactAreaQuery extends EntityDaoCriteria<ContactArea, Integer> implements Existance<ContactArea,Integer>{
	public static final long serialVersionUID = 1L;
	public ContactAreaQuery() {
		super(ContactArea.class);
	}

	
	@Override
	public Integer convert(String id) throws ConvertException {
		try{
			return Integer.parseInt(id);
		} catch (NumberFormatException  e){
			return 0;//throw new ConvertException();
		}
	}

	@Override
	public SingularAttribute<? super ContactArea, Integer> getPK() {
		return ContactArea_.id;
	}

}
