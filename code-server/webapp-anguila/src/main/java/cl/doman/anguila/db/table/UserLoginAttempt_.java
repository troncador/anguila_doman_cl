package cl.doman.anguila.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2015-09-19T02:21:34.576-0300")
@StaticMetamodel(UserLoginAttempt.class)
public class UserLoginAttempt_ extends StandardTable_{
	public static volatile SingularAttribute<UserLoginAttempt, Integer> attempt;
	public static volatile SingularAttribute<UserLoginAttempt, Date> creation;
	public static volatile SingularAttribute<UserLoginAttempt, Date> modification;
	public static volatile SingularAttribute<UserLoginAttempt, User> user;
}
