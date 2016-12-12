/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
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
@Indexed
@XmlRootElement
@Entity
@Audited
public class EmergencyContact extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 12L;
    /**
     * @generated
     */
    @Field
    @NotEmpty
    protected String relation;
    /**
     * @generated
     */
    @Field(index = Index.UN_TOKENIZED)
    protected Boolean ecPrimary;
    /**
     * @generated
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_EmergencyContacts")
    protected Employee employee;
    /**
     * @NOT generated
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_Contact_EmergencyContacts")
    @Valid
    protected Contact contact;

    /**
     * @generated
     */
    public EmergencyContact() {
        super();
    }

    /**
     * @generated
     */
    public String getRelation() {
        return relation;
    }

    /**
     * @generated
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * @generated
     */
    public Boolean getEcPrimary() {
        return ecPrimary;
    }

    /**
     * @generated
     */
    public void setEcPrimary(Boolean ecPrimary) {
        this.ecPrimary = ecPrimary;
    }

    /**
     * @generated
     */
    @XmlElement
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * @generated
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getRelation());
        sb.append(":");
        return sb.toString();
    }
}
