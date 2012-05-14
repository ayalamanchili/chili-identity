/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import info.yalamanchili.jpa.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@XmlRootElement
@Entity
public class EmployeeType extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 3L;

	/**
	 * @generated
	 */
	@NotEmpty
	protected String employeeType;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "employeeType")
	protected List<Employee> employees;

	/**
	 * @generated
	 */
	public EmployeeType() {
		super();
	}

	/**
	 * @generated
	 */
	public String getEmployeeType() {
		return employeeType;
	}

	/**
	 * @generated
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
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
		entity.setEmployeeType(this);
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeType());
		sb.append(":");
		return sb.toString();
	}

}
