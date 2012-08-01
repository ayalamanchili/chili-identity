/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dao.profile.CertificationDao;
import info.yalamanchili.office.entity.profile.Certification;


import javax.ws.rs.Consumes;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanthi
 */
@Path("certification")
@Component
@Transactional
@Scope("request")
public class CertificationResource extends CRUDResource<Certification> {
     @Autowired
    public CertificationDao certificationDao;

    @Override
    public CRUDDao getDao() {
        return certificationDao;
    }  
    
    @GET
    @Path("/{start}/{limit}")
    public CertificationTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        CertificationTable tableObj = new CertificationTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }
 
 @XmlRootElement
	@XmlType
	public static class CertificationTable {
		protected Long size;
		protected List<Certification> entities;

		public Long getSize() {
			return size;
		}

		public void setSize(Long size) {
			this.size = size;
		}

		@XmlElement
		public List<Certification> getEntities() {
			return entities;
		}

		public void setEntities(List<Certification> entities) {
			this.entities = entities;
		}

	}
}
