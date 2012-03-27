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
public class PhoneType extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 7L;

	/**
	 * @generated
	 */
	protected String phoneType;

	/**
	 * @generated
	 */

	@OneToOne(cascade = CascadeType.ALL)
	protected Phone phone;

	/**
	 * @generated
	 */
	public PhoneType() {
		super();
	}

	/**
	 * @generated
	 */
	public String getPhoneType() {
		return phoneType;
	}

	/**
	 * @generated
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public Phone getPhone() {
		return this.phone;
	}

	/**
	 * @generated
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getPhoneType());
		sb.append(":");
		return sb.toString();
	}

}
