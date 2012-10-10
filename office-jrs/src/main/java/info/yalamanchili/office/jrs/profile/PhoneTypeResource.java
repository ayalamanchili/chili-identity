package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.PhoneTypeDao;

import info.yalamanchili.office.entity.profile.PhoneType;
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

@Path("phonetype")
@Component
@Scope("request")
public class PhoneTypeResource extends CRUDResource<PhoneType> {

    @Autowired
    public PhoneTypeDao phoneTypeDao;

    @Override
    public CRUDDao getDao() {
        return phoneTypeDao;
    }

    @GET
    @Path("/{start}/{limit}")
     @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public PhoneTypeResource.PhoneTypeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        PhoneTypeResource.PhoneTypeTable tableObj = new PhoneTypeResource.PhoneTypeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    @Override
    public PhoneType save(PhoneType entity) {
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
    public static class PhoneTypeTable {

        protected Long size;
        protected List<PhoneType> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<PhoneType> getEntities() {
            return entities;
        }

        public void setEntities(List<PhoneType> entities) {
            this.entities = entities;
        }
    }
}