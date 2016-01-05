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
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
public class EmployeeLocationDto implements Serializable {

    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String client;
    protected List<ClientInformation> clientInfos;
    protected List<Address> clientLocations;
    protected String vendor;
    protected Date startDate;
    protected Date endDate;
    protected String state;
    protected String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<Address> getClientLocations() {
        return clientLocations;
    }

    public void setClientLocations(List<Address> clientLocations) {
        this.clientLocations = clientLocations;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public List<ClientInformation> getClientInfos() {
        return clientInfos;
    }

    public void setClientInfos(List<ClientInformation> clientInfos) {
        this.clientInfos = clientInfos;
    }

    @Override
    public String toString() {
        return "EmployeeLocationDto{" + "firstName=" + firstName + ", lastName=" + lastName + ", client=" + client + ", clientLocations=" + clientLocations + ", vendor=" + vendor + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    public static EmployeeLocationDto map(Mapper mapper, Employee entity) {
        EmployeeLocationDto dto = mapper.map(entity, EmployeeLocationDto.class);
        dto.setStartDate(null);
        dto.setFirstName(null);
        dto.setLastName(null);
        dto.setEndDate(null);
        if (entity.getAddresss().size() > 0) {
            dto.setCity(entity.getAddresss().get(0).getCity());
            dto.setState(entity.getAddresss().get(0).getState());
        }
        if (entity.getClientInformations().size() > 0) {
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            for (ClientInformation ci : entity.getClientInformations()) {
                dto.setClient(ci.getClient().getName());
                dto.setVendor(ci.getVendor().getName());
                dto.setStartDate(ci.getStartDate());
                dto.setEndDate(ci.getEndDate());
            }
            dto.setClientInfos(entity.getClientInformations());
            dto.setId(entity.getId());
        }
        return dto;
    }

}
