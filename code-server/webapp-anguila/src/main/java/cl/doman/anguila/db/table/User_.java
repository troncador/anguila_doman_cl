package cl.doman.anguila.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2015-09-19T02:21:34.575-0300")
@StaticMetamodel(User.class)
public class User_ extends StandardTable_{
    public static volatile SingularAttribute<User, Date> creation;
    public static volatile SingularAttribute<User, Byte> isConfirmed;
    public static volatile SingularAttribute<User, Byte> isDeleted;
    public static volatile SingularAttribute<User, Byte> isSuspended;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> username;
//  public static volatile SingularAttribute<User, User> user;
//  public static volatile ListAttribute<User, User> users;
//  public static volatile SingularAttribute<User, UserGroup> group;
//  public static volatile SingularAttribute<User, UserLoginAttempt> userLoginAttempt;
//  public static volatile SingularAttribute<User, UserPassRestore> userPassRestore;
}
