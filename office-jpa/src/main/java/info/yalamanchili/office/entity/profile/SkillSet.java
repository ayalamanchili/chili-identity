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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
    @OneToMany(cascade = CascadeType.ALL)
    protected List<Skill> skills;
    @OneToMany(cascade = CascadeType.ALL)
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

    @XmlTransient
    public List<Skill> getSkills() {
        if (this.skills == null) {
            this.skills = new ArrayList<Skill>();
        }
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @XmlTransient
    public List<Certification> getCertifications() {
        if (this.certifications == null) {
            this.certifications = new ArrayList<Certification>();
        }
        return this.certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }
}
