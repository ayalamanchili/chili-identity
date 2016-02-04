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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Madhu.Badiginchala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class i94Record extends AbstractHandleEntity {

    @Transient
    private static final long serialVersionUID = 11L;

    @org.hibernate.annotations.Index(name = "i94_RECORD_NBR")
    protected String i94RecordNumber;

    public String getI94RecordNumber() {
        return i94RecordNumber;
    }
    
    public void setI94RecordNumber(String i94RecordNumber) {
        this.i94RecordNumber = i94RecordNumber;
    }

}
