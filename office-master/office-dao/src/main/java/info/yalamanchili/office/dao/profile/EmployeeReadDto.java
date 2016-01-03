/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.security.SecurityUtils;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.WorkStatus;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeReadDto extends Employee {

    public EmployeeReadDto(Long id, String firstName, String lastName, String middleInitial, String employeeId, String imageURL, String jobTitle, String ssn, Date dateOfBirth, Date startDate, Date endDate, Sex sex, WorkStatus workStatus, Branch branch, Integer hoursPerWeek, Long employeeTypeId, String employeeType, Long companyId, String company, Boolean status) {
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
        this.ssn = ssn;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sex = sex;
        this.workStatus = workStatus;
        this.branch = branch;
        this.hoursPerWeek = hoursPerWeek;
        this.employeeType = new EmployeeType(employeeTypeId, employeeType);
        this.company = new Company(companyId, company);
        this.status = status;
    }

    public EmployeeReadDto() {
    }

    protected Boolean status;

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
