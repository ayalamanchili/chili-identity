/**
 * Automanage Copyright (C) 2011 yalamanchili.info
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.validation.Unique;
import info.yalamanchili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.security.CUser;

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
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"emailType"}))
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
    @NotEmpty
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

    /**
     * @generated
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getEmailType());
        sb.append(":");
        return sb.toString();
    }
}
