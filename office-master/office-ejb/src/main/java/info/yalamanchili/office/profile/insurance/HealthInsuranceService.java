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
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceDao;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceWaiverDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.insurance.HealthInsurance;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Cobra;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.EmployerSponsoredGroupPlan;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Individual;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Medicare;
import static info.yalamanchili.office.entity.profile.insurance.InsuranceCoverageType.Tricare;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.core.Response;
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

        HealthInsuranceWaiver healthInsuranceWaiver = HealthInsuranceWaiverDao.instance().find(entity);
        if (entity != null) {
            if (healthInsuranceWaiver != null) {
                if (healthInsuranceWaiver.getWaivingCoverageFor() != null) {
                    if (healthInsuranceWaiver.getWaivingCoverageDueTo().equals("waivingCoverageFor")) {
                        data.getData().put("myself", "true");
                        data.getData().put("spouse", "true");
                        data.getData().put("dependent", "true");
                    }
                }
                if (healthInsuranceWaiver.getWaivingCoverageDueTo() != null) {
                    if (healthInsuranceWaiver.getWaivingCoverageDueTo().equals("waivingCoverageDueTo")) {
                        data.getData().put("nocoverage", "true");
                    } else if (healthInsuranceWaiver.getWaivingCoverageDueTo().equals("waivingCoverageDueTo")) {
                        data.getData().put("spouseplan", "true");
                    } else if (healthInsuranceWaiver.getWaivingCoverageDueTo().equals("waivingCoverageDueTo")) {
                        data.getData().put("other", "true");
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
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = health-insurance.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static HealthInsuranceService instance() {
        return SpringContext.getBean(HealthInsuranceService.class);
    }
}
