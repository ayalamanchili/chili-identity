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
public class Address extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 4L;

	/**
	 * @generated
	 */
	protected String street1;

	/**
	 * @generated
	 */
	protected String street2;

	/**
	 * @generated
	 */
	protected String city;

	/**
	 * @generated
	 */
	protected String state;

	/**
	 * @generated
	 */
	protected String country;

	/**
	 * @generated
	 */
	protected String zip;

	/**
	 * @generated
	 */

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Contact contact;

	/**
	 * @generated
	 */

	@ManyToOne
	protected AddressType addressType;

	/**
	 * @generated
	 */
	public Address() {
		super();
	}

	/**
	 * @generated
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * @generated
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * @generated
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * @generated
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @generated
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @generated
	 */
	public String getState() {
		return state;
	}

	/**
	 * @generated
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @generated
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @generated
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @generated
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @generated
	 */
	public void setZip(String zip) {
		this.zip = zip;
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
	@XmlElement
	public AddressType getAddressType() {
		return this.addressType;
	}

	/**
	 * @generated
	 */
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getStreet1());
		sb.append(":");
		sb.append(getStreet2());
		sb.append(":");
		sb.append(getCity());
		sb.append(":");
		sb.append(getState());
		sb.append(":");
		sb.append(getCountry());
		sb.append(":");
		sb.append(getZip());
		sb.append(":");
		return sb.toString();
	}

}
