/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.client.ProjectResource.ProjectTable;
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
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

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

    @GET
    @Path("/projects/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public ProjectTable getProjects(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ProjectTable tableObj = new ProjectTable();
        Client elient = (Client) getDao().findById(id);
        tableObj.setEntities(elient.getProjects());
        tableObj.setSize((long) elient.getProjects().size());
        return tableObj;
    }

     @GET
    @Path("/clientlocation/{id}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public AddressTable getClientLocations(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        AddressTable tableObj = new AddressTable();
        Client elient = (Client) getDao().findById(id);
        tableObj.setEntities(elient.getLocations());
        tableObj.setSize((long) elient.getLocations().size());
        return tableObj;
    }
     
    @PUT
    @Path("/project/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public void addProject(@PathParam("clientId") Long clientId, Project project) {
        Client clnt = (Client) getDao().findById(clientId);
        clnt.addProject(project);
    }
    
     @PUT
    @Path("/clientlocation/{clientId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public void addclientlocation(@PathParam("clientId") Long clientId,Address address) {
        Client clnt = (Client) getDao().findById(clientId);
        clnt.addLocations(address);
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
