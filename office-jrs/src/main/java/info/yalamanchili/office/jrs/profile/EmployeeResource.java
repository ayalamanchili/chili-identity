/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.entity.profile.ReportsTo;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
import info.yalamanchili.office.jrs.profile.EmailResource.EmailTable;
import info.yalamanchili.office.jrs.profile.EmergencyContactResource.EmergencyContactTable;
import info.yalamanchili.office.jrs.profile.PhoneResource.PhoneTable;
import info.yalamanchili.office.jrs.profile.ReportsToResource.ReportsToTable;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author ayalamanchili
 */
@Path("/employee")
@Component
@Transactional
@Scope("request")
public class EmployeeResource extends CRUDResource<Employee> {

	@Autowired
	public EmployeeDao employeeDao;

	@GET
	@Path("/{start}/{limit}")
	public EmployeeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
		EmployeeTable tableObj = new EmployeeTable();
		tableObj.setEntities(getDao().query(start, limit));
		tableObj.setSize(getDao().size());
		return tableObj;
	}

	/* Address */
	@GET
	@Path("/addresses/{id}/{start}/{limit}")
	public AddressTable getAddresses(@PathParam("id") long id, @PathParam("start") int start,
			@PathParam("limit") int limit) {
		AddressTable tableObj = new AddressTable();
		Employee emp = (Employee) getDao().findById(id);
		tableObj.setEntities(emp.getAddresss());
		tableObj.setSize((long) emp.getAddresss().size());
		return tableObj;
	}

	@PUT
	@Path("/address/{empId}")
	public void addAddress(@PathParam("empId") Long empId, Address address) {
		Employee emp = (Employee) getDao().findById(empId);
		if (address.getAddressType() != null) {
			AddressType addressType = getDao().getEntityManager().find(AddressType.class,
					address.getAddressType().getId());
			address.setAddressType(addressType);
		}
		emp.addAddress(address);
	}

	/* Email */
	@GET
	@Path("/emails/{id}/{start}/{limit}")
	public EmailTable getEmails(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
		EmailTable tableObj = new EmailTable();
		Employee emp = (Employee) getDao().findById(id);
		tableObj.setEntities(emp.getEmails());
		tableObj.setSize((long) emp.getEmails().size());
		return tableObj;
	}

	@PUT
	@Path("/email/{empId}")
	public void addEmail(@PathParam("empId") Long empId, Email email) {
		Employee emp = (Employee) getDao().findById(empId);
		if (email.getEmailType() != null) {
			EmailType emailType = getDao().getEntityManager().find(EmailType.class, email.getEmailType().getId());
			email.setEmailType(emailType);
		}
		emp.addEmail(email);
	}

	/* Phone */

	@GET
	@Path("/phones/{id}/{start}/{limit}")
	public PhoneTable getPhones(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
		PhoneTable tableObj = new PhoneTable();
		Employee emp = (Employee) getDao().findById(id);
		tableObj.setEntities(emp.getPhones());
		tableObj.setSize((long) emp.getPhones().size());
		return tableObj;
	}

	@PUT
	@Path("/phone/{empId}")
	public void addPhone(@PathParam("empId") Long empId, Phone phone) {
		Employee emp = (Employee) getDao().findById(empId);
		if (phone.getPhoneType() != null) {
			PhoneType phoneType = getDao().getEntityManager().find(PhoneType.class, phone.getPhoneType().getId());
			phone.setPhoneType(phoneType);
		}
		emp.addPhone(phone);
	}

	/* ResportsTo */

	@GET
	@Path("/reportstos/{id}/{start}/{limit}")
	public ReportsToTable getReportsTos(@PathParam("id") long id, @PathParam("start") int start,
			@PathParam("limit") int limit) {
		ReportsToTable tableObj = new ReportsToTable();
		Employee emp = (Employee) getDao().findById(id);
		tableObj.setEntities(emp.getReportsTos());
		tableObj.setSize((long) emp.getReportsTos().size());
		return tableObj;
	}

	@PUT
	@Path("/reportsto/{empId}")
	public void addReportsTo(@PathParam("empId") Long empId, ReportsTo entity) {
		Employee emp = (Employee) getDao().findById(empId);
		entity.setContact((Contact) getDao().save(entity.getContact()));
		emp.addReportsTo(entity);
	}

	/* Emergency Contact */

	@GET
	@Path("/emergencycontacts/{id}/{start}/{limit}")
	public EmergencyContactTable getEmergencyContacts(@PathParam("id") long id, @PathParam("start") int start,
			@PathParam("limit") int limit) {
		EmergencyContactTable tableObj = new EmergencyContactTable();
		Employee emp = (Employee) getDao().findById(id);
		tableObj.setEntities(emp.getEmergencyContacts());
		tableObj.setSize((long) emp.getEmergencyContacts().size());
		return tableObj;
	}

	@PUT
	@Path("/emergencycontact/{empId}")
	public void addEmergencyContact(@PathParam("empId") Long empId, EmergencyContact entity) {
		Employee emp = (Employee) getDao().findById(empId);
		entity.setContact((Contact) getDao().save(entity.getContact()));
		emp.addEmergencyContact(entity);
	}

	@Override
	public CRUDDao getDao() {
		return employeeDao;
	}

	@XmlRootElement
	@XmlType
	public static class EmployeeTable {
		protected Long size;
		protected List<Employee> entities;

		public Long getSize() {
			return size;
		}

		public void setSize(Long size) {
			this.size = size;
		}

		@XmlElement
		public List<Employee> getEntities() {
			return entities;
		}

		public void setEntities(List<Employee> entities) {
			this.entities = entities;
		}

	}

}
