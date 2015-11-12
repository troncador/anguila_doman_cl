package cl.doman.anguila.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2015-09-19T02:21:34.575-0300")
@StaticMetamodel(UserSession.class)
public class UserSession_{
	public static volatile SingularAttribute<UserSession, Date> startTimestamp;
	public static volatile SingularAttribute<UserSession, Date> lastAccessTime;
	public static volatile SingularAttribute<UserSession, String> host;
	public static volatile SingularAttribute<UserSession, Long> timeout;
	public static volatile SingularAttribute<UserSession, String> agent;
	public static volatile SingularAttribute<UserSession, String> id;
	public static volatile SingularAttribute<UserSession, String> attributes;
}
