/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.invite;

import info.chili.document.AbstractDocument;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Madhu.Badiginchala
 */
@Document
@XmlRootElement
@XmlType
public class InviteType extends AbstractDocument{
    
    protected InvitationType invitationType;
    
    protected String description;
    
    protected String emailTemplateName;

    public InvitationType getInvitationType() {
        return invitationType;
    }

    public void setInvitationType(InvitationType invitationType) {
        this.invitationType = invitationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailTemplateName() {
        return emailTemplateName;
    }

    public void setEmailTemplateName(String emailTemplateName) {
        this.emailTemplateName = emailTemplateName;
    }
    
}
