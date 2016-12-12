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
import info.chili.email.Email;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
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
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            EmployeeBasicInfoReportDto dto = mapper.map(emp, EmployeeBasicInfoReportDto.class);
            dto.setEmail(EmployeeDao.instance().getPrimaryEmail(emp));
            dto.setType(emp.getEmployeeType().getName());
            if (emp.getBranch() != null) {
                dto.setBranchName(emp.getBranch().name());
            }
            dto.setDateOfBirth(emp.getDateOfBirth());
            if (emp.getPhones().size() > 0) {
                dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
            }
            if (emp.getCompany() != null) {
                dto.setCompany(emp.getCompany().getName());
            }
            res.add(dto);
        }
        String[] columnOrder = new String[]{"firstName", "lastName", "startDate", "dateOfBirth", "type", "branchName", "phoneNumber", "jobTitle", "email", "company"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Employee-Basic-Info-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateProfileReport(String email) {
        List<EmployeProfileDto> res = new ArrayList();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            EmployeProfileDto dto = new EmployeProfileDto();
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            if (emp.getMiddleInitial() != null) {
                dto.setMiddleInitial(emp.getMiddleInitial());
            }
            dto.setEmployee_Type(emp.getEmployeeType().getName());
            if (emp.getDateOfBirth() != null) {
                dto.setDateOfBirth(emp.getDateOfBirth());
            }
            if (emp.getCompany() != null) {
                dto.setCompny(emp.getCompany().getName());
            }
            dto.setStartDate(emp.getStartDate());
            if (emp.getJobTitle() != null) {
                dto.setJobTitle(emp.getJobTitle());
            }
            if (emp.getHoursPerWeek() != null) {
                dto.setHoursPerWeek(emp.getHoursPerWeek());
            }
            if (emp.getPhones().size() > 0 && emp.getPhones().get(0).getExtension() != null) {
                dto.setPhoneNumberExt(emp.getPhones().get(0).getExtension());
            }
            for (CompanyContact contact : CompanyContactDao.instance().getEmployeeCompanyContacts(emp.getId())) {
                if (contact.getType().getName().equalsIgnoreCase("Reports_To")) {
                    dto.setReportsManager(contact.getContact().getFirstName() + " " + contact.getContact().getLastName());
                }
            }
            dto.setEmployeeId(emp.getEmployeeId());
            if (emp.getEndDate() != null) {
                dto.setEndDate(emp.getEndDate());
            }
            dto.setEmail(emp.getPrimaryEmail().getEmail());
            if (emp.getPhones().size() > 0) {
                dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
            }
            if (emp.getBranch() != null) {
                dto.setBranchName(emp.getBranch().name());
            }
            if (emp.getWorkStatus() != null) {
                dto.setWork_Status(emp.getWorkStatus().name());
            }
            if (emp.getAddresss().size() > 0) {
                dto.setHomeAddress(emp.getAddresss().get(0).getStreet1() + "-" + emp.getAddresss().get(0).getStreet2() + "-" + emp.getAddresss().get(0).getCity() + "-" + emp.getAddresss().get(0).getState() + "-" + emp.getAddresss().get(0).getCountry() + "-" + emp.getAddresss().get(0).getZip());
            }
            dto.setGender(emp.getSex().name().toLowerCase());
            if (emp.getEmergencyContacts().size() > 0) {
                String ecContactInfo = "\n";
                ecContactInfo = ecContactInfo.concat(emp.getEmergencyContacts().get(0).getContact().getFirstName() + " " + emp.getEmergencyContacts().get(0).getContact().getLastName() + "\n" + emp.getEmergencyContacts().get(0).getContact().getPhones().get(0).getPhoneNumber() + "\n");
                if (emp.getEmergencyContacts().get(0).getContact().getEmails().size() > 0) {
                    ecContactInfo = ecContactInfo.concat(emp.getEmergencyContacts().get(0).getContact().getEmails().get(0).getEmail());
                }
                dto.setEmergencyContactInfo(ecContactInfo);
            }
            res.add(dto);
        }
        String[] columnOrder = new String[]{"employeeId", "firstName", "middleInitial", "lastName", "gender", "employee_Type", "compny", "startDate", "endDate", "dateOfBirth", "email", "branchName", "jobTitle", "work_Status", "reportsManager", "hoursPerWeek", "phoneNumber", "phoneNumberExt", "emergencyContactInfo", "homeAddress"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Profile-Information-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateEmployeClientInfoReport(String email) {
        List<EmployeeClientInfoReportDto> res = new ArrayList<>();
        //TODO using paging
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.EMPLOYEE, EmployeeType._1099_CONTRACTOR, EmployeeType.SUBCONTRACTOR)) {
            for (ClientInformation ci : emp.getClientInformations()) {
                EmployeeClientInfoReportDto dto = new EmployeeClientInfoReportDto();
                dto.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
                dto.setStartDate(emp.getStartDate());
                dto.setJobTitle(emp.getJobTitle());
                dto.setEmployee_Type(emp.getEmployeeType().getName());
                dto.setEmail(EmployeeDao.instance().getPrimaryEmail(emp));
                if (ci.getPayRate1099() != null) {
                    dto.setPayRate1099(ci.getPayRate1099());
                }
                if (ci.getSubcontractorPayRate() != null) {
                    dto.setSubPayRate(ci.getSubcontractorPayRate());
                }
                if (emp.getPhones().size() > 0) {
                    dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
                }
                dto.setClientName(ci.getClient().getName());
                if (ci.getVendor() != null) {
                    dto.setVendorName(ci.getVendor().getName());
                }
                if (ci.getClientLocation() != null) {
                    dto.setClientLocation(ci.getClientLocation().getCity() + " " + ci.getClientLocation().getState());
                }
                if (emp.getUser().isEnabled()) {
                    dto.setActive("Yes");
                } else {
                    dto.setActive("No");
                }

                if (ci.getBillingRate() != null) {
                    dto.setBillingRate(ci.getBillingRate());
                }
                dto.setProjectStartDate(ci.getStartDate());
                if (ci.getEndDate() != null) {
                    dto.setProjectEndDate(ci.getEndDate());
                }
                res.add(dto);
            }
        }
        String[] columnOrder = new String[]{"employeeName", "employee_Type", "jobTitle", "startDate", "active", "email", "phoneNumber", "clientName", "clientLocation", "vendorName", "billingRate", "payRate1099", "subPayRate", "projectStartDate", "projectEndDate"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "employee-client-info-report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
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
        EmployeeDao.instance().getEmployeesByType(EmployeeType.EMPLOYEE, EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.INTERN_SEASONAL_EMPLOYEE).stream().forEach((emp) -> {
            StringBuilder emailBody = new StringBuilder();
            EmployeProfileDto dto = new EmployeProfileDto();
            int profileCompleteCounter = 10;
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            boolean isCorporateEmployee = emp.getEmployeeType().getName().equals(EmployeeType.CORPORATE_EMPLOYEE);
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
            if (emp.getSkillSet() == null || emp.getSkillSet().getPractice() == null) {
                emailBody.append("<li>No skill set information available</li>").append("</br>");
                profileCompleteCounter--;
            }
            if (profileCompleteCounter < 10) {
                Email email = new Email();
                email.addTo(emp.getPrimaryEmail().getEmail());
                email.setHtml(true);
                email.setRichText(true);
                email.setHtml(Boolean.TRUE);
                email.setRichText(Boolean.TRUE);
                email.setSubject("Please review and complete your profile information");
                StringBuilder emailBodyTitle = new StringBuilder();
                emailBodyTitle.insert(0, "Your profile information is not complete. </br> Its very critical to have the up-to date information since all departments rely on this information for Correspondance, Immigration, Projects, etc... </br> Please take a couple of minutes to review and update your information. </br>");
                emailBodyTitle.append("<a href=\"https://apps.sstech.us/site/office/forgot-password.html\">How can i login:</a>").append("</br>");
                emailBodyTitle.append("<a href=\"https://apps.sstech.us/site/office/profile/profile.html\">How can i update my profile:</a>").append("</br> </br>");
                emailBodyTitle.append("<h5> <b> <u> Missing information:</h5> </b> </u>").append("</br>");
                email.setBody(emailBodyTitle.toString() + emailBody.toString());
                MessagingService.instance().sendEmail(email);
                report.add(dto);
            }
        });
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(report, "Profile-Information-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), OfficeServiceConfiguration.instance().getAdminEmail());
    }

    @Async
    @Transactional
    public void generateEmployeCompanyContactsReport(String email) {
        List<EmployeeBasicInfoReportDto> report = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.SUBCONTRACTOR, EmployeeType.INTERN_SEASONAL_EMPLOYEE, EmployeeType.W2_CONTRACTOR, EmployeeType._1099_CONTRACTOR)) {
            for (CompanyContact contact : CompanyContactDao.instance().getEmployeeCompanyContacts(emp.getId())) {
                EmployeeBasicInfoReportDto dto = new EmployeeBasicInfoReportDto();
                dto.setFirstName(emp.getFirstName());
                dto.setLastName(emp.getLastName());
                dto.setManager(contact.getContact().getFirstName() + " " + contact.getContact().getLastName());
                dto.setType(contact.getType().getName());
                report.add(dto);
            }
        }
        String[] columnOrder = new String[]{"firstName", "lastName", "type", "manager"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(report, "Employee-Compnay-Contact-Info-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    public static ProfileReportsService instance() {
        return SpringContext.getBean(ProfileReportsService.class);
    }
}
