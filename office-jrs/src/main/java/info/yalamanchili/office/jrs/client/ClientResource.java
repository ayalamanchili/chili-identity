/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
 * @author raghu
 */
@Path("client")
@Component
@Scope("request")
public class ClientResource extends CRUDResource<Client> {

    @Autowired
    public ClientDao clientDao;

    @Override
    public CRUDDao getDao() {
        return clientDao;
    }

    @GET
    @Path("/{start}/{limit}")
    public ClientTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ClientTable tableObj = new ClientTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }
    
   @PUT
    @Path("/project/{clientId}")
    public void addProject(@PathParam("clientId") Long clientId, Project project) {
        
        Client clnt = (Client) getDao().findById(clientId);
        
        clnt.addProject(project);
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
