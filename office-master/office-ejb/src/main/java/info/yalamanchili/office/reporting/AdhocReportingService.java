/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reporting;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
public class AdhocReportingService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public String generateIncompleteProfileReport() {
        StringBuilder report = new StringBuilder();
        int start = 0;
        List<Employee> emps;
        while (EmployeeDao.instance().query(start, 50).size() > 0) {
            emps = EmployeeDao.instance().query(start, 50);
            for (Employee emp : emps) {
                if (emp.getEmployeeType().getName().equals(EmployeeType.CORPORATE_EMPLOYEE)) {
                    emp = em.find(Employee.class, emp.getId());
                    if (emp.getPrimaryEmail() == null || emp.getAddresss().size() < 1 || emp.getEmergencyContacts().size() < 1 || emp.getPhones().size() < 1) {
                        report.append("\n");
                        report.append("Proflile for Employee:").append(emp.getFirstName()).append(" ").append(emp.getLastName()).append(" Incomplete.");
                    }
                }
            }
            start += 50;
        }
        return report.toString();
    }

    public static AdhocReportingService instance() {
        return SpringContext.getBean(AdhocReportingService.class);
    }
}
