/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.audit;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author anuyalamanchili
 */
@Entity
public class LoginActivity extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    
    protected String name;
    @org.hibernate.annotations.Index(name = "LOGINACT_EMPID_IDX")
    protected String employeeId;
    @org.hibernate.annotations.Index(name = "LOGINACT_TS_IDX")
    protected Date loginTimeStamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(Date loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }

    @Override
    public String toString() {
        return "LoginActivity{" + "name=" + name + ", employeeId=" + employeeId + ", loginTimeStamp=" + loginTimeStamp + '}';
    }
}
