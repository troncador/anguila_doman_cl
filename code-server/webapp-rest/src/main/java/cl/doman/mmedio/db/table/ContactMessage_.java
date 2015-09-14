package cl.doman.mmedio.db.table;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;
import cl.doman.mmedio.db.field.BooleanType;

@Generated(value="Dali", date="2013-09-02T03:31:10.341-0400")
@StaticMetamodel(ContactMessage.class)
public class ContactMessage_ extends StandardTable_{
	public static volatile SingularAttribute<ContactMessage, Country> country;
	public static volatile SingularAttribute<ContactMessage, Date> date;
	public static volatile SingularAttribute<ContactMessage, String> email;
	public static volatile SingularAttribute<ContactMessage, ContactArea> contactArea;
	public static volatile SingularAttribute<ContactMessage, String> lastname;
	public static volatile SingularAttribute<ContactMessage, String> message;
	public static volatile SingularAttribute<ContactMessage, String> name;
	public static volatile SingularAttribute<ContactMessage, String> phone;
	public static volatile SingularAttribute<ContactMessage, BooleanType> send;
}
