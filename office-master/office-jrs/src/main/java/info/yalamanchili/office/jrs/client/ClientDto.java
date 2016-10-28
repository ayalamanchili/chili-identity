/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
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
public class ClientDto implements Serializable {

    protected Long id;
    protected String name;
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String country;
    protected String zip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public static ClientDto map(Mapper mapper, Client entity, ClientSearchDto csdto) {
        ClientDto dto = mapper.map(entity, ClientDto.class);
        dto.setName(entity.getName());
        if (entity.getLocations().size() > 0) {
            for (Address address : entity.getLocations()) {
                    dto.setStreet1(address.getStreet1());
                    dto.setStreet2(address.getStreet2());
                    dto.setCity(address.getCity());
                    dto.setState(address.getState());
            }
        }
        dto.setId(entity.getId());
        return dto;
    }

    public static ClientDto mapVendor(Mapper mapper, Vendor entity, VendorSearchDto csdto) {
        ClientDto dto = mapper.map(entity, ClientDto.class);
        dto.setName(entity.getName());
        if (entity.getLocations().size() > 0) {
            for (Address address : entity.getLocations()) {
                dto.setStreet1(address.getStreet1());
                dto.setStreet2(address.getStreet2());
                dto.setCity(address.getCity());
                dto.setState(address.getState());
            }
        }
        dto.setId(entity.getId());
        return dto;
    }

    public static ClientDto mapSubcontractor(Mapper mapper, Subcontractor entity, SubcontractorSearchDto csdto) {
        ClientDto dto = mapper.map(entity, ClientDto.class);
        dto.setName(entity.getName());
        if (entity.getLocations().size() > 0) {
            for (Address address : entity.getLocations()) {
                dto.setStreet1(address.getStreet1());
                dto.setStreet2(address.getStreet2());
                dto.setCity(address.getCity());
                dto.setState(address.getState());
            }
        }
        dto.setId(entity.getId());
        return dto;
    }

}
