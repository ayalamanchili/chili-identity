/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.onboarding.invite;

import info.chili.document.AbstractDocument;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Madhu.Badiginchala
 */
@Document
@XmlRootElement
@XmlType
public class InviteCode extends AbstractDocument{
    
    @Indexed
    protected String invitationCode;
    
    @Indexed
    protected Date expiryDate;
    
    @Indexed
    protected Date validFromDate;
    
    @Indexed
    protected String email;
    
    @Indexed
    protected InvitationType invitationType;

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InvitationType getInvitationType() {
        return invitationType;
    }

    public void setInvitationType(InvitationType invitationType) {
        this.invitationType = invitationType;
    }
    
}
