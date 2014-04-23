/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.company;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author anuyalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class CompanyContact extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_CMP_CNT_TP_CONTACTS")
    @NotNull(message = "{contacttype.not.empty.msg}")
    protected CompanyContactType type;
    /*
     * 
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_CMP_CNTS")
    @NotNull(message = "{employee.not.empty.msg}")
    protected Employee employee;
    /*
     * 
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_CNT_CMP_CNTS")
    @NotNull(message = "{contact.not.empty.msg}")
    protected Employee contact;

    @XmlElement
    public CompanyContactType getType() {
        return type;
    }

    public void setType(CompanyContactType type) {
        this.type = type;
    }

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getContact() {
        return contact;
    }

    public void setContact(Employee contact) {
        this.contact = contact;
    }
}
