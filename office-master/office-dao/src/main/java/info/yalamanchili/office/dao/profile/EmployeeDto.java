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
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.WorkStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement(name = "Employee")
@XmlType
public class EmployeeDto implements Serializable {
    
    protected Long id;
    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;
    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;
    protected String middleInitial;
    protected String employeeId;
    //@Past(message = "{dateOfBirth.past.msg}")
    //@NotNull(message = "{dateOfBirth.not.empty.msg}")
    protected Date dateOfBirth;
    @NotNull(message = "{sex.not.empty.msg}")
    protected Sex sex;
    @NotNull(message = "{branch.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    @Field
    protected Branch branch;
    @Max(40)
    @Min(1)
    protected Integer hoursPerWeek;
    protected WorkStatus workStatus;
    protected String imageURL;
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    protected Date endDate;
    @Email(message = "Enter a valid email address ")
    @NotEmpty(message = "{email.not.empty.msg}")
    protected String email;
    protected String phoneNumber;
    protected String phoneNumberExt;
    protected String jobTitle;
    @NotNull(message = "{employeetype.not.null.msg}")
    protected EmployeeType employeeType;
    protected Company company;
    protected String ssn;
    protected String gender;
    protected String branchName;
    protected String compny;
    protected Boolean status;
    
    protected int noOfYears;
    
    public EmployeeDto(Long id, String firstName, String lastName, String middleInitial, String employeeId, Date dateOfBirth, Sex sex, Branch branch, WorkStatus workStatus, String imageURL, Date startDate, Date endDate, String email, String phoneNumber, String phoneNumberExt, String jobTitle, EmployeeType employeeType, Company company, String ssn, Boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.employeeId = employeeId;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.branch = branch;
        this.workStatus = workStatus;
        this.imageURL = imageURL;
        this.startDate = startDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.phoneNumberExt = phoneNumberExt;
        this.jobTitle = jobTitle;
        this.employeeType = employeeType;
        this.company = company;
        this.ssn = ssn;
        this.endDate = endDate;
        this.status = status;
    }
    
    public EmployeeDto() {
    }
    
    public EmployeeDto(Long id, String firstName, String lastName, String jobTitle, String type, String email, String imageURL) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.employeeType = new EmployeeType(type);
        this.email = email;
        this.imageURL = imageURL;
    }
    
    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getMiddleInitial() {
        return middleInitial;
    }
    
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public Branch getBranch() {
        return branch;
    }
    
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    
    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }
    
    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
    
    public WorkStatus getWorkStatus() {
        return workStatus;
    }
    
    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }
    
    public String getImageURL() {
        return imageURL;
    }
    
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumberExt() {
        return phoneNumberExt;
    }
    
    public void setPhoneNumberExt(String phoneNumberExt) {
        this.phoneNumberExt = phoneNumberExt;
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
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
    
    public String getSsn() {
        return SecurityUtils.OBFUSCATED_STR;
    }
    
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getBranchName() {
        return branchName;
    }
    
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    public String getCompny() {
        return compny;
    }
    
    public void setCompny(String compny) {
        this.compny = compny;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }
    
    @Override
    public String toString() {
        return "EmployeeDto{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", employeeId=" + employeeId + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", imageURL=" + imageURL + ", startDate=" + startDate + ", email=" + email + ", phoneNumber=" + phoneNumber + ", jobTitle=" + jobTitle + ", employeeType=" + employeeType + ", workStatus=" + workStatus + ", staus=" + status +'}';
    }
    
    public static EmployeeDto map(Mapper mapper, info.yalamanchili.office.entity.profile.Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setJobTitle(entity.getJobTitle());
        dto.setStartDate(entity.getStartDate());
        dto.setEmployeeId(entity.getEmployeeId());
        if (entity.getDateOfBirth() != null) {
            dto.setDateOfBirth(entity.getDateOfBirth());
        }
        dto.setEndDate(entity.getEndDate());
        dto.setImageURL(entity.getImageURL());
        dto.setGender(entity.getSex().name().toLowerCase());
        if (entity.getBranch() != null) {
            dto.setBranchName(entity.getBranch().name());
        }
        if (entity.getCompany() != null) {
            dto.setCompny(entity.getCompany().getName());
        }
        dto.setEmail(EmployeeDao.instance().getPrimaryEmail(entity));
        if (entity.getPhones().size() > 0) {
            Phone phone = entity.getPhones().get(0);
            dto.setPhoneNumber(phone.getPhoneNumber());
            dto.setPhoneNumberExt(phone.getExtension());
        }
        dto.setEmployeeType(entity.getEmployeeType());
        dto.setId(entity.getId());
        dto.setStatus(entity.isActive());
        return dto;
    }
}
