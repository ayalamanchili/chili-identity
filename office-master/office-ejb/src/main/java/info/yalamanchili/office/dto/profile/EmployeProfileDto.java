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
    protected String homeAddress1;
    protected String homeAddress2;
    protected String homeAddressCity;
    protected String homeAddressState;
    protected String homeAddressCountry;
    protected String homeAddressZip;
    /**
     * emergency contact 
     */
    protected String emergencyContactName;
    protected String emergencyContactPhone;
    protected String emergencyContactEmail;
    protected String employeeTypeStr;
    protected String manager;

    public String getHomeAddress1() {
        return homeAddress1;
    }

    public void setHomeAddress1(String homeAddress1) {
        this.homeAddress1 = homeAddress1;
    }

    public String getHomeAddress2() {
        return homeAddress2;
    }

    public void setHomeAddress2(String homeAddress2) {
        this.homeAddress2 = homeAddress2;
    }

    public String getHomeAddressCity() {
        return homeAddressCity;
    }

    public void setHomeAddressCity(String homeAddressCity) {
        this.homeAddressCity = homeAddressCity;
    }

    public String getHomeAddressState() {
        return homeAddressState;
    }

    public void setHomeAddressState(String homeAddressState) {
        this.homeAddressState = homeAddressState;
    }

    public String getHomeAddressCountry() {
        return homeAddressCountry;
    }

    public void setHomeAddressCountry(String homeAddressCountry) {
        this.homeAddressCountry = homeAddressCountry;
    }

    public String getHomeAddressZip() {
        return homeAddressZip;
    }

    public void setHomeAddressZip(String homeAddressZip) {
        this.homeAddressZip = homeAddressZip;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getEmergencyContactEmail() {
        return emergencyContactEmail;
    }

    public void setEmergencyContactEmail(String emergencyContactEmail) {
        this.emergencyContactEmail = emergencyContactEmail;
    }

    public String getEmployeeTypeStr() {
        return employeeTypeStr;
    }

    public void setEmployeeTypeStr(String employeeTypeStr) {
        this.employeeTypeStr = employeeTypeStr;
    }

    

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
    
}
