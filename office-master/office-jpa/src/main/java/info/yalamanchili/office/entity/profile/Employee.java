/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.security.domain.CUser;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.entity.time.TimeSheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.envers.Audited;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.jasypt.digest.StringDigester;
import org.jasypt.hibernate.type.EncryptedStringType;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class,
        parameters = {
            @Parameter(name = "encryptorRegisteredName", value = "hibernateStringEncryptor")
        })
@Indexed
@XmlRootElement
@Entity
@Audited
public class Employee extends Contact {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 2L;
    /**
     *
     */
    @NotEmpty(message = "{employeeId.not.empty.msg}")
    @Field
    @org.hibernate.annotations.Index(name = "EMPID")
    protected String employeeId;
    /**
     *
     */
    protected String jobTitle;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    protected Branch branch;
    /**
     * hours per week used to prorate monthly leave hours defaults to 40 hours
     */
    @Max(40)
    @Min(1)
    protected Integer hoursPerWeek;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    protected WorkStatus workStatus;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    /**
     * @generated
     */
    @Field(index = Index.UN_TOKENIZED)
    @Temporal(TemporalType.DATE)
    protected Date startDate;
    /**
     * @generated
     */
    protected Date endDate;
    /**
     * @generated
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Company_Employees")
    protected Company company;
    /**
     * @generated
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull(message = "{employeetype.not.null.msg}")
    @Valid
    @ForeignKey(name = "FK_EmployeeType_Employees")
    protected EmployeeType employeeType;
    /**
     * @generated
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<ClientInformation> clientInformations;
    /**
     * @generated
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<EmergencyContact> emergencyContacts;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<Post> posts;
    @OneToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_SkillSet_Employee")
    protected SkillSet skillSet;
    /**
     * CUser
     */
    //TODO change cascade type to just persist and remove
    @OneToOne(cascade = CascadeType.REMOVE)
    @ForeignKey(name = "FK_Employee_CUser")
    protected CUser user;
    //TODO make this one way from timesheet remove ref here
    /**
     * timesheets
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<TimeSheet> timeSheets;
    /**
     * preferences
     */
    @OneToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_Preferences_Employee")
    protected Preferences preferences;
    /**
     * todos
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<Todo> todos;
    /*
     * ssn
     */
    @Type(type = "encryptedString")
    @Length(min = 9, max = 9, message = "{ssnnumber.length.invalid.msg}")
    @org.hibernate.annotations.Index(name = "EMP_SSN_IDX")
    protected String ssn;
    /*
     * ssn hash
     */
    @org.hibernate.annotations.Index(name = "EMP_SSN_HASH_IDX")
    protected String ssnHash;

    /**
     * @generated
     */
    public Employee() {
        super();
    }

    @org.hibernate.annotations.Index(name = "EMP_EMPID")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @generated
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @generated
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @generated
     */
    @XmlElement
    public Company getCompany() {
        return this.company;
    }

    /**
     * @generated
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @generated
     */
    @XmlElement
    public EmployeeType getEmployeeType() {
        return this.employeeType;
    }

    /**
     * @generated
     */
    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    /**
     * @generated
     */
    @XmlTransient
    public List<ClientInformation> getClientInformations() {
        if (this.clientInformations == null) {
            this.clientInformations = new ArrayList<ClientInformation>();
        }
        return this.clientInformations;
    }

    /**
     * @generated
     */
    public void setClientInformations(List<ClientInformation> clientInformations) {
        this.clientInformations = clientInformations;
    }

    /**
     * @generated
     */
    public void addClientInformation(ClientInformation entity) {
        if (entity == null) {
            return;
        }
        getClientInformations().add(entity);
        entity.setEmployee(this);
    }

    /**
     * @generated
     */
    @XmlTransient
    public List<EmergencyContact> getEmergencyContacts() {
        if (this.emergencyContacts == null) {
            this.emergencyContacts = new ArrayList<EmergencyContact>();
        }
        return this.emergencyContacts;
    }

    /**
     * @generated
     */
    public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    /**
     * @generated
     */
    public void addEmergencyContact(EmergencyContact entity) {
        if (entity == null) {
            return;
        }
        getEmergencyContacts().add(entity);
        entity.setEmployee(this);
    }

    @XmlTransient
    public List<Post> getPosts() {
        if (this.posts == null) {
            this.posts = new ArrayList<Post>();
        }
        return this.posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        if (post == null) {
            return;
        }
        getPosts().add(post);
        post.setEmployee(this);
    }

    @XmlTransient
    public List<Todo> getTodos() {
        if (this.todos == null) {
            this.todos = new ArrayList<Todo>();
        }
        return this.todos;
    }

    public void setTodos(List<Todo> todo) {
        this.todos = todo;
    }

    public void addTodo(Todo todo) {
        if (todo == null) {
            return;
        }
        getTodos().add(todo);
        todo.setEmployee(this);
    }

    @XmlTransient
    public SkillSet getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(SkillSet skillSet) {
        this.skillSet = skillSet;
    }

    @XmlTransient
    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
//TODO make this transient and get the roles from dto

    @XmlTransient
    public CUser getUser() {
        return user;
    }

    public void setUser(CUser user) {
        this.user = user;
    }

    @XmlTransient
    public List<TimeSheet> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheet> timeSheets) {
        this.timeSheets = timeSheets;
    }

    @XmlTransient
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @XmlTransient
    public String getSsnHash() {
        return ssnHash;
    }

    public void setSsnHash(String ssnHash) {
        this.ssnHash = ssnHash;
    }

    /**
     * @return the hoursPerWeek
     */
    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    /**
     * @param hoursPerWeek the hoursPerWeek to set
     */
    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Transient
    public boolean isActive() {
        if (this.getUser() != null && !this.getUser().isEnabled()) {
            return false;
        } else {
            return true;
        }
    }

    @PrePersist
    @PreUpdate
    protected void setHash() {
        if (this.ssn != null && !validateNumbers(this.ssn)) {
            throw new RuntimeException();
        }
        if (this.ssn != null) {
            StringDigester officeStringDigester = (StringDigester) SpringContext.getBean("officeStringDigester");
            this.ssnHash = officeStringDigester.digest(this.ssn);

        }
    }

    protected boolean validateNumbers(String str) {
        Pattern digitPattern = Pattern.compile("^(\\d{9})$");
        return digitPattern.matcher(str).matches();
    }

    /**
     * @return the workStatus
     */
    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    /**
     * @param workStatus the workStatus to set
     */
    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Contact{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", imageURL=" + imageURL + ", workStatus=" + workStatus + '}';
    }

}
