package cl.doman.anguila.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2015-09-19T02:21:34.577-0300")
@StaticMetamodel(UserPassRestore.class)
public class UserPassRestore_ extends StandardTable_{
	public static volatile SingularAttribute<UserPassRestore, Date> creation;
	public static volatile SingularAttribute<UserPassRestore, String> password;
	public static volatile SingularAttribute<UserPassRestore, User> user;
}
