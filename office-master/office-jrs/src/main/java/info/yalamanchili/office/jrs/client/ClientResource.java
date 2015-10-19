/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.dto.profile.ContactDto.ContactDtoTable;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.client.ProjectResource.ProjectTable;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
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
 * @author raghu
 */
@Path("secured/client")
@Component
@Scope("request")
@Transactional
public class ClientResource extends CRUDResource<Client> {

    @Autowired
    public ClientDao clientDao;
    @Autowired
    public VendorDao vendorDao;
    @Autowired
    protected ContactService contactService;
    @PersistenceContext
    protected EntityManager em;

    @Override
    public CRUDDao getDao() {
        return clientDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
    @Cacheable(OfficeCacheKeys.CLIENT)
    public ClientTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ClientTable tableObj = new ClientTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    @CacheEvict(value = OfficeCacheKeys.CLIENT, allEntries = true)
    public Client save(Client client) {
        return super.save(client);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    @CacheEvict(value = OfficeCacheKeys.CLIENT, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.CLIENT)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    /*
     * Client Projects
     */
    @PUT
    @Validate
    @Path("/project/{clientId}/{vendorID}/{midVendorID}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public Project addProject(@PathParam("clientId") Long clientId, Project project, @PathParam("vendorID") Long venID, @PathParam("midVendorID") Long midVenID) {
        Client clnt = (Client) getDao().findById(clientId);
        Vendor vendor = vendorDao.findById(venID);
        Vendor middleVendor = vendorDao.findById(midVenID);
        project.setVendor(vendor);
        project.setMiddleVendor(middleVendor);
        project.setClient(clnt);
        vendor.getClients().add(clnt);
        middleVendor.getClients().add(clnt);
        clnt.getVendors().add(vendor);
        em.merge(project);
        return project;
    }

    @GET
    @Path("/projects/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
    public ProjectTable getProjects(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ProjectTable tableObj = new ProjectTable();
        Client elient = (Client) getDao().findById(id);
// To do - get project information from Project object using Client id
//        tableObj.setEntities(elient.getProjects());
//        tableObj.setSize((long) elient.getProjects().size());
        return tableObj;
    }

    /**
     * Add Client Contact
     *
     * @param clientId
     * @param dto
     */
    @PUT
    @Validate
    @Path("/clientcontact/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public void addclientContact(@PathParam("clientId") Long clientId, ContactDto contactDto) {
        Client clnt = (Client) getDao().findById(clientId);
        Contact contact = contactService.save(contactDto);
        clnt.addContact(contact);
    }

    @PUT
    @Path("/contact/remove/{clientId}/{contactId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public void removeContact(@PathParam("clientId") Long clientId, @PathParam("contactId") Long contactId) {
        Client client = (Client) getDao().findById(clientId);
        if (client == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "clientIdInvalid", "client not found");
        }
        Contact contact = ContactDao.instance().findById(contactId);
        if (contact == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "contactIdInvalid", "contact not found");
        }
        client.getContacts().remove(contact);
        ContactDao.instance().delete(contact.getId());
    }

    /**
     * Get Client Contacts
     *
     * @param id
     * @param start
     * @param limit
     * @return
     */
    @GET
    @Path("/clientcontact/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
    public ContactDtoTable getClientContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ContactDtoTable tableObj = new ContactDtoTable();
        Client client = (Client) getDao().findById(id);
        List<ContactDto> dtos = new ArrayList<ContactDto>();
        for (Contact entity : client.getContacts()) {
            dtos.add(ContactMapper.map(entity));
        }
        tableObj.setEntities(dtos);
        tableObj.setSize((long) client.getContacts().size());
        return tableObj;
    }

    /**
     * Get Client Contacts DropDown
     *
     * @param id
     * @param start
     * @param limit
     * @param columns
     * @return
     */
    @GET
    @Path("/contacts/dropdown/{id}/{start}/{limit}")
    public List<Entry> getClientContactsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Client client = ClientDao.instance().findById(id);
        List<Entry> result = new ArrayList<Entry>();
        for (Contact contact : client.getContacts()) {
            Entry entry = new Entry();
            entry.setId(contact.getId().toString());
            entry.setValue(contact.getFirstName() + " " + contact.getLastName());
            result.add(entry);
        }
        return result;
    }

    /**
     * Add Client Location
     *
     * @param clientId
     * @param address
     */
    @PUT
    @Validate
    @Path("/clientlocation/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public void addclientlocation(@PathParam("clientId") Long clientId, Address address) {
        Client clnt = (Client) getDao().findById(clientId);
        clnt.addLocations(address);
    }

    @PUT
    @Path("/location/remove/{clientId}/{locationId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public void removeLocation(@PathParam("clientId") Long clientId, @PathParam("locationId") Long locationId) {
        Client client = (Client) getDao().findById(clientId);
        if (client == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "clientIdInvalid", "client not found");
        }
        Address location = AddressDao.instance().findById(locationId);
        if (location == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "LocationIdInvalid", "location not found");
        }
        client.getLocations().remove(location);
        AddressDao.instance().delete(location.getId());
    }

    /**
     * Get Client Locations
     *
     * @param id
     * @param start
     * @param limit
     * @return
     */
    @GET
    @Path("/clientlocation/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
    public AddressTable getClientLocations(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        AddressTable tableObj = new AddressTable();
        Client elient = (Client) getDao().findById(id);
        tableObj.setEntities(elient.getLocations());
        tableObj.setSize((long) elient.getLocations().size());
        return tableObj;
    }

    /**
     * Get Client Contacts DropDown
     *
     * @param id
     * @param start
     * @param limit
     * @param columns
     * @return
     */
    @GET
    @Path("/locations/dropdown/{id}/{start}/{limit}")
    public List<Entry> getClientLocationsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Client client = ClientDao.instance().findById(id);
        List<Entry> result = new ArrayList<Entry>();
        for (Address address : client.getLocations()) {
            Entry entry = new Entry();
            entry.setId(address.getId().toString());
            entry.setValue(address.getStreet1() + " " + address.getCity());
            result.add(entry);
        }
        return result;
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
}
