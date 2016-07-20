/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

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
    protected Company company;
    
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
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }
    
    
    
}
