package cl.doman.anguila.db.query;

import javax.persistence.metamodel.SingularAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.db.table.SystemConfig;
import cl.doman.anguila.db.table.SystemConfig_;
import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.query.dao.EntityDaoCriteria;

public class SystemQuery extends EntityDaoCriteria<SystemConfig,Integer> implements Existance<SystemConfig,Integer>{
	static Logger log = LoggerFactory.getLogger(UserQuery.class);

	@Override
	public SingularAttribute<? super SystemConfig, Integer> getPK() {
		return SystemConfig_.id;
	}
	
	public SystemQuery(){
		super(SystemConfig.class);
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
