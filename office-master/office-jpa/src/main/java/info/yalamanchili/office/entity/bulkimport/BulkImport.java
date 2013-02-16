/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.bulkimport;

import info.chili.jpa.AbstractEntity;
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

    @NotEmpty
    protected String name;
    protected String description;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date importTimeStamp;
//    @NotEmpty
    protected String fileUrl;
//    @NotEmpty
    protected String adapter;
    @Enumerated(EnumType.STRING)
    protected BulkImportStatus status;
    @OneToMany(mappedBy = "bulkImport", cascade = CascadeType.ALL)
    protected List<BulkUploadMessage> messages;

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

    @XmlElement
    public List<BulkUploadMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<BulkUploadMessage> messages) {
        this.messages = messages;
    }

    @PrePersist
    @PreUpdate
    protected void populateAuditData() {
        this.setImportTimeStamp(new Date());
    }

    @Override
    public String toString() {
        return "BulkImport{" + "name=" + name + ", description=" + description + ", importDate=" + importTimeStamp + ", fileUrl=" + fileUrl + ", status=" + status + ", messages=" + messages + '}';
    }
}
