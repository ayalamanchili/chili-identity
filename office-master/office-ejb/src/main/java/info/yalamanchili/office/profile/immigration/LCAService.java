/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.entity.immigration.LCADto;
import info.yalamanchili.office.entity.immigration.LCAStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("request")
public class LCAService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected LCADao lcaDao;
    @Autowired
    protected EmployeeDao employeeDao;
    @Autowired
    protected CompanyDao companyDao;

    public LCA saveLCA(LCADto dto) {
        LCA lca = mapper.map(dto, LCA.class);
        if (lca.getStatus() == null) {
            lca.setStatus(LCAStatus.Pending);
        }
        if (lca.getCompany() != null) {
            lca.setCompany(companyDao.findById(lca.getCompany().getId()));
        }
        lca.setWorkedByEmployees(null);
        for (Employee emp : dto.getWorkedByEmployees()) {
            if (emp.getId() != null) {
                lca.addWorkedByEmployee(employeeDao.findById(emp.getId()));
            }
        }
        lca = lcaDao.save(lca);
        String comment = lca.getComment();
        CommentDao.instance().addComment(comment, lca);
        CommentDao.instance().addComment(lca.getComment(), lca);
//        lca = lcaDao.save(lca);
        return lca;
    }

    public LCA updateLCA(LCADto dto) {
        LCA lca = mapper.map(dto, LCA.class);
        if (lca.getStatus() == null) {
            lca.setStatus(LCAStatus.Pending);
        }
        if (lca.getCompany() != null) {
            lca.setCompany(companyDao.findById(lca.getCompany().getId()));
        }
        lca.setWorkedByEmployees(null);
        Set<Employee> newRecs = new HashSet();
        for (Employee emp : dto.getWorkedByEmployees()) {
            if (emp.getId() != null) {
                newRecs.add(employeeDao.findById(emp.getId()));
            }
        }
        lca.setWorkedByEmployees(newRecs);
        String comment = lca.getComment();
        CommentDao.instance().addComment(comment, lca);
        CommentDao.instance().addComment(lca.getComment(), lca);
        lca = em.merge(lca);
        return lca;
    }

    public static LCAService instance() {
        return SpringContext.getBean(LCAService.class);
    }

    @Async
    @Transactional
    public void generateLcaReport(String email) {
        List<LCAMasterReportDto> res = new ArrayList();
        for (LCA lca : lcaDao.query(0, 2000)) {
            res.add(populateLcaInfo(lca));
        }
        String[] columnOrder = new String[]{"candidateNames", "totalWorkingPositions", "totalPendingPositions", "visaClassification", "socCodesAndOccupations", "workedByEmployees", "company", "lcaAddress1", "lcaAddress2", "lcaCurrWageLvl", "lcaCurrMinWage", "lcaCurrMaxWage", "jobTitle", "withdrawnLCANumber", "lcaNumber", "lcaFiledDate", "lcaValidFromDate", "lcaValidToDate", "status", "clientName", "vendorName", "lcaPostingSentToVendor", "responseOnLcaPosting", "reminderEmail", "certifiedLcaSentConsultant", "lcaPostingSSTLocation", "lcaFiledInPIF", "nonDisplacement", "comment"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "LCA Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    public LCAMasterReportDto populateLcaInfo(LCA lca) {
        LCAMasterReportDto dto = new LCAMasterReportDto();
        if (lca.getCandidateNames() != null) {
            dto.setCandidateNames(lca.getCandidateNames());
        }
        dto.setLcaNumber(lca.getLcaNumber());
        if (lca.getTotalWorkingPositions() != null) {
            dto.setTotalWorkingPositions(lca.getTotalWorkingPositions());
        }
        if (lca.getTotalPendingPositions() != null) {
            dto.setTotalPendingPositions(lca.getTotalPendingPositions());
        }
        dto.setVisaClassification(lca.getVisaClassification().name());
        if (lca.getSocCodesAndOccupations() != null) {
            dto.setSocCodesAndOccupations(lca.getSocCodesAndOccupations().name().toLowerCase().replaceAll("_", " "));
        }
        if (lca.getCandidateNames() != null) {
            dto.setCandidateNames(lca.getCandidateNames());
        }
        if (lca.getCompany() != null) {
            dto.setCompany(lca.getCompany().getName());
        }
        if (lca.getLcaAddress1() != null) {
            dto.setLcaAddress1(lca.getLcaAddress1().getStreet1() + "-" + lca.getLcaAddress1().getStreet2() + "-" + lca.getLcaAddress1().getCity() + "-" + lca.getLcaAddress1().getState() + "-" + lca.getLcaAddress1().getCountry() + "-" + lca.getLcaAddress1().getZip());
        }
        if (lca.getLcaAddress2() != null) {
            dto.setLcaAddress2(lca.getLcaAddress2().getStreet1() + "-" + lca.getLcaAddress2().getStreet2() + "-" + lca.getLcaAddress2().getCity() + "-" + lca.getLcaAddress2().getState() + "-" + lca.getLcaAddress2().getCountry() + "-" + lca.getLcaAddress2().getZip());
        }
        dto.setLcaCurrWageLvl(lca.getLcaCurrWageLvl().name());
        dto.setLcaCurrMinWage(lca.getLcaCurrMinWage());
        if (lca.getLcaCurrMaxWage() != null) {
            dto.setLcaCurrMaxWage(lca.getLcaCurrMaxWage());
        }
        dto.setJobTitle(lca.getJobTitle());
        if (lca.getWithdrawnLCANumber() != null) {
            dto.setWithdrawnLCANumber(lca.getWithdrawnLCANumber());
        }
        if (lca.getLcaFiledDate() != null) {
            dto.setLcaFiledDate(lca.getLcaFiledDate());
        }
        dto.setLcaValidFromDate(lca.getLcaValidFromDate());
        dto.setLcaValidToDate(lca.getLcaValidToDate());
        if (lca.getStatus() != null) {
            dto.setStatus(lca.getStatus().name());
        }
        if (lca.getClientName() != null) {
            dto.setClientName(lca.getClientName());
        }
        if (lca.getVendorName() != null) {
            dto.setVendorName(lca.getVendorName());
        }
        if (lca.getLcaPostingSentToVendor() != null) {
            dto.setLcaPostingSentToVendor(lca.getLcaPostingSentToVendor());
        }
        if (lca.getResponseOnLcaPosting() != null) {
            dto.setResponseOnLcaPosting(lca.getResponseOnLcaPosting());
        }
        if (lca.getReminderEmail() != null) {
            dto.setReminderEmail(lca.getReminderEmail());
        }
        if (lca.getCertifiedLcaSentConsultant() != null) {
            dto.setCertifiedLcaSentConsultant(lca.getCertifiedLcaSentConsultant());
        }
        if (lca.getLcaPostingSSTLocation() != null) {
            dto.setLcaPostingSSTLocation(lca.getLcaPostingSSTLocation());
        }
        if (lca.getLcaFiledInPIF() != null) {
            dto.setLcaFiledInPIF(lca.getLcaFiledInPIF());
        }
        if (lca.getNonDisplacement() != null) {
            dto.setNonDisplacement(lca.getNonDisplacement().name());
        }
        if (lca.getComment() != null) {
            dto.setComment(lca.getComment());
        }
        if (lca.getNonDisplacement() != null) {
            dto.setNonDisplacement(lca.getNonDisplacement().name());
        }
        StringBuilder workedByEmp = new StringBuilder();
        for (Employee rec : lca.getWorkedByEmployees()) {
            workedByEmp.append(rec.getFirstName()).append(" ").append(rec.getLastName()).append(" , ");
        }
        if (!workedByEmp.toString().isEmpty()) {
            dto.setWorkedByEmployees(workedByEmp.substring(0, workedByEmp.length() - 2));
        }
        return dto;
    }

}
