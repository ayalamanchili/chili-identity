/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.activity;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.activity.CommunicationActivityDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.activity.CommunicationActivity;
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

/**
 *
 * @author ayalamanchili
 */
@Path("secured/communication_activity")
@Component
@Scope("request")
public class CommunicationActivityResource extends CRUDResource<CommunicationActivity> {

    @Autowired
    public CommunicationActivityDao communicationActivityDao;

    @Override
    public CRUDDao getDao() {
        return communicationActivityDao;
    }

    @GET
    @Path("/{empId}/{start}/{limit}")
    public CommunicationActivityTable table(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        CommunicationActivityTable tableObj = new CommunicationActivityTable();
        tableObj.setEntities(communicationActivityDao.getCommunicationActivity(empId, start, limit));
        tableObj.setSize(communicationActivityDao.getCommunicationActivitySize(empId, start, limit));
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RELATIONSHIP')")
    @Path("/{empId}")
    public CommunicationActivity save(@PathParam("empId") Long empId, CommunicationActivity entity) {
        entity.setEmployee(EmployeeDao.instance().findById(empId));
        return communicationActivityDao.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RELATIONSHIP')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class CommunicationActivityTable {

        protected Long size;
        protected List<CommunicationActivity> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<CommunicationActivity> getEntities() {
            return entities;
        }

        public void setEntities(List<CommunicationActivity> entities) {
            this.entities = entities;
        }
    }
}
