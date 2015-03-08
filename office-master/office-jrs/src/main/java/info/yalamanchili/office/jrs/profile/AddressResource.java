/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.profile.BPMProfileService;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("secured/address")
@Component
@Scope("request")
public class AddressResource extends CRUDResource<Address> {

    @Autowired
    public AddressDao addressDao;
    @Autowired
    public EmployeeDao employeeDao;
    @Autowired
    protected OfficeSecurityService securityService;
    @Autowired
    protected ProfileNotificationService profileNotificationservice;

    @Override
    public CRUDDao getDao() {
        return addressDao;
    }

    @PUT
    @Validate
    @Path("/employee")
    public Address saveEmployeeAddress(Address entity) {
        processAddressUpdateNotificationV2(entity, null, true, true, true);
        return save(entity);
    }

    public void processAddressUpdateNotification(Address entity, Employee emp) {
        if (emp == null) {
            emp = EmployeeDao.instance().findById(entity.getContact().getId());
        }
        if (emp.getEmployeeType().getName().equals("Employee") && entity.isNotifyChange()) {
            BPMProfileService.instance().startAddressUpdatedProcess(entity, emp, entity.getChangeNotes());
        }
    }

    public void processAddressUpdateNotificationV2(Address entity, Employee emp, boolean primaryMailingAddress, boolean notifyImmigration, boolean notifyHealthInsurance) {
        if (emp == null) {
            emp = EmployeeDao.instance().findById(entity.getContact().getId());
        }
        if (emp.getEmployeeType().getName().equals("Employee") && entity.isNotifyChange()) {
            Map<String, Object> vars = new HashMap<String, Object>();
            vars.put("entity", entity);
            vars.put("entityId", entity.getId());
            vars.put("employeeName", emp.getFirstName() + " " + emp.getLastName());
            //notify flags
            vars.put("primaryMailingAddress", true);
            vars.put("${notifyImmigration", true);
            vars.put("${notifyHealthInsurance", true);
            OfficeBPMService.instance().startProcess("home_address_update_process", vars);
        }
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    public static AddressResource instance() {
        return SpringContext.getBean(AddressResource.class);
    }

    @XmlRootElement
    @XmlType
    public static class AddressTable implements java.io.Serializable {

        protected Long size;
        protected List<Address> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Address> getEntities() {
            return entities;
        }

        public void setEntities(List<Address> entities) {
            this.entities = entities;
        }
    }
}
