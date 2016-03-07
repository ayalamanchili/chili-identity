/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class SkillSetSaveDto extends SkillSet {

    protected Set<SkillSetFile> skillSetFile;
    protected Employee employee;
    protected List<Skill> skills;
    protected List<Certification> certifications;
    protected Set<SkillSetTag> tags;

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
        if (this.skills == null) {
            this.skills = new ArrayList();
        }
        return this.skills;
    }

    @Override
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @XmlElement
    @Override
    public List<Certification> getCertifications() {
        if (this.certifications == null) {
            this.certifications = new ArrayList();
        }
        return this.certifications;
    }

    @Override
    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    @XmlElement
    @Override
    public Set<SkillSetTag> getTags() {
        if (this.tags == null) {
            this.tags = new HashSet();
        }
        return tags;
    }

    @Override
    public void setTags(Set<SkillSetTag> tags) {
        this.tags = tags;
    }
}
