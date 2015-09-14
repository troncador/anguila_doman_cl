package cl.doman.mmedio.db.table;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-08-22T01:24:30.892-0400")
@StaticMetamodel(ContactPerson.class)
public class ContactPerson_ {
	public static volatile SingularAttribute<ContactPerson, Integer> id;
	public static volatile SingularAttribute<ContactPerson, String> country;
	public static volatile SingularAttribute<ContactPerson, String> mail;
	public static volatile SingularAttribute<ContactPerson, ContactArea> contactArea;
}
