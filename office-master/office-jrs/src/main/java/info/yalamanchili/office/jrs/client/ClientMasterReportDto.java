/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramana.Lukalapu
 */
@XmlRootElement
public class ClientMasterReportDto implements Serializable {

    protected String clientName;
    protected String webSite;
    protected String paymentTerms;
    protected String invFrequency;
    protected String clientLocations;
    protected String recruiterContact;
    protected String acctPayContact;
    protected String employeeName;
    protected String employeeType;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getInvFrequency() {
        return invFrequency;
    }

    public void setInvFrequency(String invFrequency) {
        this.invFrequency = invFrequency;
    }

    public String getClientLocations() {
        return clientLocations;
    }

    public void setClientLocations(String clientLocations) {
        this.clientLocations = clientLocations;
    }

    public String getRecruiterContact() {
        return recruiterContact;
    }

    public void setRecruiterContact(String recruiterContact) {
        this.recruiterContact = recruiterContact;
    }

    public String getAcctPayContact() {
        return acctPayContact;
    }

    public void setAcctPayContact(String acctPayContact) {
        this.acctPayContact = acctPayContact;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}
