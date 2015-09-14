package cl.doman.mmedio.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-08-22T01:24:30.865-0400")
@StaticMetamodel(Blog.class)
public class Blog_ {
	public static volatile SingularAttribute<Blog, Integer> id;
	public static volatile SingularAttribute<Blog, Date> date;
	public static volatile SingularAttribute<Blog, String> text;
	public static volatile SingularAttribute<Blog, String> title;
}
