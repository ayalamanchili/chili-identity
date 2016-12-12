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
import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
public class InvoiceDto extends Invoice implements Serializable {

    protected String invoicestatus;
    protected String timeSheetstatus;
    protected String invoicefrequency;
    protected String employeeName;

    public String getInvoicestatus() {
        return invoicestatus;
    }

    public void setInvoicestatus(String invoicestatus) {
        this.invoicestatus = invoicestatus;
    }

    public String getTimeSheetstatus() {
        return timeSheetstatus;
    }

    public void setTimeSheetstatus(String timeSheetstatus) {
        this.timeSheetstatus = timeSheetstatus;
    }

    public String getInvoicefrequency() {
        return invoicefrequency;
    }

    public void setInvoicefrequency(String invoicefrequency) {
        this.invoicefrequency = invoicefrequency;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static InvoiceDto map(Mapper mapper, Invoice invoice) {
        InvoiceDto mapDto = new InvoiceDto();
        mapDto = mapper.map(invoice, InvoiceDto.class);
        Employee employee1 = invoice.getClientInformation().getEmployee();
        mapDto.setEmployee(employee1.getFirstName() + " " + employee1.getLastName());
        mapDto.setInvoicestatus(invoice.getInvoiceStatus().name().toLowerCase());
        mapDto.setInvoicefrequency(invoice.getInvoiceFrequency().name().toLowerCase());
        mapDto.setTimeSheetstatus(invoice.getTimeSheetStatus().name().toLowerCase());
        return mapDto;
    }
}
