/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import info.yalamanchili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class EmailType extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 9L;

	/**
	 * @generated
	 */
	protected String emailType;

	/**
	 * @generated
	 */

	@OneToOne(cascade = CascadeType.ALL)
	protected Email email;

	/**
	 * @generated
	 */
	public EmailType() {
		super();
	}

	/**
	 * @generated
	 */
	public String getEmailType() {
		return emailType;
	}

	/**
	 * @generated
	 */
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public Email getEmail() {
		return this.email;
	}

	/**
	 * @generated
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getEmailType());
		sb.append(":");
		return sb.toString();
	}

}
