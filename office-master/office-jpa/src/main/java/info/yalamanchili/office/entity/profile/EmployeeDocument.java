/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author prasanthi.p
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class EmployeeDocument extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    /*DocumentType */
    @NotNull(message = "{documentType.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected DocumentType documentType;
    /*fileurl*/
    protected String fileUrl;
    /*updatedByTS Date*/
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date updatedTs;
    /*updateBy String*/
    protected String updatedBy;
    /*Employee*/
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_DOC")
    protected Employee employee;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Date updatedTs) {
        this.updatedTs = updatedTs;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @PrePersist
    @PreUpdate
    protected void populateAuditData() {
        this.setUpdatedTs(new Date());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.setUpdatedBy(auth.getName());
    }

    @Override
    public String toString() {
        return "EmployeeDocument{" + "DocumentType=" + documentType + ", FileUrl=" + fileUrl + "UpdatedTs=" + updatedTs + ", UpdatedBy=" + updatedBy + ", Employee=" + employee + '}';
    }
}
