/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.privacy;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author anuyalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class PrivacySetting extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{privacyData.not.empty.msg}")
    @Index(name = "PRVCY_DAT")
    protected PrivacyData privacyData;
    @NotNull(message = "{privacyMode.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected PrivacyMode privacyMode;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_PRVCY_STGNS")
    protected Employee employee;

    public PrivacyData getPrivacyData() {
        return privacyData;
    }

    public void setPrivacyData(PrivacyData privacyData) {
        this.privacyData = privacyData;
    }

    public PrivacyMode getPrivacyMode() {
        return privacyMode;
    }

    public void setPrivacyMode(PrivacyMode privacyMode) {
        this.privacyMode = privacyMode;
    }

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
