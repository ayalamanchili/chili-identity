/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import info.chili.spring.SpringContext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.validator.constraints.NotEmpty;
import org.jasypt.digest.StringDigester;
import org.jasypt.hibernate.type.EncryptedStringType;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class,
        parameters = {
            @Parameter(name = "encryptorRegisteredName", value = "hibernateStringEncryptor")
        })
@XmlRootElement
@Entity
@Audited
public class Email extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 8L;
    /**
     * @NOT generated
     */
    @org.hibernate.validator.constraints.Email(message = "Enter a valid email asddress")
    // @Unique(entity = Email.class, property = "email", message="{email.not.unique.msg}")
    @NotEmpty(message = "{email.not.empty.msg}")
    @Type(type = "encryptedString")
    @org.hibernate.annotations.Index(name = "EMAIL_ADDRESS_IDX")
    protected String email;
    /*
     * email hashed used for querying data
     */
    @org.hibernate.annotations.Index(name = "EMAIL_ADDRESS_HASH_IDX")
    protected String emailHash;
    /**
     * @generated
     */
    @NotNull
    @Field(index = Index.UN_TOKENIZED)
    @org.hibernate.annotations.Index(name = "EMAIL_PRI_IDX")
    protected Boolean primaryEmail;
    /**
     * @generated
     */
    @ManyToOne
    @ForeignKey(name = "FK_EmailType_Emails")
    protected EmailType emailType;
    /**
     * @generated
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Contact_Emails")
    protected Contact contact;

    /**
     * @generated
     */
    public Email() {
        super();
    }

    /**
     * @generated
     */
    @org.hibernate.annotations.Index(name = "EMAIL_ADDRESS")
    public String getEmail() {
        return email;
    }

    /**
     * @generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public String getEmailHash() {
        return emailHash;
    }

    public void setEmailHash(String emailHash) {
        this.emailHash = emailHash;
    }

    /**
     * @generated
     */
    public Boolean getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * @generated
     */
    public void setPrimaryEmail(Boolean primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * @generated
     */
    @XmlElement
    public EmailType getEmailType() {
        return this.emailType;
    }

    /**
     * @generated
     */
    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
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

    @PrePersist
    @PreUpdate
    protected void setHash() {
        StringDigester officeStringDigester = (StringDigester) SpringContext.getBean("officeStringDigester");
        this.emailHash = officeStringDigester.digest(this.email);
    }

    @Override
    public String toString() {
        return "Email{" + "email=" + email + ", primaryEmail=" + primaryEmail + ", emailType=" + emailType + ", contact=" + contact + '}';
    }
}
