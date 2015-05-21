/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.profile;

import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.RetirementPlanDao;
import info.yalamanchili.office.dto.profile.RetirementPlanOptInDto;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.RetirementPlan;
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
 * @author benerji.v
 */
@Component
@Scope("request")
public class CorporateStatusReportService {

    @Autowired
    protected Mapper mapper;
    @Autowired
    public CorporateStatusReportDao corporateStatusReportDao;

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
}
