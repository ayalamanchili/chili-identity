/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.validation.Unique;
import info.chili.jpa.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"emailType"}))
@Unique(entity = EmailType.class, fields = {"emailType"}, message = "{emailtype.name.not.unique.msg}")
public class EmailType extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 9L;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{emailType.not.empty.msg}")
    protected String emailType;

    /**
     * @generated
     */
    public EmailType() {
        super();
    }

    /**
     * @generated
     */
    public String getEmailType() {
        return emailType;
    }

    /**
     * @generated
     */
    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    @Override
    public String toString() {
        return "EmailType{" + "emailType=" + emailType + '}';
    }
}
