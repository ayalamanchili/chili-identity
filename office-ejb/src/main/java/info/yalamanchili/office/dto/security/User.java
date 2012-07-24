/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.security;

import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
public class User {
    protected String userName;
    protected String oldPassword;
    protected String newPassword;
    
     public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
     public String getoldPassword() {
        return oldPassword;
    }

    public void setoldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    
     public String getnewPassword() {
        return newPassword;
    }

    public void setnewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
