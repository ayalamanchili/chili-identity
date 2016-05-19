/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.Time.OutOfOfficeService;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Path("secured/out-of-office")
@Component
@Transactional
@Scope("request")
public class OutOfOfficeResource extends CRUDResource<OutOfOfficeRequest> {

    @Autowired
    protected Mapper mapper;

    @Autowired
    public OutOfOfficeDao outOfOfficeDao;

    @Override
    public CRUDDao getDao() {
        return outOfOfficeDao;
    }
    
    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public OutOfOfficeRequest read(@PathParam("id") Long id) {
        return outOfOfficeDao.findById(id);
    }

    @PUT
    @Path("/submit-request/")
    public OutOfOfficeRequest submitLeaveRequest(OutOfOfficeRequest outOfOfficeRequest) {
       return OutOfOfficeService.instance().submitRequest(outOfOfficeRequest);
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public OutOfOfficeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        OutOfOfficeTable tableObj = new OutOfOfficeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class OutOfOfficeTable implements java.io.Serializable {

        protected Long size;
        protected List<OutOfOfficeRequest> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<OutOfOfficeRequest> getEntities() {
            return entities;
        }

        public void setEntities(List<OutOfOfficeRequest> entities) {
            this.entities = entities;
        }
    }
}
