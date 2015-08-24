/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.onboarding.invite;

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
public class InvitationType extends AbstractDocument{
    
    protected String type;
    
    protected String description;
    
    protected String emailTemplateName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
