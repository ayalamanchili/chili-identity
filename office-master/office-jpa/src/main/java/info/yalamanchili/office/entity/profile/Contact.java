/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import com.google.common.base.Strings;
import info.chili.jpa.AbstractEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlRootElement
@Entity
@Audited
@Indexed
//@Table(uniqueConstraints =@UniqueConstraint(columnNames = {"firstName", "lastName"}))
public class Contact extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 5L;
    /**
     * @generated
     */
    @NotEmpty(message = "{firstName.not.empty.msg}")
    @Field
    @org.hibernate.annotations.Index(name = "CNT_FST_NM")
    protected String firstName;
    /**
     * @generated
     */
    @NotEmpty(message = "{lastName.not.empty.msg}")
    @Field
    @org.hibernate.annotations.Index(name = "CNT_LST_NM")
    protected String lastName;
    /**
     * @generated
     */
    @Field
    protected String middleInitial;
    /**
     * @generated
     */
    @Past
    @Field(index = Index.UN_TOKENIZED)
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateOfBirth;
    /**
     * @generated
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected Sex sex;
    @Field
    protected String imageURL;
    /**
     * @generated
     */
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    protected List<Address> addresss;
    /**
     * @generated
     */
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    protected List<Email> emails;
    /**
     * @generated
     */
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    protected List<Phone> phones;

    /**
     * @generated
     */
    public Contact() {
        super();
    }

    /**
     * @generated
     */
    @org.hibernate.annotations.Index(name = "CNT_FST_NM")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @generated
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @generated
     */
    @org.hibernate.annotations.Index(name = "CNT_LST_NM")
    public String getLastName() {
        return lastName;
    }

    /**
     * @generated
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @generated
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * @generated
     */
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * @generated
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @generated
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @generated
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * @generated
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
        entity.setContact(this);
    }

    /**
     * @generated
     */
    @XmlTransient
    public List<Email> getEmails() {
        if (this.emails == null) {
            this.emails = new ArrayList<Email>();
        }
        return this.emails;
    }

    /**
     * @generated
     */
    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    /**
     * @generated
     */
    public void addEmail(Email entity) {
        if (entity == null) {
            return;
        }
        getEmails().add(entity);
        entity.setContact(this);
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
        entity.setContact(this);
    }
//replace with public String getPrimaryEmail(Employee emp) {

    @Transient
    public Email getPrimaryEmail() {
        //TODO use Query for better performance?
        Hibernate.initialize(this.getEmails());
        for (Email email : this.getEmails()) {
            if (email.getPrimaryEmail()) {
                return email;
            }
        }
        return null;
    }

    public String details() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.getFirstName()).append(" ").append(this.getLastName()).append("<br/>");
        for (Email email : this.getEmails()) {
            sb.append("Email: ").append(email.getEmail());
            sb.append("<br/>");
        }
        for (Phone p : this.getPhones()) {
            sb.append("Phone: ").append(p.getPhoneNumber());
            if (!Strings.isNullOrEmpty(p.getExtension())) {
                sb.append(" ext: ").append(p.getExtension());
            }
            sb.append("<br/>");
        }

        return sb.toString();
    }
    //TODO add helpers for getPrimary ReportsTo

    @Override
    public String toString() {
        return "Contact{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", imageURL=" + imageURL + '}';
    }
}
