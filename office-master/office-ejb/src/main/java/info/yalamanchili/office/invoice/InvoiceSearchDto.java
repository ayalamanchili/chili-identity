/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.invoice;

import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class InvoiceSearchDto extends Invoice {

    protected ClientInformationCompany clientInformationCompany;
    protected String vendor;
    protected String employeeName;

    public ClientInformationCompany getClientInformationCompany() {
        return clientInformationCompany;
    }

    public void setClientInformationCompany(ClientInformationCompany clientInformationCompany) {
        this.clientInformationCompany = clientInformationCompany;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}