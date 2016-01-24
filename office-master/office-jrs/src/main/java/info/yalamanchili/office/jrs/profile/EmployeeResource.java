/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import com.google.common.base.Strings;
import info.chili.commons.SearchUtils;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.chili.security.domain.CUser;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.TechnologyGroupDao;
import info.yalamanchili.office.dto.profile.EmergencyContactDto;
import info.yalamanchili.office.dao.profile.EmployeeDto;
import info.yalamanchili.office.dao.profile.EmployeeReadDto;
import info.yalamanchili.office.dto.profile.EmployeeSaveDto;
import info.yalamanchili.office.dto.profile.EmployeeSearchDto;
import info.yalamanchili.office.dto.profile.SkillSetDto;
import info.yalamanchili.office.entity.profile.*;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.client.ContractService;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.dto.profile.ClientInformationDto;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.privacy.PrivacyData;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.privacy.PrivacyAware;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
import info.yalamanchili.office.jrs.profile.EmailResource.EmailTable;
import info.yalamanchili.office.jrs.profile.EmergencyContactResource.EmergencyContactTable;
import info.yalamanchili.office.jrs.profile.PhoneResource.PhoneTable;
import info.yalamanchili.office.jrs.profile.ClientInformationResource.ClientInformationTable;
import info.yalamanchili.office.profile.ClientInformationService;
import info.yalamanchili.office.profile.EmergencyContactService;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/employee")
@Component
@Transactional
@Scope("request")
public class EmployeeResource extends CRUDResource<Employee> {

    @Autowired
    public EmployeeDao employeeDao;
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected ProfileNotificationService profileNotificationservice;

    @GET
    @Path("/{id}")
    @Override
    @Transactional(readOnly = true)
    public EmployeeReadDto read(@PathParam("id") Long id) {
        return employeeDao.read(id);
    }

