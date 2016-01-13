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
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.drive.FileDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.prospect.ProspectService;
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
import javax.ws.rs.QueryParam;
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
@Scope("request")
@Transactional
public class ProspectResource extends CRUDResource<ProspectDto> {

    @Autowired
    public ProspectDao prospectDao;

    @Autowired
    public ProspectService prospectService;

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
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER')")
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
    @Override
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public ProspectDto save(ProspectDto prospect) {
        return prospectService.save(prospect);
    }

    @PUT
    @Path("/update")
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public Prospect update(ProspectDto prospect) {
        return prospectService.update(prospect);
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
    @Path("/search/{searchText}/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<ProspectDto> search(@PathParam("searchText") String searchText, @PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("column") List<String> columns) {
        List<ProspectDto> res = new ArrayList();
        for (Object p : getDao().sqlSearch(searchText, start, limit, columns, true)) {
            res.add(map((Prospect) p));
        }
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

    protected ProspectDto map(Prospect p) {
        ProspectDto dto = new ProspectDto();
        dto.setFirstName(p.getContact().getFirstName());
        dto.setLastName(p.getContact().getLastName());
        dto.setScreenedBy(p.getScreenedBy());
        dto.setReferredBy(p.getReferredBy());
        dto.setStatus(p.getStatus());
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

    @GET
    @Path("/report/{status}")
    public void generateReport(@PathParam("status") String status) {
        List<Prospect> prospects = prospectDao.query(0, 10000);
        List<ProspectDto> dtos = new ArrayList();
        ProspectTable table = new ProspectTable();
        ProspectDto dto = null;
        for (Prospect prospect : prospects) {
            if (prospect.getStatus().name().equals(status)) {
                dto = ProspectDto.map(mapper, prospect);
                if (!prospect.getStatus().equals(ProspectStatus.CLOSED_WON)) {
                    dto.setDateOfJoining(null);
                    dto.setPlacedby(null);
                    dto.setTrfEmptype(null);
                    dto.setPetitionFor(null);
                }
                dtos.add(dto);
            }
        }
        table.setEntities(dtos);
        String[] columnOrder = new String[]{"employee", "dateOfBirth", "gender", "email", "phoneNumber", "referredBy", "screenedBy", "petitionFor", "placedby", "trfEmptype", "dateOfJoining"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Prospects " + status.toLowerCase() + " Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
    }
}
