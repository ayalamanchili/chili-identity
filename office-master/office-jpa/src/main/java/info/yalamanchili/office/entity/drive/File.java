/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.drive;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author yphanikumar
 */
@Entity
public class File extends AbstractEntity {

    @NotEmpty(message = "{file.not.empty.msg}")
    protected String name;
    @NotEmpty
    protected String fileUrl;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date updatedTs;
    protected String updatedBy;
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    protected Folder folder;

    public File() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
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
        return "File{" + "name=" + name + ", fileUrl=" + fileUrl + ", updatedTs=" + updatedTs + ", updatedBy=" + updatedBy + ", folder=" + folder + '}';
    }
}
