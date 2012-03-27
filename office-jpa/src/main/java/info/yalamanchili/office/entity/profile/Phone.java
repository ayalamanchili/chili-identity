/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import info.yalamanchili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
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
	protected String phoneNumber;

	/**
	 * @generated
	 */
	protected String extension;

	/**
	 * @generated
	 */

	@OneToOne(cascade = CascadeType.ALL)
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
		return sb.toString();
	}

}
