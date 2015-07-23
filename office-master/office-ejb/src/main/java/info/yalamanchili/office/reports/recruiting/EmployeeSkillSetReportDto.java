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
    protected String skills;
    protected String certifications;
    protected String tags;

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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}
