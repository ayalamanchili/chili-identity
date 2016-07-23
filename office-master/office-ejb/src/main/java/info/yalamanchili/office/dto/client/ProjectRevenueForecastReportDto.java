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
 * @author phani
 */
public class ProjectRevenueForecastReportDto {

    String employee;
    String client;
    String vendor;
    BigDecimal billingRate;
    Date startDate;
    Date endDate;
    String totalDuration;
    Integer remainingDuration;
    BigDecimal monthlyIncome;
    BigDecimal remainingIncome;
    String employeeType;
    BillingDuration billingDuration;
    String company;

    protected static final BigDecimal hoursPerMonth = new BigDecimal("168.00");
    protected static final BigDecimal daysPerMonth = new BigDecimal("21.00");
    protected static final BigDecimal weeksPerMonth = new BigDecimal("4.00");

    public ProjectRevenueForecastReportDto(String employee, String client, String vendor, BigDecimal billingRate, BillingDuration billingDuration, Date startDate, Date endDate, String employeeType, ClientInformationCompany company) {
        this.employee = employee;
        this.client = client;
        this.vendor = vendor;
        this.billingRate = billingRate;
        this.billingDuration = billingDuration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeType = employeeType;
        this.company = company.name();
        this.totalDuration = Integer.toString(DateUtils.differenceInMonths(startDate, endDate));
        this.remainingDuration = DateUtils.differenceInMonths(new Date(), endDate);
        if (null != billingDuration) {
            switch (billingDuration) {
                case MONTH:
                    this.monthlyIncome = billingRate;
                    this.remainingIncome = new BigDecimal(this.remainingDuration).multiply(billingRate);
                    break;
                case WEEK:
                    this.monthlyIncome = weeksPerMonth.multiply(billingRate);
                    this.remainingIncome = weeksPerMonth.multiply(new BigDecimal(this.remainingDuration)).multiply(billingRate);
                    break;
                case DAY:
                    this.monthlyIncome = daysPerMonth.multiply(billingRate);
                    this.remainingIncome = daysPerMonth.multiply(new BigDecimal(this.remainingDuration)).multiply(billingRate);
                    break;
                case HOUR:
                    this.monthlyIncome = hoursPerMonth.multiply(billingRate);
                    this.remainingIncome = hoursPerMonth.multiply(new BigDecimal(this.remainingDuration)).multiply(billingRate);
                default:
                    this.monthlyIncome = hoursPerMonth.multiply(billingRate);
                    this.remainingIncome = hoursPerMonth.multiply(new BigDecimal(this.remainingDuration)).multiply(billingRate);
            }
        } else {
            this.monthlyIncome = hoursPerMonth.multiply(billingRate);
            this.remainingIncome = hoursPerMonth.multiply(new BigDecimal(this.remainingDuration)).multiply(billingRate);
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

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getRemainingDuration() {
        return remainingDuration;
    }

    public void setRemainingDuration(Integer remainingDuration) {
        this.remainingDuration = remainingDuration;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public BigDecimal getRemainingIncome() {
        return remainingIncome;
    }

    public void setRemainingIncome(BigDecimal remainingIncome) {
        this.remainingIncome = remainingIncome;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BillingDuration getBillingDuration() {
        return billingDuration;
    }

    public void setBillingDuration(BillingDuration billingDuration) {
        this.billingDuration = billingDuration;
    }

}
