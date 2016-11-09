/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Bhavana.Atluri
 */
@XmlRootElement(name = "CreateClient")
@XmlType
public class CreateClientDto implements Serializable {

    protected Long id;

    @NotEmpty(message = "{client.not.empty.msg}")
    protected String name;

    protected String description;
    protected String website;
    protected Boolean directClient;
    private Date msaValDate;
    protected Date msaExpDate;
    protected String paymentTerms;
    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency clientinvFrequency;
    protected Float clientFee;
    protected BigDecimal maxClientFee;
    protected BigDecimal minClientFee;

    protected Address location;
    protected ContactDto contact;
    protected ContactDto clientAcctPayContact;
    @Enumerated(EnumType.STRING)
    protected InvoiceDeliveryMethod clientInvDeliveryMethod;
    protected Integer terminationNoticePeriod;
    @Enumerated(EnumType.STRING)
    protected ClientStatus clientStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getDirectClient() {
        return directClient;
    }

    public void setDirectClient(Boolean directClient) {
        this.directClient = directClient;
    }

    /**
     * @return the msaValDate
     */
    public Date getMsaValDate() {
        return msaValDate;
    }

    /**
     * @param msaValDate the msaValDate to set
     */
    public void setMsaValDate(Date msaValDate) {
        this.msaValDate = msaValDate;
    }

    /**
     * @return the msaExpDate
     */
    public Date getMsaExpDate() {
        return msaExpDate;
    }

    /**
     * @param msaExpDate the msaExpDate to set
     */
    public void setMsaExpDate(Date msaExpDate) {
        this.msaExpDate = msaExpDate;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public InvoiceFrequency getClientinvFrequency() {
        return clientinvFrequency;
    }

    public void setClientinvFrequency(InvoiceFrequency clientinvFrequency) {
        this.clientinvFrequency = clientinvFrequency;
    }

    public Float getClientFee() {
        return clientFee;
    }

    public void setClientFee(Float clientFee) {
        this.clientFee = clientFee;
    }

    public BigDecimal getMaxClientFee() {
        return maxClientFee;
    }

    public ContactDto getContact() {
        return contact;
    }

    public void setContact(ContactDto contact) {
        this.contact = contact;
    }

    public ContactDto getClientAcctPayContact() {
        return clientAcctPayContact;
    }

    public void setClientAcctPayContact(ContactDto clientAcctPayContact) {
        this.clientAcctPayContact = clientAcctPayContact;
    }

    public void setMaxClientFee(BigDecimal maxClientFee) {
        this.maxClientFee = maxClientFee;
    }

    public BigDecimal getMinClientFee() {
        return minClientFee;
    }

    public void setMinClientFee(BigDecimal minClientFee) {
        this.minClientFee = minClientFee;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public InvoiceDeliveryMethod getClientInvDeliveryMethod() {
        return clientInvDeliveryMethod;
    }

    public void setClientInvDeliveryMethod(InvoiceDeliveryMethod clientInvDeliveryMethod) {
        this.clientInvDeliveryMethod = clientInvDeliveryMethod;
    }

    public Integer getTerminationNoticePeriod() {
        return terminationNoticePeriod;
    }

    public void setTerminationNoticePeriod(Integer terminationNoticePeriod) {
        this.terminationNoticePeriod = terminationNoticePeriod;
    }
     /**
     * @return the clientStatus
     */
    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    /**
     * @param clientStatus the clientStatus to set
     */
    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }

    @Override
    public String toString() {
        return "Create Client{" + "name=" + name + ", description=" + description + '}';
    }

}
