/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.travelauthorization;

import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.expense.travelauthorization.TravelAuthorizationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class TravelExpenseService {

    @Autowired
    protected TravelAuthorizationDao travelAuthorizationDao;

    public void submitTravelAuthorization(TravelAuthorization entity) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("entity", entity);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        String processId = OfficeBPMService.instance().startProcess("travel_authorization_process", vars);
        entity.setBpmProcessId(processId);
    }

    protected Task getTaskForTicket(TravelAuthorization travelExpenseRequisition) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(travelExpenseRequisition.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        TravelAuthorization ticket = travelAuthorizationDao.findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        travelAuthorizationDao.delete(id);
    }

    public Response getReport(TravelAuthorization entity) {
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/travel-authorization-template.pdf");
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("employeeName", prepareByStr);

        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = travel-authorization.pdf")
                .header("Content-Length", pdf)
                .build();

    }

    public static TravelExpenseService instance() {
        return SpringContext.getBean(TravelExpenseService.class);
    }
}
