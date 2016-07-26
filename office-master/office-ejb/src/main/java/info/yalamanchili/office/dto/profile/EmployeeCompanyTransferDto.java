/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.Company;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@XmlRootElement
@XmlType
public class EmployeeCompanyTransferDto implements Serializable {
    
    @NotNull(message = "{company.transferDate.not.empty.msg}")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date transferDate;
    
    @NotNull(message = "{transferCompany.not.empty.msg}")
    protected Company transferCompany;
    
    protected Company previousCompany;
    
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
     * @return the transferCompany
     */
    public Company getTransferCompany() {
        return transferCompany;
    }

    /**
     * @param transferCompany the transferCompany to set
     */
    public void setTransferCompany(Company transferCompany) {
        this.transferCompany = transferCompany;
    }

    /**
     * @return the previousCompany
     */
    public Company getPreviousCompany() {
        return previousCompany;
    }

    /**
     * @param previousCompany the previousCompany to set
     */
    public void setPreviousCompany(Company previousCompany) {
        this.previousCompany = previousCompany;
    }
    
    
    
}