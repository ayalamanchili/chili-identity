/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.cits;

import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anu
 */
@Component
@Transactional
public class CitsService {

    @PersistenceContext
    protected EntityManager em;

    @Async
    public void pushNewEmployeeInformation(Employee employee) {
        Employee emp = em.find(Employee.class, employee.getId());
        System.out.println(emp.toString());
    }

    @Async
    public void syncEmployeeInformation() {
    }
}
