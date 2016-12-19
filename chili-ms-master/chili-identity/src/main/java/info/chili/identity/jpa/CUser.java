/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@XmlRootElement
@XmlType
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"username"}))
public class CUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long userId;
    private String username;
    private String passwordHash;
    private boolean enabled;
    private Set<CRole> roles;

    public CUser() {
    }

    public CUser(String username) {
        this.username = username;
    }

    public CUser(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    @Id
    @GeneratedValue
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @NotEmpty(message = "{username.not.empty.msg}")
    @Index(name = "USR_NM")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 6, message = "{user.passwordHash.length.invalid.msg}")
    @NotEmpty(message = "{user.passwordHash.not.empty.msg}")
    @Index(name = "USR_PWD")
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @org.hibernate.annotations.Index(name = "CUSER_ENABLED")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @ManyToMany(targetEntity = CRole.class, fetch = FetchType.EAGER)
    @ForeignKey(name = "FK_CRoles_CUsers")
    @JoinTable(name = "UserRoles", joinColumns
            = @JoinColumn(name = "UserId"), inverseJoinColumns
            = @JoinColumn(name = "RoleId"))
    @XmlElement
    public Set<CRole> getRoles() {
        if (roles == null) {
            roles = new HashSet<CRole>();
        }
        return roles;
    }

    public void setRoles(Set<CRole> roles) {
        this.roles = roles;
    }

    public void addRole(CRole role) {
        this.getRoles().add(role);
    }

    public void removeRole(CRole role) {
        this.getRoles().remove(role);
    }

    @Override
    public String toString() {
        return "CUser{" + "userId=" + userId + ", username=" + username + ", enabled=" + enabled + ", roles=" + roles + '}';
    }
}
