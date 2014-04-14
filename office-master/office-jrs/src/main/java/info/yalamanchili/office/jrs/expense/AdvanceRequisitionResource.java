/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.expense.AdvanceRequisitionDao;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
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
 * @author prasanthi.p
 */
@Path("secured/advancerequisition")
@Component
@Transactional
@Scope("request")
public class AdvanceRequisitionResource extends CRUDResource<AdvanceRequisition> {

    @Autowired
    public AdvanceRequisitionDao advanceRequisitionDao;

    @Override
    public CRUDDao getDao() {
        return advanceRequisitionDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_EXPENSE')")
    public AdvanceRequisitionTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        AdvanceRequisitionTable tableObj = new AdvanceRequisitionTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class AdvanceRequisitionTable {

        protected Long size;
        protected List<AdvanceRequisition> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<AdvanceRequisition> getEntities() {
            return entities;
        }

        public void setEntities(List<AdvanceRequisition> entities) {
            this.entities = entities;
        }
    }
}
