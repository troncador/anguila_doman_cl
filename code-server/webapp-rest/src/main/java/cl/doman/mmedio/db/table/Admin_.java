package cl.doman.mmedio.db.table;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2013-08-22T01:24:30.865-0400")
@StaticMetamodel(Admin.class)
public class Admin_ extends StandardTable_{
	public static volatile SingularAttribute<Admin, String> username;
	public static volatile SingularAttribute<Admin, String> password;
	public static volatile SingularAttribute<Admin, Status> status;
}
