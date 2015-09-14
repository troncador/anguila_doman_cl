package cl.doman.mmedio.db.table;

import java.io.Serializable;

import javax.persistence.*;

import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.db.model.table.StandardTable;

import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
public class Status extends StandardTable implements cl.doman.db.model.table.BaseTable<Integer>,Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public Integer getId() {
		return this.id;
	}

	private String name;

	static public Status AVAILABLE;
	static public Status DELETED; 
	
	static public void init() throws SystemInitializatorException{
		try {
			AVAILABLE = Status.getStatus(1);
			DELETED = Status.getStatus(2);
		} catch (QueryException e) {
			throw new SystemInitializatorException(e.getMessage(),e);
		}
		
	}
	static public Status getStatus(int id) throws QueryException{
		StandardQuery<Status> query = new StandardQuery<Status>(Status.class);
		return query.get(id);
	}
	
	//bi-directional many-to-one association to ContactPerson
	@OneToMany(mappedBy="status")
	private List<Admin> adminList;
	
	
	public List<Admin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}