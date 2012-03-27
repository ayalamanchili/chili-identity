/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import java.util.Date;

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
public class Employee extends Contact {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 2L;

	/**
	 * @generated
	 */
	protected Date startDate;

	/**
	 * @generated
	 */
	protected String ssn;

	/**
	 * @generated
	 */

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Company company;

	/**
	 * @generated
	 */

	@OneToOne(cascade = CascadeType.ALL)
	protected EmployeeType employeeType;

	/**
	 * @generated
	 */
	public Employee() {
		super();
	}

	/**
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @generated
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @generated
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @generated
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public Company getCompany() {
		return this.company;
	}

	/**
	 * @generated
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @generated
	 */
	@XmlElement
	public EmployeeType getEmployeeType() {
		return this.employeeType;
	}

	/**
	 * @generated
	 */
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getSsn());
		sb.append(":");
		return sb.toString();
	}

}
