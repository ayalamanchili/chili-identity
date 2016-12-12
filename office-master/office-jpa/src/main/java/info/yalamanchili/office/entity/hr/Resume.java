/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.hr;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class Resume extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    protected String name;
    /**
     *
     */
    protected String fileURL;

    @ManyToOne
    @ForeignKey(name = "FK_PROSPECT_RESUMES")
    protected Prospect prospect;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date updatedTS;

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public Date getUpdatedTS() {
        return updatedTS;
    }

    public void setUpdatedTS(Date updatedTS) {
        this.updatedTS = updatedTS;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resume other = (Resume) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.fileURL, other.fileURL);
    }

}
