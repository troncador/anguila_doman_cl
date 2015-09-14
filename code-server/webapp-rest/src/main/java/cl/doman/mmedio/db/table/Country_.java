package cl.doman.mmedio.db.table;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable;
import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2013-08-22T01:24:30.879-0400")
@StaticMetamodel(Country.class)
public class Country_ extends StandardTable_{
	public static volatile SingularAttribute<Country, String> name;
	public static volatile SingularAttribute<Country, String> safeName;
}
