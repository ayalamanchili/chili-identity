/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rohith.Vallabhaneni
 */
@XmlRootElement
@XmlType
public class EmployeeDeptTransferDto implements Serializable {
    
    @NotNull(message = "{transferDate.not.empty.msg}")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date transferDate;
    
    @NotEmpty(message = "{existingDepartment.not.empty.msg}")
    protected String existingDepartment;
    
    @NotEmpty(message = "{newDepartment.not.empty.msg}")
    protected String newDepartment;

    /**
     * @return the transferDate
     */
    public Date getTransferDate() {
        return transferDate;
    }

    /**
     * @param transferDate the transferDate to set
     */
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    /**
     * @return the existingDepartment
     */
    public String getExistingDepartment() {
        return existingDepartment;
    }

    /**
     * @param existingDepartment the existingDepartment to set
     */
    public void setExistingDepartment(String existingDepartment) {
        this.existingDepartment = existingDepartment;
    }

    /**
     * @return the newDepartment
     */
    public String getNewDepartment() {
        return newDepartment;
    }

    /**
     * @param newDepartment the newDepartment to set
     */
    public void setNewDepartment(String newDepartment) {
        this.newDepartment = newDepartment;
    }
    
    
    
}
