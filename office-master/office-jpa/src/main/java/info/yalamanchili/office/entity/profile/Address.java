/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

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
@Audited
public class Address extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 4L;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{address.street1.not.empty.msg}")
    protected String street1;
    /**
     * @generated
     */
    @Field
    protected String street2;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{address.city.not.empty.msg}")
    protected String city;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{address.state.not.empty.msg}")
    protected String state;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{address.country.not.empty.msg}")
    protected String country;
    /**
     * @generated
     */
    @Size(min = 5, max = 10, message = "{address.zip.length.invalid.msg}")
    @Field
//    @NotEmpty(message = "{address.zip.not.empty.msg}")
    protected String zip;
    /**
     * @generated
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Contact_Addresses")
    protected Contact contact;
    /**
     * @generated
     */
    @ManyToOne
    @ForeignKey(name = "FK_AddressType_Addresses")
    protected AddressType addressType;

    /**
     * @generated
     */
    @Transient
    protected boolean notifyChange;
    /**
     * @generated
     */
    @Transient
    protected boolean notifyHealthInsurance;
    /**
     *
     */
    @Transient
    protected String changeNotes;

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

    public boolean isNotifyChange() {
        return notifyChange;
    }

    public void setNotifyChange(boolean notifyChange) {
        this.notifyChange = notifyChange;
    }

    public boolean isNotifyHealthInsurance() {
        return notifyHealthInsurance;
    }

    public void setNotifyHealthInsurance(boolean notifyHealthInsurance) {
        this.notifyHealthInsurance = notifyHealthInsurance;
    }

    public String getChangeNotes() {
        return changeNotes;
    }

    public void setChangeNotes(String changeNotes) {
        this.changeNotes = changeNotes;
    }

    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("\n");
        if (this.getAddressType() != null) {
            description.append("Address Type   :").append(this.getAddressType().getAddressType()).append("\n");
        }
        description.append("Street1        :").append(this.getStreet1()).append("\n");
        description.append("Street2        :").append(this.getStreet2()).append("\n");
        description.append("City           :").append(this.getCity()).append("\n");
        description.append("Country        :").append(this.getCountry()).append("\n");
        if (this.getZip() != null) {
            description.append("Zip            :").append(this.getZip()).append("\n");
        }
        return description.toString();
    }
    /**
     * needed for adderss read access check
     */
//    @Transient
//    protected Employee employee;
//
//    /**
//     *
//     * @return
//     */
//    public Employee getEmployee() {
//        Employee emp = new Employee();
//        emp.setId(getContact().getId());
//        return emp;
//    }

    @Override
    public String toString() {
        return "Address{" + "street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip + ", contact=" + contact + ", addressType=" + addressType + '}';
    }
}
