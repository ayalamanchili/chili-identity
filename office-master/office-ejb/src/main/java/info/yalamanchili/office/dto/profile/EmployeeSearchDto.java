/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.chili.security.domain.CUser;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeSearchDto extends Employee {

    protected Date startDateFrom;
    protected Date startDateTo;
    protected Date endDateFrom;
    protected Date endDateTo;

    protected List<CompanyContact> companyContacts;

    public Date getStartDateFrom() {
        return startDateFrom;
    }

    public void setStartDateFrom(Date startDateFrom) {
        this.startDateFrom = startDateFrom;
    }

    public Date getStartDateTo() {
        return startDateTo;
    }

    public void setStartDateTo(Date startDateTo) {
        this.startDateTo = startDateTo;
    }

    public Date getEndDateFrom() {
        return endDateFrom;
    }

    public void setEndDateFrom(Date endDateFrom) {
        this.endDateFrom = endDateFrom;
    }

    public Date getEndDateTo() {
        return endDateTo;
    }

    public void setEndDateTo(Date endDateTo) {
        this.endDateTo = endDateTo;
    }

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
    public CUser getUser() {
        return user;
    }

    public void setUser(CUser user) {
        this.user = user;
    }

    @XmlElement
    @Override
    public List<ClientInformation> getClientInformations() {
        return super.getClientInformations();
    }
}
