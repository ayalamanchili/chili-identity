/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.yalamanchili.jpa.AbstractEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
public class SkillSet extends AbstractEntity {

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date lastUpdated;
    protected String resumeUrl;
    @ManyToMany(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_SkillSet_Skills")
    protected List<Skill> skills;
    @ManyToMany(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_SkillSet_Certifications")
    protected List<Certification> certifications;
    @OneToOne(mappedBy = "skillSet")
    private Employee employee;

    public SkillSet() {
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public List<Skill> getSkills() {
        if (this.skills == null) {
            this.skills = new ArrayList<Skill>();
        }
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Certification> getCertifications() {
        if (this.certifications == null) {
            this.certifications = new ArrayList<Certification>();
        }
        return this.certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }
    //TODO add per or post persist and merge to update/set the lastupdated date.

    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
