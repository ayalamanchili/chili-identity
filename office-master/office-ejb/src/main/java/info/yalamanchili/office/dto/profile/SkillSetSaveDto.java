/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import java.util.HashSet;
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
    }

}
