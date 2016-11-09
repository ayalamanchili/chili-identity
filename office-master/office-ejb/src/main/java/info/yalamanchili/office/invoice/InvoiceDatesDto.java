/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.invoice;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author hemalatha.duggirala
 */
@XmlRootElement
@XmlType
public class InvoiceDatesDto implements Serializable {

    protected Date startDate;
    protected Date endDate;
    protected Date invoiceSentDate;
    protected Date vmsUploadDate;
    protected Boolean doNotSendInv;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getInvoiceSentDate() {
        return invoiceSentDate;
    }

    public void setInvoiceSentDate(Date invoiceSentDate) {
        this.invoiceSentDate = invoiceSentDate;
    }

    public Date getVmsUploadDate() {
        return vmsUploadDate;
    }

    public void setVmsUploadDate(Date vmsUploadDate) {
        this.vmsUploadDate = vmsUploadDate;
    }

    public Boolean getDoNotSendInv() {
        return doNotSendInv;
    }

    public void setDoNotSendInv(Boolean doNotSendInv) {
        this.doNotSendInv = doNotSendInv;
    }
}
