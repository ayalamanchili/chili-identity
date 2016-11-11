/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import com.google.common.base.Strings;
import info.chili.dao.CRUDDao;
import info.chili.email.Email;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.client.SubcontractorReportService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.dto.profile.SubcontractorDto;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.SubcontractorStatus;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.profile.AddressResource;
import info.yalamanchili.office.mapper.profile.ContactMapper;
import info.yalamanchili.office.profile.ContactService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/subcontractor")
@Component
@Scope("request")
public class SubcontractorResource extends CRUDResource<Subcontractor> {

    @Autowired
    public SubcontractorDao subcontractorDao;
    @Autowired
    protected ContactService contactService;
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    @Override
    public CRUDDao getDao() {
        return subcontractorDao;
    }

    @PUT
    @Validate
    @Path("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.SUB_CONTRACTOR, allEntries = true)
    public Subcontractor createSubcontractor(SubcontractorDto subcontractorDto) {
        Subcontractor subcontractor = mapper.map(subcontractorDto, Subcontractor.class);

        subcontractor.setSubcontractorStatus(SubcontractorStatus.ACTIVE);
        if (subcontractorDto.getLocation() != null) {
            subcontractor.addLocations(subcontractorDto.getLocation());
        }
        if (subcontractorDto.getContact() != null) {
            Contact contact = contactService.save(subcontractorDto.getContact());
            subcontractor.addContact(contact);
        }
        return super.save(subcontractor);
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    @Cacheable(OfficeCacheKeys.SUB_CONTRACTOR)
    public SubcontractorTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        SubcontractorTable tableObj = new SubcontractorTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.SUB_CONTRACTOR, allEntries = true)
    public Subcontractor save(Subcontractor entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.SUB_CONTRACTOR, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        Subcontractor sub = subcontractorDao.findById(id);
        super.delete(id);
        sendSubDeleteNotification(sub);
    }

    @GET
    @Path("/search-text/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    public List<Subcontractor> search(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("text") String searchText, @QueryParam("column") List<String> columns) {
        return getDao().sqlSearch(searchText, start, limit, columns, false);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.SUB_CONTRACTOR)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    /**
     * Add Subcontractor Contact
     *
     * @param subcontractorId
     * @param dto
     *
     */
    @PUT
    @Validate
    @Path("/contact/add/{subcontractorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void addContact(@PathParam("subcontractorId") Long subcontractorId, ContactDto dto) {
        Subcontractor entity = (Subcontractor) getDao().findById(subcontractorId);
        Contact contact = contactService.save(dto);
        entity.addContact(contact);
    }

    @PUT
    @Path("/contact/remove/{subcontractorId}/{contactId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void removeContact(@PathParam("subcontractorId") Long subcontractorId, @PathParam("contactId") Long contactId) {
        Subcontractor entity = (Subcontractor) getDao().findById(subcontractorId);
        if (entity == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "subcontractorId", "subcontractor not found");
        }
        Contact contact = ContactDao.instance().findById(contactId);
        if (contact == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "contactIdInvalid", "contact not found");
        }
        entity.getContacts().remove(contact);
        ContactDao.instance().delete(contact.getId());
    }

    /**
     * Get subcontractor Contact
     *
     * @param id
     * @param start
     * @param limit
     * @return
     *
     */
    @GET
    @Path("/contacts/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    public ContactDto.ContactDtoTable getContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ContactDto.ContactDtoTable tableObj = new ContactDto.ContactDtoTable();
        Subcontractor subcontractor = (Subcontractor) getDao().findById(id);
        List<ContactDto> dtos = new ArrayList<ContactDto>();
        for (Contact entity : subcontractor.getContacts()) {
            dtos.add(ContactMapper.map(entity));
        }
        tableObj.setEntities(dtos);
        tableObj.setSize((long) subcontractor.getContacts().size());
        return tableObj;
    }

    @GET
    @Path("/contacts/dropdown/{id}/{start}/{limit}")
    public List<Entry> getContactsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Subcontractor subcontractor = (Subcontractor) getDao().findById(id);
        List<Entry> result = new ArrayList<Entry>();
        for (Contact contact : subcontractor.getContacts()) {
            Entry entry = new Entry();
            entry.setId(contact.getId().toString());
            entry.setValue(contact.getFirstName() + " " + contact.getLastName());
            result.add(entry);
        }
        return result;
    }

    /**
     * Add subcontractor locations
     *
     * @param subcontractorId
     * @param address
     *
     */
    @PUT
    @Validate
    @Path("/location/add/{subcontractorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void addlocation(@PathParam("subcontractorId") Long subcontractorId, Address address) {
        Subcontractor subcontractor = (Subcontractor) getDao().findById(subcontractorId);
        subcontractor.addLocations(address);
    }

    @PUT
    @Path("/location/remove/{subcontractorId}/{locationId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void removeLocation(@PathParam("subcontractorId") Long subcontractorId, @PathParam("locationId") Long locationId) {
        Subcontractor subcontractor = (Subcontractor) getDao().findById(subcontractorId);
        if (subcontractor == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "subcontractorIdInvalid", "subcontractor not found");
        }
        Address location = AddressDao.instance().findById(locationId);
        if (location == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "LocationIdInvalid", "location not found");
        }
        subcontractor.getLocations().remove(location);
        AddressDao.instance().delete(location.getId());
    }
    
    @GET
    @Path("/subcontractor-clientinfo-report")
    public void getActiveClientsReport() {
        SubcontractorReportService.instance().generateActiveClientsInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    /**
     * Get subcontractor Locations
     *
     * @param id
     * @param start
     * @param limit
     * @return
     *
     */
    @GET
    @Path("/locations/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    public AddressResource.AddressTable getLocations(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        AddressResource.AddressTable tableObj = new AddressResource.AddressTable();
        Subcontractor subcontractor = (Subcontractor) getDao().findById(id);
        tableObj.setEntities(subcontractor.getLocations());
        tableObj.setSize((long) subcontractor.getLocations().size());
        return tableObj;
    }

    @GET
    @Path("/locations/dropdown/{id}/{start}/{limit}")
    public List<Entry> getLocationsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Subcontractor subcontractor = (Subcontractor) getDao().findById(id);
        List<Entry> result = new ArrayList<Entry>();
        for (Address address : subcontractor.getLocations()) {
            Entry entry = new Entry();
            entry.setId(address.getId().toString());
            entry.setValue(address.getStreet1() + " " + address.getCity());
            result.add(entry);
        }
        return result;
    }

    @GET
    @Path("/reports")
    public void generateRecruiterReport(@QueryParam("coiFromEndDate") Date startDate, @QueryParam("coiToEndDate") Date endDate) {
        SubcontractorTable table = searchForCOIEndDate(startDate, endDate);
        if (table.getSize() != null) {
            String[] columnOrder = new String[]{"name", "description", "website", "coiEndDate"};
            Employee emp = OfficeSecurityService.instance().getCurrentUser();
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "COI End Date Report ", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }

    @PUT
    @Path("/report/{start}/{limit}")
    public SubcontractorTable searchForCOIEndDate(@QueryParam("coiFromEndDate") Date startDate, @QueryParam("coiToEndDate") Date endDate) {
        SubcontractorTable table = searchCOIEndDate(startDate, endDate);
        return table;
    }

    private SubcontractorTable searchCOIEndDate(Date startDate, Date endDate) {
        SubcontractorTable table = table(0, 1000);
        SubcontractorTable resulttable = new SubcontractorTable();
        List<Subcontractor> list = new ArrayList();
        List<Subcontractor> finallist = new ArrayList();
        list.addAll(table.getEntities());
        for (Subcontractor sub : list) {
            if (sub.getCoiEndDate() != null) {
                if (sub.getCoiEndDate().after(startDate) && sub.getCoiEndDate().before(endDate)) {
                    finallist.add(sub);
                }
            }
        }
        if (finallist.size() > 0) {
            resulttable.setEntities(finallist);
            resulttable.setSize(Long.valueOf(finallist.size()));
        }
        return resulttable;

    }

    @XmlRootElement
    @XmlType
    public static class SubcontractorTable implements java.io.Serializable {

        protected Long size;
        protected List<Subcontractor> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Subcontractor> getEntities() {
            return entities;
        }

        public void setEntities(List<Subcontractor> entities) {
            this.entities = entities;
        }
    }
    
    @PUT
    @Path("/search-subcontractor1/{start}/{limit}")
    public List<ClientDto> search1(SubcontractorSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<ClientDto> dtos = new ArrayList();
        ClientDto dto1 = null;
        TypedQuery<Subcontractor> q = em.createQuery(getSearchQuery(dto), Subcontractor.class);
        for (Subcontractor client : q.getResultList()) {
            dto1 = ClientDto.mapSubcontractor(mapper, client, dto);
            dtos.add(dto1);
        }
        return dtos;
    }
    
    protected String getSearchQuery(SubcontractorSearchDto dto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT s from ").append(Subcontractor.class.getCanonicalName()).append(" as s");
        if (!Strings.isNullOrEmpty(dto.getCity()) || !Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append(" join s.locations as subcontractorLocations");
        }
        queryStr.append("  where ");
        if (!Strings.isNullOrEmpty(dto.getName())) {
            queryStr.append("name LIKE '%").append(dto.getName().trim()).append("%' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getCity())) {
            queryStr.append("lower(subcontractorLocations.city) = '").append(dto.getCity().toLowerCase().trim()).append("' ").append(" and ");
        }

        if (!Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append("subcontractorLocations.state = '").append(dto.getState().trim()).append("' ").append(" and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    @Async
    @Transactional
    public void sendSubDeleteNotification(Subcontractor sub) {
        Email email = new Email();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_CONTRACTS.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_RECEIVABLE.name()));
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setSubject("Subcontractor Has Been Deleted.");
        String messageText = " <b><u>System Soft Tech Subcontractor Notification :</b></u> </br> ";
        messageText = messageText.concat("</br> <b>Name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; :</b> " + sub.getName());
        messageText = messageText.concat("</br> <b>Description &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; :</b> Subcontractor has been deleted.");
        messageText = messageText.concat("</br> <b>Date of Deletion  &nbsp; :</b> " + sdf.format(new Date()));
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

}
