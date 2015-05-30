/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.profile;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.employee.statusreport.CropStatusReportsStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author benerji.v
 */
@Component
@Scope("request")
public class CorporateStatusReportService {

    @Autowired
    protected Mapper mapper;
    @Autowired
    public CorporateStatusReportDao corporateStatusReportDao;

    public String save(CorporateStatusReport entity, Boolean submitForApproval) {
        entity = corporateStatusReportDao.save(entity);
        if (submitForApproval) {
            entity.setStatus(CropStatusReportsStatus.Pending_Manager_Approval);
            String bpmProcessId = startCorporateStatusReportProcess(entity);
            entity.setBpmProcessId(bpmProcessId);
        }
        return entity.getId().toString();
    }

    public String startCorporateStatusReportProcess(CorporateStatusReport entity) {
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        Map<String, Object> vars = new HashMap<>();
        vars.put("entityId", entity.getId());
        vars.put("entity", entity);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        return OfficeBPMService.instance().startProcess("corporate_status_report_approval_process", vars);
    }

    public void delete(Long id) {
        CorporateStatusReport entity = corporateStatusReportDao.findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        corporateStatusReportDao.delete(id);
    }

    @Async
    @Transactional(readOnly = true)
    public void getCorporateStatusReport(String email) {
        List<CorporateStatusReport> res = new ArrayList<CorporateStatusReport>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee")) {
            CorporateStatusReport dto = mapper.map(emp, CorporateStatusReport.class);
            dto.setReportStartDate(dto.getReportStartDate());
            dto.setReportEndDate(dto.getReportEndDate());
            dto.setReport(dto.getReport());
            res.add(dto);
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "Corporate-Status-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    public static CorporateStatusReportService instance() {
        return SpringContext.getBean(CorporateStatusReportService.class);
    }
}
