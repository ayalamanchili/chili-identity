/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kiranmai.Ramisetti
 */
@XmlRootElement
@XmlType
public class MissingInvoicesReportDto implements Serializable {

    protected String employee;
    protected String itemNumber;
    protected String invFrequency;
    protected Date missingInvPeriodFrom;
    protected Date missingInvPeriodTo;
    
    public MissingInvoicesReportDto(String employee, String itemNumber, String invFrequency) {
        this.employee = employee;
        this.itemNumber = itemNumber;
        this.invFrequency = invFrequency;
    }
    
    public MissingInvoicesReportDto() {
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getInvFrequency() {
        return invFrequency;
    }

    public void setInvFrequency(String invFrequency) {
        this.invFrequency = invFrequency;
    }

    public Date getMissingInvPeriodFrom() {
        return missingInvPeriodFrom;
    }

    public void setMissingInvPeriodFrom(Date missingInvPeriodFrom) {
        this.missingInvPeriodFrom = missingInvPeriodFrom;
    }

    public Date getMissingInvPeriodTo() {
        return missingInvPeriodTo;
    }

    public void setMissingInvPeriodTo(Date missingInvPeriodTo) {
        this.missingInvPeriodTo = missingInvPeriodTo;
    }

    
}
