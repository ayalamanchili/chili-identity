/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.profile.TechnologyGroup;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class SkillSetDto implements Serializable {

    protected String employeeName;
    /**
     *
     */
    protected String resumeUrl;
    @NotNull(message = "{practice.not.empty.msg}")
    private Practice practice;
    @NotNull(message = "{technologyGroup.not.empty.msg}")
    private TechnologyGroup technologyGroup;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
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
}
