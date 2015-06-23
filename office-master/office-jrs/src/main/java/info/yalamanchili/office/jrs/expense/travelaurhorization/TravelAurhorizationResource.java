/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.travelaurhorization;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.expense.travelauthorization.TravelAuthorizationDao;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelExpenseRequisition;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/travelexpense")
@Component
@Transactional
@Scope("request")
public class TravelAurhorizationResource extends CRUDResource<TravelExpenseRequisition> {

    @PUT
    @Validate
    @Override
    public TravelExpenseRequisition save(TravelExpenseRequisition entity) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/{start}/{limit}")
    public TravelAurhorizationResource.TravelAurhorizationTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        TravelAurhorizationResource.TravelAurhorizationTable tableObj = new TravelAurhorizationResource.TravelAurhorizationTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @Override
    public CRUDDao getDao() {
        return TravelAuthorizationDao.instance();
    }

    @XmlRootElement
    @XmlType
    public static class TravelAurhorizationTable implements java.io.Serializable {

        protected Long size;
        protected List<TravelExpenseRequisition> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<TravelExpenseRequisition> getEntities() {
            return entities;
        }

        public void setEntities(List<TravelExpenseRequisition> entities) {
            this.entities = entities;
        }
    }
}
