package cl.doman.anguila.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2015-09-19T02:21:34.572-0300")
@StaticMetamodel(UserGroup.class)
public class UserGroup_ extends StandardTable_{
	public static volatile SingularAttribute<UserGroup, Date> creation;
	public static volatile SingularAttribute<UserGroup, String> description;
	public static volatile SingularAttribute<UserGroup, String> name;
	public static volatile ListAttribute<UserGroup, FileUpload> fileUploads;
	public static volatile ListAttribute<UserGroup, User> users;
}
