/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author yphanikumar
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class Preferences extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;
    
    protected Boolean enableEmailNotifications = true;
    @OneToOne(mappedBy = "preferences")
    protected Employee employee;

    public Preferences() {
    }

    public Boolean getEnableEmailNotifications() {
        return enableEmailNotifications;
    }

    public void setEnableEmailNotifications(Boolean enableEmailNotifications) {
        this.enableEmailNotifications = enableEmailNotifications;
    }

    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Preferences{" + "enableEmailNotifications=" + enableEmailNotifications + '}';
    }
}
