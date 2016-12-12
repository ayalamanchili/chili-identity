/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.security;

import java.io.Serializable;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@XmlRootElement
@XmlType
public class User implements Serializable {

    protected String userName;
    protected String oldPassword;

    protected String newPassword;
    protected long empid;

    @NotEmpty(message = "{username.not.empty.msg}")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotEmpty(message = "{oldpasswordHash.not.empty.msg}")
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @Size(min = 6, message = "{user.newpasswordHash.length.invalid.msg}")
    @NotEmpty(message = "{newpasswordHash.not.empty.msg}")
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
