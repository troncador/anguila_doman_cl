package cl.doman.mmedio.db.table;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.mmedio.db.field.BooleanType;

@Generated(value="Dali", date="2013-12-16T23:59:14.722-0300")
@StaticMetamodel(Curriculum.class)
public class Curriculum_ {
	public static volatile SingularAttribute<Curriculum, Integer> id;
	public static volatile SingularAttribute<Curriculum, Country> country;
	public static volatile SingularAttribute<Curriculum, byte[]> curriculum;
	public static volatile SingularAttribute<Curriculum, String> curriculumExtension;
	public static volatile SingularAttribute<Curriculum, Date> date;
	public static volatile SingularAttribute<Curriculum, String> email;
	public static volatile SingularAttribute<Curriculum, String> lastname;
	public static volatile SingularAttribute<Curriculum, String> message;
	public static volatile SingularAttribute<Curriculum, String> name;
	public static volatile SingularAttribute<Curriculum, String> phone;
	public static volatile SingularAttribute<Curriculum, BooleanType> send;
}
