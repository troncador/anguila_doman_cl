package cl.doman.anguila.db.table;

import java.io.Serializable;
import javax.persistence.*;

import cl.doman.db.model.table.BaseTable;
import cl.doman.db.model.table.StandardTable;

import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the file_upload database table.
 * 
 */
@Entity
@Table(name="file_upload")
@NamedQuery(name="FileUpload.findAll", query="SELECT f FROM FileUpload f")
public class FileUpload extends StandardTable implements Serializable, BaseTable<Integer> {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "fid")
	public Integer getId() {
		return this.id;
	}

	private byte[] description;

	private int fileStateId;

	private String name;

	private String path;

	private BigInteger weight;

	private UserGroup group;

	private List<FileUploadAccess> fileUploadAccesses;

	public FileUpload() {
	}
    @Lob
	public byte[] getDescription() {
		return this.description;
	}

	public void setDescription(byte[] description) {
		this.description = description;
	}
	
	@Column(name="file_state_id")
	public int getFileStateId() {
		return this.fileStateId;
	}

	public void setFileStateId(int fileStateId) {
		this.fileStateId = fileStateId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public BigInteger getWeight() {
		return this.weight;
	}

	public void setWeight(BigInteger weight) {
		this.weight = weight;
	}

	//bi-directional many-to-one association to Group
    @ManyToOne
    @JoinColumn(name="gid")
	public UserGroup getGroup() {
		return this.group;
	}

	public void setGroup(UserGroup group) {
		this.group = group;
	}

	//bi-directional many-to-one association to FileUploadAccess
    @OneToMany(mappedBy="fileUpload")
	public List<FileUploadAccess> getFileUploadAccesses() {
		return this.fileUploadAccesses;
	}

	public void setFileUploadAccesses(List<FileUploadAccess> fileUploadAccesses) {
		this.fileUploadAccesses = fileUploadAccesses;
	}

	public FileUploadAccess addFileUploadAccess(FileUploadAccess fileUploadAccess) {
		getFileUploadAccesses().add(fileUploadAccess);
		fileUploadAccess.setFileUpload(this);

		return fileUploadAccess;
	}

	public FileUploadAccess removeFileUploadAccess(FileUploadAccess fileUploadAccess) {
		getFileUploadAccesses().remove(fileUploadAccess);
		fileUploadAccess.setFileUpload(null);

		return fileUploadAccess;
	}

}