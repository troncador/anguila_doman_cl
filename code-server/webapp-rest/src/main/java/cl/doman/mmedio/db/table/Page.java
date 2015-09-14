package cl.doman.mmedio.db.table;

import java.io.Serializable;

import javax.persistence.*;

import cl.doman.base.Existance;


/**
 * The persistent class for the page database table.
 * 
 */
@Entity
@Table(name="page")
public class Page implements Serializable, cl.doman.db.model.table.BaseTable<String>{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getId() {
		return url;
	}

	@Override
	public void setId(String id) {
		this.url = id;
	}

	@Id
	private String url;

	private String file;

	public Page() {
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}



}