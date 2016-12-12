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

    protected String employee;
    protected String skills;
    protected String certifications;
    protected String skillSetTags;
    protected String resumeUploadStatus;
    protected String practice;
    protected String technologyGroup;
   
    public EmployeeSkillSetReportDto() {
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
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

    public String getSkillSetTags() {
        return skillSetTags;
    }

    public void setSkillSetTags(String skillSetTags) {
        this.skillSetTags = skillSetTags;
    }

    public String getResumeUploadStatus() {
        return resumeUploadStatus;
    }

    public void setResumeUploadStatus(String resumeUploadStatus) {
        this.resumeUploadStatus = resumeUploadStatus;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getTechnologyGroup() {
        return technologyGroup;
    }

    public void setTechnologyGroup(String technologyGroup) {
        this.technologyGroup = technologyGroup;
    }

}
