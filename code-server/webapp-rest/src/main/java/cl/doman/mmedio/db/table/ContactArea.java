package cl.doman.mmedio.db.table;

import java.io.Serializable;

import javax.persistence.*;

import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.db.model.table.StandardTable;

import java.util.List;


/**
 * The persistent class for the contact_area database table.
 * 
 */
@Entity
@Table(name="contact_area")
public class ContactArea  extends StandardTable implements Serializable , cl.doman.db.model.table.BaseTable<Integer>{
	private static final long serialVersionUID = 1L;

	public static ContactArea ALL = null;

	static public void init() throws SystemInitializatorException{
		try {
			ALL = ContactArea.getContactArea(0);
		} catch (QueryException e) {
			throw new SystemInitializatorException(e.getMessage(),e);
		}
		
	}
	static public ContactArea getContactArea(int id) throws QueryException{
		StandardQuery<ContactArea> query = new StandardQuery<ContactArea>(ContactArea.class);
		return query.get(id);
	}
	
	@Id
	public Integer getId() {
		return this.id;
	}

	@Column(nullable=false, length=40)
	private String name;

	//bi-directional many-to-one association to ContactPerson
	@OneToMany(mappedBy="contactArea")
	private List<ContactPerson> contactPersons;

	public ContactArea() {
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ContactPerson> getContactPersons() {
		return this.contactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	

}