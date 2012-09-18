/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.Client.ClientEntityDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Path("client")
@Component
@Scope("request")
public class ClientResource extends CRUDResource<Client> 
     {
     @Autowired
    public ClientEntityDao cliententityDao;
     
      @Override
    public CRUDDao getDao() {
        return cliententityDao;
    }

    @XmlRootElement
    @XmlType
    public static class ClientTable {

        protected Long size;
        protected List<Client> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Client> getEntities() {
            return entities;
        }

        public void setEntities(List<Client> entities) {
            this.entities = entities;
        }
    }
    
}
