/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.domain;

import info.chili.jpa.validation.Unique;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
//@Unique(entity = CRole.class, fields = {"rolename"}, idName = "roleId")
@Table(indexes = @Index(name = "ROLE_NM", columnList = "rolename", unique = true))
public class CRole implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long roleId;
    private String rolename;
    private Set<CRole> groups;

    public CRole() {
    }

    public CRole(String rolename) {
        this.rolename = rolename;
    }

    @Id
    @GeneratedValue
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @ManyToMany(targetEntity = CRole.class)
    @JoinTable(name = "RoleGroups", joinColumns
            = @JoinColumn(name = "RoleId"), inverseJoinColumns
            = @JoinColumn(name = "GroupId"), foreignKey = @ForeignKey(name = ""))
    @XmlTransient
    public Set<CRole> getGroups() {
        if (groups == null) {
            groups = new HashSet<CRole>();
        }
        return groups;
    }

    public void setGroups(Set<CRole> groups) {
        this.groups = groups;
    }
}
