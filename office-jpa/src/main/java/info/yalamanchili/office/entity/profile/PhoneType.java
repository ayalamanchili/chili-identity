/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import info.chili.jpa.validation.Unique;
import info.yalamanchili.jpa.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Indexed
@XmlRootElement
@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"phoneType"}))
public class PhoneType extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 7L;

	/**
	 * @generated
	 */
	@Field
	@NotEmpty
        //@Unique(entity = Certification.class, property = "name", message="{PhoneType.already.exists}")
	protected String phoneType;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "phoneType")
	protected List<Phone> phones;

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
	@XmlTransient
	public List<Phone> getPhones() {
		if (this.phones == null) {
			this.phones = new ArrayList<Phone>();
		}
		return this.phones;
	}

	/**
	 * @generated
	 */
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	/**
	 * @generated
	 */
	public void addPhone(Phone entity) {
		if (entity == null) {
			return;
		}
		getPhones().add(entity);
		entity.setPhoneType(this);
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
