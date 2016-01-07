/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.dao.profile.EmployeeDto;

/**
 *
 * @author ayalamanchili
 */
public class EmployeProfileDto extends EmployeeDto {

    /**
     * Home Address
     */
    protected String homeAddress;
    /**
     * emergency contact
     */
    protected String emergencyContactInfo;
    protected String employee_Type;
    protected String reportsManager;
    protected String gender;
    protected String companY;
    protected String work_Status;

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmergencyContactInfo() {
        return emergencyContactInfo;
    }

    public void setEmergencyContactInfo(String emergencyContactInfo) {
        this.emergencyContactInfo = emergencyContactInfo;
    }

    public String getEmployee_Type() {
        return employee_Type;
    }

    public void setEmployee_Type(String employee_Type) {
        this.employee_Type = employee_Type;
    }

    public String getReportsManager() {
        return reportsManager;
    }

    public void setReportsManager(String reportsManager) {
        this.reportsManager = reportsManager;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompanY() {
        return companY;
    }

    public void setCompanY(String companY) {
        this.companY = companY;
    }

    public String getWork_Status() {
        return work_Status;
    }

    public void setWork_Status(String work_Status) {
        this.work_Status = work_Status;
    }

}
