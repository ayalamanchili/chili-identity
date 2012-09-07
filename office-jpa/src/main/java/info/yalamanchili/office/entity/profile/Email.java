/**
 * Automanage Copyright (C) 2011 yalamanchili.info
 */
package info.yalamanchili.office.entity.profile;

import info.yalamanchili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
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
public class Email extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 8L;
    /**
     * @NOT generated
     */
    @org.hibernate.validator.constraints.Email
    // @Unique(entity = Email.class, property = "email", message="{email.not.unique.msg}")
    @NotEmpty(message = "{email.not.empty.msg}")
    protected String email;
    /**
     * @generated
     */
    @NotNull
    @Field(index = Index.UN_TOKENIZED)
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
    public String getEmail() {
        return email;
    }

    /**
     * @generated
     */
    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Email{" + "email=" + email + ", primaryEmail=" + primaryEmail + ", emailType=" + emailType + ", contact=" + contact + '}';
    }
}
