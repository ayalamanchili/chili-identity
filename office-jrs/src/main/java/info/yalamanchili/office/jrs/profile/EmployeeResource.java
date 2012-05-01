/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author ayalamanchili
 */
@Path("/employee")
@Component
@Transactional
public class EmployeeResource extends CRUDResource<Employee> {

	@Autowired
	public EmployeeDao employeeDao;

	@GET
	@Path("/table/{start}/{limit}")
	public EmployeeTable table(@PathParam("start") int start,
			@PathParam("limit") int limit) {
		EmployeeTable tableObj = new EmployeeTable();
		tableObj.setEntities(getDao().query(start, limit));
		tableObj.setSize(getDao().size());
		return tableObj;
	}

	@GET
	@Path("/addresses/table/{id}/{start}/{limit}")
	public AddressTable getAddresses(@PathParam("id") long id,
			@PathParam("start") int start, @PathParam("limit") int limit) {
		AddressTable tableObj = new AddressTable();
		Employee emp = (Employee) getDao().findById(id);
		System.out.println(emp);
		tableObj.setEntities(emp.getAddresss());
		tableObj.setSize((long) emp.getAddresss().size());
		return tableObj;
	}

	@PUT
	@Path("/address/{empId}")
	public void addAddress(@PathParam("empId") Long empId, Address address) {
		Employee emp = (Employee) getDao().findById(empId);
		emp.addAddress(address);
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
