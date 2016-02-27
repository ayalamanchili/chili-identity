/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author hemalatha.duggirala
 */
@XmlRootElement
@XmlType
public class EmployeeLocationReportDto implements Serializable {

    protected String employee;
    protected String branch;
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String country;
    protected String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public static EmployeeLocationReportDto map(Mapper mapper, Employee emp, EmployeeLocationDto dto) {
        EmployeeLocationReportDto reportdto = new EmployeeLocationReportDto();
        reportdto.setEmployee(emp.getFirstName() + " " + emp.getLastName());
        if (emp.getBranch() != null) {
            reportdto.setBranch(emp.getBranch().name());
        }
        if (emp.getAddresss().size() > 0) {
            for (Address address : emp.getAddresss()) {
                if ((dto.getCity() != null && dto.getCity().equals(address.getCity())) || (dto.getState() != null && dto.getState().equals(address.getState()) || (dto.getCountry() != null && dto.getCountry().equals(address.getCountry())))) {
                    reportdto.setStreet1(address.getStreet1());
                    reportdto.setStreet2(address.getStreet2());
                    reportdto.setCity(address.getCity());
                    reportdto.setState(address.getState());
                    reportdto.setCountry(address.getCountry());
                    reportdto.setZip(address.getZip());
                } else {
                    reportdto.setStreet1(address.getStreet1());
                    reportdto.setStreet2(address.getStreet2());
                    reportdto.setCity(address.getCity());
                    reportdto.setState(address.getState());
                    reportdto.setCountry(address.getCountry());
                    reportdto.setZip(address.getZip());
                }
            }
        }
        return reportdto;
    }
}
