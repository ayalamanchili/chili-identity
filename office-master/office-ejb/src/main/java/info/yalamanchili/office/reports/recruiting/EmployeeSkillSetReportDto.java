/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.recruiting;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public class EmployeeSkillSetReportDto {

    protected String name;
    protected String technologyGroup;
    protected String practice;
    protected List<String> skills;
    protected List<String> certifications;
    protected List<String> tags;

    public EmployeeSkillSetReportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnologyGroup() {
        return technologyGroup;
    }

    public void setTechnologyGroup(String technologyGroup) {
        this.technologyGroup = technologyGroup;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public List<String> getSkills() {
        if (skills == null) {
            this.skills = new ArrayList();
        }
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getCertifications() {
        if (certifications == null) {
            this.certifications = new ArrayList();
        }
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public List<String> getTags() {
        if (tags == null) {
            this.tags = new ArrayList();
        }
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
