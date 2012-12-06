package info.yalamanchili.office.entity.security;

import info.chili.jpa.validation.Unique;
import info.yalamanchili.office.entity.profile.Employee;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Audited
@XmlRootElement
@XmlType
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"username"}))
@Unique(entity = CUser.class, fields = {"username"}, message = "{user.name.not.unique.msg}", idName = "userId")
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

    @NotEmpty(message = "{username.not.empty.msg}")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 6, message = "{user.passwordHash.length.invalid.msg}")
    @NotEmpty(message = "{passwordHash.not.empty.msg}")
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_Employee_CUser")
    @Valid
    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    protected Employee employee;

    @ManyToMany(targetEntity = CRole.class, fetch = FetchType.EAGER)
    @ForeignKey(name = "FK_CRoles_CUsers")
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

    @Override
    public String toString() {
        return "CUser{" + "userId=" + userId + ", username=" + username + ", passwordHash=" + passwordHash + ", enabled=" + enabled + ", roles=" + roles + ", employee=" + employee + '}';
    }
}
