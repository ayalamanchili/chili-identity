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
        = @UniqueConstraint(columnNames = {"addressType"}))
@Unique(entity = AddressType.class, fields = {"addressType"}, message = "{addresstype.name.not.unique.msg}")
public class AddressType extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 10L;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{addressType.not.empty.msg}")
    protected String addressType;

    /**
     * @generated
     */
    /**
     * @generated
     */
    public AddressType() {
        super();
    }

    /**
     * @generated
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * @generated
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "AddressType{" + "addressType=" + addressType + '}';
    }
}
