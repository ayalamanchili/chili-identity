/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.chkreq;

import info.chili.commons.BeanMapper;
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
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
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
import org.hibernate.Hibernate;
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

    public void checkVoidRequest(Long id) {
        ImmigrationCheckRequisition icr = ImmigrationCheckRequisitionDao.instance().findById(id);
        Map<String, Object> vars = new HashMap<>();
        icr.setStatus(ImmigrationCheckRequisitionStatus.PENDING_VOID);
        vars.put("entity", icr);
        vars.put("entityId", icr.getId());
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        icr.setBpmProcessId(OfficeBPMService.instance().startProcess("immigration_check_requisition_void_request", vars));
        immigrationCheckRequisitionDao.save(icr);
    }

    public void submitImmigrationCheckRequisition(ImmigrationCheckRequisitionSaveDto dto) {
        ImmigrationCheckRequisition entity = mapper.map(dto, ImmigrationCheckRequisition.class);
        entity.setSubmittedBy(OfficeSecurityService.instance().getCurrentUserName());
        entity.setRequestedDate(new Date());
        if (entity.getEmployee() != null) {
            Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
            entity.setEmployee(emp);
            if (dto.getCompany() != null) {
                emp.setCompany(CompanyDao.instance().findById(dto.getCompany().getId()));
            }
        } else if (dto.getCompany() != null) {
            Company company = CompanyDao.instance().findById(dto.getCompany().getId());
            entity.setCompanyName(company.getName());
        }
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
        if (entity.getEmployee() != null) {
            vars.put("employeeName", entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
        } else {
            vars.put("employeeName", entity.getEmployeeName());
        }
        vars.put("entityId", entity.getId());
        return OfficeBPMService.instance().startProcess("immigration_check_requisition_process", vars);
    }

    public void saveImmigrationCheckRequisition(ImmigrationCheckRequisitionSaveDto dto) {
        ImmigrationCheckRequisition entity = immigrationCheckRequisitionDao.save(dto);
        //add/update items
        if (entity.getEmployee() != null && dto.getCompany() != null) {
            entity.getEmployee().setCompany(CompanyDao.instance().findById(dto.getCompany().getId()));
        } else if (dto.getCompany() != null) {
            Company company = CompanyDao.instance().findById(dto.getCompany().getId());
            entity.setCompanyName(company.getName());
        }

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
        ImmigrationCheckRequisition entity = immigrationCheckRequisitionDao.findById(id);
        ImmigrationCheckRequisitionSaveDto res = (ImmigrationCheckRequisitionSaveDto) BeanMapper.clone(entity, ImmigrationCheckRequisitionSaveDto.class);
        res.setItems(entity.getItems());
        //TO fix lazy init error
        Hibernate.initialize(res.getItems());
        if (res.getEmployee() == null && res.getCompanyName() != null) {
            res.setCompany(CompanyDao.instance().findByCompanyName(res.getCompanyName()));
        }
        res.setEmployee(entity.getEmployee());
        res.setCaseType(entity.getCaseType());
        res.setStatus(entity.getStatus());
        return res;
    }

    public ImmigrationCheckRequisitionSaveDto clone(Long id) {
        ImmigrationCheckRequisition entity = immigrationCheckRequisitionDao.clone(id, "amount", "submittedBy", "employeeName", "requestedDate", "approvedBy", "approvedDate", "accountedBy", "checkIssuedDate", "accountDeptReceivedDate", "status", "bpmProcessId", "employee");
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
        data.setTemplateUrl("/templates/pdf/check-request-template.pdf");
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = EmployeeDao.instance().findEmployeWithEmpId(entity.getSubmittedBy());
        EmployeeDao employeeDao = EmployeeDao.instance();
        if (preparedBy != null) {
            String prepareByStr = preparedBy.getLastName() + " ," + preparedBy.getFirstName();
            data.getData().put("submittedBy", prepareByStr);
            Signature approvedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "submittedBySignature", DateUtils.dateToCalendar(entity.getApprovedDate()), employeeDao.getPrimaryEmail(preparedBy), null);
            data.getSignatures().add(approvedBysignature);
        }
        data.getData().put("attorneyName", entity.getAttorneyName());
        if (entity.getEmployee() != null) {
            data.getData().put("employee", entity.getEmployee().getFirstName() + "," + entity.getEmployee().getLastName());
        } else {
            data.getData().put("employee", entity.getEmployeeName());
        }
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
        String empCompanyLogo = "";
        if (emp != null) {
            if (emp.getCompany() == null && emp.getCompany().getLogoURL() == null) {
                Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
                empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
            } else {
                empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());
            }
        } else if (emp == null) {
            if (entity.getCompanyName() != null) {
                Company company = CompanyDao.instance().findByCompanyName(entity.getCompanyName());
                empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
            } else {
                Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
                empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
            }
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);
        return Response.ok(pdf)
                .header("content-disposition", "filename = check-requisition.pdf")
                .header("Content-Length", pdf.length)
                .build();

    }

    public static ImmigrationCheckRequisitionService instance() {
        return SpringContext.getBean(ImmigrationCheckRequisitionService.class);
    }
}
