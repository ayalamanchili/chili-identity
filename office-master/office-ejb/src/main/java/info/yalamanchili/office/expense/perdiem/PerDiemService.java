/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.perdiem;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.perdiem.PerDiemDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.Perdiem.PerDiem;
import info.yalamanchili.office.entity.expense.Perdiem.PerDiemStatus;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("request")
public class PerDiemService {

    @Autowired
    protected PerDiemDao perDiemDao;

    public PerDiem save(PerDiem perDiem) {
        PerDiem perDiemObj = new PerDiem();
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        perDiemObj.setTargetEntityName(PerDiem.class.getCanonicalName());
        perDiemObj.setTargetEntityId(emp.getId());
        if (perDiem.getAddresses() != null && perDiem.getAddresses().size() > 0) {
            for (Address address : perDiem.getAddresses()) {
                if (address.getStreet1() != null) {
                    AddressDao.instance().save(address);
                    emp.addAddress(address);
                }
            }
        }
        perDiemObj.setLive50MilesAway(perDiem.isLive50MilesAway());
        perDiemObj.setPerDiemStartDate(perDiem.getPerDiemStartDate());
        perDiemObj.setPerDiemEndDate(perDiem.getPerDiemEndDate());
        perDiemObj.setAmount(perDiem.getAmount());
        perDiemObj.setPercentage(perDiem.getPercentage());
        perDiemObj.setEmployee(emp);
        perDiemObj.setSubmittedDate(new Date());
        perDiemObj.setStatus(PerDiemStatus.Pending_Payroll_Approval);
        PerDiem entity = perDiemDao.save(perDiemObj);
        Map<String, Object> vars = new HashMap<>();
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        vars.put("entityId", entity.getId());
        entity.setBpmProcessId(OfficeBPMService.instance().startProcess("perdiem_request_process", vars));
        perDiemDao.getEntityManager().merge(entity);
        perDiemObj.setBpmProcessId(entity.getBpmProcessId());
        perDiemObj.setId(entity.getId());
        return perDiemObj;
    }

    public PerDiem update(PerDiem perdiem) {
        PerDiem perdiemObj = perDiemDao.findById(perdiem.getId());
        perdiemObj.setPerDiemStartDate(perdiem.getPerDiemStartDate());
        perdiemObj.setPerDiemEndDate(perdiem.getPerDiemEndDate());
        perdiemObj.setAmount(perdiem.getAmount());
        perdiemObj.setPercentage(perdiem.getPercentage());
        return perdiemObj;
    }

    public Response getReport(PerDiem entity, List<Address> addresses) {
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/perdiem-requisition-template.pdf");
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("employeename", prepareByStr);
        if (entity.isLive50MilesAway() == true) {
            data.getData().put("live50MilesAway", "On");
        } else {
            data.getData().put("maintainTwoResidences", "On");
        }
        if (addresses != null && addresses.size() > 0) {
            for (Address address : addresses) {
                if (entity.isLive50MilesAway() == false) {
                    if (address.getAddressType().getAddressType().equals("Home")) {
                        data.getData().put("permanentstreet1", address.getStreet1());
                        data.getData().put("permanentstreet2", address.getStreet2());
                        data.getData().put("permanentcity", address.getCity());
                        data.getData().put("permanentstate", address.getState());
                        data.getData().put("permanentzip", address.getZip());
                    } else if (address.getAddressType().getAddressType().equals("Other")) {
                        data.getData().put("temporarystreet1", address.getStreet1());
                        data.getData().put("temporarystreet2", address.getStreet2());
                        data.getData().put("temporarycity", address.getCity());
                        data.getData().put("temporarystate", address.getState());
                        data.getData().put("temporaryzip", address.getZip());
                    }
                } else {
                    if (address.getAddressType().getAddressType().equals("Office")) {
                        data.getData().put("workstreet1", address.getStreet1());
                        data.getData().put("workstreet2", address.getStreet2());
                        data.getData().put("workcity", address.getCity());
                        data.getData().put("workstate", address.getState());
                        data.getData().put("workzip", address.getZip());
                    } else if (address.getAddressType().getAddressType().equals("Home")) {
                        data.getData().put("permanentstreet3", address.getStreet1());
                        data.getData().put("permanentstreet4", address.getStreet2());
                        data.getData().put("permanentcity1", address.getCity());
                        data.getData().put("permanentstate1", address.getState());
                        data.getData().put("permanentzip1", address.getZip());
                    }
                }
            }
        }
        data.getData().put("check", "On");
        Date submittedDate = null;
        submittedDate = entity.getSubmittedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        data.getData().put("currentDate", sdf.format(submittedDate));
        Signature signature = new Signature(entity.getEmployee().getEmployeeId(), entity.getEmployee().getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(submittedDate), entity.getEmployee().getPrimaryEmail().getEmail(), null);
        data.getSignatures().add(signature);
        String empCompanyLogo = "";
        if (preparedBy.getCompany() != null) {
            empCompanyLogo = preparedBy.getCompany().getLogoURL().replace("entityId", preparedBy.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);
        return Response.ok(pdf)
                .header("content-disposition", "filename = perdiem-requisition.pdf")
                .header("Content-Length", pdf.length)
                .build();

    }

    public static PerDiemService instance() {
        return SpringContext.getBean(PerDiemService.class);
    }

}
