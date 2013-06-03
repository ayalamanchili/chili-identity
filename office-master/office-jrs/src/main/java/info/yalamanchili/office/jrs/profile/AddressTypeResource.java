/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.AddressTypeDao;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.jrs.CRUDResource;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Path("secured/addresstype")
@Component
@Scope("request")
public class AddressTypeResource extends CRUDResource<AddressType> {
	@Autowired
	public AddressTypeDao addressTypeDao;

	@Override
	public CRUDDao getDao() {
		return addressTypeDao;
	}
    @GET
    @Path("/{start}/{limit}")
     @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public AddressTypeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        AddressTypeTable tableObj = new AddressTypeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }
   
    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    @Override
    public AddressType save(AddressType entity) {
        return super.save(entity);
    }
     
    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }
    
    @XmlRootElement
	@XmlType
	public static class AddressTypeTable {
		protected Long size;
		protected List<AddressType> entities;

		public Long getSize() {
			return size;
		}

		public void setSize(Long size) {
			this.size = size;
		}

		@XmlElement
		public List<AddressType> getEntities() {
			return entities;
		}

		public void setEntities(List<AddressType> entities) {
			this.entities = entities;
		}

	}
}
