/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import info.yalamanchili.office.entity.hr.ProspectStatus;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author phani
 */
@XmlRootElement
@XmlType
public class ProspectReportDto {

    protected ProspectStatus status;
    protected Date createdDateTo;
    protected Date createdDateFrom;
    protected Date joiningDateTo;
    protected Date joiningDateFrom;
    protected String caseManager;
    protected String assignedTo;
    protected String company;
    
    public ProspectStatus getStatus() {
        return status;
    }

    public String getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(String caseManager) {
        this.caseManager = caseManager;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    public void setStatus(ProspectStatus status) {
        this.status = status;
    }

    public Date getCreatedDateTo() {
        return createdDateTo;
    }

    public void setCreatedDateTo(Date createdDateTo) {
        this.createdDateTo = createdDateTo;
    }

    public Date getCreatedDateFrom() {
        return createdDateFrom;
    }

    public void setCreatedDateFrom(Date createdDateFrom) {
        this.createdDateFrom = createdDateFrom;
    }

    public Date getJoiningDateTo() {
        return joiningDateTo;
    }

    public void setJoiningDateTo(Date joiningDateTo) {
        this.joiningDateTo = joiningDateTo;
    }

    public Date getJoiningDateFrom() {
        return joiningDateFrom;
    }

    public void setJoiningDateFrom(Date joiningDateFrom) {
        this.joiningDateFrom = joiningDateFrom;
    }
}