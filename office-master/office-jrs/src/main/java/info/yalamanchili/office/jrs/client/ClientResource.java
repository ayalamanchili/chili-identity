/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import com.google.common.base.Strings;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.client.ClientService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dto.profile.CreateClientDto;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.dto.profile.ContactDto.ContactDtoTable;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.ClientStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.invoice.GenericsDatesDto;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.client.ProjectResource.ProjectTable;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
import info.yalamanchili.office.mapper.profile.ContactMapper;
import info.yalamanchili.office.profile.ContactService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
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

    private Logger logger = Logger.getLogger(ClientResource.class.getName());

    @Autowired
    public ClientDao clientDao;
    @Autowired
    public VendorDao vendorDao;
    @Autowired
    protected ContactService contactService;
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected OfficeBPMService officeBPMService;

    @Override
    public CRUDDao getDao() {
        return clientDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    @Cacheable(OfficeCacheKeys.CLIENT)
    public ClientTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ClientTable tableObj = new ClientTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.CLIENT, allEntries = true)
    public Client createClient(CreateClientDto createClientDto) {
        Client client = mapper.map(createClientDto, Client.class);
        
        client.setClientStatus(ClientStatus.ACTIVE);
        if (createClientDto.getLocation() != null) {
            client.addLocations(createClientDto.getLocation());
        }
        if (createClientDto.getContact() != null) {
            Contact contact = contactService.save(createClientDto.getContact());
            client.addContact(contact);
        }
        if (createClientDto.getClientAcctPayContact() != null) {
            Contact clientAcctPayContact = contactService.save(createClientDto.getClientAcctPayContact());
            client.addClientAcctPayContact(clientAcctPayContact);
        }
        return super.save(client);
    }

    @PUT
    @Validate
    @CacheEvict(value = OfficeCacheKeys.CLIENT, allEntries = true)
    @Override
    public Client save(Client entity) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("client", entity);
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        officeBPMService.startProcess("update_client_notification_process", vars);
        return clientDao.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.CLIENT, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        Client clnt = ClientDao.instance().findById(id);
        super.delete(id);
        ClientService.instance().sendClientDeleteNotification(clnt);
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    public ProjectTable getProjects(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ProjectTable tableObj = new ProjectTable();
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void addclientContact(@PathParam("clientId") Long clientId, ContactDto contactDto) {
        Client clnt = (Client) getDao().findById(clientId);
        Contact contact = contactService.save(contactDto);
        clnt.addContact(contact);
    }

    @PUT
    @Validate
    @Path("/acct-pay-contact/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING' , 'ROLE_BILLING_ADMIN')")
    public void addclientAcctPayContact(@PathParam("clientId") Long clientId, ContactDto dto) {
        Client client = (Client) getDao().findById(clientId);
        Contact contact = contactService.save(dto);
        client.addClientAcctPayContact(contact);
    }

    @PUT
    @Path("/contact/remove/{clientId}/{contactId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
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

    @PUT
    @Path("/acct-pay-contact/remove/{clientId}/{contactId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void removeAcctPayContact(@PathParam("clientId") Long clientId, @PathParam("contactId") Long contactId) {
        Client client = (Client) getDao().findById(clientId);
        Contact contact = ContactDao.instance().findById(contactId);
        client.getClientAcctPayContacts().remove(contact);
        ContactDao.instance().delete(contact.getId());
    }

    @GET
    @Path("/clientinfo-report")
    public void clientReport() {
        ClientService.instance().generateClientInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/active-clientinfo-report")
    public void getActiveClientsReport() {
        ClientService.instance().generateActiveClientsInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    public ContactDtoTable getClientContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit
    ) {
        ContactDtoTable tableObj = new ContactDtoTable();
        Client client = (Client) getDao().findById(id);
        List<ContactDto> dtos = new ArrayList<>();
        for (Contact entity : client.getContacts()) {
            dtos.add(ContactMapper.map(entity));
        }
        tableObj.setEntities(dtos);
        tableObj.setSize((long) client.getContacts().size());
        return tableObj;
    }

    /**
     * Get Client Account Payable Contact
     *
     * @param id
     * @param start
     * @param limit
     * @return
     *
     */
    @GET
    @Path("/acct-pay-contacts/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    public ContactDtoTable getClientAcctPayContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit
    ) {
        Client contact = (Client) getDao().findById(id);
        return getContacts(contact.getClientAcctPayContacts());
    }

    protected ContactDtoTable getContacts(List<Contact> contacts) {
        ContactDtoTable tableObj = new ContactDtoTable();
        for (Contact entity : contacts) {
            tableObj.getEntities().add(ContactMapper.map(entity));
        }
        tableObj.setSize((long) contacts.size());
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
        List<Entry> result = new ArrayList<>();
        for (Contact contact : client.getContacts()) {
            Entry entry = new Entry();
            entry.setId(contact.getId().toString());
            entry.setValue(contact.getFirstName() + " " + contact.getLastName());
            result.add(entry);
        }
        return result;
    }

    @GET
    @Path("/acct-pay-contacts/dropdown/{id}/{start}/{limit}")
    public List<Entry> getClientAcctPayContactsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Client client = ClientDao.instance().findById(id);
        return getContactDropDown(client.getClientAcctPayContacts());
    }

    protected List<Entry> getContactDropDown(List<Contact> contacts) {
        List<Entry> result = new ArrayList<>();
        for (Contact contact : contacts) {
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void addclientlocation(@PathParam("clientId") Long clientId, Address address) {
        Client clnt = (Client) getDao().findById(clientId);
        clnt.addLocations(address);
    }

    @PUT
    @Path("/location/remove/{clientId}/{locationId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
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
        List<Entry> result = new ArrayList<>();
        for (Address address : client.getLocations()) {
            Entry entry = new Entry();
            entry.setId(address.getId().toString());
            entry.setValue(address.getStreet1() + "-" + address.getCity() + "-" + address.getState());
            result.add(entry);
        }
        return result;
    }

    @GET
    @Path("/search/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    public List<Client> search(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("text") String searchText, @QueryParam("column") List<String> columns) {
        return getDao().sqlSearch(searchText, start, limit, columns, false);
    }

    @PUT
    @Path("/search-client/{start}/{limit}")
    public List<Client> search(ClientSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        TypedQuery<Client> q = em.createQuery(getSearchQuery(dto), Client.class);
        return q.getResultList();
    }

    protected String getSearchQuery(ClientSearchDto dto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT c from ").append(Client.class.getCanonicalName()).append(" as c");
        if (!Strings.isNullOrEmpty(dto.getCity()) || !Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append(" join c.locations as clientLocations");
        }
        queryStr.append("  where ");
        if (!Strings.isNullOrEmpty(dto.getName())) {
            queryStr.append("name LIKE '%").append(dto.getName().trim()).append("%' ").append(" and ");
        }
        if (dto.getClientinvFrequency() != null) {
            queryStr.append("clientinvFrequency LIKE '%").append(dto.getClientinvFrequency().name().trim()).append("%' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getCity())) {
            queryStr.append("lower(clientLocations.city) = '").append(dto.getCity().toLowerCase().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append("clientLocations.state = '").append(dto.getState().trim()).append("' ").append(" and ");
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

    @PUT
    @Path("/search-client1/{start}/{limit}")
    public List<ClientDto> search1(ClientSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<ClientDto> dtos = new ArrayList();
        ClientDto dto1 = null;
        TypedQuery<Client> q = em.createQuery(getSearchQuery(dto), Client.class);
        for (Client client : q.getResultList()) {
            dto1 = ClientDto.map(mapper, client, dto);
            dtos.add(dto1);
        }
        return dtos;
    }

    @PUT
    @Path("/report")
    public void report(ClientSearchDto dto) {
        ClientDtoTable table = new ClientDtoTable();
        List<ClientDto> dtos = new ArrayList();
        ClientDto dto1 = null;
        TypedQuery<Client> q = em.createQuery(getSearchQuery(dto), Client.class);
        for (Client client : q.getResultList()) {
            dto1 = ClientDto.map(mapper, client, dto);
            dtos.add(dto1);
        }
        table.setEntities(dtos);
        table.setSize(Long.valueOf(dtos.size()));
        String[] columnOrder = new String[]{"name", "street1", "street2", "city", "state"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        if (dto.getCity() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Clients In City " + dto.getCity(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        } else if (dto.getState() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Clients In State  " + dto.getState(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        }
    }

    @PUT
    @Path("/msa-valid-reports")
    public void generateMSAValidReport(GenericsDatesDto dto) {
        List<Client> list = clientDao.getReport(dto.getStartDate(), dto.getEndDate(), 0, 10000);
        if (list.size() > 0) {
            String reportName = "MSA Report";
            ClientService.instance().generateSearchDatesReport(list, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), reportName);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }

    @PUT
    @Path("/msa-valid-search/{start}/{limit}")
    public List<Client> searchForMSADate(GenericsDatesDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return clientDao.getReport(dto.getStartDate(), dto.getEndDate(), start, limit);
    }

    @XmlRootElement
    @XmlType
    public static class ClientDtoTable implements java.io.Serializable {

        protected Long size;
        protected List<ClientDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ClientDto> getEntities() {
            return entities;
        }

        public void setEntities(List<ClientDto> entities) {
            this.entities = entities;
        }
    }
}
