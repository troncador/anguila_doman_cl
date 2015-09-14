package cl.doman.mmedio.db.table;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.mmedio.db.field.BooleanType;
import cl.doman.mmedio.db.field.PressType;

@Generated(value="Dali", date="2013-08-28T01:07:56.832-0400")
@StaticMetamodel(Press.class)
public class Press_ {
	public static volatile SingularAttribute<Press, Integer> id;
	public static volatile SingularAttribute<Press, Country> country;
	public static volatile SingularAttribute<Press, Date> date;
	public static volatile SingularAttribute<Press, BooleanType> external;
	public static volatile SingularAttribute<Press, String> image;
	public static volatile SingularAttribute<Press, String> resume;
	public static volatile SingularAttribute<Press, String> title;
	public static volatile SingularAttribute<Press, PressType> type;
	public static volatile SingularAttribute<Press, String> url;
}
