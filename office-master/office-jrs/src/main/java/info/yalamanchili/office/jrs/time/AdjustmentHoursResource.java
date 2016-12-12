/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.AdjustmentHoursDao;
import info.yalamanchili.office.entity.time.AdjustmentHours;
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
 * @author raghu
 */
@Path("secured/bonuspayment")
@Component
@Scope("request")
public class AdjustmentHoursResource extends CRUDResource<AdjustmentHours> {

    @Autowired
    public AdjustmentHoursDao adjustmentHoursDao;

    @Override
    public CRUDDao getDao() {
        return adjustmentHoursDao;
    }

    @PUT
    @Override
    public AdjustmentHours save(AdjustmentHours entity) {
        info.yalamanchili.office.entity.profile.Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
        entity.setEmployee(emp);
        return (AdjustmentHours) getDao().save(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public AdjustmentHoursResource.BopnusPaymentTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        AdjustmentHoursResource.BopnusPaymentTable tableObj = new AdjustmentHoursResource.BopnusPaymentTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class BopnusPaymentTable implements java.io.Serializable {

        protected Long size;
        protected List<AdjustmentHours> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<AdjustmentHours> getEntities() {
            return entities;
        }

        public void setEntities(List<AdjustmentHours> entities) {
            this.entities = entities;
        }
    }
}
