/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.commons.DateUtils;
import info.chili.email.Email;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
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
 * @author Ramana.Lukalapu
 */
@Component
@Scope("prototype")
public class OutOfOfficeService {

    @Autowired
    protected Mapper mapper;

    public void submitRequest(OutOfOfficeRequest entity) {
        Employee emp;
        Map<String, Object> vars = new HashMap<>();
        validateRequest(entity);
        emp = OfficeSecurityService.instance().getCurrentUser();
        entity.setEmployee(emp);

        if (entity.getStatus() != null && entity.getStatus().name().equalsIgnoreCase("Pending_Manager_Approval")) {
            vars.put("status1", "update");
        }
        entity.setStatus(OutOfOfficeRequestStatus.Pending_Manager_Approval);
        if (entity.getNotifyEmployees() != null && entity.getNotifyEmployees().size() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYY");
            Email email = new Email();
            email.setHtml(Boolean.TRUE);
            email.setRichText(Boolean.TRUE);
            for (Entry e : entity.getNotifyEmployees()) {
                email.addTo(EmployeeDao.instance().getPrimaryEmail(e.getId()));
            }
            String summary = "";
            if (vars.containsKey("status1")) {
                email.setSubject("Remote Work Request was updated by  " + emp.getFirstName() + " " + emp.getLastName());
                summary = summary.concat(" <b> Remote Work Request was updated </b>" + "</br></br>" + " <b> Employee  : </b> &nbsp;" + emp.getFirstName() + "&nbsp;" + emp.getLastName() + "&nbsp;" + "</br>" + " <b>Start Date  : </b> " + "&nbsp;" + sdf.format(entity.getStartDate()) + "&nbsp;" + "</br>" + " <b> End Date   &nbsp;: </b> " + "&nbsp;" + sdf.format(entity.getEndDate()) + "&nbsp;" + "</br>" + " <b> Status    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </b> &nbsp;" + entity.getStatus().name().replace("_", " "));

            } else {
                email.setSubject("Remote Work Request - " + entity.getStatus().name().replace("_", " ") + " for " + emp.getFirstName() + " " + emp.getLastName());
                summary = summary.concat(" <b> Remote Work Request - </b>  " + "<b>" + entity.getStatus().name().replace("_", " ") + "</b>" + "</br></br>" + " <b> Employee : </b> &nbsp;" + emp.getFirstName() + "&nbsp;" + emp.getLastName() + "&nbsp;" + "</br>" + " <b>Start Date  : </b> " + "&nbsp;" + sdf.format(entity.getStartDate()) + "&nbsp;" + "</br>" + " <b> End Date    &nbsp;: </b> " + "&nbsp;" + sdf.format(entity.getEndDate()) + "&nbsp;");
            }
            MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
            email.setBody(summary);
            messagingService.sendEmail(email);
        }
        entity = OutOfOfficeDao.instance().save(entity);
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        vars.put("entityId", entity.getId());
        entity.setBpmProcessId(OfficeBPMService.instance().startProcess("outof_office_process", vars));
        OutOfOfficeDao.instance().getEntityManager().merge(entity);
    }

    public void updateRequest(OutOfOfficeRequest entity) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        submitRequest(entity);
    }

    public void delete(Long id) {
        OutOfOfficeRequest ticket = OutOfOfficeDao.instance().findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        OutOfOfficeDao.instance().delete(id);
    }

    protected void validateRequest(OutOfOfficeRequest entity) {
        if (entity.getEndDate().after(DateUtils.getNextMonth(entity.getStartDate(), 7))) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.startdate", "You are applying more than 6 months");
        }
    }

    public static OutOfOfficeService instance() {
        return SpringContext.getBean(OutOfOfficeService.class);
    }

}
