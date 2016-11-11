/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.chili.email.Email;
import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dto.client.ClientMasterReportDto;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
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
        String[] columnOrder = new String[]{"clientName", "clientStatus", "directClient", "webSite", "clientFee", "clientInvDeliveryMethod", "msaValDate", "msaExpDate", "terminationNoticePeriod", "clientLocations", "recruiterContact", "acctPayContact"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Client Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateActiveClientsInfoReport(String email) {
        List<ClientMasterReportDto> res = new ArrayList();
        for (ClientMasterReportDto dto : ContractReportService.instance().getAllActiveCPDWithValidSMSA()) {
            ClientInformation ci = ClientInformationDao.instance().findById(dto.getId());
            Client client = ClientDao.instance().findById(ci.getClient().getId());
            dto.setClientInvDeliveryMethod(client.getClientInvDeliveryMethod().name().toLowerCase().replaceAll("_", " "));
            dto.setTerminationNoticePeriod(client.getTerminationNoticePeriod().toString());
            dto.setMsaValDate(client.getMsaValDate());
            dto.setMsaExpDate(client.getMsaExpDate());
            dto.setClientFee(client.getClientFee().toString());
            dto.setDirectClient(client.getDirectClient());
            if (client.getWebsite() != null) {
                dto.setWebSite(client.getWebsite());
            }
            if (client.getContacts().size() > 0) {
                String recContact = "";
                int countc = client.getContacts().size();
                for (Contact contact : client.getContacts()) {
                    contact.describe();
                    String name = "Name : ";
                    name = name.concat(contact.getFirstName() + " " + contact.getLastName());
                    recContact = recContact.concat("\n" + name);
                    if (contact.getEmails().size() > 0) {
                        String rcemail = "Email : ";
                        rcemail = rcemail.concat(contact.getEmails().get(0).getEmail());
                        recContact = recContact.concat("-" + rcemail);
                    }
                    if (contact.getPhones().size() > 0) {
                        int countp = contact.getPhones().size();
                        for (Phone rphone : contact.getPhones()) {
                            String phone = "phone : ";
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
            if (client.getLocations().size() > 0) {
                String clientAddressInfo = "";
                int count = client.getLocations().size();
                for (Address address : client.getLocations()) {
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
            if (client.getClientAcctPayContacts().size() > 0) {
                String actContact = "";
                int countap = client.getClientAcctPayContacts().size();
                for (Contact acpaycnt : client.getClientAcctPayContacts()) {
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

            res.add(dto);

        }
        String[] columnOrder = new String[]{"employeeName", "employeeType", "clientName", "webSite", "clientInvDeliveryMethod", "terminationNoticePeriod", "recruiterContact", "acctPayContact", "clientLocations", "msaValDate", "msaExpDate", "directClient", "clientFee"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Active Clients Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);

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
        if (ci.getMsaValDate() != null) {
            dto.setMsaValDate(ci.getMsaValDate());
        }
        if (ci.getMsaExpDate()!= null) {
            dto.setMsaExpDate(ci.getMsaExpDate());
        }
        if (ci.getDirectClient()!= null) {         
            dto.setDirectClient(ci.getDirectClient());
        }
        if (ci.getClientFee()!= null) {         
            dto.setClientFee(ci.getClientFee().toString());
        }
        if (ci.getClientStatus()!= null) {         
            dto.setClientStatus(ci.getClientStatus().name());
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
                String name = "Name: ";
                name = name.concat(contact.getFirstName() + " " + contact.getLastName());
                recContact = recContact.concat(name+"\n");
                if (contact.getEmails().size() > 0) {
                    String email = "Email: ";
                    email = email.concat(contact.getEmails().get(0).getEmail());
                    recContact = recContact.concat(email+"\n"+"Phone: ");
                }
                if (contact.getPhones().size() > 0) {
                    int countp = contact.getPhones().size();
                    for (Phone rphone : contact.getPhones()) {
                        String phone = "";
                        if (rphone.getCountryCode() != null) {
                            String ccode = "";
                            ccode = ccode.concat(rphone.getCountryCode());
                            recContact = recContact.concat(ccode+"-");
                        }
                        phone = phone.concat(rphone.getPhoneNumber());
                        recContact = recContact.concat(phone);
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
                String acname = "Name: ";
                acname = acname.concat(acpaycnt.getFirstName() + " " + acpaycnt.getLastName());
                actContact = actContact.concat(acname+"\n");
                if (acpaycnt.getEmails().size() > 0) {
                    String acemail = "Email: ";
                    acemail = acemail.concat(acpaycnt.getEmails().get(0).getEmail());
                    actContact = actContact.concat(acemail+"\n"+"Phone: ");
                }
                if (acpaycnt.getPhones().size() > 0) {
                    int countapp = acpaycnt.getPhones().size();
                    for (Phone acpayphone : acpaycnt.getPhones()) {
                        String acphone = "";
                        if (acpayphone.getCountryCode() != null) {
                            String acccode = "";
                            acccode = acccode.concat(acpayphone.getCountryCode());
                            actContact = actContact.concat(acccode+"-");
                        }
                        acphone = acphone.concat(acpayphone.getPhoneNumber());
                        actContact = actContact.concat(acphone);
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

    @Async
    @Transactional
    public void sendClientDeleteNotification(Client clnt) {
        Email email = new Email();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_CONTRACTS.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_RECEIVABLE.name()));
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setSubject("Client Has Been Deleted.");
        String messageText = " <b><u>System Soft Tech Client Notification :</b></u> </br> ";
        messageText = messageText.concat("</br> <b>Name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; :</b> " + clnt.getName());
        messageText = messageText.concat("</br> <b>Description &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; :</b> Client has been deleted.");
        messageText = messageText.concat("</br> <b>Date of Deletion  &nbsp; :</b> " + sdf.format(new Date()));
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }
}
