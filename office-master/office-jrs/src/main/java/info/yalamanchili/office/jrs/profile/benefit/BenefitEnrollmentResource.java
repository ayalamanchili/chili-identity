/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.benefit;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.benefit.BenefitEnrollmentDao;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceWaiverDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.benefits.BenefitEnrollment;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.insurance.BenefitenrollmentService;
import info.yalamanchili.office.profile.insurance.HealthInsuranceReportDto;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Benarji.v
 */
@Path("secured/benefit")
@Component
@Transactional
@Scope("request")
public class BenefitEnrollmentResource extends CRUDResource<BenefitEnrollment> {

    @Autowired
    public BenefitEnrollmentDao benefitenrollmentDao;

    @Override
    public CRUDDao getDao() {
        return benefitenrollmentDao;
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        getDao().delete(id);
    }

    @PUT
    @Validate
    @Path("/save/{empId}")
    @AccessCheck(roles = {"ROLE_HEALTH_INSURANCE_MANAGER"})
    public void addBenefit(@PathParam("empId") Long empId, BenefitEnrollment benefitEnrollment) {
        benefitEnrollment.setEmployee(EmployeeDao.instance().findById(empId));
        benefitEnrollment.setBenefitType(benefitEnrollment.getBenefitType());
        List<BenefitEnrollment> benefitEnroll = benefitenrollmentDao.queryForEmployee(benefitEnrollment.getEmployee().getId(), 0, 10);
        if (benefitEnroll != null && benefitEnroll.size() > 0) {
            for (BenefitEnrollment enrollment : benefitEnroll) {
                if (enrollment.getEnrolledYear() != null) {
                    if (benefitEnrollment.getEnrolledYear() != null) {
                        if (enrollment.getEnrolledYear() != null && enrollment.getEnrolledYear().equals(benefitEnrollment.getEnrolledYear())) {
                            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "healthinsurance.year.submitted",
                                    "Health Insurance with the entered year already exists");
                        }
                    }
                }
            }
        }
        HealthInsuranceWaiver healthWaiver = new HealthInsuranceWaiver();
        if (benefitEnrollment.getHealthInsuranceWaiver() != null) {
            healthWaiver = benefitEnrollment.getHealthInsuranceWaiver();
            HealthInsuranceWaiverDao.instance().save(healthWaiver);
        }
        String comment = "Comments:" + benefitEnrollment.getComments();
        benefitEnrollment = super.save(benefitEnrollment);
        CommentDao.instance().addComment(comment, benefitEnrollment);
        if (benefitEnrollment.getHealthInsuranceWaiver() != null) {
            benefitEnrollment.setHealthInsuranceWaiver(healthWaiver);
        }
        getDao().save(benefitEnrollment);
        benefitEnrollment.setId(benefitEnrollment.getId());
        BenefitenrollmentService.instance().sendBenefitEnrollmentCreatedNotification(benefitEnrollment);
    }

    @GET
    @Path("/{empId}/{start}/{limit}")
    public BenefitEnrollmentTable getBenefits(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        BenefitEnrollmentResource.BenefitEnrollmentTable tableObj = new BenefitEnrollmentResource.BenefitEnrollmentTable();
        Employee emp = EmployeeDao.instance().findById(empId);
        tableObj.setEntities(benefitenrollmentDao.instance().getBenefitEnrollment(emp, start, limit));
        tableObj.setSize(benefitenrollmentDao.instance().getBenefitEnrollmentSize(emp, start, limit));
        return tableObj;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public BenefitEnrollment read(@PathParam("id") Long id) {
        return benefitenrollmentDao.findById(id);
    }

    @GET
    @Path("/benefitenrollment-print/{id}")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return BenefitenrollmentService.instance().getReport(benefitenrollmentDao.findById(id));
    }

    @GET
    @Path("/insurance-report")
    public List<HealthInsuranceReportDto> employeeHealthInsuranceReport(@QueryParam("year") String year) {
        List<HealthInsuranceReportDto> report = new ArrayList<>();
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        report = BenefitenrollmentService.instance().getHealthInsuranceReport(year);
        String[] columnOrder = new String[]{"employee", "employeeType", "company", "startDate", "benefitType", "phoneNumber", "email", "year", "enrolled"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(report, " HealthInsurance-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), emp.getPrimaryEmail().getEmail());
        return report;
    }

    @GET
    @Path("/insurance-reportView")
    public List<HealthInsuranceReportDto> employeeHealthInsReportView(@QueryParam("year") String year) {
        return BenefitenrollmentService.instance().getHealthInsuranceReport(year);
    }

    @PUT
    @Path("/get/not-submitted-reminder")
    public void notSubmittedRemainder(HealthInsuranceReportDto dto) {
        BenefitenrollmentService.instance().notSubmittedEmailNotification(dto);
    }

    @GET
    @Path("/insurance-report-dates")
    public void employeeHealthInsuranceDatesReport(@QueryParam("createdDateFrom") Date startDate, @QueryParam("createdDateTo") Date endDate) {
        BenefitEnrollmentResource.BenefitEnrollmentTable table = healthInsuranceReport(startDate, endDate);
        if (table.getSize() != null) {
            String reportName = "Health Insurance Report";
            List<BenefitEnrollment> list = new ArrayList();
            list.addAll(table.getEntities());
            List<HealthInsuranceReportDto> healthInsuranceDatesReport = BenefitenrollmentService.instance().getHealthInsuranceDatesReport(list, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), reportName);
            String[] columnOrder = new String[]{"employee", "employeeType", "company", "startDate", "benefitType", "phoneNumber", "email", "year", "enrolled"};
            String fileName = ReportGenerator.generateExcelOrderedReport(healthInsuranceDatesReport, "Health Insurance Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }

    @GET
    @Path("/{start}/{limit}")
    public BenefitEnrollmentTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        BenefitEnrollmentTable tableObj = new BenefitEnrollmentTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    private BenefitEnrollmentTable healthInsuranceReport(Date startDate, Date endDate) {
        BenefitEnrollmentResource.BenefitEnrollmentTable table = table(0, 10000);
        BenefitEnrollmentResource.BenefitEnrollmentTable resulttable = new BenefitEnrollmentResource.BenefitEnrollmentTable();
        List<BenefitEnrollment> list = new ArrayList();
        List<BenefitEnrollment> finallist = new ArrayList();
        list.addAll(table.getEntities());
        for (BenefitEnrollment ins : list) {
            if (ins.getDateRequested() != null) {
                if (ins.getDateRequested().after(startDate) && ins.getDateRequested().before(endDate)) {
                    finallist.add(ins);
                }
            }
        }
        if (finallist.size() > 0) {
            resulttable.setEntities(finallist);
            resulttable.setSize(Long.valueOf(finallist.size()));
        }
        return resulttable;
    }

    @XmlRootElement
    @XmlType
    public static class BenefitEnrollmentTable implements java.io.Serializable {

        protected Long size;
        protected List<BenefitEnrollment> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BenefitEnrollment> getEntities() {
            return entities;
        }

        public void setEntities(List<BenefitEnrollment> entities) {
            this.entities = entities;
        }

    }

}
