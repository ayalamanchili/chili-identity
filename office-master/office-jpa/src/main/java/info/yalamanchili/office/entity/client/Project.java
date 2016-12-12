/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class Project extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "{project.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "PRJ_NM")
    protected String name;

    @Lob
    protected String description;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;

    @Temporal(javax.persistence.TemporalType.DATE)
//    @NotNull(message = "{endDate.not.empty.msg}")
    protected Date endDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Client_Projects")
    protected Client client;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    protected List<StatementOfWork> SOWS;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Vendor_Projects")
    protected Vendor vendor;

    protected String purchaseOrderNo;

    protected String subContractorWorkOrderNo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_MiddleVendor_Projects")
    protected Vendor middleVendor;

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

    public void setSOWS(List<StatementOfWork> SOWS) {
        this.SOWS = SOWS;
    }

    @XmlTransient
    public List<StatementOfWork> getSOWS() {
        if (this.SOWS == null) {
            this.SOWS = new ArrayList<StatementOfWork>();
        }
        return this.SOWS;
    }

    public void addSOW(StatementOfWork entity) {
        if (entity == null) {
            return;
        }
        getSOWS().add(entity);
        entity.setProject(this);
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getSubContractorWorkOrderNo() {
        return subContractorWorkOrderNo;
    }

    public void setSubContractorWorkOrderNo(String subContractorWorkOrderNo) {
        this.subContractorWorkOrderNo = subContractorWorkOrderNo;
    }

    public Vendor getMiddleVendor() {
        return middleVendor;
    }

    public void setMiddleVendor(Vendor middleVendor) {
        this.middleVendor = middleVendor;
    }

    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", client=" + client + '}';
    }
}
