/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.email.domain;

import info.chili.jpa.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Join table to associate the user to his/her email preferences
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"userId", "emailPreferenceRule_id"}))
public class UserEmailPreferenceRule extends AbstractEntity {

    public static final String USER_EMAIL_PREF_RULE_CACHE_REGION = "user-email-pref-rules";

    @NotEmpty
    protected String userId;
    @NotNull
    @OneToOne
    @ForeignKey(name = "FK_USR_EML_PREF_RUL")
    protected EmailPreferenceRule emailPreferenceRule;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public EmailPreferenceRule getEmailPreferenceRule() {
        return emailPreferenceRule;
    }

    public void setEmailPreferenceRule(EmailPreferenceRule emailPreferenceRule) {
        this.emailPreferenceRule = emailPreferenceRule;
    }

}
