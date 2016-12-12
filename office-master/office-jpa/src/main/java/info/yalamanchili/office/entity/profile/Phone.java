/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
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
public class Phone extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 6L;
    /**
     * @generated
     */
    @Size(min = 10, max = 10, message = "{phone.phoneNumber.length.invalid.msg}")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "{invalid.phonenumber.format}")
    @NotEmpty(message = "{phone.phoneNumber.not.empty.msg}")
    @Field
    @org.hibernate.annotations.Index(name = "PHN_NO")
    protected String phoneNumber;
    /**
     * @generated
     */
    @Size(min = 0, max = 5, message = "{phone.extension.length.invalid.msg}")
    @Field
    protected String extension;
    /**
     * @generated
     */
    @Size(min = 0, max = 4, message = "{phone.countryCode.length.invalid.msg}")
    @Field
    protected String countryCode;
    /**
     * @generated
     */
    @ManyToOne
    @ForeignKey(name = "FK_PhoneType_Phones")
    protected PhoneType phoneType;
    /**
     * @generated
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Contact_Phones")
    protected Contact contact;

    /**
     * @generated
     */
    public Phone() {
        super();
    }

    /**
     * @generated
     */
    @org.hibernate.annotations.Index(name = "PHN_NM")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @generated
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @generated
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @generated
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @generated
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @generated
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @generated
     */
    @XmlElement
    public PhoneType getPhoneType() {
        return this.phoneType;
    }

    /**
     * @generated
     */
    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
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

    @Override
    public String toString() {
        return "Phone{" + "phoneNumber=" + phoneNumber + ", extension=" + extension + ", countryCode=" + countryCode + ", phoneType=" + phoneType + ", contact=" + contact + '}';
    }
}
