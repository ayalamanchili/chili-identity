/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.security;

import info.chili.security.SecurityUtils;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.WorkStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class EmployeeLoginDto extends Employee {

    public EmployeeLoginDto() {
    }

    public EmployeeLoginDto(Long id, String firstName, String lastName, String middleInitial, String employeeId, String imageURL, String jobTitle, String ssn, Date dateOfBirth, Date startDate, Date endDate, Sex sex, WorkStatus workStatus, Branch branch, Integer hoursPerWeek, Long employeeTypeId, String employeeType, Long companyId, String company) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.employeeId = employeeId;
        this.dateOfBirth = dateOfBirth;
        this.imageURL = imageURL;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sex = sex;
        this.workStatus = workStatus;
        this.branch = branch;
        this.hoursPerWeek = hoursPerWeek;
        this.employeeType = new EmployeeType(employeeTypeId, employeeType);
        this.company = new Company(companyId, company);
    }

    protected String username;

    protected List<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public List<String> getRoles() {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    @XmlElement
    public String getSsn() {
        return SecurityUtils.OBFUSCATED_STR;
    }
}
