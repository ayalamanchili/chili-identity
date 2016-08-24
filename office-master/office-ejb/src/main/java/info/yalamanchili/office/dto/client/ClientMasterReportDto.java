/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

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
    protected String clientLocations;
    protected String recruiterContact;
    protected String acctPayContact;
    protected String employeeName;
    protected String employeeType;
    protected String clientInvDeliveryMethod;
    protected String terminationNoticePeriod;

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

    public String getClientInvDeliveryMethod() {
        return clientInvDeliveryMethod;
    }

    public void setClientInvDeliveryMethod(String clientInvDeliveryMethod) {
        this.clientInvDeliveryMethod = clientInvDeliveryMethod;
    }

    public String getTerminationNoticePeriod() {
        return terminationNoticePeriod;
    }

    public void setTerminationNoticePeriod(String terminationNoticePeriod) {
        this.terminationNoticePeriod = terminationNoticePeriod;
    }
}
