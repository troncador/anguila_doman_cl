package cl.doman.mmedio.db.table;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;
@Entity
@Table(name="admin")
public class Admin extends StandardTable implements Serializable ,BaseTable<Integer>{
	private static final long serialVersionUID = 1L;

	@Id
	public Integer getId() {
		return this.id;
	}

	private String username;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="id_status", nullable=false)
	private Status status;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
