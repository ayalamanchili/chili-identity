/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.Perdiem;

import info.chili.jpa.AbstractHandleEntity;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author prasanthi.p
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class PerDiem extends AbstractHandleEntity {

    private static long serialVersionUID = 11L;

    private BigDecimal amount;

    private BigDecimal percentage;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{perdiemStartDate.cannot.be.empty}")
    private Date perDiemStartDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    
    @NotNull(message = "{perdiemEndDate.cannot.be.empty}")
    private Date perDiemEndDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date submittedDate;

    private boolean live50MilesAway;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_Perdiem")
    private Employee employee;
    
    protected String bpmProcessId;
    
    @Enumerated(EnumType.STRING)
    protected PerDiemStatus status;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the percentage
     */
    public BigDecimal getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    /**
     * @return the perDiemStartDate
     */
    public Date getPerDiemStartDate() {
        return perDiemStartDate;
    }

    /**
     * @param perDiemStartDate the perDiemStartDate to set
     */
    public void setPerDiemStartDate(Date perDiemStartDate) {
        this.perDiemStartDate = perDiemStartDate;
    }

    /**
     * @return the perDiemEndDate
     */
    public Date getPerDiemEndDate() {
        return perDiemEndDate;
    }

    /**
     * @param perDiemEndDate the perDiemEndDate to set
     */
    public void setPerDiemEndDate(Date perDiemEndDate) {
        this.perDiemEndDate = perDiemEndDate;
    }

    /**
     * @return the live50MilesAway
     */
    public boolean isLive50MilesAway() {
        return live50MilesAway;
    }

    /**
     * @param live50MilesAway the live50MilesAway to set
     */
    public void setLive50MilesAway(boolean live50MilesAway) {
        this.live50MilesAway = live50MilesAway;
    }

    /**
     * @return the addresses
     */
    @XmlElement
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    public PerDiemStatus getStatus() {
        return status;
    }

    public void setStatus(PerDiemStatus status) {
        this.status = status;
    }
}
