/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class ContractSearchDto extends ContractDto {

    protected String employeeFirstName;
    protected String employeeLastName;
    protected String city;
    protected String state;
    protected String clientCity;
    protected String clientState;
    protected String vendorState;
    protected String vendorCity;
    protected Date recruitedDateFrom;
    protected Date recruitedDateTo;

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public String getVendorState() {
        return vendorState;
    }

    public void setVendorState(String vendorState) {
        this.vendorState = vendorState;
    }

    public String getVendorCity() {
        return vendorCity;
    }

    public void setVendorCity(String vendorCity) {
        this.vendorCity = vendorCity;
    }

    public ClientInformationCompany getCompany() {
        return company;
    }

    public void setCompany(ClientInformationCompany company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public Date getRecruitedDateFrom() {
        return recruitedDateFrom;
    }

    public void setRecruitedDateFrom(Date recruitedDateFrom) {
        this.recruitedDateFrom = recruitedDateFrom;
    }

    public Date getRecruitedDateTo() {
        return recruitedDateTo;
    }

    public void setRecruitedDateTo(Date recruitedDateTo) {
        this.recruitedDateTo = recruitedDateTo;
    }

}
