/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
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
import info.yalamanchili.office.bpm.offboarding.ProjectOffBoardingDto;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.client.ContractService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.dto.profile.ClientInformationDto;
import info.yalamanchili.office.dto.profile.ClientInformationSaveDto;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.project.offboarding.ProjectOffBoardingService;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.Date;
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
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RECRUITER','ROLE_CONTRACTS_ADMIN')")
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
//    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_HR","ROLE_CONTRACTS_ADMIN", "ROLE_BILLING_ADMIN", "ROLE_RECRUITER", "ROLE_BILLING_AND_INVOICING"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public ClientInformationDto readCIDto(@PathParam("id") Long id) {
        return clientInformationService.read(id);
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
    @Path("/mp/employees")
    public ClientInformationTable getMPForEmployees() {
        ClientInformationTable list = new ClientInformationTable();
        String[] types = {"Corporate Employee", "Employee", "Subcontractor", "W2 Contractor", "1099 Contractor"};
        List<Employee> emps = EmployeeDao.instance().getEmployeesByType(types);
        List<ClientInformation> clients = new ArrayList();
        for (Employee emp : emps) {
            if (emp.getClientInformations() != null && emp.getClientInformations().size() > 1) {
                for (ClientInformation ci : emp.getClientInformations()) {
                    if (ci.getEndDate() != null) {
                        if ((ci.getEndDate().after(new Date())) || (ci.getEndDate().equals(new Date()))) {
                            clients.add(ci);
                        }
                    } else {
                        clients.add(ci);
                    }
                }
            }
        }
        if (clients.size() > 1) {
            list.setEntities(clients);
            list.setSize(Long.valueOf(clients.size()));
            return list;
        } else {
            return null;
        }
    }

    @PUT
    @Path("/search-projects-between-days/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    public ClientInformationTable table(@PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
        ClientInformationTable table = new ClientInformationTable();
        List<ClientInformation> clients = clientInformationDao.queryForProjEndBetweenDays(start, limit, startDate, endDate);
        if (clients != null && clients.size() > 0) {
            table.setEntities(clients);
            table.setSize(Long.valueOf(clients.size()));
            return table;
        } else {
            return null;
        }
    }

    @GET
    @Path("/ended-projects-report")
    public void report(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
        ContractDto.ContractTable ctable = new ContractDto.ContractTable();
        List<ClientInformation> clients = clientInformationDao.queryForProjEndBetweenDays(0, 10000, startDate, endDate);
        if (clients != null && clients.size() > 0) {
            for (ClientInformation ci : clients) {
                ctable.getEntities().add(ContractService.instance().mapClientInformation(ci));
            }
        }
        String[] columnOrder = new String[]{"employee", "recruiter", "vendor", "subContractorName", "billingRate", "startDate", "endDate"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        String start = DateUtils.formatDate(startDate, "MM-dd-yyyy");
        String end = DateUtils.formatDate(endDate, "MM-dd-yyyy");
        String fileName = ReportGenerator.generateExcelOrderedReport(ctable.getEntities(), "ProjectsEnded Or Going To End Between " + start + " and " + end, OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/multiple-projects-report")
    public void multipleProjreport() {
        ClientInformationTable table = getMPForEmployees();
        List<ClientInformation> cis = new ArrayList();
        ContractDto.ContractTable ctable = new ContractDto.ContractTable();
        if (table.getSize() > 0) {
            cis.addAll(table.getEntities());
        }
        for (ClientInformation ci : cis) {
            ctable.getEntities().add(ContractService.instance().mapClientInformation(ci));
        }
        String[] columnOrder = new String[]{"employee", "client", "vendor", "billingRate", "startDate", "endDate"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        String fileName = ReportGenerator.generateExcelOrderedReport(ctable.getEntities(), "Employees On Multiple Projects Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
    }

    @PUT
    @Validate
    @Path("/project-off-boarding")
    public void projectOffBoarding(ProjectOffBoardingDto dto) {
        ProjectOffBoardingService.instance().startProjectOffBoardingTask(dto);
    }

    @GET
    @Path("/endDate/{id}/{endPrevProj}")
    public String getPrevProjEndDate(@PathParam("id") Long id, @PathParam("endPrevProj") Boolean endprevProj) {
        return clientInformationDao.queryForPrevProjEndDate(id);
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
