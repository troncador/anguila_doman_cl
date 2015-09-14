package cl.doman.mmedio.db.table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.db.model.table.StandardTable;


/**
 * The persistent class for the contact_country database table.
 * 
 */
@Entity
@Table(name="country")
public class Country extends StandardTable implements Serializable ,
		BaseTable<Integer> {
	private static final long serialVersionUID = 1L;

	static public Country ALL;
	
	static public void init() throws SystemInitializatorException{
		try {
			ALL = Country.getCountry(0);
		} catch (QueryException e) {
			throw new SystemInitializatorException(e.getMessage(),e);
		}
		
	}
	static public Country getCountry(int id) throws QueryException{
		StandardQuery<Country> query = new StandardQuery<Country>(Country.class);
		return query.get(id);
	}
	
	@Id
	public Integer getId() {
		return this.id;
	}
	@Column(name="safe_name",nullable=false, length=30)
	private String safeName;


	public String getSafeName() {
		return this.name;
	}

	public void setSafeName(String name) {
		this.safeName = name;
	}
	@Column(nullable=false, length=30)
	private String name;


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}