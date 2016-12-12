/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author hemalatha.duggirala
 */
@XmlRootElement
@XmlType
public class EmployeeOnBoardingReportDto implements Serializable {

    protected String employee;
    protected String employeeType;
    protected Date startDate;
    protected String email;
    protected String company;
    protected String branch;
    protected String workStatus;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public static EmployeeOnBoardingReportDto map(Mapper mapper, EmployeeOnBoarding onboarding) {
        EmployeeOnBoardingReportDto reportDto = mapper.map(onboarding, EmployeeOnBoardingReportDto.class);
        Employee onboardEmployee = onboarding.getEmployee();
        reportDto.setStartDate(onboardEmployee.getStartDate());
        reportDto.setEmployee(onboardEmployee.getFirstName() + " " + onboardEmployee.getLastName());
        reportDto.setEmployeeType(onboardEmployee.getEmployeeType().getName());
        reportDto.setEmail(onboardEmployee.getPrimaryEmail().getEmail());
        if (onboardEmployee.getCompany() != null) {
            reportDto.setCompany(onboardEmployee.getCompany().getName());
        }
        if (onboardEmployee.getBranch() != null) {
            reportDto.setBranch(onboardEmployee.getBranch().name());
        }
        if (onboardEmployee.getWorkStatus() != null) {
            reportDto.setWorkStatus(onboardEmployee.getWorkStatus().name());
        }
        return reportDto;
    }

}
