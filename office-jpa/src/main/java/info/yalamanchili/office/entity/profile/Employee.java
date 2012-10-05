/**
 * Automanage Copyright (C) 2011 yalamanchili.info
 */
package info.yalamanchili.office.entity.profile;

import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.entity.time.TimeSheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
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
    @NotEmpty(message = "{employeeId.not.empty.msg}")
    @Field
    protected String employeeId;
    /**
     * @generated
     */
    @Field(index = Index.UN_TOKENIZED)
    @Temporal(TemporalType.DATE)
    protected Date startDate;
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
    @OneToOne(mappedBy = "employee")
    protected CUser user;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<TimeSheet> timeSheets;
    @OneToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_Preferences_Employee")
    protected Preferences preferences;

    /**
     * @generated
     */
    public Employee() {
        super();
    }

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

    @Override
    public String toString() {
        return "Contact{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", imageURL=" + imageURL + '}';
    }
}
