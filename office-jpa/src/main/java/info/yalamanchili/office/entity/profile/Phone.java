/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import info.yalamanchili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Indexed
@XmlRootElement
@Entity
public class Phone extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 6L;

	/**
	 * @generated
	 */
	@Size(min = 10, max = 10)
	@Field
	protected String phoneNumber;

	/**
	 * @generated
	 */
	@Field
	protected String extension;

	/**
	 * @generated
	 */
	@Field
	protected String countryCode;

	/**
	 * @generated
	 */

	@ManyToOne
	protected PhoneType phoneType;

	/**
	 * @generated
	 */

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Contact contact;

	/**
	 * @generated
	 */
	public Phone() {
		super();
	}

	/**
	 * @generated
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @generated
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @generated
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @generated
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @generated
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @generated
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public PhoneType getPhoneType() {
		return this.phoneType;
	}

	/**
	 * @generated
	 */
	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public Contact getContact() {
		return this.contact;
	}

	/**
	 * @generated
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getPhoneNumber());
		sb.append(":");
		sb.append(getExtension());
		sb.append(":");
		sb.append(getCountryCode());
		sb.append(":");
		return sb.toString();
	}

}
