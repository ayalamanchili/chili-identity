/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeSearchDto extends Employee {

    protected List<CompanyContact> companyContacts;

    @XmlElement
    public List<CompanyContact> getCompanyContacts() {
        if (companyContacts == null) {
            this.companyContacts = new ArrayList<CompanyContact>();
        }
        return companyContacts;
    }

    public void setCompanyContacts(List<CompanyContact> companyContacts) {
        this.companyContacts = companyContacts;
    }

    @XmlElement
    @Override
    public List<Address> getAddresss() {
        return super.getAddresss();
    }

    @XmlElement
    @Override
    public List<ClientInformation> getClientInformations() {
        return super.getClientInformations();
    }
}
