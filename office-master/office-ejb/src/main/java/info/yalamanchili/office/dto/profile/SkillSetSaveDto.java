/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import info.yalamanchili.office.entity.profile.TechnologyGroup;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class SkillSetSaveDto extends SkillSet {

    @NotNull(message = "{resumeUrl.not.empty.msg}")
    protected Set<SkillSetFile> skillSetFile;
    protected Employee employee;
    protected List<Skill> skills;
    protected List<Certification> certifications;
    protected Set<SkillSetTag> tags;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Practice_SkillSets")
    @IndexedEmbedded
    @NotNull(message = "{practice.not.empty.msg}")
    private Practice practice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_TechGrp_SkillSets")
    @IndexedEmbedded
    @NotNull(message = "{technologyGroup.not.empty.msg}")
    private TechnologyGroup technologyGroup;

    @XmlElement
    @Override
    public Set<SkillSetFile> getSkillSetFile() {
        if (this.skillSetFile == null) {
            this.skillSetFile = new HashSet();
        }
        return skillSetFile;
    }

    @Override
    public void setSkillSetFile(Set<SkillSetFile> skillSetFile) {
        this.skillSetFile = skillSetFile;
    }

    @XmlElement
    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @XmlElement
    @Override
    public List<Skill> getSkills() {
        return this.skills;
    }

    @Override
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @XmlElement
    @Override
    public List<Certification> getCertifications() {
        return this.certifications;
    }

    @Override
    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    @XmlElement
    @Override
    public Set<SkillSetTag> getTags() {
        return tags;
    }

    @Override
    public void setTags(Set<SkillSetTag> tags) {
        this.tags = tags;
    }

    @Override
    public Practice getPractice() {
        return practice;
    }

    @Override
    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    @Override
    public TechnologyGroup getTechnologyGroup() {
        return technologyGroup;
    }

    @Override
    public void setTechnologyGroup(TechnologyGroup technologyGroup) {
        this.technologyGroup = technologyGroup;
    }
}
