/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class LoginActivityDto implements Serializable {

    protected String name;
    protected String employeeId;
    protected Date loginTimeStamp;
    protected Long loginCount;

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

    public Date getLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(Date loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }

    public Long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    @XmlRootElement
    @XmlType
    public static class LoginActivityTable implements java.io.Serializable{

        protected Long size;
        protected List<LoginActivityDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<LoginActivityDto> getEntities() {
            return entities;
        }

        public void setEntities(List<LoginActivityDto> entities) {
            this.entities = entities;
        }
    }

    @Override
    public String toString() {
        return "LoginActivity{" + "employeeId=" + employeeId + ", loginTimeStamp=" + loginTimeStamp + ", loginCount=" + loginCount + '}';
    }
}
