/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.audit;

import info.chili.service.jrs.types.Entry;
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
public class EntityAuditData implements Serializable {

    protected List<Entry> auditData;

    @XmlElement
    public List<Entry> getAuditData() {
        if (this.auditData == null) {
            this.auditData = new ArrayList<Entry>();
        }
        return auditData;
    }

    public void setAuditData(List<Entry> auditData) {
        this.auditData = auditData;
    }

    public void addData(Entry e) {
        getAuditData().add(e);
    }
}
