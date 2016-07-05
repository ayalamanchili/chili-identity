/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.expense.ImmigrationCaseType;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
/**
 *
 * @author Bhavana.Atluri
 */
@Entity
@Audited
@XmlRootElement
@Indexed
public class ImmigrationCase extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 9993L;
    
    /**
    * Immigration Case Type
    */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{immigrationcase.type.not.empty.msg}")
    protected ImmigrationCaseType type;
    
    /**
     * employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_Employee_IMM_CASE")
    protected Employee employee;
    
    /**
     *The Date the Immigration case is created on
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "IMM_CASE_CRT_TM_STMP")
    @NotNull(message = "{immigrationcase.createddate.not.empty.msg}")
    protected Date createdTimeStamp;
    
    /**
     * The employee who created the immigration case
     */
    protected String createdBy;
    
    /**
     * Immigration Case status
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{immigrationcase.status.not.empty.msg}")
    protected ImmigrationCaseStatus immigrationCaseStatus;
    
    public ImmigrationCaseType getType() {
        return type;
    }

    public void setType(ImmigrationCaseType type) {
        this.type = type;
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }
    
    public String getCreateBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public ImmigrationCaseStatus getImmigrationCaseStatus() {
        return immigrationCaseStatus;
    }

    public void setImmigrationCaseStatus(ImmigrationCaseStatus immigrationCaseStatus) {
        this.immigrationCaseStatus = immigrationCaseStatus;
    }
}
