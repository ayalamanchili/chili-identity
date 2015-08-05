/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.statusreport;

import info.chili.commons.HtmlUtils;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.chili.email.Email;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.employee.statusreport.CropStatusReportStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
            entity.setStatus(CropStatusReportStatus.Submitted);
            notifyManager(entity);
        }
        return entity.getId().toString();
    }
    public static String CORPORATE_STATUS_REPORT_SUBMITTED_EMAIL = "Disable_Corporate_Status_Report_Submited_Emails";

    protected void notifyManager(CorporateStatusReport entity) {
        Email email = new Email();
        Employee perfEvalManager = CompanyContactDao.instance().getCompanyContactForEmployee(entity.getEmployee(), "Perf_Eval_Manager");
        if (perfEvalManager != null) {
            email.addTo(perfEvalManager.getPrimaryEmail().getEmail());
        }
        Employee reportsToMgr = CompanyContactDao.instance().getCompanyContactForEmployee(entity.getEmployee(), "Reports_To");
        if (reportsToMgr != null) {
            email.addTo(reportsToMgr.getPrimaryEmail().getEmail());
        }
        for (Employee supervisor : CompanyContactDao.instance().getCompanyContactsForEmployee(entity.getEmployee(), "Supervisor")) {
            email.addTo(supervisor.getPrimaryEmail().getEmail());
        }
        email.setSubject("Weekly Status Report submitted for " + entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName() + " for " + new SimpleDateFormat("dd-MMM-yyyy").format(entity.getReportStartDate()) + "-" + new SimpleDateFormat("dd-MMM-yyyy").format(entity.getReportEndDate()));
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setBody(entity.getReport());
        email.setEmailPreferenceRuleId(CORPORATE_STATUS_REPORT_SUBMITTED_EMAIL);
        MessagingService.instance().sendEmail(email);

    }
    protected static final String DIFF_STYLE = "<head>\n"
            + "<style>\n"
            + "span.diff-html-removed {\n"
            + "color: red; \n"
            + "text-decoration: line-through;\n"
            + "cursor: default;\n"
            + "} \n"
            + "\n"
            + "span.diff-html-added {\n"
            + "color: blue;\n"
            + "cursor: default;\n"
            + "} \n"
            + "\n"
            + "span.diff-html-changed {\n"
            + "color: black;\n"
            + "border-bottom: dotted 2px red;\n"
            + "cursor: default;\n"
            + "text-decoration: none;\n"
            + "}\n"
            + "</style>\n"
            + "</head>";

    public String diff(Long report1) {
        String orginalText = corporateStatusReportDao.findById(report1).getReport();
        if (corporateStatusReportDao.getPreviousReport(report1) == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "previous.report.not.exist", "Cannot find previous report to Compare");
        }
        String modifiedText = corporateStatusReportDao.getPreviousReport(report1).getReport();
        String diff = null;
        try {
            diff = HtmlUtils.getDiffForHTMLInput(modifiedText, orginalText);
        } catch (Exception ex) {
            return "";
        }
        return DIFF_STYLE + diff;
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

    public static CorporateStatusReportService instance() {
        return SpringContext.getBean(CorporateStatusReportService.class);
    }
}
