/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import info.yalamanchili.jpa.AbstractEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlRootElement
@Entity
@Indexed
public class Contact extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 5L;

	/**
	 * @generated
	 */
	@NotEmpty
	@Field
	protected String firstName;

	/**
	 * @generated
	 */
	@NotEmpty
	@Field
	protected String lastName;

	/**
	 * @generated
	 */
	@Field
	protected String middleInitial;

	/**
	 * @generated
	 */
	@Past
	@Field(index = Index.UN_TOKENIZED)
	protected Date dateOfBirth;

	/**
	 * @generated
	 */
	@Enumerated(EnumType.STRING)
	@Field
	protected Sex sex;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	protected List<Address> addresss;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	protected List<Email> emails;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	protected List<Phone> phones;

	/**
	 * @generated
	 */
	public Contact() {
		super();
	}

	/**
	 * @generated
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @generated
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @generated
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @generated
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @generated
	 */
	public String getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * @generated
	 */
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	/**
	 * @generated
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @generated
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @generated
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * @generated
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * @generated
	 */
	@XmlTransient
	public List<Address> getAddresss() {
		if (this.addresss == null) {
			this.addresss = new ArrayList<Address>();
		}
		return this.addresss;
	}

	/**
	 * @generated
	 */
	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}

	/**
	 * @generated
	 */
	public void addAddress(Address entity) {
		if (entity == null) {
			return;
		}
		getAddresss().add(entity);
		entity.setContact(this);
	}

	/**
	 * @generated
	 */
	@XmlTransient
	public List<Email> getEmails() {
		if (this.emails == null) {
			this.emails = new ArrayList<Email>();
		}
		return this.emails;
	}

	/**
	 * @generated
	 */
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	/**
	 * @generated
	 */
	public void addEmail(Email entity) {
		if (entity == null) {
			return;
		}
		getEmails().add(entity);
		entity.setContact(this);
	}

	/**
	 * @generated
	 */
	@XmlTransient
	public List<Phone> getPhones() {
		if (this.phones == null) {
			this.phones = new ArrayList<Phone>();
		}
		return this.phones;
	}

	/**
	 * @generated
	 */
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	/**
	 * @generated
	 */
	public void addPhone(Phone entity) {
		if (entity == null) {
			return;
		}
		getPhones().add(entity);
		entity.setContact(this);
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getFirstName());
		sb.append(":");
		sb.append(getLastName());
		sb.append(":");
		sb.append(getMiddleInitial());
		sb.append(":");
		return sb.toString();
	}

}
