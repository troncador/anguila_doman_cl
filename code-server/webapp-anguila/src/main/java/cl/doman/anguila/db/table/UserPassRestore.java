package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.util.Date;


/**
 * The persistent class for the user_pass_restore database table.
 * 
 */
@Entity
@Table(name="user_pass_restore")
@NamedQuery(name="UserPassRestore.findAll", query="SELECT u FROM UserPassRestore u")
public class UserPassRestore extends StandardTable implements Serializable, BaseTable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid")
    public Integer getId() {
        return this.id;
    }

    private Date creation;

    private String password;

    private User user;

    public UserPassRestore() {
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreation() {
        return this.creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //bi-directional one-to-one association to User
    @OneToOne
    @JoinColumn(name="uid",insertable=false, updatable=false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}