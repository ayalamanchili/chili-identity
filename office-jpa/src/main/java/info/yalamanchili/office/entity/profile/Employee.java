/**
 * Automanage Copyright (C) 2011 yalamanchili.info
 */
package info.yalamanchili.office.entity.profile;

import info.yalamanchili.office.entity.social.Post;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Indexed
@XmlRootElement
@Entity
public class Employee extends Contact {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 2L;
    /**
     * @generated
     */
    @Field(index = Index.UN_TOKENIZED)
    @Temporal(TemporalType.DATE)
    protected Date startDate;
    /**
     * @generated
     */
    @Field
    protected String ssn;
    /**
     * @generated
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    protected Company company;
    /**
     * @generated
     */
    @ManyToOne
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
    protected SkillSet skillSet;

    /**
     * @generated
     */
    public Employee() {
        super();
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
    public String getSsn() {
        return ssn;
    }

    /**
     * @generated
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
