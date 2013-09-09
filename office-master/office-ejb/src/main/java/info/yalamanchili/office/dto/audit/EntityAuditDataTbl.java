/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
//TODO move to commons
public class EntityAuditDataTbl implements Serializable {

    protected List<EntityAuditData> entityAuditData;

    @XmlElement
    public List<EntityAuditData> getEntityAuditData() {
        if (this.entityAuditData == null) {
            this.entityAuditData = new ArrayList<EntityAuditData>();
        }
        return entityAuditData;
    }

    public void setEntityAuditData(List<EntityAuditData> entityAuditData) {
        this.entityAuditData = entityAuditData;
    }

    public void addAuditData(EntityAuditData data) {
        getEntityAuditData().add(data);
    }
}
