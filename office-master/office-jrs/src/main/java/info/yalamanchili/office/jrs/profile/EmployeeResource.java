/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.commons.SearchUtils;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.TechnologyGroupDao;
import info.yalamanchili.office.dto.profile.EmergencyContactDto;
import info.yalamanchili.office.dto.profile.EmployeeDto;
import info.yalamanchili.office.dto.profile.EmployeeReadDto;
import info.yalamanchili.office.dto.profile.EmployeeSaveDto;
import info.yalamanchili.office.dto.profile.EmployeeSearchDto;
import info.yalamanchili.office.dto.profile.SkillSetDto;
import info.yalamanchili.office.entity.profile.*;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.ClientInformationDto;
import info.yalamanchili.office.entity.privacy.PrivacyData;
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
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public EmployeeReadDto read(@PathParam("id") Long id) {
        Employee emp = employeeDao.findById(id);
        EmployeeReadDto response = mapper.map(emp, EmployeeReadDto.class);
        if (emp.getUser() != null) {
            response.setStatus(emp.getUser().isEnabled());
        }
        return response;
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
        @CacheEvict(value = OfficeCacheKeys.LOGIN, key = "#dto.employeeId")
    })
    //TODO currently does not have any restrictions since user emp profile update also uses this method
    public Employee save(EmployeeSaveDto dto) {
        return (Employee) getDao().save(mapper.map(dto, Employee.class));
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    public EmployeeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<info.yalamanchili.office.dto.profile.EmployeeDto> employees = new ArrayList<info.yalamanchili.office.dto.profile.EmployeeDto>();
        EmployeeTable tableObj = new EmployeeTable();
        for (Object empObj : employeeDao.query(start, limit)) {
            employees.add(info.yalamanchili.office.dto.profile.EmployeeDto.map(mapper, (Employee) empObj));
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
//TODO make this generic

    @GET
    @Path("/employees-by-type/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.EMPLOYEES)
    public List<Entry> getEmployeesByTypeDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns, @QueryParam("employee-type") List<String> employeeType) {
        List<Entry> result = new ArrayList<Entry>();
        Map<String, String> values = EmployeeDao.instance().getEmployeeStringMapByType(start, limit, employeeType, columns.toArray(new String[columns.size()]));
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
    public void addClientInformation(@PathParam("empId") Long empId, ClientInformationDto clientInformation, @QueryParam("submitForApproval") Boolean submitForApproval) {
        ClientInformationService clientInformationService = (ClientInformationService) SpringContext.getBean("clientInformationService");
        clientInformationService.addClientInformation(empId, clientInformation, submitForApproval);
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
    public List<info.yalamanchili.office.dto.profile.EmployeeDto> searchEmployee(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("text") String text, @QueryParam("column") List<String> columns, @QueryParam("includeDeactivated") boolean includeDeactivated) {
        List<info.yalamanchili.office.dto.profile.EmployeeDto> employees = new ArrayList<>();
        for (Object empObj : employeeDao.sqlSearch(text, start, limit, columns, includeDeactivated)) {
            employees.add(info.yalamanchili.office.dto.profile.EmployeeDto.map(mapper, (Employee) empObj));
        }
        return employees;
    }

    @PUT
    @Path("/searchEmployee/{start}/{limit}")
    public List<info.yalamanchili.office.dto.profile.EmployeeDto> searchEmployee(EmployeeSearchDto entity, @PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("includeDeactivated") boolean includeDeactivated) {
        List<info.yalamanchili.office.dto.profile.EmployeeDto> employees = new ArrayList<info.yalamanchili.office.dto.profile.EmployeeDto>();
        List<Employee> result = null;
        if (entity.getCompanyContacts().size() > 0 && entity.getCompanyContacts().get(0).getContact() != null) {
            result = employeeDao.searchByCompanyContact(entity.getCompanyContacts().get(0).getContact(), start, limit);
        } else if (entity.getUser() != null && entity.getUser().getRoles().size() > 0) {
            result = OfficeSecurityService.instance().getUsersWithRoles(start, limit, entity.getUser().getRoles().iterator().next().getRolename());
        } else {
            result = getDao().search(mapper.map(entity, Employee.class), start, limit, new SearchUtils.SearchCriteria());
        }
        for (Object empObj : result) {
            employees.add(info.yalamanchili.office.dto.profile.EmployeeDto.map(mapper, (Employee) empObj));
        }
        return employees;
    }
//TODO user super class search

    @POST
    @Path("/search_employee_report")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response searchEmployeeReport(EmployeeSearchDto entity, @QueryParam("reportName") String reportName, @QueryParam("format") String format) {
        List<EmployeeDto> data = new ArrayList<EmployeeDto>();
        String[] columnOrder = new String[]{"employeeId", "firstName", "lastName", "sex", "dateOfBirth", "branch", "email", "phoneNumber", "jobTitle", "company"};
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

    @Override
    public CRUDDao getDao() {
        return employeeDao;
    }

    @XmlRootElement
    @XmlType
    public static class EmployeeTable implements java.io.Serializable {

        protected Long size;
        protected List<info.yalamanchili.office.dto.profile.EmployeeDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<info.yalamanchili.office.dto.profile.EmployeeDto> getEntities() {
            return entities;
        }

        public void setEntities(List<info.yalamanchili.office.dto.profile.EmployeeDto> entities) {
            this.entities = entities;
        }
    }
}
