package cl.doman.mmedio.db.table;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable;
import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2013-08-22T01:24:30.877-0400")
@StaticMetamodel(ContactArea.class)
public class ContactArea_ extends StandardTable_{
	public static volatile SingularAttribute<ContactArea, String> name;
	public static volatile ListAttribute<ContactArea, ContactPerson> contactPersons;
}
