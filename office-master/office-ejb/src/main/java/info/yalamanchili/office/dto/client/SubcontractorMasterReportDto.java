/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import java.util.Date;

/**
 *
 * @author Benarji.v
 */
public class SubcontractorMasterReportDto {
    protected String employeeName;
    protected Long id;
    protected String employeeType;
    protected String subContractorName;
    protected Date msaValDate;
    protected Date msaExpDate;
    protected String recruiterContact;
    
    public SubcontractorMasterReportDto() {
    }
    public SubcontractorMasterReportDto(Long id, String firstName, String lastName, String employeeType, String subContractName, Date msaValDate, Date msaExpDate) {
        this.id = id;
        this.employeeName = firstName + " " + lastName;
        this.employeeType = employeeType;
        this.subContractorName = subContractName;
        this.msaValDate = msaValDate;
        this.msaExpDate = msaExpDate;
       
    }
    /**
     * @return the employeeType
     */
    public String getEmployeeType() {
        return employeeType;
    }

    /**
     * @param employeeType the employeeType to set
     */
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    /**
     * @return the msaValDate
     */
    public Date getMsaValDate() {
        return msaValDate;
    }

    /**
     * @param msaValDate the msaValDate to set
     */
    public void setMsaValDate(Date msaValDate) {
        this.msaValDate = msaValDate;
    }

    /**
     * @return the msaExpDate
     */
    public Date getMsaExpDate() {
        return msaExpDate;
    }

    /**
     * @param msaExpDate the msaExpDate to set
     */
    public void setMsaExpDate(Date msaExpDate) {
        this.msaExpDate = msaExpDate;
    }

    /**
     * @return the recruiterContact
     */
    public String getRecruiterContact() {
        return recruiterContact;
    }

    /**
     * @param recruiterContact the recruiterContact to set
     */
    public void setRecruiterContact(String recruiterContact) {
        this.recruiterContact = recruiterContact;
    }

    /**
     * @return the subContractorName
     */
    public String getSubContractorName() {
        return subContractorName;
    }

    /**
     * @param subContractorName the subContractorName to set
     */
    public void setSubContractorName(String subContractorName) {
        this.subContractorName = subContractorName;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
