/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import org.springframework.mail.MailException;

/**
 *
 * @author anuyalamanchili
 */
public class CEmailException extends MailException {

    protected Email email;

    public CEmailException(Email email, String msg, Throwable cause) {
        super(msg, cause);
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

}
