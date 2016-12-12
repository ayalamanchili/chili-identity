/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.perdiem;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.dao.perdiem.PerDiemDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.Perdiem.PerDiem;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.expense.perdiem.PerDiemService;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/perdiem")
@Component
@Scope("prototype")
@Transactional
public class PerdiemResource extends CRUDResource<PerDiem> {

    @Autowired
    public PerDiemDao perDiemDao;

    @Autowired
    public PerDiemService perDiemService;

    @Override
    public CRUDDao getDao() {
        return perDiemDao;
    }

    @GET
    @Path("/get-emp-address/{employeeId}")
    public List<Address> table(@PathParam("employeeId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        List<Address> addresses = new ArrayList();
        List<Address> addressByType = AddressDao.instance().getAddressByType(emp, "Office");
        if (addressByType.size() > 0) {
            addresses.add(addressByType.get(0));
        }
        List<Address> otherAddress = AddressDao.instance().getAddressByType(emp, "Other");
        if (otherAddress.size() > 0) {
            addresses.add(otherAddress.get(0));
        }
        List<Address> homeAddress = AddressDao.instance().getAddressByType(emp, "Home");
        if (homeAddress.size() > 0) {
            addresses.add(homeAddress.get(0));
        }
        List<Address> noAddressType = AddressDao.instance().getAddressByType(emp, "");
        if (noAddressType.size() > 0) {
            addresses.add(noAddressType.get(0));
        }
        return addresses;
    }

    @PUT
    @Path("/save")
    @Validate
    @Override
    public PerDiem save(PerDiem perDiem) {
        return perDiemService.save(perDiem);
    }

    @PUT
    @Path("/update")
    @Validate
    public PerDiem update(PerDiem perdiem) {
        return perDiemService.update(perdiem);
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public PerDiem read(@PathParam("id") Long id) {
        PerDiem perdiem = perDiemDao.findById(id);
        List<Address> perdiemAddress = new ArrayList();
        Employee emp = perdiem.getEmployee();
        if (perdiem.isLive50MilesAway() == true) {
            List<Address> officeAddr = AddressDao.instance().getAddressByType(emp, "Office");
            if (!officeAddr.isEmpty()) {
                perdiemAddress.add(officeAddr.get(0));
            }
            List<Address> homeAddr = AddressDao.instance().getAddressByType(emp, "Home");
            if (!homeAddr.isEmpty()) {
                perdiemAddress.add(homeAddr.get(0));
            }
        } else {
            List<Address> homeAddr = AddressDao.instance().getAddressByType(emp, "Home");
            if (!homeAddr.isEmpty()) {
                perdiemAddress.add(homeAddr.get(0));
            }
            List<Address> otherAddress = AddressDao.instance().getAddressByType(emp, "Other");
            if (!otherAddress.isEmpty()) {
                perdiemAddress.add(otherAddress.get(0));
            }
        }
        perdiem.setAddresses(perdiemAddress);
        return perdiem;
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        PerDiem entity = perDiemDao.findById(id);
        List<Address> addresses = table(entity.getEmployee().getId());
        PerDiemService service = PerDiemService.instance();
        return service.getReport(entity, addresses);
    }

    @GET
    @Path("/{start}/{limit}")
    public PerDiemTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        PerDiemTable table = new PerDiemTable();
        List<PerDiem> query = new ArrayList();
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), OfficeRoles.OfficeRole.ROLE_ADMIN.name())) {
            query = perDiemDao.query(start, limit);
            List<PerDiem> perdiems = new ArrayList();
            for (PerDiem perdiem : query) {
                perdiems.add(perdiem);
                Hibernate.initialize(perdiem.getAddresses());
            }
            table.setEntities(perdiems);
            table.setSize(Long.valueOf(perdiems.size()));
        } else {
            Employee currentEmp = OfficeSecurityService.instance().getCurrentUser();
            query = perDiemDao.queryForEmployee(currentEmp.getId(), start, limit);
            List<PerDiem> perdiems = new ArrayList();
            for (PerDiem perdiem : query) {
                perdiems.add(perdiem);
                Hibernate.initialize(perdiem.getAddresses());
            }
            table.setEntities(perdiems);
            table.setSize(Long.valueOf(perdiems.size()));
        }
        return table;
    }

    @XmlRootElement
    @XmlType
    public static class PerDiemTable implements java.io.Serializable {

        protected Long size;
        protected List<PerDiem> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<PerDiem> getEntities() {
            return entities;
        }

        public void setEntities(List<PerDiem> entities) {
            this.entities = entities;
        }
    }
}
