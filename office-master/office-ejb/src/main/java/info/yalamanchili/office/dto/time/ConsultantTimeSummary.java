/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.WorkStatus;
import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class ConsultantTimeSummary implements Serializable {

    /**
     * PTO
     */
    protected String totalPTOHours;
    protected String usedPTOHours;
    protected String availablePTOHours;
    /**
     * total hours
     */
    protected String totalAccumulatedHours;
    protected String totalUsedHours;
    protected String totalAvailableHours;
    /**
     *
     *
     */
    protected String usedUnpaidHours;
    protected String employee;
    protected String startDate;
    @Enumerated(EnumType.STRING)
    protected WorkStatus workStatus;
    protected Company company;

    public ConsultantTimeSummary() {
    }

    public ConsultantTimeSummary(String availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public String getTotalPTOHours() {
        return totalPTOHours;
    }

    public void setTotalPTOHours(String totalPTOHours) {
        this.totalPTOHours = totalPTOHours;
    }

    public String getUsedPTOHours() {
        return usedPTOHours;
    }

    public void setUsedPTOHours(String usedPTOHours) {
        this.usedPTOHours = usedPTOHours;
    }

    public String getAvailablePTOHours() {
        return availablePTOHours;
    }

    public void setAvailablePTOHours(String availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public String getUsedUnpaidHours() {
        return usedUnpaidHours;
    }

    public void setUsedUnpaidHours(String usedUnpaidHours) {
        this.usedUnpaidHours = usedUnpaidHours;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTotalAccumulatedHours() {
        return totalAccumulatedHours;
    }

    public void setTotalAccumulatedHours(String totalAccumulatedHours) {
        this.totalAccumulatedHours = totalAccumulatedHours;
    }

    public String getTotalUsedHours() {
        return totalUsedHours;
    }

    public void setTotalUsedHours(String totalUsedHours) {
        this.totalUsedHours = totalUsedHours;
    }

    public String getTotalAvailableHours() {
        return totalAvailableHours;
    }

    public void setTotalAvailableHours(String totalAvailableHours) {
        this.totalAvailableHours = totalAvailableHours;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
