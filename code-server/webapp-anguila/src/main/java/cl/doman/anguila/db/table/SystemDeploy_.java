package cl.doman.anguila.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2015-09-19T02:21:34.574-0300")
@StaticMetamodel(SystemDeploy.class)
public class SystemDeploy_ extends StandardTable_{
	public static volatile SingularAttribute<SystemDeploy, Date> shutdown;
	public static volatile SingularAttribute<SystemDeploy, Date> startup;
	public static volatile SingularAttribute<SystemDeploy, String> version;
}
