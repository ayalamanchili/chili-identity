/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.chkreq;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.expense.chkreq.CheckRequisitionItemDao;
import info.yalamanchili.office.dao.expense.chkreq.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.CheckRequisitionItem;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisitionStatus;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    protected CheckRequisitionItemDao checkRequisitionItemDao;

    @Autowired
    protected Mapper mapper;

    public void submitImmigrationCheckRequisition(ImmigrationCheckRequisitionSaveDto dto) {
        ImmigrationCheckRequisition entity = mapper.map(dto, ImmigrationCheckRequisition.class);
        entity.setSubmittedBy(OfficeSecurityService.instance().getCurrentUserName());
        entity.setRequestedDate(new Date());
        entity.setEmployee(EmployeeDao.instance().findById(entity.getEmployee().getId()));
        entity.setStatus(ImmigrationCheckRequisitionStatus.PENDING_APPROVAL);
        for (CheckRequisitionItem item : entity.getItems()) {
            item.setId(null);
            item.setVersion(null);
            item.setImmigrationCheckRequisition(entity);
        }
        entity = immigrationCheckRequisitionDao.save(entity);
        //TODO if removed the total amount is not being calcluated incorrectly.
        entity.updateTotalAmount();
        entity.setBpmProcessId(startExpenseReportProcess(entity));
        entity = immigrationCheckRequisitionDao.save(entity);
    }

    protected String startExpenseReportProcess(ImmigrationCheckRequisition entity) {
        if (entity.getBpmProcessId() != null) {
            OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        }
        Map<String, Object> vars = new HashMap<>();
        vars.put("entity", entity);
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        vars.put("employeeName", entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
        vars.put("entityId", entity.getId());
        return OfficeBPMService.instance().startProcess("immigration_check_requisition_process", vars);
    }

    public void saveImmigrationCheckRequisition(ImmigrationCheckRequisitionSaveDto dto) {
        ImmigrationCheckRequisition entity = immigrationCheckRequisitionDao.save(dto);
        //add/update items
        for (CheckRequisitionItem item : dto.getItems()) {
            if (item.getId() != null) {
                checkRequisitionItemDao.save(item);
            } else {
                item.setImmigrationCheckRequisition(entity);
                item = checkRequisitionItemDao.getEntityManager().merge(item);
                entity.getItems().add(item);
            }
        }
        immigrationCheckRequisitionDao.getEntityManager().merge(entity);
    }

    public void delete(Long id) {
        ImmigrationCheckRequisition ticket = immigrationCheckRequisitionDao.findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        immigrationCheckRequisitionDao.delete(id);
    }

    public ImmigrationCheckRequisitionSaveDto read(Long id) {
        return mapper.map(immigrationCheckRequisitionDao.findById(id), ImmigrationCheckRequisitionSaveDto.class);
    }

    public ImmigrationCheckRequisitionSaveDto clone(Long id) {
        ImmigrationCheckRequisition entity = immigrationCheckRequisitionDao.clone(id, "amount", "submittedBy", "requestedDate", "approvedBy", "approvedDate", "accountedBy", "checkIssuedDate", "accountDeptReceivedDate", "status", "bpmProcessId", "employee");
        ImmigrationCheckRequisitionSaveDto res = mapper.map(entity, ImmigrationCheckRequisitionSaveDto.class);
        for (CheckRequisitionItem item : res.getItems()) {
            item.setId(null);
            item.setVersion(null);
        }
        return res;
    }

    public Response getReport(ImmigrationCheckRequisition entity) {
        PdfDocumentData data = new PdfDocumentData();
        Employee emp = entity.getEmployee();
        if (emp.getCompany() != null && emp.getCompany().getName().equals("TechPillars")) {
            data.setTemplateUrl("/templates/pdf/check-request-tp-template.pdf");
        } else {
            data.setTemplateUrl("/templates/pdf/check-request-template.pdf");
        }

        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = EmployeeDao.instance().findEmployeWithEmpId(entity.getSubmittedBy());
        EmployeeDao employeeDao = EmployeeDao.instance();
        if (preparedBy != null) {
            String prepareByStr = preparedBy.getLastName() + " , " + preparedBy.getFirstName();
            data.getData().put("submittedBy", prepareByStr);
            Signature approvedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "submittedBySignature", DateUtils.dateToCalendar(entity.getApprovedDate()), employeeDao.getPrimaryEmail(preparedBy), null);
            data.getSignatures().add(approvedBysignature);
        }
        data.getData().put("attorneyName", entity.getAttorneyName());
        data.getData().put("employee", entity.getEmployee().getFirstName() + "," + entity.getEmployee().getLastName());
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
        if (entity.getApprovedBy() != null) {
            Employee approvedBy = EmployeeDao.instance().findEmployeWithEmpId(entity.getApprovedBy());
            if (approvedBy != null) {
                Signature approvedBysignature = new Signature(approvedBy.getEmployeeId(), approvedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approvedBySignature", DateUtils.dateToCalendar(entity.getApprovedDate()), employeeDao.getPrimaryEmail(approvedBy), null);
                data.getSignatures().add(approvedBysignature);
            }
        }
        if (entity.getApprovedDate() != null) {
            data.getData().put("approvedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getApprovedDate()));
        }
        Employee accountedBy = EmployeeDao.instance().findEmployeWithEmpId(entity.getAccountedBy());
        if (accountedBy != null) {
            String accountedByStr = accountedBy.getLastName() + " , " + accountedBy.getFirstName();
            data.getData().put("accountedBy", accountedByStr);
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
