package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.util.Date;


/**
 * The persistent class for the user_login_attempt database table.
 * 
 */
@Entity
@Table(name="user_login_attempt")
@NamedQuery(name="UserLoginAttempt.findAll", query="SELECT u FROM UserLoginAttempt u")
public class UserLoginAttempt extends StandardTable implements Serializable, BaseTable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid")
    public Integer getId() {
        return this.id;
    }

    private int attempt;

    private Date creation;

    private Date modification;


    private User user;

    public UserLoginAttempt() {
    }

    public int getAttempt() {
        return this.attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreation() {
        return this.creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getModification() {
        return this.modification;
    }

    public void setModification(Date modification) {
        this.modification = modification;
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