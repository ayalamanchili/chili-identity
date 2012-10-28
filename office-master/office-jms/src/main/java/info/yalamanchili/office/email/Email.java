/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import java.io.Serializable;
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
    protected boolean isHtml = false;

    public Email() {
    }

    public Set<String> getTos() {
        return tos;
    }

    public void setTos(Set<String> tos) {
        this.tos = tos;
    }

    public Set<String> getCcs() {
        return ccs;
    }

    public void setCcs(Set<String> ccs) {
        this.ccs = ccs;
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

    public boolean getIsHtml() {
        return isHtml;
    }

    public void setIsHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    @Override
    public String toString() {
        return "Email{" + "tos=" + tos + ", ccs=" + ccs + ", bccs=" + bccs + ", subject=" + subject + ", body=" + body + '}';
    }
}
