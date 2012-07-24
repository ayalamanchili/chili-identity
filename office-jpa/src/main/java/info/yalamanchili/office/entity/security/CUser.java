package info.yalamanchili.office.entity.security;

import info.chili.jpa.validation.Unique;
import info.yalamanchili.office.entity.profile.Employee;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@XmlType
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"username"}))

public class CUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long userId;
    private String username;
    private String passwordHash;
    private boolean enabled;
    private Set<CRole> roles;

    @Id
    @GeneratedValue
    public Long getUserId() {
        return userId;
    }
    
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Size(min = 6,message="{user.userId.length.invalid.msg}")
    @Unique(entity = CUser.class, property = "username", message = "{user.name.not.unique.msg}")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    @Size(min = 6,message="{user.passwordHash.length.invalid.msg}")
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToOne(cascade= CascadeType.ALL)
    @Valid
    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    protected Employee employee;

    @ManyToMany(targetEntity = CRole.class)
    @JoinTable(name = "UserRoles", joinColumns =
    @JoinColumn(name = "UserId"), inverseJoinColumns =
    @JoinColumn(name = "RoleId"))
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
}
