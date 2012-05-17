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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@XmlRootElement
@Entity
public class EmergencyContact extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 12L;

	/**
	 * @generated
	 */
	protected String relation;

	/**
	 * @generated
	 */
	protected Boolean primary;

	/**
	 * @generated
	 */

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Employee employee;

	/**
	 * @generated
	 */

	@ManyToOne
	protected Contact contact;

	/**
	 * @generated
	 */
	public EmergencyContact() {
		super();
	}

	/**
	 * @generated
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * @generated
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	 * @generated
	 */
	public Boolean getPrimary() {
		return primary;
	}

	/**
	 * @generated
	 */
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public Employee getEmployee() {
		return this.employee;
	}

	/**
	 * @generated
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
		sb.append(getRelation());
		sb.append(":");
		return sb.toString();
	}

}
