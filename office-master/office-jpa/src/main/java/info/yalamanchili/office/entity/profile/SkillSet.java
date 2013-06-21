/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.practice.Practice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class SkillSet extends AbstractEntity {

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name="SKL_SET_UPDT_TM_STMP")
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
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Practice_SkillSets")
    private Practice practice;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Practice_SkillSets")
    private TechnologyGroup technologyGroup;

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

    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public TechnologyGroup getTechnologyGroup() {
        return technologyGroup;
    }

    public void setTechnologyGroup(TechnologyGroup technologyGroup) {
        this.technologyGroup = technologyGroup;
    }
    
    @PrePersist
    @PreUpdate
    protected void populateUpdatedTimeStamp() {
        this.setLastUpdated(new Date());
    }

    @Override
    public String toString() {
        return "SkillSet{" + "lastUpdated=" + lastUpdated + ", resumeUrl=" + resumeUrl + ", skills=" + skills + ", certifications=" + certifications + '}';
    }
}
