package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;


/**
 * The persistent class for the system_config database table.
 * 
 */
@Entity
@Table(name="system_config")
@NamedQuery(name="SystemConfig.findAll", query="SELECT s FROM SystemConfig s")
public class SystemConfig extends StandardTable implements Serializable, BaseTable<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	public Integer getId() {
		return this.id;
	}
	
	private String name;

	private String value;

	public SystemConfig() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}