/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.insurance;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.email.Email;
import info.chili.security.Signature;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.insurance.HealthInsurance;
import info.yalamanchili.office.entity.profile.insurance.InsuranceEnrollment;
import info.yalamanchili.office.entity.profile.insurance.InsuranceType;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class HealthInsuranceService {

    @Autowired
    protected HealthInsuranceDao healthInsuranceDao;
    @Autowired
    protected Mapper mapper;

    public Response getReport(HealthInsurance entity) {
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/health-waiver-template.pdf");
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        data.getData().put("firstName", preparedBy.getFirstName());
        data.getData().put("lastName", preparedBy.getLastName());
        data.getData().put("middleName", preparedBy.getMiddleInitial());

        //PreparedBy
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getDateRequested()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getSignatures().add(preparedBysignature);
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = health-insurance.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public List<HealthInsuranceReportDto> getHealthInsuranceReport(String year) {
        if (year == null || year.isEmpty() || year.contains("null")) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "healthinsurance.not.present", "Please select a Year");
        }
        List<HealthInsuranceReportDto> report = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            List<HealthInsurance> insurances = healthInsuranceDao.queryForEmployee(emp.getId(), 0, 50);
            if (insurances != null && insurances.size() > 0) {
                for (HealthInsurance insurance : insurances) {
                    if (insurance.getInsuranceEnrollment() != null && year.equals(insurance.getInsuranceEnrollment().getYear())) {
                        report.add(populateHealthInsuranceEnrollmentInfo(insurance, emp));
                    } else if (insurance.getInsuranceEnrollment() == null) {
                        report.add(populateHealthInsuranceWaiverInfo(insurance, emp));
                    }
                }
            }
        }
        return report;
    }

    public HealthInsuranceReportDto populateHealthInsuranceEnrollmentInfo(HealthInsurance ins, Employee emp) {
        HealthInsuranceReportDto dto = new HealthInsuranceReportDto();
        dto.setEmployee(emp.getFirstName() + " " + emp.getLastName());
        if (emp.getCompany() != null) {
            dto.setCompany(emp.getCompany().getName());
        }
        dto.setEmployeeType(emp.getEmployeeType().getName());
        dto.setStartDate(emp.getStartDate());
        if (emp.getPhones().size() > 0) {
            dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
        }
        dto.setEmail(emp.getPrimaryEmail().getEmail());
        InsuranceEnrollment enrollment = ins.getInsuranceEnrollment();
        if (enrollment.getInsuranceType() != null && enrollment.getInsuranceType().equals(InsuranceType.Health)) {
            dto.setHealth("yes");
            dto.setDental("no");
        } else if (enrollment.getInsuranceType() != null && enrollment.getInsuranceType().equals(InsuranceType.Dental)) {
            dto.setDental("yes");
            dto.setHealth("no");
        }
        if (ins.getEnrolled()) {
            dto.setEnrolled("Enrolled");
            dto.setWaiver("n/a");
        } else {
            dto.setEnrolled("Not Enrolled");
        }
        dto.setYear(ins.getInsuranceEnrollment().getYear());
        return dto;
    }

    public HealthInsuranceReportDto populateHealthInsuranceWaiverInfo(HealthInsurance ins, Employee emp) {
        HealthInsuranceReportDto dto = new HealthInsuranceReportDto();
        dto.setEmployee(emp.getFirstName() + " " + emp.getLastName());
        if (emp.getCompany() != null) {
            dto.setCompany(emp.getCompany().getName());
        }
        dto.setEmployeeType(emp.getEmployeeType().getName());
        dto.setStartDate(emp.getStartDate());
        if (emp.getPhones().size() > 0) {
            dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
        }
        dto.setEmail(emp.getPrimaryEmail().getEmail());
        dto.setHealth("n/a");
        dto.setDental("n/a");
        dto.setWaiver("yes");
        if (ins.getEnrolled()) {
            dto.setEnrolled("Enrolled");
        } else {
            dto.setEnrolled("Not Enrolled");
        }
        return dto;

    }

    public void notSubmittedEmailNotification(HealthInsuranceReportDto dto) {
        if (dto.getYear() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "healthinsurance.not.present", "Please select a Year");
        }
        List<Employee> notSubmittedEmps = new ArrayList();
        if (dto.getEmployee() != null) {
            Employee emp = EmployeeDao.instance().findById(Long.valueOf(dto.getEmployee()));
            List<HealthInsurance> insurances = healthInsuranceDao.queryForEmployee(emp.getId(), 0, 50);
            if (insurances == null || insurances.isEmpty()) {
                notSubmittedEmps.add(emp);
            } else if (insurances.size() > 0) {
                List<InsuranceEnrollment> enrolledInsurances = new ArrayList();
                for (HealthInsurance ins : insurances) {
                    if (ins.getInsuranceEnrollment() != null) {
                        enrolledInsurances.add(ins.getInsuranceEnrollment());
                    }
                }
                if (isInsuranceEnrolled(enrolledInsurances, dto.getYear()) == enrolledInsurances.size()) {
                    notSubmittedEmps.add(emp);
                }
            }
        } else {
            for (Employee emp : EmployeeDao.instance().queryAll(0, 1000)) {
                List<HealthInsurance> insurances = healthInsuranceDao.queryForEmployee(emp.getId(), 0, 50);
                if (insurances == null || insurances.isEmpty()) {
                    notSubmittedEmps.add(emp);
                } else if (insurances.size() > 0) {
                    List<InsuranceEnrollment> enrolledInsurances = new ArrayList();
                    for (HealthInsurance ins : insurances) {
                        if (ins.getInsuranceEnrollment() != null) {
                            enrolledInsurances.add(ins.getInsuranceEnrollment());
                        }
                    }
                    if (isInsuranceEnrolled(enrolledInsurances, dto.getYear()) == enrolledInsurances.size()) {
                        notSubmittedEmps.add(emp);
                    }
                }
            }
        }
        if (notSubmittedEmps.size() > 0) {
            notSubmittedEmail(notSubmittedEmps, dto.getYear());
            notSubmittedEmps.clear();
        }
    }

    private int isInsuranceEnrolled(List<InsuranceEnrollment> enrolledInsurances, String year) {
        int falseCount = 0;
        for (InsuranceEnrollment ins : enrolledInsurances) {
            if (!ins.getYear().equals(year)) {
                falseCount++;
            }
        }
        return falseCount;
    }

    protected void notSubmittedEmailNotification(String empEmail, String year) {
        Email email = new Email();
        email.addTo(empEmail);
        email.setSubject("Health Insurance Not submitted reminder");
        String messageText = "Please submit your Health Insurance for " + year;
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

    protected void notSubmittedEmail(List<Employee> emps, String year) {
        for (Employee emp : emps) {
            Email email = new Email();
            email.addTo(emp.getPrimaryEmail().getEmail());
            email.setSubject("Health Insurance Not submitted reminder");
            String messageText = "Please submit your Health Insurance for " + year;
            email.setBody(messageText);
            MessagingService.instance().sendEmail(email);
        }
        Email email = new Email();
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRole.ROLE_HEALTH_INSURANCE_MANAGER.name()));
        email.setSubject("Health Insurances Not submitted Consolidated Email for " + year);
        String messageText = "Employees, not submitted health insurance waiver for the year " + year;
        email.setBody(messageText);
        HashMap<String, Object> emailContext = new HashMap();
        emailContext.put("employees", emps);
        emailContext.put("year", year);
        email.setContext(emailContext);
        email.setTemplateName("health_insurance_template.html");
        MessagingService.instance().sendEmail(email);
    }

    public static HealthInsuranceService instance() {
        return SpringContext.getBean(HealthInsuranceService.class);
    }

    public List<HealthInsuranceReportDto> getHealthInsuranceDatesReport(List<HealthInsurance> ins, String email, String reportName) {
        List<HealthInsuranceReportDto> report = new ArrayList<>();
        for (HealthInsurance insurance : ins) {
            if (insurance.getInsuranceEnrollment() != null) {
                report.add(populateHealthInsuranceEnrollmentInfo(insurance, insurance.getEmployee()));
            } else if (insurance.getInsuranceEnrollment() == null) {
                report.add(populateHealthInsuranceWaiverInfo(insurance, insurance.getEmployee()));
            }
        }
        return report;
    }
}
