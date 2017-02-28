/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.dto;

import info.chili.identity.domain.CRole;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author phani.y
 */
@XmlRootElement
@XmlType
public class User implements Serializable {

    private Long userId;
    private String username;
    private boolean enabled;
    private boolean locked;
    private List<Role> roles;

    public User() {
    }

    public User(Long userId, String username, boolean enabled, boolean locked, CRole... roles) {
        this.userId = userId;
        this.username = username;
        this.enabled = enabled;
        this.locked = locked;
        for (CRole crole : roles) {
            this.getRoles().add(new Role(crole.getRoleId(), crole.getRolename()));
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles = roles;
    }

}
