/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Path("vendor")
@Component
@Scope("request")
public class VendorResource extends CRUDResource<Vendor> {

    @Autowired
    public VendorDao vendorDao;
    @PersistenceContext
    protected EntityManager em;

    @Override
    public CRUDDao getDao() {
        return vendorDao;
    }

    @XmlRootElement
    @XmlType
    public static class VendorTable {

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
}
