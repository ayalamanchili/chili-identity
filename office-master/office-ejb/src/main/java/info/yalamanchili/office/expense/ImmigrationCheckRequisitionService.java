/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense;

import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.chili.bpm.types.Task;
import info.yalamanchili.office.dao.expense.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.CheckRequisitionItem;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("request")
public class ImmigrationCheckRequisitionService {

    @Autowired
    protected ImmigrationCheckRequisitionDao immigrationCheckRequisitionDao;

    public void submitImmigrationCheckRequisition(ImmigrationCheckRequisition entity) {
        Map<String, Object> vars = new HashMap<>();
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        entity.setSubmittedBy(emp);
        vars.put("entity", entity);
        vars.put("Employee", entity.getEmployee());
        vars.put("currentEmployee", emp);
        String processId = OfficeBPMService.instance().startProcess("immigration_check_requisition_process", vars);
        entity.setBpmProcessId(processId);
    }

    protected Task getTaskForTicket(ImmigrationCheckRequisition immigrationCheckRequisition) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(immigrationCheckRequisition.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        ImmigrationCheckRequisition ticket = immigrationCheckRequisitionDao.findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        immigrationCheckRequisitionDao.delete(id);
    }
    
    public ImmigrationCheckRequisition read(Long id) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        return mapper.map(immigrationCheckRequisitionDao.findById(id), ImmigrationCheckRequisition.class);
    }

    public ImmigrationCheckRequisition clone(Long id) {
        ImmigrationCheckRequisition entity = immigrationCheckRequisitionDao.clone(id, "submittedDate", "approvedByManager", "approvedByManagerDate", "approvedByAccountsDept", "approvedByAccountsDeptDate", "approvedByCEO", "approvedByCEODate", "bpmProcessId", "status", "totalExpenses", "expenseReceipts");
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        return mapper.map(entity, ImmigrationCheckRequisition.class);
    }

    public Response getReport(ImmigrationCheckRequisition entity) {
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/check-request-template.pdf");

        Employee preparedBy = entity.getSubmittedBy();
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("attorneyName", entity.getAttorneyName());
        data.getData().put("submittedBy", prepareByStr);
        data.getData().put("employee", entity.getEmployee());
        data.getData().put("requestedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getRequestedDate()));
        data.getData().put("neededByDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getNeededByDate()));
        if (entity.getAmount() != null) {
            data.getData().put("amount", entity.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
        }
        data.getData().put("purpose", entity.getPurpose());
        data.getData().put("caseType", entity.getCaseType().name());
        data.getData().put("mailingAddress", entity.getMailingAddress());
        if (entity.getAccountDeptReceivedDate() != null) {
            data.getData().put("accountDeptReceivedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getAccountDeptReceivedDate()));
        }
        if (entity.getCheckIssuedDate() != null) {
            data.getData().put("checkIssuedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getCheckIssuedDate()));
        }
        if (entity.getApprovedDate() != null) {
            data.getData().put("approvedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getApprovedDate()));
        }
        if (entity.getAccountedBy() != null) {
            String accountedBy = entity.getAccountedBy().getLastName() + ", " + entity.getAccountedBy().getFirstName();
            data.getData().put("accountedBy", accountedBy);
        }

        Integer i = 1;
        BigDecimal itemTotal = new BigDecimal(0);
        for (CheckRequisitionItem item : entity.getItems()) {
            data.getData().put("sl" + i, i.toString());
            data.getData().put("itemName" + i, item.getItemName());
            data.getData().put("itemDesc" + i, item.getItemDesc());
            data.getData().put("itemAmount" + i, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
            itemTotal = itemTotal.add(item.getAmount());
            i++;
        }
        data.getData().put("itemTotal", itemTotal.setScale(2, BigDecimal.ROUND_UP).toString());

        //Comment
        List<Comment> cmnts = CommentDao.instance().findAll(entity.getId(), entity.getClass().getCanonicalName());
        String allComment = "";
        for (Comment comment : cmnts) {
            allComment = allComment + ". " + comment.getComment();
        }
        data.getData().put("comment", allComment);
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = check-requisition.pdf")
                .header("Content-Length", pdf)
                .build();

    }

    public static ImmigrationCheckRequisitionService instance() {
        return SpringContext.getBean(ImmigrationCheckRequisitionService.class);
    }
}
