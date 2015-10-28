/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity;

import info.chili.jpa.validation.Unique;
import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.social.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Company.class, fields = {"name"}, message = "{company.name.not.unique.msg}")
public class Company extends AbstractEntity {

    /**
     * @generated
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * @generated
     */
    @Field
    @NotEmpty(message = "{company.name.not.empty.msg}")
    protected String name;
    /**
     * @generated
     */
    @Past(message = "{establishedDate.past.msg}")
    @Field(index = Index.UN_TOKENIZED)
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date establishedDate;
    /**
     * @generated
     */
    @Field
    protected String logoURL;
    /**
     * @generated
     */
    @OneToMany(mappedBy = "company", cascade = CascadeType.MERGE)
    protected List<Employee> employees;
    @OneToMany(mappedBy = "company", cascade = CascadeType.MERGE)
    protected List<Post> posts;
    
    protected String abbreviation;

    /**
     * @generated
     */
    public Company() {
        super();
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public Date getEstablishedDate() {
        return establishedDate;
    }

    /**
     * @generated
     */
    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    /**
     * @generated
     */
    public String getLogoURL() {
        return logoURL;
    }

    /**
     * @generated
     */
    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    /**
     * @generated
     */
    @XmlTransient
    public List<Employee> getEmployees() {
        if (this.employees == null) {
            this.employees = new ArrayList<Employee>();
        }
        return this.employees;
    }

    /**
     * @generated
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * @generated
     */
    public void addEmployee(Employee entity) {
        if (entity == null) {
            return;
        }
        getEmployees().add(entity);
        entity.setCompany(this);
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
        post.setCompany(this);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * @generated
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(":");
        return sb.toString();
    }
}
