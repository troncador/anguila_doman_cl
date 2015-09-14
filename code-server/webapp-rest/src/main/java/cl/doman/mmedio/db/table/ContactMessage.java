package cl.doman.mmedio.db.table;

import java.io.Serializable;

import javax.persistence.*;

import cl.doman.db.model.table.StandardTable;
import cl.doman.mmedio.db.field.BooleanType;

import java.util.Date;


/**
 * The persistent class for the contact_message database table.
 * 
 */
@Entity
@Table(name="contact_message")
public class ContactMessage extends StandardTable implements Serializable, cl.doman.db.model.table.BaseTable<Integer>  {
	private static final long serialVersionUID = 1L;

	public String getFullName(){
		return name+" "+lastname;
	}
	
	
	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="id_country", nullable=false)
	private Country country;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, length=100)
	private String email;

	@ManyToOne
	@JoinColumn(name="id_contact_area", nullable=false)
	private ContactArea contactArea;

	@Column(nullable=false, length=90)
	private String lastname;

	@Column(nullable=false, length=400)
	private String message;

	@Column(nullable=false, length=90)
	private String name;

	@Column(nullable=false, length=30)
	private String phone;

	@Column(name="send",nullable=false)
	@Enumerated(EnumType.STRING)
	private BooleanType send;

	public ContactMessage() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ContactArea getContactArea() {
		return this.contactArea;
	}

	public void setContactArea(ContactArea contactArea) {
		this.contactArea = contactArea;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BooleanType getSend() {
		return this.send;
	}

	public void setSend(BooleanType send) {
		this.send = send;
	}

}