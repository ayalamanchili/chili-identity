/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.onboarding;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author hemalatha.duggirala
 */
@XmlRootElement
@XmlType
public class EmployeeOnBoardingSearchDto implements Serializable {

    protected String employeeType;
    protected String company;
    protected String status;
    protected Date startDate;

    public String getEmployeeType() {
        return employeeType;
    }

    public String getCompany() {
        return company;
    }

    public String getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }
    

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(Date startedDate) {
        this.startDate = startedDate;
    }
    

}
