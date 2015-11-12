package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.util.Date;


/**
 * The persistent class for the file_upload_access database table.
 * 
 */
@Entity
@Table(name="file_upload_access")
@NamedQuery(name="FileUploadAccess.findAll", query="SELECT f FROM FileUploadAccess f")
public class FileUploadAccess extends StandardTable implements Serializable, BaseTable<Integer>{
	private static final long serialVersionUID = 1L;

	@Id
	public Integer getId() {
		return this.id;
	}

	private Date creation;

	private String password;

	private byte used;

	private FileUpload fileUpload;

	public FileUploadAccess() {
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

	public byte getUsed() {
		return this.used;
	}

	public void setUsed(byte used) {
		this.used = used;
	}

	//bi-directional many-to-one association to FileUpload
    @ManyToOne
    @JoinColumn(name="fid")
	public FileUpload getFileUpload() {
		return this.fileUpload;
	}

	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
}