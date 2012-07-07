package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;

import java.util.List;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("address")
@Component
@Scope("request")
public class AddressResource extends CRUDResource<Address> {

	@Autowired
	public AddressDao addressDao;
        
        @Autowired
         public EmployeeDao employeeDao;
        
        @Autowired
        protected SecurityService securityService;
        
        @Autowired
        protected CUser cuser;
        
        @Autowired
         protected ProfileNotificationService profileNotificationservice;
        

	@Override
	public CRUDDao getDao() {
		return addressDao;
	}

	@XmlRootElement
	@XmlType
	public static class AddressTable {
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
         @PUT
                public Address save(Address address){
                    
                 Employee emp=securityService.getCurrentUser();
                 
                
                    if(address.getId()==null){
                       
                        return save(address);
                        
                    }
                    else
                    {
                        Address savedAddress= (Address)getDao().save(address);
                           
                       
                        
                        profileNotificationservice.sendEmployeeAddressUpdatedNotification(emp);
                        
                         return savedAddress;
                        
                    }
        
                    
                        
                }
        
 
       
}
