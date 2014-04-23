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
        = @UniqueConstraint(columnNames = {"phoneType"}))
@Unique(entity = PhoneType.class, fields = {"phoneType"}, message = "{phonetype.name.not.unique.msg}")
public class PhoneType extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 7L;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{phoneType.not.empty.msg}")
    protected String phoneType;

    /**
     * @generated
     */
    public PhoneType() {
        super();
    }

    /**
     * @generated
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * @generated
     */
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "PhoneType{" + "phoneType=" + phoneType + '}';
    }
}
