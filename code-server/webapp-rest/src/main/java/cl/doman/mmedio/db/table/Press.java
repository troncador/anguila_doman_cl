package cl.doman.mmedio.db.table;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cl.doman.mmedio.db.field.BooleanType;
import cl.doman.mmedio.db.field.PressType;
//import org.eclipse.persistence.annotations.ObjectTypeConverter;
//import org.eclipse.persistence.annotations.ConversionValue;


/**
 * The persistent class for the press database table.
 * 
 */
@Entity
@Table(name="press")
public class Press implements Serializable, cl.doman.db.model.table.BaseTable<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="id_country", nullable=false)
	private Country country;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Enumerated(EnumType.STRING)
	private BooleanType external;

	@Column(nullable=false, length=100)
	private String image;

	@Column(nullable=false, length=400)
	private String resume;

	@Column(nullable=false, length=100)
	private String title;

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private PressType type;

	@Column(nullable=false, length=200)
	private String url;

	public Press() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BooleanType getExternal() {
		return this.external;
	}

	public void setExternal(BooleanType external) {
		this.external = external;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PressType getType() {
		return this.type;
	}

	public void setType(PressType type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}