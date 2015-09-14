package cl.doman.mmedio.db.table;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contact_person database table.
 * 
 */
@Entity
@Table(name="contact_person")
public class ContactPerson implements Serializable, cl.doman.db.model.table.BaseTable<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@ManyToOne
	@JoinColumn(name="id_country", nullable=false)
	private Country country;

	@Column(nullable=false, length=80)
	private String mail;

	//bi-directional many-to-one association to ContactArea
	@ManyToOne
	@JoinColumn(name="id_contact_area", nullable=false)
	private ContactArea contactArea;

	public ContactPerson() {
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

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ContactArea getContactArea() {
		return this.contactArea;
	}

	public void setContactArea(ContactArea contactArea) {
		this.contactArea = contactArea;
	}

}