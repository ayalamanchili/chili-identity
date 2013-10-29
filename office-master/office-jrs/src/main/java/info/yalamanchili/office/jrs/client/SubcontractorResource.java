/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.profile.AddressResource;
import info.yalamanchili.office.mapper.profile.ContactMapper;
import info.yalamanchili.office.profile.ContactService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
    @Cacheable(OfficeCacheKeys.SUB_CONTRACTOR)
    public SubcontractorTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        SubcontractorTable tableObj = new SubcontractorTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    @CacheEvict(value = OfficeCacheKeys.SUB_CONTRACTOR, allEntries = true)
    public Subcontractor save(Subcontractor entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    @CacheEvict(value = OfficeCacheKeys.SUB_CONTRACTOR, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
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
    @Path("/contact/add/{subcontractorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public void addContact(@PathParam("subcontractorId") Long subcontractorId, ContactDto dto) {
        Subcontractor entity = (Subcontractor) getDao().findById(subcontractorId);
        Contact contact = contactService.save(dto);
        entity.addContact(contact);
    }

    @PUT
    @Path("/contact/remove/{subcontractorId}/{contactId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
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
    @Path("/location/add/{subcontractorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public void addlocation(@PathParam("subcontractorId") Long subcontractorId, Address address) {
        Subcontractor subcontractor = (Subcontractor) getDao().findById(subcontractorId);
        subcontractor.addLocations(address);
    }

    @PUT
    @Path("/location/remove/{subcontractorId}/{locationId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
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

    @XmlRootElement
    @XmlType
    public static class SubcontractorTable {

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
}
