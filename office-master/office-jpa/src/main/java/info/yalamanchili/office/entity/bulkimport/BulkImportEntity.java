/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.bulkimport;

import info.chili.jpa.AbstractEntity;
import javax.persistence.Entity;
import org.hibernate.envers.Audited;

/**
 * Any entity associated with the bulk import
 *
 * @author ayalamanchili
 */
@Entity
@Audited
public class BulkImportEntity extends AbstractEntity {

    protected String entityType;
    protected Long entityId;
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

    public BulkImport getBulkImport() {
        return bulkImport;
    }

    public void setBulkImport(BulkImport bulkImport) {
        this.bulkImport = bulkImport;
    }
}
