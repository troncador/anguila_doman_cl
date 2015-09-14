package cl.doman.mmedio.db.table;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the blog database table.
 * 
 */
@Entity
@Table(name="blog")
public class Blog implements Serializable, cl.doman.db.model.table.BaseTable<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Lob
	@Column(nullable=false)
	private String text;

	@Column(nullable=false, length=200)
	private String title;

	public Blog() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}