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
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@XmlRootElement
@Entity
public class ReportsTo extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 11L;

	/**
	 * @generated
	 */
	protected String reportsToRole;

	/**
	 * @generated
	 */
	protected Boolean rtPrimary;

	/**
	 * @generated
	 */

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Employee employee;

	/**
	 * @NOT generated
	 */

	@ManyToOne
	@Valid
	protected Contact contact;

	/**
	 * @generated
	 */
	public ReportsTo() {
		super();
	}

	/**
	 * @generated
	 */
	public String getReportsToRole() {
		return reportsToRole;
	}

	/**
	 * @generated
	 */
	public void setReportsToRole(String reportsToRole) {
		this.reportsToRole = reportsToRole;
	}

	/**
	 * @generated
	 */
	public Boolean getRtPrimary() {
		return rtPrimary;
	}

	/**
	 * @generated
	 */
	public void setRtPrimary(Boolean rtPrimary) {
		this.rtPrimary = rtPrimary;
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
		sb.append(getReportsToRole());
		sb.append(":");
		return sb.toString();
	}

}
