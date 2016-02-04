package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@Table(name="user_group")
@NamedQuery(name="UserGroup.findAll", query="SELECT g FROM UserGroup g")
public class UserGroup extends StandardTable implements Serializable, BaseTable<Integer>{
    private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "gid")
  @TableGenerator(
    name="TABLE_GEN_USER_GROUP",
    table="table_generator", 
    pkColumnName = "SEQ_NAME", 
    pkColumnValue = "gid", 
    valueColumnName = "SEQ_COUNT", 
    allocationSize = 1,
    initialValue = 100
  )
  @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN_USER_GROUP")
    public Integer getId() {
        return this.id;
    }

    private Date creation;

    private String description;

    private String name;

    private List<FileUpload> fileUploads;

    private List<User> users;

    public UserGroup() {
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreation() {
        return this.creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //bi-directional many-to-one association to FileUpload
    @OneToMany(mappedBy="group")
    public List<FileUpload> getFileUploads() {
        return this.fileUploads;
    }

    public void setFileUploads(List<FileUpload> fileUploads) {
        this.fileUploads = fileUploads;
    }

    public FileUpload addFileUpload(FileUpload fileUpload) {
        getFileUploads().add(fileUpload);
        fileUpload.setGroup(this);

        return fileUpload;
    }

    public FileUpload removeFileUpload(FileUpload fileUpload) {
        getFileUploads().remove(fileUpload);
        fileUpload.setGroup(null);

        return fileUpload;
    }

//  //bi-directional many-to-one association to User
    @OneToMany(mappedBy="group")
  public List<User> getUsers() {
      return this.users;
  }

    public void setUsers(List<User> users) {
        this.users = users;
    }

  public User addUser(User user) {
      getUsers().add(user);
      user.setGroup(this);

      return user;
  }

  public User removeUser(User user) {
      getUsers().remove(user);
      user.setGroup(null);

      return user;
  }

}