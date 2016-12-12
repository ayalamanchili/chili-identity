/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.bulkimport;

import info.chili.jpa.AbstractEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

/**
 *
 * @author ayalamanchili
 */
@Entity
@XmlRootElement
@Audited
public class BulkImportMessage extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    protected String code;
    protected String description;
    @Enumerated(EnumType.STRING)
    protected BulkImportMessageType messageType;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_BulkImport_Messages")
    protected BulkImport bulkImport;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BulkImportMessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(BulkImportMessageType messageType) {
        this.messageType = messageType;
    }

    @XmlTransient
    public BulkImport getBulkImport() {
        return bulkImport;
    }

    public void setBulkImport(BulkImport bulkImport) {
        this.bulkImport = bulkImport;
    }

    @Override
    public String toString() {
        return "BulkUploadMessage{" + "code=" + code + ", description=" + description + ", messageType=" + messageType + '}';
    }
}
