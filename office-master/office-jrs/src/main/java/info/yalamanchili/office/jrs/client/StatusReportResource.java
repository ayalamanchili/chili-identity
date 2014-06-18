/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.client.StatusReportDao;
import info.yalamanchili.office.entity.client.StatusReport;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.statusreport.StatusReportService;
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
@Path("secured/statusreport")
@Component
@Transactional
@Scope("request")
public class StatusReportResource extends CRUDResource<StatusReport> {

    @Autowired
    public StatusReportDao employeeReportDao;

    @Override
    public CRUDDao getDao() {
        return employeeReportDao;
    }

    @PUT
    @Path("/submit-status-reoprt-request")
    public void submitStatusReportRequest(StatusReport entity) {
        StatusReportService.instance().submitStatusReport(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    public EmployeeReportTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        EmployeeReportTable tableObj = new EmployeeReportTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class EmployeeReportTable implements java.io.Serializable {

        protected Long size;
        protected List<StatusReport> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<StatusReport> getEntities() {
            return entities;
        }

        public void setEntities(List<StatusReport> entities) {
            this.entities = entities;
        }
    }
}
