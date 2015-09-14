package cl.doman.mmedio.db.query;

import javax.persistence.metamodel.SingularAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.mmedio.db.table.Curriculum;
import cl.doman.mmedio.db.table.Curriculum_;

public class CurriculumQuery extends EntityDaoCriteria<Curriculum, Integer> implements Existance<Curriculum,Integer>{
	static Logger log =LoggerFactory.getLogger(CurriculumQuery.class);
	public CurriculumQuery() {
		super(Curriculum.class);
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
	public SingularAttribute<Curriculum, Integer> getPK() {
		return Curriculum_.id;
	}

}
