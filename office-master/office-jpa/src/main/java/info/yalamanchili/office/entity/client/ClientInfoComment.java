/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@XmlType
@Entity
@Audited
public class ClientInfoComment extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    
    @Lob
    protected String comment;
    protected String createdBy;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "CLNT_INFO_CMT_TM_STMP")
    protected Date createdTimeStamp;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClientInfo_Comments")
    protected ClientInformation clientInformation;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }
}
