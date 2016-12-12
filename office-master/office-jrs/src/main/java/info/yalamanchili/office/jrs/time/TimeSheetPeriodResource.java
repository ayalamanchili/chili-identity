/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.time.TimeSheetPeriodDao;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
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
 * @author bala
 */
@Path("secured/timesheetperiod")
@Component
@Scope("request")
public class TimeSheetPeriodResource extends CRUDResource<TimeSheetPeriod> {

    @Autowired
    public TimeSheetPeriodDao timeSheetPeriodDao;

    @Override
    public CRUDDao getDao() {
        return timeSheetPeriodDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public TimeSheetPeriodResource.TimeSheetTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        TimeSheetPeriodResource.TimeSheetTable tableObj = new TimeSheetPeriodResource.TimeSheetTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public TimeSheetPeriod save(TimeSheetPeriod entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class TimeSheetTable implements java.io.Serializable {

        protected Long size;
        protected List<TimeSheetPeriod> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<TimeSheetPeriod> getEntities() {
            return entities;
        }

        public void setEntities(List<TimeSheetPeriod> entities) {
            this.entities = entities;
        }
    }
}
