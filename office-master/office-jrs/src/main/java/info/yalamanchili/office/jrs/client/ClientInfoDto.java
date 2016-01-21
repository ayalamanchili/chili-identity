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

/**
 *
 * @author Ramana.Lukalapu
 */
public class ClientInfoDto implements Serializable {

    protected String name;
    protected String webSite;
    protected String paymentTerms;
    protected String invFrequency;
    protected String clientLocations;
    protected String recruiterContact;
    protected String acctPayContact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
