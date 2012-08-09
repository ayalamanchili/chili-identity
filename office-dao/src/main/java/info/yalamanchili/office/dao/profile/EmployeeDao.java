/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeDao extends CRUDDao<Employee> {

    @PersistenceContext
    protected EntityManager em;

    public EmployeeDao() {
        super(Employee.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void delete(Long id) {
        try {
            Employee emp = findById(id);
            //Phones
            for (Phone phone : emp.getPhones()) {
                em.remove(phone);
            }
            //similarly
        } catch (javax.persistence.PersistenceException e) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "SQLError", "cannot delete due to associated data");
        }
    }
}
