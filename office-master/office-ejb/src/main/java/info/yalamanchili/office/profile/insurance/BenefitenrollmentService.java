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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.benefit.BenefitEnrollmentDao;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceWaiverDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.benefits.BenefitEnrollment;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Cobra;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.EmployerSponsoredGroupPlan;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Individual;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Medicare;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Tricare;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class BenefitenrollmentService {

    @Autowired
    protected BenefitEnrollmentDao benefitEnrollmentDao;
    @Autowired
    protected Mapper mapper;

    public Response getReport(Long id) {
        BenefitEnrollment entity = benefitEnrollmentDao.findById(id);
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/health-waiver-template.pdf");
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        data.getData().put("firstName", preparedBy.getFirstName());
        data.getData().put("lastName", preparedBy.getLastName());
        data.getData().put("middleName", preparedBy.getMiddleInitial());

        //PreparedBy
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getEffectiveDate()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getSignatures().add(preparedBysignature);

        HealthInsuranceWaiver healthInsuranceWaiver = HealthInsuranceWaiverDao.instance().getEntityManager().find(HealthInsuranceWaiver.class, id);
        if (entity != null) {
            if (healthInsuranceWaiver != null) {
                if (healthInsuranceWaiver.getWaivingCoverageFor() != null) {
                    if (healthInsuranceWaiver.getWaivingCoverageFor().contains("MySelf")) {
                        data.getData().put("myself", "true");
                    }
                    if (healthInsuranceWaiver.getWaivingCoverageFor().contains("Spouse")) {
                        data.getData().put("spouse", "true");
                    }
                    if (healthInsuranceWaiver.getWaivingCoverageFor().contains("Dependent")) {
                        data.getData().put("dependent", "true");
                    }
                }
                if (healthInsuranceWaiver.getWaivingCoverageDueTo() != null) {
                    if (healthInsuranceWaiver.getWaivingCoverageDueTo().equalsIgnoreCase("NoCoverage")) {
                        data.getData().put("nocoverage", "true");
                    } else if (healthInsuranceWaiver.getWaivingCoverageDueTo().equalsIgnoreCase("SpousePlan")) {
                        data.getData().put("spouseplan", "true");
                    } else if (healthInsuranceWaiver.getWaivingCoverageDueTo().equalsIgnoreCase("Other")) {
                        data.getData().put("otherC", "true");
                    }
                }
                if (healthInsuranceWaiver.getSpouseName() != null) {
                    data.getData().put("spouseName", healthInsuranceWaiver.getSpouseName());
                }
                if (healthInsuranceWaiver.getDependentName() != null) {
                    data.getData().put("dependentName", healthInsuranceWaiver.getDependentName());
                }
                if (healthInsuranceWaiver.getSpouseNameOfCarrier() != null) {
                    data.getData().put("spouseNameOfCarrier", healthInsuranceWaiver.getSpouseNameOfCarrier());
                }
                if (healthInsuranceWaiver.getOtherNameOfCarrier() != null) {
                    data.getData().put("otherNameOfCarrier", healthInsuranceWaiver.getOtherNameOfCarrier());
                }
                data.getData().put("year", new SimpleDateFormat("MM/dd/yyyy").format(new Date()).split("/")[2]);
                if (healthInsuranceWaiver.getSubmittedDate() != null) {
                    data.getData().put("submittedDate", new SimpleDateFormat("MM-dd-yyyy").format(healthInsuranceWaiver.getSubmittedDate()));
                }
                if (healthInsuranceWaiver.getOtherCarrierType() != null) {
                    switch (healthInsuranceWaiver.getOtherCarrierType()) {
                        case Individual:
                            data.getData().put("individual", "true");
                            break;
                        case Cobra:
                            data.getData().put("cobra", "true");
                            break;
                        case Medicare:
                            data.getData().put("medicare", "true");
                            break;
                        case Tricare:
                            data.getData().put("tricare", "true");
                            break;
                        case EmployerSponsoredGroupPlan:
                            data.getData().put("employerSponsoredGroupPlan", "true");
                            break;
                    }
                }
            }
        }
        String empCompanyLogo = "";
        if (preparedBy.getCompany() != null) {
            empCompanyLogo = preparedBy.getCompany().getLogoURL().replace("entityId", preparedBy.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);
        return Response.ok(pdf)
                .header("content-disposition", "filename = health-insurance.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static BenefitenrollmentService instance() {
        return SpringContext.getBean(BenefitenrollmentService.class);
    }

    public List<HealthInsuranceReportDto> getHealthInsuranceReport(String year) {
        if (year == null || year.isEmpty() || year.contains("null")) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "benefit.not.present", "Please select a Year");
        }
        List<HealthInsuranceReportDto> report = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            List<BenefitEnrollment> insurances = benefitEnrollmentDao.queryForEmployee(emp.getId(), 0, 50);
            if (insurances != null && insurances.size() > 0) {
                for (BenefitEnrollment insurance : insurances) {
                    if (insurance != null && year.equals(insurance.getEnrolledYear())) {
                        report.add(populateHealthInsuranceEnrollmentInfo(insurance, emp));
                    } else if (insurance == null) {
                        report.add(populateHealthInsuranceWaiverInfo(insurance, emp));
                    }
                }
            }
        }
        return report;
    }

    public HealthInsuranceReportDto populateHealthInsuranceEnrollmentInfo(BenefitEnrollment ins, Employee emp) {
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
        if (ins.getBenefitType() != null) {
            dto.setBenefitType(ins.getBenefitType().name());
        }
        if (ins.getEnrolled() != null) {
            if (ins.getEnrolled()) {
                dto.setEnrolled("Yes");
            } else {
                dto.setEnrolled("No");
            }
        }
        dto.setEmail(emp.getPrimaryEmail().getEmail());

        dto.setYear(ins.getEnrolledYear());
        return dto;
    }

    public HealthInsuranceReportDto populateHealthInsuranceWaiverInfo(BenefitEnrollment ins, Employee emp) {
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
        if (ins.getBenefitType() != null) {
            dto.setBenefitType(ins.getBenefitType().name());
        }
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
            List<BenefitEnrollment> insurances = benefitEnrollmentDao.queryForEmployee(emp.getId(), 0, 1000);
            if (insurances == null || insurances.isEmpty()) {
                notSubmittedEmps.add(emp);
            } else if (insurances.size() > 0) {
                List<BenefitEnrollment> enrolledInsurances = new ArrayList();
                for (BenefitEnrollment ins : insurances) {
                    if (ins != null) {
                        enrolledInsurances.add(ins);
                    }
                }
                if (isInsuranceEnrolled(enrolledInsurances, dto.getYear()) > 0) {
                    notSubmittedEmps.add(emp);
                }
            }
        } else {
            for (Employee emp : EmployeeDao.instance().queryAll(0, 1000)) {
                List<BenefitEnrollment> insurances = benefitEnrollmentDao.queryForEmployee(emp.getId(), 0, 50);
                if (insurances == null || insurances.isEmpty()) {
                    notSubmittedEmps.add(emp);
                } else if (insurances.size() > 0) {
                    List<BenefitEnrollment> enrolledInsurances = new ArrayList();
                    for (BenefitEnrollment ins : insurances) {
                        if (ins != null) {
                            enrolledInsurances.add(ins);
                        }
                    }
                    if (isInsuranceEnrolled(enrolledInsurances, dto.getYear()) > 0) {
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

    private int isInsuranceEnrolled(List<BenefitEnrollment> enrolledInsurancess, String year) {
        int falseCount = 0;
        for (BenefitEnrollment ins : enrolledInsurancess) {
            if (!ins.getEnrolledYear().equals(year)) {
                falseCount++;
            }
        }
        return falseCount;
    }

    @Async
    @Transactional
    public void sendBenefitEnrollmentCreatedNotification(BenefitEnrollment clnt) {
        Email email = new Email();
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_HEALTH_INSURANCE_MANAGER.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_RECEIVABLE.name()));
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setSubject("Benefit Enrollment " + clnt.getEmployee().getFirstName() + " " + clnt.getEmployee().getLastName() + " Has Created");
        String messageText = " <b><u>System Soft Tech BenefitEnrollment Notification :</b></u> </br> ";
        messageText = messageText.concat("</br> <b>Benefit Type &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; :</b> " + clnt.getBenefitType().name());
        messageText = messageText.concat("</br> <b>Benefit Enrollment Year &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; :</b> " + clnt.getEnrolledYear());
        messageText = messageText.concat("</br> <b>Benefit Enrollment Comment &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; :</b> " + clnt.getComments());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
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

    public List<HealthInsuranceReportDto> getHealthInsuranceDatesReport(List<BenefitEnrollment> ins, String email, String reportName) {
        List<HealthInsuranceReportDto> report = new ArrayList<>();
        for (BenefitEnrollment insurance : ins) {
            if (insurance != null) {
                report.add(populateHealthInsuranceEnrollmentInfo(insurance, insurance.getEmployee()));
            }
        }
        return report;
    }
}
