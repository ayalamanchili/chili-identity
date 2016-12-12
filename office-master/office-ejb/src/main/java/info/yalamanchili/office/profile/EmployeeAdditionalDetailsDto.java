/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
public class EmployeeAdditionalDetailsDto implements Serializable {

    protected String referredBy;
    protected String ethnicity;
    protected String maritalStatus;
    protected Employee employee;

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static EmployeeAdditionalDetailsDto map(Mapper mapper, EmployeeAdditionalDetails entity) {
        EmployeeAdditionalDetailsDto additionalDetailsDto = mapper.map(entity, EmployeeAdditionalDetailsDto.class);
        if(entity.getEthnicity()!=null){
            additionalDetailsDto.setEthnicity(entity.getEthnicity().name());
        }
        if(entity.getMaritalStatus()!=null){
            additionalDetailsDto.setMaritalStatus(entity.getMaritalStatus().name());
        }
        return additionalDetailsDto;
    }
}
