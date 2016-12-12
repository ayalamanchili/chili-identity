/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.bulkimport;

import info.chili.jpa.AbstractEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@XmlRootElement
@Audited
public class BulkImport extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "{name.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "BLK_IMPRT_NM")
    protected String name;
    protected String description;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "IMPRT_TM_STMP")
    protected Date importTimeStamp;
    @NotEmpty(message = "{fileUrl.not.empty.msg}")
    protected String fileUrl;
    @NotEmpty(message = "{adapter.not.empty.msg}")
    protected String adapter;
    @Enumerated(EnumType.STRING)
    protected BulkImportStatus status;
    @OneToMany(mappedBy = "bulkImport", cascade = CascadeType.ALL)
    protected List<BulkImportMessage> messages;
    @OneToMany(mappedBy = "bulkImport", cascade = CascadeType.ALL)
    protected List<BulkImportEntity> entities;
    /**
     *
     */
    protected String bpmProcessId;

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

    public Date getImportTimeStamp() {
        return importTimeStamp;
    }

    public void setImportTimeStamp(Date importTimeStamp) {
        this.importTimeStamp = importTimeStamp;
    }

    public String getAdapter() {
        return adapter;
    }

    public void setAdapter(String adapter) {
        this.adapter = adapter;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public BulkImportStatus getStatus() {
        return status;
    }

    public void setStatus(BulkImportStatus status) {
        this.status = status;
    }

    @XmlTransient
    public List<BulkImportMessage> getMessages() {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        return messages;
    }

    public void setMessages(List<BulkImportMessage> messages) {
        this.messages = messages;
    }

    public void addMessage(BulkImportMessage message) {
        message.setBulkImport(this);
        getMessages().add(message);
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    @XmlTransient
    public List<BulkImportEntity> getEntities() {
        if (this.entities == null) {
            this.entities = new ArrayList<>();
        }
        return entities;
    }

    public void setEntities(List<BulkImportEntity> entities) {
        this.entities = entities;
    }

    public void addEntity(BulkImportEntity entity) {
        entity.setBulkImport(this);
        getEntities().add(entity);
    }

    @PrePersist
    @PreUpdate
    protected void populateAuditData() {
        this.setImportTimeStamp(new Date());
    }

    @Override
    public String toString() {
        return "BulkImport{" + "name=" + name + ", description=" + description + ", importTimeStamp=" + importTimeStamp + ", fileUrl=" + fileUrl + ", adapter=" + adapter + ", status=" + status + '}';
    }

}
