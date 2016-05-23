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
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
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

    private static final long serialVersionUID = 11L;

//    @NotEmpty(message = "{i94RecordNumber.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "i94_RECORD_NBR")
    protected String i94RecordNumber;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateofEntry;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date admitUntilDate;

    protected String portOfEntry;

    protected String classOfAdmission;

    @Field
    protected String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPortOfEntry() {
        return portOfEntry;
    }

    public void setPortOfEntry(String portOfEntry) {
        this.portOfEntry = portOfEntry;
    }

    public String getClassOfAdmission() {
        return classOfAdmission;
    }

    public void setClassOfAdmission(String classOfAdmission) {
        this.classOfAdmission = classOfAdmission;
    }

    public String getI94RecordNumber() {
        return i94RecordNumber;
    }

    public void setI94RecordNumber(String i94RecordNumber) {
        this.i94RecordNumber = i94RecordNumber;
    }

    public Date getDateofEntry() {
        return dateofEntry;
    }

    public void setDateofEntry(Date dateofEntry) {
        this.dateofEntry = dateofEntry;
    }

    public Date getAdmitUntilDate() {
        return admitUntilDate;
    }

    public void setAdmitUntilDate(Date admitUntilDate) {
        this.admitUntilDate = admitUntilDate;
    }

    @Override
    public String toString() {
        return "i94Record{" + "i94RecordNumber=" + i94RecordNumber + ", dateofEntry=" + dateofEntry + ", admitUntilDate=" + admitUntilDate + ", portOfEntry=" + portOfEntry + ", classOfAdmission=" + classOfAdmission + ", imageURL=" + imageURL + '}';
    }
}
