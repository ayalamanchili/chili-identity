/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author yalamanchili
 */
public class Email implements Serializable {

    protected Set<String> tos;
    protected Set<String> ccs;
    protected Set<String> bccs;
    protected String subject;
    protected String body;
    protected Boolean isHtml = false;
    protected Set<String> attachments;
    protected String templateName;

    public Email() {
    }

    public Set<String> getTos() {
        if (this.tos == null) {
            this.tos = new HashSet<String>();
        }
        return tos;
    }

    public void setTos(Set<String> tos) {
        this.tos = tos;
    }

    public void addTo(String to) {
        getTos().add(to);
    }

    public Set<String> getCcs() {
        if (this.ccs == null) {
            this.ccs = new HashSet<String>();
        }
        return ccs;
    }

    public void setCcs(Set<String> ccs) {
        this.ccs = ccs;
    }

    public void addCc(String cc) {
        getCcs().add(cc);
    }

    public Set<String> getBccs() {
        return bccs;
    }

    public void setBccs(Set<String> bccs) {
        this.bccs = bccs;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getIsHtml() {
        return isHtml;
    }

    public void setIsHtml(Boolean isHtml) {
        this.isHtml = isHtml;
    }

    public Set<String> getAttachments() {
        if (this.attachments == null) {
            this.attachments = new HashSet<String>();
        }
        return attachments;
    }

    public void setAttachments(Set<String> attachments) {
        this.attachments = attachments;
    }

    /**
     * Takes the path of the attachment relative to the content-root base
     *
     * @param attachmentPath
     */
    public void addAttachment(String attachmentPath) {
        getAttachments().add(attachmentPath);
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return "Email{" + "tos=" + tos + ", ccs=" + ccs + ", bccs=" + bccs + ", subject=" + subject + ", body=" + body + ", isHtml=" + isHtml + ", attachments=" + attachments + ", templateName=" + templateName + '}';
    }
}
