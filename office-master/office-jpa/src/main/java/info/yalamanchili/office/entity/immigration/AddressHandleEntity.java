/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractHandleEntity;
import info.yalamanchili.office.entity.profile.AddressType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class AddressHandleEntity extends AbstractHandleEntity{
   
    @Transient
    private static final long serialVersionUID = 4L;
   
    @Field
    @NotEmpty(message = "{address.street1.not.empty.msg}")
    protected String street1;
   
    @Field
    protected String street2;
    
    @Field
    @NotEmpty(message = "{address.city.not.empty.msg}")
    protected String city;
   
    @Field
    @NotEmpty(message = "{address.state.not.empty.msg}")
    protected String state;
    
    @Field
    @NotEmpty(message = "{address.country.not.empty.msg}")
    protected String country;
    
    @Size(min = 5, max = 10, message = "{address.zip.length.invalid.msg}")
    @Field
    protected String zip;
    
    /**
     * @generated
     */
    @ManyToOne
    @ForeignKey(name = "FK_AddressType_Addresses")
    protected AddressType addressType;
    
    protected Long phoneNumber;
    
    protected Long workPhone;
    
    protected Boolean isHomeAddress;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(Long workPhone) {
        this.workPhone = workPhone;
    }

    public Boolean getIsHomeAddress() {
        return isHomeAddress;
    }

    public void setIsHomeAddress(Boolean isHomeAddress) {
        this.isHomeAddress = isHomeAddress;
    }
}