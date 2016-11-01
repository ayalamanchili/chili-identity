/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.profile.Address;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramana.Lukalapu
 */
@XmlRootElement
public class ClientMasterReportDto implements Serializable {

    protected String clientName;
     protected Long id;
    protected String webSite;
    protected String clientLocations;
    protected String recruiterContact;
    protected String acctPayContact;
    protected String employeeName;
    protected String employeeType;
    protected String clientInvDeliveryMethod;
    protected String terminationNoticePeriod;
    private Date msaValDate;
    protected Date msaExpDate;
    protected Boolean directClient;
    protected String clientFee;
    
    public ClientMasterReportDto() {
    }
    public ClientMasterReportDto(Long id, String firstName, String lastName, String employeeType, String clientName, InvoiceDeliveryMethod clientInvDeliveryMethod, Integer terminationNoticePeriod, Date msaValDate, Date msaExpDate) {
        this.id = id;
        this.employeeName = firstName + " " + lastName;
        this.employeeType = employeeType;
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getMsaValDate() {
        return msaValDate;
    }

    public void setMsaValDate(Date msaValDate) {
        this.msaValDate = msaValDate;
    }

    public Date getMsaExpDate() {
        return msaExpDate;
    }

    public void setMsaExpDate(Date msaExpDate) {
        this.msaExpDate = msaExpDate;
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

    /**
     * @return the directClient
     */
    public Boolean getDirectClient() {
        return directClient;
    }

    /**
     * @param directClient the directClient to set
     */
    public void setDirectClient(Boolean directClient) {
        this.directClient = directClient;
    }

    /**
     * @return the clientFee
     */
    public String getClientFee() {
        return clientFee;
    }

    /**
     * @param clientFee the clientFee to set
     */
    public void setClientFee(String clientFee) {
        this.clientFee = clientFee;
    }
}
