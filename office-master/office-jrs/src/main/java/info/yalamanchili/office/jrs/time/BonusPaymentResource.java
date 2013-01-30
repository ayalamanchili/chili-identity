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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
}
