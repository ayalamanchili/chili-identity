/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.BonusPaymentDao;
import info.yalamanchili.office.entity.time.BonusPayment;
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
public class BonusPaymentResource extends CRUDResource<BonusPayment> {

    @Autowired
    public BonusPaymentDao bonusPaymentDao;

    @Override
    public CRUDDao getDao() {
        return bonusPaymentDao;
    }

    @PUT
    @Override
    public BonusPayment save(BonusPayment entity) {
        info.yalamanchili.office.entity.profile.Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
        entity.setEmployee(emp);
        return (BonusPayment) getDao().save(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public BonusPaymentResource.BopnusPaymentTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        BonusPaymentResource.BopnusPaymentTable tableObj = new BonusPaymentResource.BopnusPaymentTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class BopnusPaymentTable {

        protected Long size;
        protected List<BonusPayment> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BonusPayment> getEntities() {
            return entities;
        }

        public void setEntities(List<BonusPayment> entities) {
            this.entities = entities;
        }
    }
}
