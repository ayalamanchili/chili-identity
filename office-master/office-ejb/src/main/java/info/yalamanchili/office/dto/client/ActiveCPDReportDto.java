/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import java.util.Date;

/**
 *
 * @author phani
 */
public class ActiveCPDReportDto {

    String employee;
    String client;
    String vendor;
    String billingRate;
    Date startDate;
    Date endDate;
    String duration;
    String employeeType;

    public ActiveCPDReportDto(String employee, String client, String vendor, String billingRate, Date startDate, Date endDate, String duration, String employeeType) {
        this.employee = employee;
        this.client = client;
        this.vendor = vendor;
        this.billingRate = billingRate;
        this.duration = duration;
        this.startDate=startDate;
        this.endDate=endDate;
        this.employeeType = employeeType;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(String billingRate) {
        this.billingRate = billingRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

}
