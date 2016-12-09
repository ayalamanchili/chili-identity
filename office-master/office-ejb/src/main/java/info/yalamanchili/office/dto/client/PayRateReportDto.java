/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import info.chili.commons.DateUtils;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Hemanth
 */
public class PayRateReportDto {
    
    String employee;
    String client;
    String vendor;
    BigDecimal billingRate;
    Date startDate;
    Date endDate;
    String employeeType;
    BillingDuration billingRateDuration;
    String company;
    BigDecimal payRate;
    String payRatePercentage;


    public PayRateReportDto(String employee, String client, String vendor, BigDecimal billingRate, BillingDuration billingRateDuration, Date startDate, Date endDate, String employeeType, ClientInformationCompany company, BigDecimal payRate, Float payRatePercentage) {
        this.employee = employee;
        this.client = client;
        this.vendor = vendor;
        this.billingRate = billingRate;
        this.billingRateDuration = billingRateDuration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeType = employeeType;
        this.company = company.name();
        if (payRate == null) {
            if (payRatePercentage != null && billingRate != null) {
                Float f = (payRatePercentage * billingRate.floatValue()) / 100;
                this.payRate = new BigDecimal(f);
            }
        } else {
            this.payRate = payRate;
        }
        if (payRatePercentage != null) {
            this.payRatePercentage = payRatePercentage.toString();
        }

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

    public BigDecimal getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(BigDecimal billingRate) {
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

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BillingDuration getBillingRateDuration() {
        return billingRateDuration;
    }

    public void setBillingRateDuration(BillingDuration billingRateDuration) {
        this.billingRateDuration = billingRateDuration;
    }
      
    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public String getPayRatePercentage() {
        return payRatePercentage;
    }

    public void setPayRatePercentage(Float payRatePercentage) {
        this.payRatePercentage = payRatePercentage.toString();
    }

}
