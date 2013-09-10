/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Vendor;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class ClientInformation extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 11L;
    /**
     * Consultant Job Title at client
     */
    @Field
    @NotEmpty(message = "{consultantJobTitle.not.empty.msg}")
    protected String consultantJobTitle;
    /**
     * flag to indicate if this is the primary client
     */
    @Field(index = Index.UN_TOKENIZED)
    protected Boolean ciPrimary;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date endDate;
    /**
     * Client
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Client_ClientInformations")
    @NotNull(message = "{client.not.empty.msg}")
    protected Client client;
    /**
     * Client Contact
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClientContact_ClientInformations")
    protected Contact clientContact;
    /**
     * Client Location
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClientLocation_ClientInformations")
    protected Address clientLocation;
    /**
     * Vendor
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Vendor_ClientInformations")
    protected Vendor vendor;
    /**
     * Vendor Contact
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_VendorContact_ClientInformations")
    protected Contact vendorContact;
    /**
     * Vendor Location
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_VendorLocation_ClientInformations")
    protected Address vendorLocation;
    /**
     * Employee
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_ClientInformations")
    protected Employee employee;
    /**
     * Item Number (quick books generated number
     */
    protected String itemNumber;
    /**
     * PayRate
     */
    protected BigDecimal payRate;
    /**
     * BillingRate
     */
    protected BigDecimal billingRate;
    /**
     * OverTime PayRate
     */
    protected BigDecimal overTimePayRate;
    /**
     * recruiter
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Recruiter_ClientInformations")
    protected Employee recruiter;
    /**
     * Notes
     */
    @Lob
    protected String notes;

    public ClientInformation() {
        super();
    }

    public String getConsultantJobTitle() {
        return consultantJobTitle;
    }

    public void setConsultantJobTitle(String consultantJobTitle) {
        this.consultantJobTitle = consultantJobTitle;
    }

    public Boolean getCiPrimary() {
        return ciPrimary;
    }

    public void setCiPrimary(Boolean ciPrimary) {
        this.ciPrimary = ciPrimary;
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Contact getClientContact() {
        return clientContact;
    }

    public void setClientContact(Contact clientContact) {
        this.clientContact = clientContact;
    }

    public Address getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(Address clientLocation) {
        this.clientLocation = clientLocation;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Contact getVendorContact() {
        return vendorContact;
    }

    public void setVendorContact(Contact vendorContact) {
        this.vendorContact = vendorContact;
    }

    public Address getVendorLocation() {
        return vendorLocation;
    }

    public void setVendorLocation(Address vendorLocation) {
        this.vendorLocation = vendorLocation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public BigDecimal getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(BigDecimal billingRate) {
        this.billingRate = billingRate;
    }

    public BigDecimal getOverTimePayRate() {
        return overTimePayRate;
    }

    public void setOverTimePayRate(BigDecimal overTimePayRate) {
        this.overTimePayRate = overTimePayRate;
    }

    public Employee getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Employee recruiter) {
        this.recruiter = recruiter;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "ClientInformation{" + "consultantJobTitle=" + consultantJobTitle + ", ciPrimary=" + ciPrimary + ", startDate=" + startDate + ", endDate=" + endDate + ", client=" + client + ", clientContact=" + clientContact + ", clientLocation=" + clientLocation + ", vendor=" + vendor + ", vendorContact=" + vendorContact + ", vendorLocation=" + vendorLocation + ", employee=" + employee + ", itemNumber=" + itemNumber + ", payRate=" + payRate + ", billingRate=" + billingRate + ", overTimePayRate=" + overTimePayRate + ", recruiter=" + recruiter + ", notes=" + notes + '}';
    }
}
