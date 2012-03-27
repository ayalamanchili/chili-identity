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
public class Email extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 8L;

	/**
	 * @generated
	 */
	protected String email;

	/**
	 * @generated
	 */

	@OneToOne(cascade = CascadeType.ALL)
	protected EmailType emailType;

	/**
	 * @generated
	 */

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Contact contact;

	/**
	 * @generated
	 */
	public Email() {
		super();
	}

	/**
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @generated
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public EmailType getEmailType() {
		return this.emailType;
	}

	/**
	 * @generated
	 */
	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
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
		sb.append(getEmail());
		sb.append(":");
		return sb.toString();
	}

}
