/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.hr;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.email.Email;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.drive.FileDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dao.hr.ProspectReportDto;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.prospect.ProspectService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/prospect")
@Component
@Scope("prototype")
@Transactional
public class ProspectResource extends CRUDResource<ProspectDto> {

    @Autowired
    public ProspectDao prospectDao;

    @Autowired
    public ProspectService prospectService;
    @Autowired
    protected OfficeBPMService officeBPMService;
    @Autowired
    protected InviteCodeDao inviteCodeDao;
    @Autowired
    FileDao fileDao;

    @Override
    public CRUDDao getDao() {
        return prospectDao;
    }
    @Autowired
    protected Mapper mapper;

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER','ROLE_ON_BOARDING_MGR', 'ROLE_HR_ADMINSTRATION', 'ROLE_CONTRACTS_ADMIN')")
    @Cacheable(OfficeCacheKeys.PROSPECT)
    public ProspectResource.ProspectTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<ProspectDto> res = new ArrayList<>();
        for (Prospect entity : prospectDao.query(start, limit)) {
            res.add(ProspectDto.map(mapper, entity));
        }
        ProspectResource.ProspectTable tableObj = new ProspectResource.ProspectTable();
        tableObj.setEntities(res);
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Path("/save")
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public ProspectDto save(ProspectDto prospect, @QueryParam("screenedById") Long screenedById) {
        return prospectService.save(prospect, screenedById);
    }

