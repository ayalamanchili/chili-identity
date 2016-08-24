/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractHandleEntity;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Kishore.Chigurupati
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class MiscellaneousInfo extends AbstractHandleEntity {

    protected String sevisNumber;

    protected String eadNumber;

    public String getSevisNumber() {
        return sevisNumber;
    }

    public void setSevisNumber(String sevisNumber) {
        this.sevisNumber = sevisNumber;
    }

    public String getEadNumber() {
        return eadNumber;
    }

    public void setEadNumber(String eadNumber) {
        this.eadNumber = eadNumber;
    }

    @Override
    public String toString() {
        return "MiscellaneousInfo{" + "sevisNumber=" + sevisNumber + ", eadNumber=" + eadNumber + '}';
    }
}
