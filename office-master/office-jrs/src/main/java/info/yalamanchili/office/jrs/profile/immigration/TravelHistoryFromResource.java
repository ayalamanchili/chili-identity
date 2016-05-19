/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.TravelHistoryFromDao;
import info.yalamanchili.office.entity.immigration.TravelHistoryFrom;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.profile.immigration.TravelHistoryFromService;
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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/travelhistory")
@Component
@Transactional
@Scope("request")
public class TravelHistoryFromResource {

    @Autowired
    protected TravelHistoryFromDao travelHistoryFromDao;
    @Autowired
    protected TravelHistoryFromService travelHistoryFromService;

    @PUT
    @Path("/save/{empId}")
    @Validate
    public TravelHistoryFrom save(@PathParam("empId") Long empId, TravelHistoryFrom travelHistoryFrom) {
        return travelHistoryFromService.save(empId, travelHistoryFrom);
    }

    @PUT
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        TravelHistoryFrom travelHistory = travelHistoryFromDao.find(id);
        if (travelHistory.getId() != null) {
            travelHistoryFromDao.delete(id);
        }
    }

    @GET
    @Path("/{id}/{start}/{limit}")
    public TravelHistoryFromResource.TavelHistoryFromTable table(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        TravelHistoryFromResource.TavelHistoryFromTable tableObj = new TravelHistoryFromResource.TavelHistoryFromTable();
        Employee emp = EmployeeDao.instance().findById(id);
        tableObj.setEntities(travelHistoryFromDao.findAll(emp));
        tableObj.setSize(travelHistoryFromDao.size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class TavelHistoryFromTable implements java.io.Serializable {

        protected Long size;
        protected List<TravelHistoryFrom> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<TravelHistoryFrom> getEntities() {
            return entities;
        }

        public void setEntities(List<TravelHistoryFrom> entities) {
            this.entities = entities;
        }
    }

}