    @PUT
    @Path("/update")
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER', 'ROLE_RECRUITER', 'ROLE_H1B_IMMIGRATION', 'ROLE_GC_IMMIGRATION')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public ProspectDto update(ProspectDto prospect, @QueryParam("screenedById") Long screenedById) {
        return prospectService.update(prospect, screenedById);
    }

    @PUT
    @Path("/request-prospect-onboarding")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public void requestProspectOnBoarding(ProspectDto prospect) {
        Map<String, Object> vars = new HashMap<>();
        Prospect entity = ProspectDao.instance().findById(prospect.getId());
        entity.setStatus(ProspectStatus.CLOSED_ONBOARDING_REQUESTED);
        vars.put("prospect", entity);
        if (entity.getManager() != null) {
            vars.put("caseManagerName", EmployeeDao.instance().findById(entity.getManager()).getFirstName());
        } else {
            vars.put("caseManagerName", "");
        }
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        vars.put("prospectLink", getProspectLink(prospect.getId()));
        String Processid = officeBPMService.startProcess("request_prospect_onboarding_process", vars);
        entity.setBpmProcessId(Processid);
        prospectDao.getEntityManager().merge(entity);
    }

    protected String getProspectLink(Long prospect) {
        StringBuilder sb = new StringBuilder();
        sb.append(OfficeServiceConfiguration.instance().getPortalWebUrl()).append("#?entity=info.yalamanchili.office.entity.hr.Prospect&id=").append(prospect);
        return sb.toString();
    }

    @GET
    @Path("/search-firstname")
    @Transactional(propagation = Propagation.NEVER)
    public List<Entry> getFirstNameDropDown() {
        return prospectDao.searchforfirstname();
    }

    @GET
    @Path("/search-lastname")
    @Transactional(propagation = Propagation.NEVER)
    public List<Entry> getLastNameDropDown() {
        return prospectDao.searchforlastname();
    }

    @GET
    @Path("/search-suggestions")
    @Transactional(propagation = Propagation.NEVER)
    public List<Entry> getDropDown() {
        return prospectDao.searchSuggestions();
    }

    @GET
    @Path("/clone/{id}")
    @Override
    public ProspectDto clone(@PathParam("id") Long id) {
        return prospectService.clone(id);
    }

    @GET
    @Override
    @Path("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER', 'ROLE_RECRUITER', 'ROLE_H1B_IMMIGRATION', 'ROLE_GC_IMMIGRATION', 'ROLE_ON_BOARDING_MGR', 'ROLE_HR_ADMINSTRATION', 'ROLE_CONTRACTS_ADMIN')")
    public ProspectDto read(@PathParam("id") Long id) {
        return prospectService.read(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @PUT
    @Path("/graph")
    @Produces("application/text")
    public String graph(ProspectReportDto dto) {
        return prospectDao.graph(dto);
    }

    @GET
    @Path("/email-info/{id}")
    public void basicProspectRequest(@PathParam("id") Long id) {
        Prospect entity = prospectDao.findById(id);
        if (id != null) {
            Email email = new Email();
            email.addTo(entity.getContact().getPrimaryEmail().getEmail());
            StringBuilder subject = new StringBuilder();
            subject.append("Prospect Request Received");
            email.setSubject(subject.toString());
            Map emailCtx = new HashMap<>();
            emailCtx.put("employeeName", entity.getContact().getFirstName() + " " + entity.getContact().getLastName());
            email.setTemplateName("prospect_doc_sent_Date.html");
            email.setContext(emailCtx);
            email.setHtml(Boolean.TRUE);
            MessagingService.instance().sendEmail(email);
            entity.setProcessDocSentDate(new Date());
            prospectDao.save(entity);
        }
    }

    @GET
    @Path("/search/{prospectId}")
    @Transactional(propagation = Propagation.NEVER)
    public List<ProspectDto> search(@PathParam("prospectId") Long prospectId, @PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("column") List<String> columns) {
        List<ProspectDto> res = new ArrayList();
        res.add(map((Prospect) prospectDao.findById(prospectId)));
        return res;
    }

    @PUT
    @Path("/search-prospect/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    public List<ProspectDto> search(Prospect entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<ProspectDto> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(prospectDao.getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        for (Object p : searchQuery.getResultList()) {
            res.add(map((Prospect) p));
        }
        return res;
    }

    @PUT
    @Path("/prospect-status-search")
    @Transactional(readOnly = true)
    public List<ProspectDto> prospectStatusSearch(ProspectReportDto entity) {
        List<ProspectDto> res = new ArrayList();
        List<Prospect> prospects = prospectDao.report(entity);
        for (Prospect p : prospects) {
            res.add(map(p));
        }
        return res;
    }

    protected ProspectDto map(Prospect p) {
        ProspectDto dto = new ProspectDto();
        dto.setId(p.getId());
        if (p.getAssigned() != null) {
            Employee emp = EmployeeDao.instance().findById(p.getAssigned());
            dto.setAssignedto(emp.getFirstName() + " " + emp.getLastName());
        }
        dto.setFirstName(p.getContact().getFirstName());
        dto.setLastName(p.getContact().getLastName());
        if (p.getContact().getMiddleInitial() != null) {
            dto.setMiddleInitial(p.getContact().getMiddleInitial());
        }
        dto.setScreenedBy(p.getScreenedBy());
        dto.setPhoneNumber(p.getContact().getPhones().get(0).getPhoneNumber());
        if (p.getContact().getEmails() != null && p.getContact().getEmails().size() > 0) {
            dto.setEmail(p.getContact().getEmails().get(0).getEmail());
        }
        if (p.getCompany() != null) {
            dto.setCompany(p.getCompany());
        }
        dto.setReferredBy(p.getReferredBy());
        dto.setStatus(p.getStatus());
        dto.setContactId(p.getContact().getId());
        return dto;
    }

    protected final String[] ON_BOARDING_FORMS_LIST = {"W2_On_Boarding", "I9_On_Boarding"};

    @XmlRootElement
    @XmlType
    public static class ProspectTable implements java.io.Serializable {

        protected Long size;
        protected List<ProspectDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ProspectDto> getEntities() {
            return entities;
        }

        public void setEntities(List<ProspectDto> entities) {
            this.entities = entities;
        }
    }

    @PUT
    @Path("/report")
    public List<ProspectDto> generateReport(ProspectReportDto dto) {
        List<Prospect> prospects = prospectDao.report(dto);
        List<ProspectDto> dtos = new ArrayList();
        ProspectTable table = new ProspectTable();
        ProspectDto pdto = null;
        String name = "";
        for (Prospect prospect : prospects) {
            pdto = ProspectDto.map(mapper, prospect);
            if (!prospect.getStatus().equals(ProspectStatus.CLOSED_WON)) {
                pdto.setDateOfJoining(null);
                pdto.setPlacedby(null);
                pdto.setTrfEmptype(null);
                pdto.setPetitionFor(null);
            }
            dtos.add(pdto);
        }
        if (dto.getStatus() != null) {
            name = name.concat("Prospect  " + dto.getStatus().name().toLowerCase() + "  Report");
        } else if (dto.getAssignedTo() != null) {
            Employee emp = EmployeeDao.instance().findById(Long.valueOf(dto.getAssignedTo()));
            name = name.concat("Prospect Assigned To : " + emp.getFirstName() + " " + emp.getLastName() + " Report");
        } else if (dto.getCaseManager() != null) {
            Employee emp = EmployeeDao.instance().findById(Long.valueOf(dto.getCaseManager()));
            name = name.concat("Prospect Case manager : " + emp.getFirstName() + " " + emp.getLastName() + " Report");
        } else if (dto.getCompany() != null) {
            name = name.concat("Prospect Company : " + dto.getCompany() + " Report");
        } else if (dto.getJoiningDateFrom() != null && dto.getJoiningDateTo() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            name = name.concat("Prospects Joined Between  " + sdf.format(dto.getJoiningDateFrom()) + " - " + sdf.format(dto.getJoiningDateTo()) + "  Report");
        } else if (dto.getCreatedDateFrom() != null && dto.getCreatedDateTo() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            name = name.concat("Prospects Created Between  " + sdf.format(dto.getCreatedDateFrom()) + " - " + sdf.format(dto.getCreatedDateTo()) + "  Report");
        }
        if (dtos.size() > 0) {
            table.setEntities(dtos);
            String[] columnOrder;
            Employee emp = OfficeSecurityService.instance().getCurrentUser();
            if (ProspectStatus.CLOSED_WON.equals(dto.getStatus()) || (dto.getJoiningDateFrom() != null && dto.getJoiningDateTo() != null)) {
                columnOrder = new String[]{"employee", "email", "phoneNumber", "screenedBy", "caseManagerName", "assignedto", "petitionFor", "placedby", "trfEmptype", "dateOfJoining", "referredBy", "companyName", "createdDate", "stage"};
            } else {
                columnOrder = new String[]{"employee", "email", "phoneNumber", "screenedBy", "caseManagerName", "assignedto", "referredBy", "createdDate", "stage"};
            }
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), name, OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
            return dtos;
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "no.results", "No Results");
        }
    }

    @PUT
    @Path("/report/exportReport/{format}")
    public Response exportReport(ProspectList dto, @PathParam("format") String format) {
        List<ProspectDto> dtos = new ArrayList();
        String home = "C://Users//" + System.getProperty("user.name") + "//Downloads/";
        String[] split = dto.getListids().split(",");
        for (String id : split) {
            Prospect findById = ProspectDao.instance().findById(Long.valueOf(id));
            dtos.add(ProspectDto.map(mapper, findById));
        }
        String reportFormat = "";
        if (format.equals("Excel")) {
            reportFormat = reportFormat.concat("xls").trim();
        } else if (format.equals("Pdf")) {
            reportFormat = reportFormat.concat("pdf").trim();
        }
        String[] columnOrder = new String[]{"employee", "email", "phoneNumber", "screenedBy", "caseManagerName", "assignedto", "petitionFor", "placedby", "trfEmptype", "dateOfJoining", "referredBy", "companyName", "createdDate", "stage"};
        return ReportGenerator.generateReport(dtos, "Prospect Report", reportFormat, home, columnOrder);
    }

    @GET
    @Path("/stageProgressReport")
    public void stageProgressReport() {
        List<ProspectDto> prospectDtos = new ArrayList();
        List<Prospect> prospects = new ArrayList();
        ProspectTable table = table(0, 100000);
        prospectDtos.addAll(table.getEntities());
        for (ProspectDto dto : prospectDtos) {
            prospects.add(prospectDao.findById(dto.getId()));
        }
        prospectService.getProspectsStageProgressReport(prospects);
    }
}