/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.profile;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.profile.EmployeProfileDto;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
public class ProfileReportsService {

    @Autowired
    protected Mapper mapper;

    @Async
    @Transactional
    public void generateEmployeBasicInfoReport(String email) {
        List<EmployeeBasicInfoReportDto> res = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee", "Employee")) {
            EmployeeBasicInfoReportDto dto = mapper.map(emp, EmployeeBasicInfoReportDto.class);
            dto.setEmail(EmployeeDao.instance().getPrimaryEmail(emp));
            dto.setType(emp.getEmployeeType().getName());
            if (emp.getBranch() != null) {
                dto.setBranch(emp.getBranch().name());
            }
            dto.setDateOfBirth(emp.getDateOfBirth());
            if (emp.getPhones().size() > 0) {
                dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
            }

            res.add(dto);
        }
        String[] columnOrder = new String[]{"firstName", "lastName", "startDate", "dateOfBirth", "type", "branch", "phoneNumber", "jobTitle", "email"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Employee-Basic-Info-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateProfileReport(String email) {
        List<EmployeProfileDto> res = new ArrayList();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee", "Employee")) {
            EmployeProfileDto dto = new EmployeProfileDto();
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            dto.setEmployeeType(emp.getEmployeeType());
            dto.setDateOfBirth(emp.getDateOfBirth());
            dto.setStartDate(emp.getStartDate());
            dto.setJobTitle(emp.getJobTitle());
            dto.setEmail(emp.getPrimaryEmail().getEmail());
            if (emp.getPhones().size() > 0) {
                dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
            }
            dto.setBranch(emp.getBranch());
            dto.setWorkStatus(emp.getWorkStatus());
            if (emp.getAddresss().size() > 0) {
                dto.setHomeAddress1(emp.getAddresss().get(0).getStreet1());
                dto.setHomeAddress2(emp.getAddresss().get(0).getStreet2());
                dto.setHomeAddressCity(emp.getAddresss().get(0).getCity());
                dto.setHomeAddressState(emp.getAddresss().get(0).getState());
                dto.setHomeAddressCountry(emp.getAddresss().get(0).getCountry());
                dto.setHomeAddressZip(emp.getAddresss().get(0).getZip());
            }
            if (emp.getEmergencyContacts().size() > 0) {
                dto.setEmergencyContactName(emp.getEmergencyContacts().get(0).getContact().getFirstName() + " " + emp.getEmergencyContacts().get(0).getContact().getLastName());
            }
            res.add(dto);
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "Profile-Information-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    @Async
    @Transactional
    public void generateEmployeClientInfoReport(String email) {
        List<EmployeeClientInfoReportDto> res = new ArrayList<>();
        //TODO using paging
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Employee")) {
            for (ClientInformation ci : emp.getClientInformations()) {
                EmployeeClientInfoReportDto dto = new EmployeeClientInfoReportDto();
                dto.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
                dto.setStartDate(emp.getStartDate());
                dto.setJobTitle(emp.getJobTitle());
                dto.setEmail(EmployeeDao.instance().getPrimaryEmail(emp));
                if (emp.getPhones().size() > 0) {
                    dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
                }
                if (ci.getClient() != null) {
                    dto.setClientName(ci.getClient().getName());
                }
                if (ci.getVendor() != null) {
                    dto.setVendorName(ci.getVendor().getName());
                }
                if (ci.getClientLocation() != null) {
                    dto.setClientLocation(ci.getClientLocation().getCity() + " " + ci.getClientLocation().getState());
                }
                if (ci.getVendorLocation() != null) {
                    dto.setVendorLocation(ci.getVendorLocation().getCity() + " " + ci.getVendorLocation().getState());
                }
                dto.setActive(emp.getUser().isEnabled());
                dto.setBillingRate(ci.getBillingRate());
                dto.setProjectStartDate(ci.getStartDate());
                dto.setProjectEndDate(ci.getEndDate());
                res.add(dto);
            }
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "employee-client-info-report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    /**
     * this will generate a list of employees whose profile is not complete
     *
     * @param email
     */
    @Async
    @Transactional
    public void sendMissingProfileInfoEmail() {
        List<EmployeProfileDto> report = new ArrayList();
        AddressDao addressDao = AddressDao.instance();
        EmployeeDao.instance().getEmployeesByType("Employee", "Corporate Employee").stream().forEach((emp) -> {
            StringBuilder emailBody = new StringBuilder();
            EmployeProfileDto dto = new EmployeProfileDto();
            int profileCompleteCounter = 10;
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            boolean isCorporateEmployee = emp.getEmployeeType().getName().equals("Corporate Employee");
            if (addressDao.getAddressByType(emp, "Home").size() <= 0) {
                emailBody.append("<li>Primary Mailing/Home address is missing </li>").append("</br>");
                profileCompleteCounter--;
            }
            if (!isCorporateEmployee && addressDao.getAddressByType(emp, "Office").size() <= 0) {
                emailBody.append("<li>Work address is missing</li>").append("</br>");
                profileCompleteCounter--;
            }
            if (emp.getPhones().size() <= 0) {
                emailBody.append("<li>No contact phone numbers available</li>").append("</br>");
                profileCompleteCounter--;
            }
            if (emp.getEmergencyContacts().size() <= 0) {
                emailBody.append("<li>No emergency contacts information available</li>").append("</br>");
                profileCompleteCounter--;
            }
            if (emp.getSkillSet().getPractice() == null) {
                emailBody.append("<li>No skill set information available</li>").append("</br>");
                profileCompleteCounter--;
            }
            if (profileCompleteCounter < 10) {
                Email email = new Email();
                email.addTo(emp.getPrimaryEmail().getEmail());
                email.setHtml(true);
                email.setRichText(true);
                email.setSubject("Please review and complete your profile information");
                StringBuilder emailBodyTitle = new StringBuilder();
                emailBodyTitle.insert(0, "Your profile information is not complete. </br> <h4>Its very criticle to have the up-to date information since all departments rely on this information for Correspondance, Immigration, Projects, etc...</h4> </br> Please take a couple of minutes to review and update your information. </br>");
                emailBodyTitle.append("<a href=\"https://apps.sstech.us/site/office/forgot-password.html\">How can i login:</a>").append("</br>");
                emailBodyTitle.append("<a href=\"https://apps.sstech.us/site/office/profile/profile.html\">How can i update my profile:</a>").append("</br>");
                emailBodyTitle.append("<h5>Missing information:</h5>").append("</br>");
                email.setBody(emailBodyTitle.toString() + emailBody.toString());
                MessagingService.instance().sendEmail(email);
                report.add(dto);
            }
        });
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(report, "Profile-Information-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), OfficeServiceConfiguration.instance().getAdminEmail());
    }

    public static ProfileReportsService instance() {
        return SpringContext.getBean(ProfileReportsService.class);
    }
}
