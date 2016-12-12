/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.integration.bis.BISClientInformationServiceBean;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.ClientInformationService;
import info.yalamanchili.office.dto.offboarding.ProjectOffboardingDto;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dto.profile.ClientInformationDto;
import info.yalamanchili.office.dto.profile.ClientInformationSaveDto;
import info.yalamanchili.office.project.offboarding.ProjectOffboardingService;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Path("secured/clientinformation")
@Component
@Transactional
@Scope("request")
public class ClientInformationResource extends CRUDResource<ClientInformation> {

    @Autowired
    protected ClientInformationDao clientInformationDao;
    @Autowired
    protected ClientInformationService clientInformationService;

    @Override
    public CRUDDao getDao() {
        return clientInformationDao;
    }

    @PUT
    @Path("/save")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RECRUITER','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_ADMIN')")
    @Validate
    @CacheEvict(value = OfficeCacheKeys.CLIENTINFORMATION, allEntries = true)
    public ClientInformationSaveDto save(ClientInformationSaveDto dto, @QueryParam("submitForApproval") Boolean submitForApproval) {
        return clientInformationService.update(dto, submitForApproval);
    }

    @Override
    public ClientInformation save(ClientInformation entity) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/read/{id}")
    @Transactional(readOnly = true)
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_CONTRACTS_ADMIN", "ROLE_BILLING_ADMIN", "ROLE_INVOICE_MANAGER", "ROLE_CONTRACTS_FULL_VIEW"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public ClientInformationDto readCIDto(@PathParam("id") Long id) {
        return clientInformationService.read(id);
    }

    @GET
    @Path("/invoice/read/{id}")
    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public ClientInformationDto readCIForInvoice(@PathParam("id") Long id) {
        return clientInformationService.readCIForInvoice(id);
    }

    @PUT
    @Path("/delete/{id}")
    @CacheEvict(value = OfficeCacheKeys.CLIENTINFORMATION, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        clientInformationService.delete(id);
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public ClientInformation read(@PathParam("id") Long id) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/bis-info/{id}")
    public String getBISInformation(@PathParam("id") Long id) {
        return BISClientInformationServiceBean.instance().getClientInformation(id);
    }

    @GET
    @Path("/dropdown/employee")
    @Transactional(propagation = Propagation.NEVER)
    public List<Entry> getDropDown(@QueryParam("employeeId") Long employeeId) {
        Query query = clientInformationDao.getEntityManager().createQuery("select id, client.name from " + ClientInformation.class.getCanonicalName() + " where employee=:employeeParam");
        Employee emp;
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);
        } else {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        query.setParameter("employeeParam", emp);
        List<Entry> result = new ArrayList<>();
        List<Object> results = query.getResultList();
        for (Iterator<Object> it = results.iterator(); it.hasNext();) {
            Object[] values = (Object[]) it.next();
            result.add(new Entry(values[0].toString(), values[1].toString()));
        }
        return result;
    }

    @GET
    @Path("/projects/dropdown/{id}/{start}/{limit}")
    public List<Entry> getClientContactsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        List<Entry> result = new ArrayList<>();
        Project project = ci.getClientProject();
        Entry entry = new Entry();
        entry.setId(project.getId().toString());
        entry.setValue(project.getName());
        result.add(entry);

        return result;
    }

    @PUT
    @Validate
    @Path("/update-billing-rate/{id}")
    public void updateBillingRate(@PathParam("id") Long id, BillingRate billingRate) {
        clientInformationService.updateBillingRate(id, billingRate);
    }

    @GET
    @Path("/billing-rates/{id}")
    public BillingRateTable updateBillingRate(@PathParam("id") Long id) {
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        BillingRateTable res = new BillingRateTable();
        res.setEntities(ci.getBillingRates());
        res.setSize(Long.valueOf(ci.getBillingRates().size()));
        return res;
    }

    @PUT
    @Validate
    @Path("/project-off-boarding")
    public void projectOffboarding(ProjectOffboardingDto dto) {
        ProjectOffboardingService.instance().startProjectOffboardingTask(dto);
    }

    @PUT
    @Validate
    @Path("/update-project-off-boarding")
    public void updateprojectOffboarding(ProjectOffboardingDto dto) {
        ProjectOffboardingService.instance().updateProjectOffboardingRequest(dto);
    }

    @GET
    @Path("/endDate/{id}/{endPrevProj}")
    public String getPrevProjEndDate(@PathParam("id") Long id, @PathParam("endPrevProj") Boolean endprevProj) {
        return clientInformationDao.queryForPrevProjEndDate(id);
    }
    
    @PUT
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_CONTRACTS_ADMIN')")
    @Path("/add-cpd/{sourceId}/{sourceName}")
    public ClientInformationDto addCPDToProspect(@PathParam("sourceId") Long sourceId,  @PathParam("sourceName") String sourceName, ClientInformationDto cpdDto) {
        return clientInformationService.addCPDToProspect(sourceId, sourceName, cpdDto);
    }

    @XmlRootElement
    @XmlType
    public static class BillingRateTable implements java.io.Serializable {

        protected Long size;
        protected List<BillingRate> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BillingRate> getEntities() {
            return entities;
        }

        public void setEntities(List<BillingRate> entities) {
            this.entities = entities;
        }
    }

    @XmlRootElement
    @XmlType
    public static class ClientInformationTable implements java.io.Serializable {

        protected Long size;
        protected List<ClientInformation> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ClientInformation> getEntities() {
            return entities;
        }

        public void setEntities(List<ClientInformation> entities) {
            this.entities = entities;
        }
    }
}
