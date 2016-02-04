package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends StandardTable implements Serializable, BaseTable<Integer> {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "uid")
  @TableGenerator(
    name="TABLE_GEN_USER",
    table="table_generator", 
    pkColumnName = "SEQ_NAME", 
    pkColumnValue = "uid", 
    valueColumnName = "SEQ_COUNT", 
    allocationSize = 1,
    initialValue = 100
  )
  @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN_USER")
  public Integer getId() {
      return this.id;
  }

  public String toString(){
    return String.format("%d %s: %s", getId(), getUsername(), isDeleted?"deleted":"no deleted");
  }
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date creation;

  private boolean isConfirmed;

  private boolean isDeleted;

  private boolean isSuspended;

  private String password;

  private String username;

  private User user;

  private List<User> users;

  private UserGroup group;

  private UserLoginAttempt userLoginAttempt;

  private UserPassRestore userPassRestore;

    public User() {
    }

    public Date getCreation() {
        return this.creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    @Column(name="is_confirmed")
    public boolean getIsConfirmed() {
        return this.isConfirmed;
    }

    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Column(name="is_deleted")
    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name="is_suspended")
    public boolean getIsSuspended() {
        return this.isSuspended;
    }

    public void setIsSuspended(boolean isSuspended) {
        this.isSuspended = isSuspended;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="parent_uid")
  public User getUser() {
      return this.user;
  }

  public void setUser(User user) {
      this.user = user;
  }

    //bi-directional many-to-one association to User
    @OneToMany(mappedBy="user")
  public List<User> getUsers() {
      return this.users;
  }

  public void setUsers(List<User> users) {
      this.users = users;
  }

  public User addUser(User user) {
      getUsers().add(user);
      user.setUser(this);

      return user;
  }

  public User removeUser(User user) {
      getUsers().remove(user);
      user.setUser(null);

      return user;
  }

    //bi-directional many-to-one association to Group
    @ManyToOne
    @JoinColumn(name="gid")
  public UserGroup getGroup() {
      return this.group;
  }

  public void setGroup(UserGroup group) {
      this.group = group;
  }

    //bi-directional one-to-one association to UserLoginAttempt
    @OneToOne(mappedBy="user")
  public UserLoginAttempt getUserLoginAttempt() {
      return this.userLoginAttempt;
  }

  public void setUserLoginAttempt(UserLoginAttempt userLoginAttempt) {
      this.userLoginAttempt = userLoginAttempt;
  }

  //bi-directional one-to-one association to UserLoginAttempt
    @OneToOne(mappedBy="user")
  public UserPassRestore getUserPassRestore() {
      return this.userPassRestore;
  }

  public void setUserPassRestore(UserPassRestore userPassRestore) {
      this.userPassRestore = userPassRestore;
  }
}