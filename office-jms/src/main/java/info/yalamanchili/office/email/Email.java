/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author yalamanchili
 */
public class Email implements Serializable {

    protected List<String> tos;
    protected List<String> ccs;
    protected List<String> bccs;
    protected String subject;
    protected String body;

    public Email() {
    }

    public List<String> getTos() {
        return tos;
    }

    public void setTos(List<String> tos) {
        this.tos = tos;
    }

    public List<String> getCcs() {
        return ccs;
    }

    public void setCcs(List<String> ccs) {
        this.ccs = ccs;
    }

    public List<String> getBccs() {
        return bccs;
    }

    public void setBccs(List<String> bccs) {
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
}
