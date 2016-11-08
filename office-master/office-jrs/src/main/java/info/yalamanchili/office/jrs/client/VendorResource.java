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
import info.yalamanchili.office.client.VendorService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.InvoiceScheduleDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.dto.profile.ContactDto.ContactDtoTable;
import info.yalamanchili.office.dto.profile.VendorDto;
import info.yalamanchili.office.entity.client.InvoiceSchedule;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.VendorStatus;
import info.yalamanchili.office.invoice.GenericsDatesDto;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
import info.yalamanchili.office.mapper.profile.ContactMapper;
import info.yalamanchili.office.profile.ContactService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author Prashanthi
 */
@Path("secured/vendor")
@Component
@Scope("request")
public class VendorResource extends CRUDResource<Vendor> {

    @Autowired
    public VendorDao vendorDao;

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected OfficeBPMService officeBPMService;

    @Override
    public CRUDDao getDao() {
        return vendorDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    @Cacheable(OfficeCacheKeys.VENDOR)
    public VendorTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        VendorTable tableObj = new VendorTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.VENDOR, allEntries = true)
    public Vendor save(Vendor vendor) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("/updatecpd")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @Validate
    @CacheEvict(value = OfficeCacheKeys.VENDOR, allEntries = true)
    public Vendor update(Vendor vendor, @QueryParam("submitForUpdateF") Boolean submitForUpdateF, @QueryParam("submitForUpdateP") Boolean submitForUpdateP, @QueryParam("submitForUpdateD") Boolean submitForUpdateD) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("vendor", vendor);
        vars.put("currentEmployee",OfficeSecurityService.instance().getCurrentUser());
        officeBPMService.startProcess("update_vendor_notification_process", vars);
        vendor = super.save(vendor);
        if (submitForUpdateP || submitForUpdateF || submitForUpdateD) {
            vendorDao.updateExistingClientInformations(vendor, submitForUpdateF, submitForUpdateP, submitForUpdateD, OfficeSecurityService.instance().getCurrentUserName());
        }
        return vendor;
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.VENDOR, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        Vendor vn = vendorDao.findById(id);
        List<InvoiceSchedule> schedules = InvoiceScheduleDao.instance().findAll(id, "info.yalamanchili.office.entity.client.Vendor");
        if (schedules.size() > 0) {
            for (InvoiceSchedule invschedule : schedules) {
                InvoiceScheduleDao.instance().delete(invschedule);
            }
        }
        super.delete(id);
        VendorService.instance().sendVendorDeleteNotification(vn);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.VENDOR)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    /**
     * Add Vendor Contact
     *
     * @param vendorId
     * @param dto
     *
     */
    @PUT
    @Validate
    @Path("/vendorcontact/{vendorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void addvendorContact(@PathParam("vendorId") Long vendorId, ContactDto dto) {
        Vendor vendor = (Vendor) getDao().findById(vendorId);
        Contact contact = ContactService.instance().save(dto);
        vendor.addContact(contact);
    }

    @PUT
    @Validate
    @Path("/acct-pay-contact/{vendorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING' , 'ROLE_BILLING_ADMIN')")
    public void addvendorAcctPayContact(@PathParam("vendorId") Long vendorId, ContactDto dto) {
        Vendor vendor = (Vendor) getDao().findById(vendorId);
        Contact contact = ContactService.instance().save(dto);
        vendor.addAcctPayContact(contact);
    }

    @PUT
    @Path("/contact/remove/{vendorId}/{contactId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void removeContact(@PathParam("vendorId") Long vendorId, @PathParam("contactId") Long contactId) {
        Vendor vendor = (Vendor) getDao().findById(vendorId);
        Contact contact = ContactDao.instance().findById(contactId);
        vendor.getContacts().remove(contact);
        ContactDao.instance().delete(contact.getId());
    }

    @PUT
    @Path("/acct-pay-contact/remove/{vendorId}/{contactId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void removeAcctPayContact(@PathParam("vendorId") Long vendorId, @PathParam("contactId") Long contactId) {
        Vendor vendor = (Vendor) getDao().findById(vendorId);
        Contact contact = ContactDao.instance().findById(contactId);
        vendor.getAcctPayContacts().remove(contact);
        ContactDao.instance().delete(contact.getId());
    }

    /**
     * Get Vendor Contact
     *
     * @param id
     * @param start
     * @param limit
     * @return
     *
     */
    @GET
    @Path("/vendorcontact/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    public ContactDtoTable getVendorContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        Vendor vendor = (Vendor) getDao().findById(id);
        return getContacts(vendor.getContacts());
    }

    /**
     * Get Vendor Account Payable Contact
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
    public ContactDtoTable getVendorAcctPayContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        Vendor vendor = (Vendor) getDao().findById(id);
        return getContacts(vendor.getAcctPayContacts());
    }

    protected ContactDtoTable getContacts(List<Contact> contacts) {
        ContactDtoTable tableObj = new ContactDtoTable();
        for (Contact entity : contacts) {
            tableObj.getEntities().add(ContactMapper.map(entity));
        }
        tableObj.setSize((long) contacts.size());
        return tableObj;
    }

    @GET
    @Path("/contacts/dropdown/{id}/{start}/{limit}")
    public List<Entry> getVendorContactsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Vendor vendor = VendorDao.instance().findById(id);
        return getContactDropDown(vendor.getContacts());
    }

    @GET
    @Path("/acct-pay-contacts/dropdown/{id}/{start}/{limit}")
    public List<Entry> getVendorAcctPayContactsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Vendor vendor = VendorDao.instance().findById(id);
        return getContactDropDown(vendor.getAcctPayContacts());
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

    @GET
    @Path("/vendorinfo-report")
    public void vendorReport() {
        VendorService.instance().generateVendorInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/active-vendorinfo-report")
    public void getActiveVendorsReport() {
        VendorService.instance().generateActiveVendorsInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    /**
     * Add Vendor locations
     *
     * @param vendorId
     * @param address
     *
     */
    @PUT
    @Validate
    @Path("/vendorlocation/{vendorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void addvendorlocation(@PathParam("vendorId") Long vendorId, Address address) {
        Vendor vend = (Vendor) getDao().findById(vendorId);
        vend.addLocations(address);
    }

    @PUT
    @Path("/location/remove/{vendorId}/{locationId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    public void removeLocation(@PathParam("vendorId") Long vendorId, @PathParam("locationId") Long locationId) {
        Vendor vendor = (Vendor) getDao().findById(vendorId);
        if (vendor == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "vendorIdInvalid", "vendor not found");
        }
        Address location = AddressDao.instance().findById(locationId);
        if (location == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "LocationIdInvalid", "location not found");
        }
        vendor.getLocations().remove(location);
        AddressDao.instance().delete(location.getId());
    }

    /**
     * Get Vendor Locations
     *
     * @param id
     * @param start
     * @param limit
     * @return
     *
     */
    @GET
    @Path("/vendorlocation/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_BILLING_AND_INVOICING','ROLE_CONTRACTS_FULL_VIEW')")
    public AddressTable getVendorLocations(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        AddressTable tableObj = new AddressTable();
        Vendor evendor = (Vendor) getDao().findById(id);
        tableObj.setEntities(evendor.getLocations());
        tableObj.setSize((long) evendor.getLocations().size());
        return tableObj;
    }

    @GET
    @Path("/locations/dropdown/{id}/{start}/{limit}")
    public List<Entry> getVendorLocationsDropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Vendor vendor = VendorDao.instance().findById(id);
        List<Entry> result = new ArrayList<>();
        for (Address address : vendor.getLocations()) {
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
    public List<Vendor> search(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("text") String searchText, @QueryParam("column") List<String> columns) {
        return getDao().sqlSearch(searchText, start, limit, columns, false);
    }

    @PUT
    @Path("/search-vendor/{start}/{limit}")
    public List<Vendor> search(VendorSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        TypedQuery<Vendor> q = em.createQuery(getSearchQuery(dto), Vendor.class);
        return q.getResultList();
    }

    protected String getSearchQuery(VendorSearchDto dto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT v from ").append(Vendor.class.getCanonicalName()).append(" as v");
        if (!Strings.isNullOrEmpty(dto.getCity()) || !Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append(" join v.locations as vendorLocations");
        }
        queryStr.append("  where ");
        if (!Strings.isNullOrEmpty(dto.getVendorName())) {
            queryStr.append("name LIKE '%").append(dto.getVendorName().trim()).append("%' ").append(" and ");
        }
        if (dto.getVendorType() != null) {
            queryStr.append("vendorType LIKE '%").append(dto.getVendorType().name().trim()).append("%' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getCity())) {
            queryStr.append("lower(vendorLocations.city) = '").append(dto.getCity().toLowerCase().trim()).append("' ").append(" and ");
        }

        if (!Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append("vendorLocations.state = '").append(dto.getState().trim()).append("' ").append(" and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    @PUT
    @Path("/report")
    public void report(VendorSearchDto dto) {
        ClientResource.ClientDtoTable table = new ClientResource.ClientDtoTable();
        List<ClientDto> dtos = new ArrayList();
        ClientDto dto1 = null;
        TypedQuery<Vendor> q = em.createQuery(getSearchQuery(dto), Vendor.class);
        for (Vendor vendor : q.getResultList()) {
            dto1 = ClientDto.mapVendor(mapper, vendor, dto);
            dtos.add(dto1);
        }
        table.setEntities(dtos);
        table.setSize(Long.valueOf(dtos.size()));
        String[] columnOrder = new String[]{"name", "street1", "street2", "city", "state"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        if (dto.getCity() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Vendors In City " + dto.getCity(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        } else if (dto.getState() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Vendors In State " + dto.getState(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        }
    }

    @GET
    @Path("/reports")
    public void generateCOIEndReport(@QueryParam("coiFromEndDate") Date startDate, @QueryParam("coiToEndDate") Date endDate) {
        VendorResource.VendorTable table = searchForCOIEndDate(startDate, endDate);
        if (table.getSize() != null) {
            String reportName = "COI Report";
            List<Vendor> list = new ArrayList();
            list.addAll(table.getEntities());
            VendorService.instance().generateSearchDatesReport(list, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), reportName);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }

    @PUT
    @Path("/coiSearch")
    public VendorResource.VendorTable searchForCOIEndDate(@QueryParam("coiFromEndDate") Date startDate, @QueryParam("coiToEndDate") Date endDate) {
        VendorResource.VendorTable table = searchCOIEndDate(startDate, endDate);
        return table;
    }

    private VendorResource.VendorTable searchCOIEndDate(Date startDate, Date endDate) {
        VendorResource.VendorTable table = table(0, 10000);
        VendorResource.VendorTable resulttable = new VendorResource.VendorTable();
        List<Vendor> list = new ArrayList();
        List<Vendor> finallist = new ArrayList();
        list.addAll(table.getEntities());
        for (Vendor ven : list) {
            if (ven.getCoiEndDate() != null) {
                if (ven.getCoiEndDate().after(startDate) && ven.getCoiEndDate().before(endDate)) {
                    finallist.add(ven);
                }
            }
        }
        if (finallist.size() > 0) {
            resulttable.setEntities(finallist);
            resulttable.setSize(Long.valueOf(finallist.size()));
        }
        return resulttable;

    }

    @PUT
    @Path("/msa-valid-reports")
    public void generateMSAValidReport(GenericsDatesDto dto) {
        List<Vendor> list = vendorDao.getReport(dto.getStartDate(), dto.getEndDate(), 0, 10000);
        if (list.size() > 0) {
            String reportName = "MSA Report";
            VendorService.instance().generateSearchDatesReport(list, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), reportName);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }

    @PUT
    @Path("/msa-valid-search/{start}/{limit}")
    public List<Vendor> searchForMSADate(GenericsDatesDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return vendorDao.getReport(dto.getStartDate(), dto.getEndDate(), start, limit);
    }

    @XmlRootElement
    @XmlType
    public static class VendorTable implements java.io.Serializable {

        protected Long size;
        protected List<Vendor> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Vendor> getEntities() {
            return entities;
        }

        public void setEntities(List<Vendor> entities) {
            this.entities = entities;
        }
    }

    @PUT
    @Path("/search-vendor1/{start}/{limit}")
    public List<ClientDto> search1(VendorSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<ClientDto> dtos = new ArrayList();
        ClientDto dto1 = null;
        TypedQuery<Vendor> q = em.createQuery(getSearchQuery(dto), Vendor.class);
        for (Vendor client : q.getResultList()) {
            dto1 = ClientDto.mapVendor(mapper, client, dto);
            dtos.add(dto1);
        }
        return dtos;
    }

    @PUT
    @Validate
    @Path("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS','ROLE_CONTRACTS_ADMIN','ROLE_BILLING_AND_INVOICING')")
    @CacheEvict(value = OfficeCacheKeys.VENDOR, allEntries = true)
    public Vendor createVendor(VendorDto vendorDto) {
        Vendor vendor = mapper.map(vendorDto, Vendor.class);
        vendor.setVendorStatus(VendorStatus.ACTIVE);
        if (vendorDto.getLocation() != null) {
            vendor.addLocations(vendorDto.getLocation());
        }
        if (vendorDto.getContact() != null) {
            Contact contact = ContactService.instance().save(vendorDto.getContact());
            vendor.addContact(contact);
        }
        if (vendorDto.getVendorAcctPayContact() != null) {
            Contact vendorAcctPayContact = ContactService.instance().save(vendorDto.getVendorAcctPayContact());
            vendor.addAcctPayContact(vendorAcctPayContact);
        }
        return super.save(vendor);
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
