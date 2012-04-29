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

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@XmlRootElement
@Entity
public class AddressType extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 10L;

	/**
	 * @generated
	 */
	protected String addressType;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "addressType")
	protected List<Address> addresss;

	/**
	 * @generated
	 */
	public AddressType() {
		super();
	}

	/**
	 * @generated
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * @generated
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * @generated
	 */
	@XmlTransient
	public List<Address> getAddresss() {
		if (this.addresss == null) {
			this.addresss = new ArrayList<Address>();
		}
		return this.addresss;
	}

	/**
	 * @generated
	 */
	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}

	/**
	 * @generated
	 */
	public void addAddress(Address entity) {
		if (entity == null) {
			return;
		}
		getAddresss().add(entity);
		entity.setAddressType(this);
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getAddressType());
		sb.append(":");
		return sb.toString();
	}

}
