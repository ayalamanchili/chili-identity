/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.expense.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/checkrequisition")
@Component
@Transactional
@Scope("request")
public class ImmigrationCheckRequisitionResource extends CRUDResource<ImmigrationCheckRequisition>{
    @Autowired
    public ImmigrationCheckRequisitionDao immigrationCheckRequisitionDao;
    
 

    @PUT
    @Override
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_EXPENSE')")
    public ImmigrationCheckRequisition save(ImmigrationCheckRequisition entity) {
        return super.save(entity);
    }

    @Override
    public CRUDDao getDao() {
        return immigrationCheckRequisitionDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_EXPENSE')")
    public ImmigrationCheckRequisitionTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ImmigrationCheckRequisitionTable tableObj = new ImmigrationCheckRequisitionTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class ImmigrationCheckRequisitionTable implements java.io.Serializable {

        protected Long size;
        protected List<ImmigrationCheckRequisition> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ImmigrationCheckRequisition> getEntities() {
            return entities;
        }

        public void setEntities(List<ImmigrationCheckRequisition> entities) {
            this.entities = entities;
        }
    }
    
}