    @PUT
    @Override
    public Employee save(Employee entity) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Validate
    @Path("/save")
    @Caching(evict = {
        @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true),
        @CacheEvict(value = OfficeCacheKeys.LOGIN, allEntries = true)
    })
    //TODO currently does not have any restrictions since user emp profile update also uses this method
    public Employee save(EmployeeSaveDto dto) {
        if (dto.isActive() == true) {
            dto.setEndDate(null);
            Long employeeId = dto.getId();
            Employee employee = EmployeeDao.instance().findById(employeeId);
            CUser user = employee.getUser();
            if (user != null) {
                user.setEnabled(true);
            }
        }
        return (Employee) getDao().save(mapper.map(dto, Employee.class));
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    public EmployeeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<info.yalamanchili.office.dao.profile.EmployeeDto> employees = new ArrayList<info.yalamanchili.office.dao.profile.EmployeeDto>();
        EmployeeTable tableObj = new EmployeeTable();
        for (Object empObj : employeeDao.query(start, limit)) {
            employees.add(info.yalamanchili.office.dao.profile.EmployeeDto.map(mapper, (Employee) empObj));
        }
        tableObj.setEntities(employees);
        tableObj.setSize(employeeDao.size());
        return tableObj;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        Employee emp = EmployeeDao.instance().findById(id);
        if (emp.getUser() != null) {
            OfficeBPMIdentityService.instance().deleteUser(emp.getUser().getUsername());
        }
        super.delete(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }
//TODO ignore inactive employees

    @GET
    @Path("/employees-by-type/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    public List<Entry> getEmployeesByTypeDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns, @QueryParam("employee-type") List<String> employeeType, @QueryParam("includeAll") boolean includeAll) {
        List<Entry> result = new ArrayList<>();
        Map<String, String> values;
        if (includeAll) {
            values = EmployeeDao.instance().getAllEmployeeStringMapByType(start, limit, employeeType, columns.toArray(new String[columns.size()]));
        } else {
            values = EmployeeDao.instance().getEmployeeStringMapByType(start, limit, employeeType, columns.toArray(new String[columns.size()]));
        }
        for (String key : values.keySet()) {
            result.add(new Entry(key, values.get(key)));
        }
        return result;
    }

    @GET
    @Path("/employees-by-role/dropdown/{role}/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    public List<Entry> getEmployeesWithRoleDropDown(@PathParam("role") String role, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<Entry> result = new ArrayList<>();
        Map<String, String> values = EmployeeDao.instance().getEmpByRoleEntityMap(start, limit, role);
        for (String key : values.keySet()) {
            result.add(new Entry(key, values.get(key)));
        }
        return result;
    }

    /* Address */
    @GET
    @Path("/addresses/{id}/{start}/{limit}")
    @PrivacyAware(key = PrivacyData.ADDRESSES)
    public AddressTable getAddresses(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        AddressTable tableObj = new AddressTable();
        Employee emp = (Employee) getDao().findById(id);
        tableObj.setEntities(emp.getAddresss());
        tableObj.setSize((long) emp.getAddresss().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/address/{empId}")
    public void addAddress(@PathParam("empId") Long empId, Address address) {
        Employee emp = (Employee) getDao().findById(empId);
        address.setContact(emp);
        AddressResource.instance().saveEmployeeAddress(address);
    }

    /* SkillSet */
    @GET
    @Path("/skillset/{empId}")
    @PrivacyAware(key = PrivacyData.SKILL_SET)
    public SkillSet getSkillSet(@PathParam("empId") long empId) {
        Employee emp = (Employee) getDao().findById(empId);
        //If skillset not present create a empty skillset so certifications and skills can be added.
        if (emp.getSkillSet() == null) {
            SkillSet ss = new SkillSet();
            emp.setSkillSet(ss);
        }
        return emp.getSkillSet();

    }

    @PUT
    @Validate
    @Path("/skillset/{empId}")
    @Produces("application/text")
    public String addSkillSet(@PathParam("empId") Long empId, SkillSetDto skillset) {
        Employee emp = (Employee) getDao().findById(empId);
        SkillSet skillSetUpdated = emp.getSkillSet();
        if (skillSetUpdated == null) {
            skillSetUpdated = mapper.map(skillset, SkillSet.class);
        }
        if (skillset.getResumeUrl() != null) {
            skillSetUpdated.setResumeUrl(skillset.getResumeUrl());
        }
        if (skillset.getPractice() == null || skillset.getPractice().getId() == null) {
            skillSetUpdated.setPractice(null);
        } else {
            skillSetUpdated.setPractice(PracticeDao.instance().findById(skillset.getPractice().getId()));
        }
        if (skillset.getTechnologyGroup() == null || skillset.getTechnologyGroup().getId() == null) {
            skillSetUpdated.setTechnologyGroup(null);
        } else {
            skillSetUpdated.setTechnologyGroup(TechnologyGroupDao.instance().findById(skillset.getTechnologyGroup().getId()));
        }
        emp.setSkillSet(skillSetUpdated);
        emp = em.merge(emp);
        profileNotificationservice.skillSetUpdatedNotification(emp);
        return emp.getSkillSet().getId().toString();
    }
    /* Preferences*/

    @GET
    @Path("/preferences/{empId}")
    public Preferences getPreferences(@PathParam("empId") long empId) {
        Employee emp = (Employee) getDao().findById(empId);
        return emp.getPreferences();

    }

    /* Email */
    @GET
    @Path("/emails/{id}/{start}/{limit}")
    @PrivacyAware(key = PrivacyData.EMAILS)
    public EmailTable getEmails(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        EmailTable tableObj = new EmailTable();
        Employee emp = (Employee) getDao().findById(id);
        tableObj.setEntities(emp.getEmails());
        tableObj.setSize((long) emp.getEmails().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/email/{empId}")
    @Caching(evict = {
        @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true),
        @CacheEvict(value = info.chili.email.Email.EMAILS_CACHE_KEY, allEntries = true)
    })
    public void addEmail(@PathParam("empId") Long empId, Email email) {
        Employee emp = (Employee) getDao().findById(empId);

        if (email.getEmailType() != null) {
            EmailType emailType = getDao().getEntityManager().find(EmailType.class, email.getEmailType().getId());
            email.setEmailType(emailType);
        }
        //email = getDao().getEntityManager.(emp, email);
        email = employeeDao.updatePrimaryEmail(emp, email);
        emp.addEmail(email);
    }

    /* Phone */
    @GET
    @Path("/phones/{id}/{start}/{limit}")
    @PrivacyAware(key = PrivacyData.PHONES)
    public PhoneTable getPhones(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        PhoneTable tableObj = new PhoneTable();
        Employee emp = (Employee) getDao().findById(id);
        tableObj.setEntities(emp.getPhones());
        tableObj.setSize((long) emp.getPhones().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/phone/{empId}")
    @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true)
    public void addPhone(@PathParam("empId") Long empId, Phone phone) {
        Employee emp = (Employee) getDao().findById(empId);
        if (phone.getPhoneType() != null) {
            PhoneType phoneType = getDao().getEntityManager().find(PhoneType.class, phone.getPhoneType().getId());
            phone.setPhoneType(phoneType);
        }
        emp.addPhone(phone);
    }

    /**
     * Get Client Information
     *
     * @param id
     * @param start
     * @param limit
     * @return
     */
    @GET
    @Path("/clientinformation/{id}/{start}/{limit}")
    @PrivacyAware(key = PrivacyData.CLIENT_INFORMATION)
    public ClientInformationTable getClientInformations(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ClientInformationTable tableObj = new ClientInformationTable();
        Employee emp = (Employee) getDao().findById(id);
        List<ClientInformation> clientInfoDtos = new ArrayList<>();
        for (ClientInformation entity : emp.getClientInformations()) {
            clientInfoDtos.add(entity);
        }
        tableObj.setEntities(clientInfoDtos);
        tableObj.setSize((long) emp.getClientInformations().size());
        return tableObj;
    }

    /**
     * Add Client Information
     *
     * @param empId
     * @param clientInformation
     * @param submitForApproval
     */
    @PUT
    @Validate
    @Path("/clientinformation/{empId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RECRUITER','ROLE_CONTRACTS_ADMIN')")
    public ClientInformationDto addClientInformation(@PathParam("empId") Long empId, ClientInformationDto clientInformation, @QueryParam("submitForApproval") Boolean submitForApproval) {
        ClientInformationService clientInformationService = (ClientInformationService) SpringContext.getBean("clientInformationService");
        return clientInformationService.addClientInformation(empId, clientInformation, submitForApproval);

    }

    /* Emergency Contact */
    @GET
    @Path("/emergencycontacts/{id}/{start}/{limit}")
    @PrivacyAware(key = PrivacyData.EMERGENCY_CONTACTS)
    public EmergencyContactTable getEmergencyContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        EmergencyContactTable tableObj = new EmergencyContactTable();
        Employee emp = (Employee) getDao().findById(id);
        List<EmergencyContactDto> emergencyContacts = new ArrayList<EmergencyContactDto>();
        for (EmergencyContact ec : emp.getEmergencyContacts()) {
            emergencyContacts.add(EmergencyContactDto.map(mapper, ec));
        }
        tableObj.setEntities(emergencyContacts);
        tableObj.setSize((long) emp.getEmergencyContacts().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/emergencycontact/{empId}")
    public void addEmergencyContact(@PathParam("empId") Long empId, EmergencyContactDto ecDto) {
        EmergencyContactService emergencyContactService = (EmergencyContactService) SpringContext.getBean("emergencyContactService");
        emergencyContactService.addEmergencyContact(empId, ecDto);
    }

    @GET
    @Path("/searchEmployee/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<info.yalamanchili.office.dao.profile.EmployeeDto> searchEmployee(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("text") String text, @QueryParam("column") List<String> columns, @QueryParam("includeDeactivated") boolean includeDeactivated) {
        return employeeDao.searchEmployee(text, start, limit, columns, includeDeactivated);
    }

    @PUT
    @Path("/searchEmployee/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<info.yalamanchili.office.dao.profile.EmployeeDto> searchEmployee(EmployeeSearchDto entity, @PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("includeDeactivated") boolean includeDeactivated) {
        List<info.yalamanchili.office.dao.profile.EmployeeDto> employees = new ArrayList<info.yalamanchili.office.dao.profile.EmployeeDto>();
        List<Employee> result = null;
        if (entity.getCompanyContacts().size() > 0 && entity.getCompanyContacts().get(0).getContact() != null) {
            result = employeeDao.searchByCompanyContact(entity.getCompanyContacts().get(0).getContact(), start, limit);
        } else if (entity.getUser() != null && entity.getUser().getRoles().size() > 0) {
            result = OfficeSecurityService.instance().getUsersWithRoles(start, limit, entity.getUser().getRoles().iterator().next().getRolename());
        } else {
            result = getDao().search(mapper.map(entity, Employee.class), start, limit, new SearchUtils.SearchCriteria());
        }
        for (Object empObj : result) {
            employees.add(info.yalamanchili.office.dao.profile.EmployeeDto.map(mapper, (Employee) empObj));
        }
        return employees;
    }
//TODO user super class search

    @POST
    @Path("/search_employee_report")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response searchEmployeeReport(EmployeeSearchDto entity, @QueryParam("reportName") String reportName, @QueryParam("format") String format) {
        List<EmployeeDto> data = new ArrayList<EmployeeDto>();
        String[] columnOrder = new String[]{"employeeId", "firstName", "lastName", "gender", "dateOfBirth", "branchName", "email", "phoneNumber", "jobTitle", "compny"};
        Long size;
        if (entity.getCompanyContacts().size() > 0) {
            size = 1000l;
        } else {
            size = SearchUtils.getSearchSize(getDao().getEntityManager(), mapper.map(entity, Employee.class), new SearchUtils.SearchCriteria());
        }
        int start = 0;
        int limit = 100;
        do {
            data.addAll(searchEmployee(entity, start, limit, false));
            start = start + limit;
        } while ((start + limit) < size);
        return ReportGenerator.generateReport(data, reportName, format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
    }

    @PUT
    @Path("/search-emp-between-days/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    public EmployeeTable table(@PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("value") String value) {
        EmployeeTable table = new EmployeeTable();
        List<EmployeeDto> dtos = new ArrayList();
        for (Object empObj : employeeDao.queryBetweenDays(start, limit, startDate, endDate, value)) {
            dtos.add(info.yalamanchili.office.dao.profile.EmployeeDto.map(mapper, (Employee) empObj));
        }
        table.setEntities(dtos);
        table.setSize(Long.valueOf(dtos.size()));
        return table;
    }

    @Override
    public CRUDDao getDao() {
        return employeeDao;
    }

    @GET
    @Path("/search-emp-between-days-report")
    public void employeeJoinedOrLeftReport(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("value") String value) {
        EmployeeTable table = table(0, 10000, startDate, endDate, value);
        if (table.getSize() > 0) {
            String[] columnOrder = new String[]{"firstName", "lastName", "startDate", "endDate", "phoneNumber"};
            Employee emp = OfficeSecurityService.instance().getCurrentUser();
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Joined Or Left In a Period Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        }
    }

    @PUT
    @Path("/searchEmployee1/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<ClientInformation> searchEmployee1(EmployeeLocationDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        TypedQuery<Employee> q = em.createQuery(getSearchQuery(dto), Employee.class);
        List<ClientInformation> dtos = new ArrayList();
        for (Employee emp : q.getResultList()) {
            for (ClientInformation ci : emp.getClientInformations()) {
                if ((ci.getEndDate().after(new Date())) || (ci.getEndDate().equals(new Date())) || (ci.getEndDate() == null)) {
                    dtos.add(ci);
                }
            }
        }
        return dtos;
    }

    @PUT
    @Path("/location-report")
    @Transactional(readOnly = true)
    public void empLocationReport(EmployeeLocationDto dto) {
        ContractDto.ContractTable table = new ContractDto.ContractTable();
        List<ClientInformation> dtos = searchEmployee1(dto, 0, 1000);
        List<ContractDto> contractdtos = new ArrayList();
        for (ClientInformation ci : dtos) {
            contractdtos.add(ContractService.instance().mapClientInformation(ci));
        }
        table.setEntities(contractdtos);
        String[] columnOrder = new String[]{"employee", "client", "clientLocation", "vendor", "startDate", "endDate"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        if (dto.getCity() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Working In City " + dto.getCity(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        } else if (dto.getState() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Working In State " + dto.getState(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        }
    }

    protected String getSearchQuery(EmployeeLocationDto dto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT emp from ").append(Employee.class.getCanonicalName()).append(" as emp");
        if (!Strings.isNullOrEmpty(dto.getCity()) || !Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append(" join emp.addresss as address");
        }
        queryStr.append("  where ");
        if (!Strings.isNullOrEmpty(dto.getCity())) {
            queryStr.append("lower(address.city) = '").append(dto.getCity().toLowerCase().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append("address.state = '").append(dto.getState().trim()).append("' ").append(" and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    @XmlRootElement
    @XmlType
    public static class ClientTable implements java.io.Serializable {

        protected Long size;
        protected List<Client> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Client> getEntities() {
            return entities;
        }

        public void setEntities(List<Client> entities) {
            this.entities = entities;
        }
    }

    @XmlRootElement
    @XmlType
    public static class EmployeeTable implements java.io.Serializable {

        protected Long size;
        protected List<info.yalamanchili.office.dao.profile.EmployeeDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<info.yalamanchili.office.dao.profile.EmployeeDto> getEntities() {
            return entities;
        }

        public void setEntities(List<info.yalamanchili.office.dao.profile.EmployeeDto> entities) {
            this.entities = entities;
        }
    }
}
