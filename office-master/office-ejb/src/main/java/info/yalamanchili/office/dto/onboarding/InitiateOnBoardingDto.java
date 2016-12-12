/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.onboarding;

import info.chili.document.dao.SerializedEntityDao;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.WorkStatus;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.profile.invite.InviteCodeService;
import info.yalamanchili.office.profile.invite.InviteCodeService.InviteCodeDto;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class InitiateOnBoardingDto implements Serializable {

    /**
     *
     */
    @NotNull(message = "{employeetype.name.not.empty.msg}")
    protected EmployeeType employeeType;
    /**
     *
     */
    @NotNull(message = "{company.name.not.empty.msg}")
    protected Company company;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    /**
     *
     */
    @Email(message = "Enter a valid email address")
    @NotNull(message = "{email.not.empty.msg}")
    protected String email;
    /**
     *
     *
     */
    protected Branch branch;

    @NotNull(message = "{workStatus.not.empty.msg}")
    protected WorkStatus workStatus;

    protected OnBoardingStatus status;

    protected String comment;

    @NotNull(message = "{jobTitle.not.empty.msg}")
    protected String jobTitle;

    protected String bpmProcessId;

    protected String firstName;
    protected String middleInitial;
    protected String lastName;

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public OnBoardingStatus getStatus() {
        return status;
    }

    public void setStatus(OnBoardingStatus status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
