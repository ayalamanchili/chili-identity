/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class RetirementPlan extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * OptIn Date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull
    protected Date optInDate;
    /**
     *
     */
    protected Boolean optIn;
    /**
     *
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_RET_PLN")
    @NotNull
    protected Employee employee;

    public RetirementPlan() {
    }

    public Date getOptInDate() {
        return optInDate;
    }

    public void setOptInDate(Date optInDate) {
        this.optInDate = optInDate;
    }

    public Boolean getOptIn() {
        return optIn;
    }

    public void setOptIn(Boolean optIn) {
        this.optIn = optIn;
    }

    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Object getComments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
