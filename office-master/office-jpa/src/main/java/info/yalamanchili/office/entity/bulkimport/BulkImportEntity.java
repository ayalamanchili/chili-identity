/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.bulkimport;

import info.chili.jpa.AbstractEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

/**
 * Any entity associated with the bulk import
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
public class BulkImportEntity extends AbstractEntity {

    protected String entityType;
    protected Long entityId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_BulkImport_Entities")
    protected BulkImport bulkImport;

    public BulkImportEntity() {
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    @XmlTransient
    public BulkImport getBulkImport() {
        return bulkImport;
    }

    public void setBulkImport(BulkImport bulkImport) {
        this.bulkImport = bulkImport;
    }
}
