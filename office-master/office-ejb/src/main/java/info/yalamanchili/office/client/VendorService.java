/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.client.VendorMasterReportDto;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("request")
public class VendorService {

    @Async
    @Transactional
    public void generateVendorInfoReport(String email) {
        List<VendorMasterReportDto> res = new ArrayList();
        for (Vendor vn : VendorDao.instance().query(0, 2000)) {
            res.add(populateVendorInfo(vn));
        }
        String[] columnOrder = new String[]{"vendorName", "webSite", "vendorType", "vendorFees", "vendorPaymentTerms", "vendorLocations", "recruiterContact", "acctPayContact"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Vendor Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateActiveVendorsInfoReport(String email) {

        String[] types = {EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.SUBCONTRACTOR, EmployeeType.W2_CONTRACTOR, EmployeeType._1099_CONTRACTOR};
        List<Employee> emps = EmployeeDao.instance().getEmployeesByType(types);
        List<ClientInformation> clientInfos = new ArrayList();
        for (Employee emp : emps) {
            if (emp.getClientInformations() != null) {
                for (ClientInformation ci : emp.getClientInformations()) {
                    if (ci.getEndDate() != null) {
                        if ((ci.getEndDate().after(new Date())) || (ci.getEndDate().equals(new Date()))) {
                            clientInfos.add(ci);
                        }
                    } else {
                        clientInfos.add(ci);
                    }
                }
            }
        }
        List<VendorMasterReportDto> dtos = new ArrayList();
        for (ClientInformation ci : clientInfos) {
            if (ci.getVendor() != null) {
                Vendor vi1 = VendorDao.instance().findById(ci.getVendor().getId());
                VendorMasterReportDto dtoss = populateVendorInfo(vi1);
                dtoss.setEmployeeName(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
                dtoss.setEmployeeType(ci.getEmployee().getEmployeeType().getName());
                dtos.add(dtoss);
            }
        }
        String[] columnOrder = new String[]{"employeeName", "employeeType", "vendorName", "webSite", "vendorType", "vendorFees", "vendorLocations", "recruiterContact", "acctPayContact"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(dtos, "Active Vendors Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    public VendorMasterReportDto populateVendorInfo(Vendor vn) {
        VendorMasterReportDto dto = new VendorMasterReportDto();
        dto.setVendorName(vn.getName());
        if (vn.getWebsite() != null) {
            dto.setWebSite(vn.getWebsite());
        }
        if (vn.getVendorType() != null) {
            dto.setVendorType(vn.getVendorType().name().toLowerCase());
        }
        if (vn.getVendorFees() != null) {
            dto.setVendorFees(vn.getVendorFees().toString());
        }
        if (vn.getPaymentTerms() != null) {
            dto.setVendorPaymentTerms(vn.getPaymentTerms());
        }
        // for getting vendor locations
        if (vn.getLocations().size() > 0) {
            String vendorAddressInfo = "";
            int count = vn.getLocations().size();
            for (Address address : vn.getLocations()) {
                vendorAddressInfo = vendorAddressInfo.concat("\n" + address.getStreet1() + "-");
                if (address.getStreet2() != null) {
                    vendorAddressInfo = vendorAddressInfo.concat(address.getStreet2() + "-");
                }
                vendorAddressInfo = vendorAddressInfo.concat(address.getCity() + "-" + address.getState() + "-" + address.getCountry());
                if (address.getZip() != null) {
                    vendorAddressInfo = vendorAddressInfo.concat("-" + address.getZip());
                }
                if (count > 1) {
                    vendorAddressInfo = vendorAddressInfo.concat(",");
                }
                dto.setVendorLocations(vendorAddressInfo);
                count--;
            }
        }
        // for getting Recruiter Contacts
        if (vn.getContacts().size() > 0) {
            String recContact = "";
            int countc = vn.getContacts().size();
            for (Contact contact : vn.getContacts()) {
                String name = "";
                name = name.concat(contact.getFirstName() + " " + contact.getLastName());
                recContact = recContact.concat("\n" + name);
                if (contact.getEmails().size() > 0) {
                    String email = "";
                    email = email.concat(contact.getEmails().get(0).getEmail());
                    recContact = recContact.concat("-" + email);
                }
                if (contact.getPhones().size() > 0) {
                    int countp = contact.getPhones().size();
                    for (Phone rphone : contact.getPhones()) {
                        String phone = "";
                        if (rphone.getCountryCode() != null) {
                            String ccode = "";
                            ccode = ccode.concat(rphone.getCountryCode());
                            recContact = recContact.concat("-" + ccode);
                        }
                        phone = phone.concat(rphone.getPhoneNumber());
                        recContact = recContact.concat("-" + phone);
                        if (rphone.getExtension() != null) {
                            String ext = "";
                            ext = ext.concat(rphone.getExtension());
                            recContact = recContact.concat("-" + ext);
                        }
                        if (countp > 1) {
                            recContact = recContact.concat("--");
                        }
                        countp--;
                    }
                }
                if (countc > 1) {
                    recContact = recContact.concat(",");
                }
                dto.setRecruiterContact(recContact);
                countc--;
            }
        }
        // for getting AcctPay Contacts
        if (vn.getAcctPayContacts().size() > 0) {
            String actContact = "";
            int countap = vn.getAcctPayContacts().size();
            for (Contact acpaycnt : vn.getAcctPayContacts()) {
                String acname = "";
                acname = acname.concat(acpaycnt.getFirstName() + " " + acpaycnt.getLastName());
                actContact = actContact.concat("\n" + acname);
                if (acpaycnt.getEmails().size() > 0) {
                    String acemail = "";
                    acemail = acemail.concat(acpaycnt.getEmails().get(0).getEmail());
                    actContact = actContact.concat("-" + acemail);
                }
                if (acpaycnt.getPhones().size() > 0) {
                    int countapp = acpaycnt.getPhones().size();
                    for (Phone acpayphone : acpaycnt.getPhones()) {
                        String acphone = "";
                        if (acpayphone.getCountryCode() != null) {
                            String acccode = "";
                            acccode = acccode.concat(acpayphone.getCountryCode());
                            actContact = actContact.concat("-" + acccode);
                        }
                        acphone = acphone.concat(acpayphone.getPhoneNumber());
                        actContact = actContact.concat("-" + acphone);
                        if (acpayphone.getExtension() != null) {
                            String acext = "";
                            acext = acext.concat(acpayphone.getExtension());
                            actContact = actContact.concat("-" + acext);
                        }
                        if (countapp > 1) {
                            actContact = actContact.concat("--");
                        }
                        countapp--;
                    }
                }
                if (countap > 1) {
                    actContact = actContact.concat(",");
                }
                dto.setAcctPayContact(actContact);
                countap--;
            }
        }
        return dto;
    }

    public static VendorService instance() {
        return SpringContext.getBean(VendorService.class);
    }

}
