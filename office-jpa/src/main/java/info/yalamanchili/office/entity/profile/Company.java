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
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@XmlRootElement
@Entity
public class Company extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	protected String name;

	/**
	 * @generated
	 */
	protected Date establishedDate;

	/**
	 * @generated
	 */
	protected String logoURL;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "company", cascade = CascadeType.MERGE)
	protected List<Employee> employees;

	/**
	 * @generated
	 */
	public Company() {
		super();
	}

	/**
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * @generated
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @generated
	 */
	public Date getEstablishedDate() {
		return establishedDate;
	}

	/**
	 * @generated
	 */
	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	/**
	 * @generated
	 */
	public String getLogoURL() {
		return logoURL;
	}

	/**
	 * @generated
	 */
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	/**
	 * @generated
	 */
	@XmlTransient
	public List<Employee> getEmployees() {
		if (this.employees == null) {
			this.employees = new ArrayList<Employee>();
		}
		return this.employees;
	}

	/**
	 * @generated
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * @generated
	 */
	public void addEmployee(Employee entity) {
		if (entity == null) {
			return;
		}
		getEmployees().add(entity);
		entity.setCompany(this);
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(":");
		return sb.toString();
	}

}
