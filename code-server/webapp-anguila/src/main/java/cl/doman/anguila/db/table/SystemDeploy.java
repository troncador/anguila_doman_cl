package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.util.Date;


/**
 * The persistent class for the system_deploy database table.
 * 
 */
@Entity
@Table(name="system_deploy")
@NamedQuery(name="SystemDeploy.findAll", query="SELECT s FROM SystemDeploy s")
public class SystemDeploy extends StandardTable implements Serializable, BaseTable<Integer>  {
	private static final long serialVersionUID = 1L;

	@Id
	public Integer getId() {
		return this.id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date shutdown;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startup;

	private String version;

	public SystemDeploy() {
	}

	public Date getShutdown() {
		return this.shutdown;
	}

	public void setShutdown(Date shutdown) {
		this.shutdown = shutdown;
	}

	public Date getStartup() {
		return this.startup;
	}

	public void setStartup(Date startup) {
		this.startup = startup;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}