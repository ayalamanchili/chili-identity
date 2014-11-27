/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.client.ProjectDao;

import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.StatementOfWork;
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
 * @author Prashanthi
 */
@Path("secured/project")
@Component
@Scope("request")
public class ProjectResource extends CRUDResource<Project> {

    @Autowired
    public ProjectDao projectDao;

    @Override
    public CRUDDao getDao() {
        return projectDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME','ROLE_EXPENSE','ROLE_RELATIONSHIP')")
    public ProjectResource.ProjectTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ProjectResource.ProjectTable tableObj = new ProjectResource.ProjectTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Path("/sow/{projectId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    public void addSOW(@PathParam("projectId") Long projectId, StatementOfWork SOW) {
        Project project = (Project) getDao().findById(projectId);
        project.addSOW(SOW);
    }

    @PUT
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    @Override
    public Project save(Project entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TIME','ROLE_EXPENSE')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class ProjectTable implements java.io.Serializable{

        protected Long size;
        protected List<Project> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Project> getEntities() {
            return entities;
        }

        public void setEntities(List<Project> entities) {
            this.entities = entities;
        }
    }
}
