/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.insurance;

import info.chili.commons.DateUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceDao;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceWaiverDao;
import info.yalamanchili.office.dao.profile.insurance.InsuranceEnrollmentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.insurance.HealthInsurance;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import info.yalamanchili.office.entity.profile.insurance.InsuranceEnrollment;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.insurance.HealthInsuranceReportDto;
import info.yalamanchili.office.profile.insurance.HealthInsuranceService;
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
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/insurance-enrollment")
@Component
@Transactional
@Scope("request")
public class HealthInsuranceResource extends CRUDResource<HealthInsurance> {

    @Autowired
    public HealthInsuranceDao healthInsuranceDao;
    @Autowired
    public HealthInsuranceService healthInsuranceService;

    @Autowired
    protected Mapper mapper;

    @Override
    public CRUDDao getDao() {
        return healthInsuranceDao;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public HealthInsurance read(@PathParam("id") Long id) {
        return healthInsuranceDao.findById(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public HealthInsuranceTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        HealthInsuranceTable tableObj = new HealthInsuranceTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @GET
    @Path("/{empId}/{start}/{limit}")
    public HealthInsuranceTable table(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        HealthInsuranceTable tableObj = new HealthInsuranceTable();
        tableObj.setEntities(healthInsuranceDao.queryForEmployee(empId, start, limit));
        tableObj.setSize(healthInsuranceDao.size(empId));
        return tableObj;
    }

    @PUT
    @Validate
    @Override
    public HealthInsurance save(HealthInsurance entity) {
        HealthInsurance insurance = new HealthInsurance();
        insurance.setEnrolled(entity.getEnrolled());
        insurance.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        insurance.setDateRequested(new Date());
        List<HealthInsurance> insurances = healthInsuranceDao.queryForEmployee(insurance.getEmployee().getId(), 0, 10);
        if (insurances != null && insurances.size() > 0) {
            for (HealthInsurance ins : insurances) {
                if (ins.getInsuranceEnrollment() != null) {
                    if (entity.getInsuranceEnrollment() != null) {
                        if (ins.getInsuranceEnrollment().getId() != null && ins.getInsuranceEnrollment().getYear().equals(entity.getInsuranceEnrollment().getYear())) {
                            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "healthinsurance.year.submitted",
                                    "Health Insurance with the entered year already exists");
                        }
                        InsuranceEnrollment entityEnrollment = entity.getInsuranceEnrollment();
                        entityEnrollment.setTargetEntityId(insurance.getEmployee().getId());
                        entityEnrollment.setTargetEntityName(InsuranceEnrollment.class.getCanonicalName());
                        InsuranceEnrollment insEnrollment = InsuranceEnrollmentDao.instance().save(entityEnrollment);
                        insurance.setInsuranceEnrollment(insEnrollment);
                    } else if (entity.getHealthInsuranceWaiver() != null) {
                        if (ins.getInsuranceEnrollment().getYear() != null && ins.getInsuranceEnrollment().getYear().equals(String.valueOf(DateUtils.getYearFromDate(new Date())))) {
                            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "health.insurance.already.enrolled",
                                    "Health Insurance already enrolled with the current year");
                        }
                        HealthInsuranceWaiver entityWaiver = entity.getHealthInsuranceWaiver();
                        HealthInsuranceWaiver waiverNew = HealthInsuranceWaiverDao.instance().save(entityWaiver);
                        insurance.setHealthInsuranceWaiver(waiverNew);
                    }
                } else if (ins.getHealthInsuranceWaiver() != null) {
                    if (entity.getInsuranceEnrollment() != null) {

                        InsuranceEnrollment entityEnrollment = entity.getInsuranceEnrollment();
                        entityEnrollment.setTargetEntityId(insurance.getEmployee().getId());
                        entityEnrollment.setTargetEntityName(InsuranceEnrollment.class.getCanonicalName());
                        InsuranceEnrollment insEnrollment = InsuranceEnrollmentDao.instance().save(entityEnrollment);
                        insurance.setInsuranceEnrollment(insEnrollment);
                    }
                } else {
                    InsuranceEnrollment entityEnrollment = entity.getInsuranceEnrollment();
                    entityEnrollment.setTargetEntityId(insurance.getEmployee().getId());
                    entityEnrollment.setTargetEntityName(InsuranceEnrollment.class.getCanonicalName());
                    InsuranceEnrollment insEnrollment = InsuranceEnrollmentDao.instance().save(entityEnrollment);
                    insurance.setInsuranceEnrollment(insEnrollment);
                }
            }
        } else {
            if (entity.getInsuranceEnrollment() != null) {
                InsuranceEnrollment entityEnrollment = entity.getInsuranceEnrollment();
                entityEnrollment.setTargetEntityId(OfficeSecurityService.instance().getCurrentUser().getId());
                entityEnrollment.setTargetEntityName(InsuranceEnrollment.class.getCanonicalName());
                InsuranceEnrollment insEnrollment = InsuranceEnrollmentDao.instance().save(entityEnrollment);
                insurance.setInsuranceEnrollment(insEnrollment);
            }
            if (entity.getHealthInsuranceWaiver() != null) {
                HealthInsuranceWaiver entityWaiver = entity.getHealthInsuranceWaiver();
                HealthInsuranceWaiver waiverNew = HealthInsuranceWaiverDao.instance().save(entityWaiver);
                insurance.setHealthInsuranceWaiver(waiverNew);
            }
        }
        return HealthInsuranceDao.instance().save(insurance);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/insurance-print")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return HealthInsuranceService.instance().getReport(healthInsuranceDao.findById(id));
    }

    @GET
    @Path("/insurance-report")
    public List<HealthInsuranceReportDto> employeeHealthInsuranceReport(@QueryParam("year") String year) {
        List<HealthInsuranceReportDto> report = new ArrayList<>();
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        report = healthInsuranceService.getHealthInsuranceReport(year);
        String[] columnOrder = new String[]{"employee", "employeeType", "company", "startDate", "waiver", "health", "dental", "phoneNumber", "email", "year", "enrolled"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(report, " HealthInsurance-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), emp.getPrimaryEmail().getEmail());
        return report;
    }

    @GET
    @Path("/insurance-reportView")
    public List<HealthInsuranceReportDto> employeeHealthInsReportView(@QueryParam("year") String year) {
        return healthInsuranceService.getHealthInsuranceReport(year);
    }

    @PUT
    @Path("/get/not-submitted-reminder")
    public void notSubmittedRemainder(HealthInsuranceReportDto dto) {
        healthInsuranceService.notSubmittedEmailNotification(dto);
    }

    @GET
    @Path("/insurance-report-dates")
    public void employeeHealthInsuranceDatesReport(@QueryParam("createdDateFrom") Date startDate, @QueryParam("createdDateTo") Date endDate) {
        HealthInsuranceResource.HealthInsuranceTable table = healthInsuranceReport(startDate, endDate);
        if (table.getSize() != null) {
            String reportName = "Health Insurance Report";
            List<HealthInsurance> list = new ArrayList();
            list.addAll(table.getEntities());
            List<HealthInsuranceReportDto> healthInsuranceDatesReport = HealthInsuranceService.instance().getHealthInsuranceDatesReport(list, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), reportName);
            String[] columnOrder = new String[]{"employee", "employeeType", "company", "startDate", "waiver", "health", "dental", "phoneNumber", "email", "year", "enrolled"};
            String fileName = ReportGenerator.generateExcelOrderedReport(healthInsuranceDatesReport, "Health Insurance Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }

    private HealthInsuranceTable healthInsuranceReport(Date startDate, Date endDate) {
        HealthInsuranceResource.HealthInsuranceTable table = table(0, 10000);
        HealthInsuranceResource.HealthInsuranceTable resulttable = new HealthInsuranceResource.HealthInsuranceTable();
        List<HealthInsurance> list = new ArrayList();
        List<HealthInsurance> finallist = new ArrayList();
        list.addAll(table.getEntities());
        for (HealthInsurance ins : list) {
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
    public static class HealthInsuranceTable implements java.io.Serializable {

        protected Long size;
        protected List<HealthInsurance> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<HealthInsurance> getEntities() {
            return entities;
        }

        public void setEntities(List<HealthInsurance> entities) {
            this.entities = entities;
        }
    }
}
