/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.VersionStatus;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeReadDto extends Employee {

    @Enumerated(EnumType.STRING)
    protected VersionStatus status;

    public VersionStatus getStatus() {
        return status;
    }

    public void setStatus(VersionStatus status) {
        this.status = status;
    }

    @Override
    public String getSsn() {
        return "*********";
    }

    @PrePersist
    @PreUpdate
    protected void preSave() {
        //TODO invoke validator also
        if (this.status == null) {
            this.status = VersionStatus.ACTIVE;
        }
    }
}