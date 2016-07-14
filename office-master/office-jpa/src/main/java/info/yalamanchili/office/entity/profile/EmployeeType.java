/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.validation.Unique;
import info.chili.jpa.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Indexed
@XmlRootElement
@Entity
@Audited
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = EmployeeType.class, fields = {"name"}, message = "{employeetype.name.not.unique.msg}")
public class EmployeeType extends AbstractEntity {
    
    public final static String CORPORATE_EMPLOYEE = "Corporate Employee";
    public final static String EMPLOYEE = "Employee";
    public final static String W2_CONTRACTOR = "W2 Contractor";
    public final static String _1099_CONTRACTOR = "1099 Contractor";
    public final static String SUBCONTRACTOR = "Subcontractor";
    public final static String INTERN_SEASONAL_EMPLOYEE = "Intern-Seasonal Employee";
    
    @Transient
    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message = "{employeetype.name.not.empty.msg}")
    protected String name;
    protected String description;
    
    public EmployeeType() {
    }
    
    public EmployeeType(String name) {
        this.name = name;
    }
    
    public EmployeeType(Long id, String name) {
        setId(id);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "EmployeeType{" + "name=" + name + ", description=" + description + '}';
    }
}
