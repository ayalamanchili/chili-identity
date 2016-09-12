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
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.client.ClientMasterReportDto;
import info.yalamanchili.office.entity.client.Client;
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
public class ClientService {

    @Async
    @Transactional
    public void generateClientInfoReport(String email) {
        List<ClientMasterReportDto> res = new ArrayList();
        for (Client ci : ClientDao.instance().query(0, 2000)) {
            res.add(populateClientInfo(ci));
        }
        String[] columnOrder = new String[]{"clientName", "webSite", "clientInvDeliveryMethod", "terminationNoticePeriod", "clientLocations", "recruiterContact", "acctPayContact"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Client Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateActiveClientsInfoReport(String email) {

        String[] types = {EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.SUBCONTRACTOR, EmployeeType.W2_CONTRACTOR, EmployeeType._1099_CONTRACTOR, EmployeeType.INTERN_SEASONAL_EMPLOYEE};
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
        List<ClientMasterReportDto> dtos = new ArrayList();
        for (ClientInformation ci : clientInfos) {
            Client ci1 = ClientDao.instance().findById(ci.getClient().getId());
            ClientMasterReportDto dtoss = populateClientInfo(ci1);
            dtoss.setEmployeeName(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            dtoss.setEmployeeType(ci.getEmployee().getEmployeeType().getName());
            dtos.add(dtoss);
        }
        String[] columnOrder = new String[]{"employeeName", "employeeType", "clientName", "webSite", "clientInvDeliveryMethod", "terminationNoticePeriod", "clientLocations", "recruiterContact", "acctPayContact"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(dtos, "Active Clients Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);

    }

    public ClientMasterReportDto populateClientInfo(Client ci) {
        ClientMasterReportDto dto = new ClientMasterReportDto();
        dto.setClientName(ci.getName());
        if (ci.getWebsite() != null) {
            dto.setWebSite(ci.getWebsite());
        }
        if (ci.getClientInvDeliveryMethod() != null) {
            dto.setClientInvDeliveryMethod(ci.getClientInvDeliveryMethod().name().toLowerCase().replaceAll("_", " "));
        }
        if (ci.getTerminationNoticePeriod() != null) {
            dto.setTerminationNoticePeriod(ci.getTerminationNoticePeriod().toString());
        }
        // for getting client locations
        if (ci.getLocations().size() > 0) {
            String clientAddressInfo = "";
            int count = ci.getLocations().size();
            for (Address address : ci.getLocations()) {
                clientAddressInfo = clientAddressInfo.concat("\n" + address.getStreet1() + "-");
                if (address.getStreet2() != null) {
                    clientAddressInfo = clientAddressInfo.concat(address.getStreet2() + "-");
                }
                clientAddressInfo = clientAddressInfo.concat(address.getCity() + "-" + address.getState() + "-" + address.getCountry());
                if (address.getZip() != null) {
                    clientAddressInfo = clientAddressInfo.concat("-" + address.getZip());
                }
                if (count > 1) {
                    clientAddressInfo = clientAddressInfo.concat(",");
                }
                dto.setClientLocations(clientAddressInfo);
                count--;
            }
        }
        // for getting Recruiter Contacts
        if (ci.getContacts().size() > 0) {
            String recContact = "";
            int countc = ci.getContacts().size();
            for (Contact contact : ci.getContacts()) {
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
        // for getting AcctPayContacts
        if (ci.getClientAcctPayContacts().size() > 0) {
            String actContact = "";
            int countap = ci.getClientAcctPayContacts().size();
            for (Contact acpaycnt : ci.getClientAcctPayContacts()) {
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

    @Async
    @Transactional
    public void generateSearchDatesReport(List<Client> cli, String email, String reportName) {
        String[] columnOrder;
        String fileName;
        columnOrder = new String[]{"name", "website", "msaValDate", "msaExpDate"};
        fileName = ReportGenerator.generateExcelOrderedReport(cli, "MSA Validity Date Report For Client", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }

    public static ClientService instance() {
        return SpringContext.getBean(ClientService.class);
    }

}
