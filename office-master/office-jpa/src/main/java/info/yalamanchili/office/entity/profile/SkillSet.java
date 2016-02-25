/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class SkillSet extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     * last updated
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "SKL_SET_UPDT_TM_STMP")
    protected Date lastUpdated;
    /**
     * resume URL
     */
    @Field
    protected String resumeUrl;
    /**
     * extracted content of resume
     */
    @Field
    @Lob
    protected String resumeContent;
    /**
     * Skills
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_SkillSet_Skills")
    @IndexedEmbedded
    protected List<Skill> skills;
    /**
     * Certifications
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_SkillSet_Certifications")
    @IndexedEmbedded
    protected List<Certification> certifications;
    /**
     * Employee
     */
    @OneToOne(mappedBy = "skillSet")
    private Employee employee;
    /**
     * Practice
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Practice_SkillSets")
    @IndexedEmbedded
    private Practice practice;
    /**
     * Technology Group
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_TechGrp_SkillSets")
    @IndexedEmbedded
    private TechnologyGroup technologyGroup;

    /**
     * Skill Set Tags
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_SkillSet_Tag", inverseName = "FK_Tag_SkillSet")
    @IndexedEmbedded
    protected Set<SkillSetTag> tags;

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
    public String getResumeContent() {
        return resumeContent;
    }

    public void setResumeContent(String resumeContent) {
        this.resumeContent = resumeContent;
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

    @XmlTransient
    public Set<SkillSetTag> getTags() {
        if (this.tags == null) {
            this.tags = new HashSet<SkillSetTag>();
        }
        return tags;
    }

    public void addSkill(Skill skill) {
        getSkills().add(skill);
    }

    public void removeSkill(Skill skill) {
        getSkills().remove(skill);
    }

    public void addCertification(Certification cert) {
        getCertifications().add(cert);
    }

    public void removeCertification(Certification cert) {
        getCertifications().remove(cert);
    }

    public void setTags(Set<SkillSetTag> tags) {
        this.tags = tags;
    }

    public void addTag(SkillSetTag tag) {
        getTags().add(tag);
    }

    public void removeTag(SkillSetTag tag) {
        getTags().remove(tag);
    }

    @PrePersist
    @PreUpdate
    protected void populateUpdatedTimeStamp() {
        this.setLastUpdated(new Date());
    }

    @OneToMany(mappedBy = "skillSet", cascade = CascadeType.ALL)
    protected Set<SkillSetFile> skillSetFile;

    @XmlTransient
    public Set<SkillSetFile> getSkillSetFile() {
        if (this.skillSetFile == null) {
            this.skillSetFile = new HashSet();
        }
        return skillSetFile;
    }

    public void setSkillSetFile(Set<SkillSetFile> skillSetFile) {
        this.skillSetFile = skillSetFile;
    }

    @Override
    public String toString() {
        return "SkillSet{" + "lastUpdated=" + lastUpdated + ", resumeUrl=" + resumeUrl + ", employee=" + employee + ", practice=" + practice + ", technologyGroup=" + technologyGroup + '}';
    }

}
