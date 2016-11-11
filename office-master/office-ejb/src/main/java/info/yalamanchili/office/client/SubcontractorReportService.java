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
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dto.client.SubcontractorMasterReportDto;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Benarji.v
 */
@Component
@Scope("request")
public class SubcontractorReportService {

    
    @Async
    @Transactional
    public void generateActiveClientsInfoReport(String email) {
        List<SubcontractorMasterReportDto> res = new ArrayList();
        for (SubcontractorMasterReportDto dto : ContractReportService.instance().getAllActiveCPDWithValidSMSASubcontractor()) {
            ClientInformation ci = ClientInformationDao.instance().findById(dto.getId());
            Subcontractor subcontractor = SubcontractorDao.instance().findById(ci.getSubcontractor().getId());
            dto.setMsaValDate(subcontractor.getMsaValDate());
            dto.setMsaExpDate(subcontractor.getMsaExpDate());
//            dto.setSubContractorName(subcontractor.getName());
            if (subcontractor.getContacts().size() > 0) {
                String recContact = "";
                int countc = subcontractor.getContacts().size();
                for (Contact contact : subcontractor.getContacts()) {
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
                            String phone = "Phone : ";
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
            res.add(dto);
        }
        
        String[] columnOrder = new String[]{"employeeName", "employeeType", "subContractorName", "recruiterContact", "msaValDate", "msaExpDate"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Active Subcontractor Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }
    
    public static SubcontractorReportService instance() {
        return SpringContext.getBean(SubcontractorReportService.class);
    }
}
