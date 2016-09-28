/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
public class MultipleInvoicesDto implements Serializable {

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClinetInfo_Invoice")
    protected ClientInformation clientInformation;

    @NotEmpty(message = "{itemNumber.not.empty.msg}")
    protected String itemNumber;

    @NotNull(message = "{invoiceFrequency.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency invoiceFrequency;

    @Transient
    protected String employee;

    protected List<InvoiceItemDto> invoiceItems;

    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public InvoiceFrequency getInvoiceFrequency() {
        return invoiceFrequency;
    }

    public void setInvoiceFrequency(InvoiceFrequency invoiceFrequency) {
        this.invoiceFrequency = invoiceFrequency;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public List<InvoiceItemDto> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItemDto> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
