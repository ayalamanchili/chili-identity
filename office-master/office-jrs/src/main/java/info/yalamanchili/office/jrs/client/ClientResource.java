/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.dto.profile.ContactDto.ContactDtoTable;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.client.ProjectResource.ProjectTable;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
import info.yalamanchili.office.mapper.profile.ContactMapper;
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
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Path("secured/client")
@Component
@Scope("request")
public class ClientResource extends CRUDResource<Client> {

    @Autowired
    public ClientDao clientDao;
    @PersistenceContext
    protected EntityManager em;

    @Override
    public CRUDDao getDao() {
        return clientDao;
    }

    @GET
    @Path("/{start}/{limit}")
    public ClientTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ClientTable tableObj = new ClientTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    /*
     * Client Projects
     */
    @PUT
    @Path("/project/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public void addProject(@PathParam("clientId") Long clientId, Project project) {
        Client clnt = (Client) getDao().findById(clientId);
        clnt.addProject(project);
    }

    @GET
    @Path("/projects/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public ProjectTable getProjects(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ProjectTable tableObj = new ProjectTable();
        Client elient = (Client) getDao().findById(id);
        tableObj.setEntities(elient.getProjects());
        tableObj.setSize((long) elient.getProjects().size());
        return tableObj;
    }

    /**
     * Add Client Contact
     *
     * @param clientId
     * @param dto
     */
    @PUT
    @Path("/clientcontact/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public void addclientContact(@PathParam("clientId") Long clientId, ContactDto dto) {
        Client clnt = (Client) getDao().findById(clientId);
        clnt.addContact(ContactMapper.map(dto, null));
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
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
    @Path("/clientlocation/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public void addclientlocation(@PathParam("clientId") Long clientId, Address address) {
        Client clnt = (Client) getDao().findById(clientId);
        clnt.addLocations(address);
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
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
    public static class ClientTable {

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
