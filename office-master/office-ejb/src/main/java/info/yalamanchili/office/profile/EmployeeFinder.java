/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This component is used to search and find the employee in the system based on
 * input information
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
public class EmployeeFinder {

    private final static Logger logger = Logger.getLogger(EmployeeFinder.class.getName());
    @PersistenceContext
    protected EntityManager em;

    public Employee find(String firstName, String lastName) {
        Employee employee = null;
        if (firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty()) {
            return null;
        }
        StringBuilder empIdBuilder = new StringBuilder();
        empIdBuilder.append(firstName.trim().substring(0, 1));
        empIdBuilder.append(lastName.trim().replace(" ", "_"));
        //TODO handle space in last name
        if (OfficeSecurityService.instance().findEmployee(empIdBuilder.toString().toLowerCase()) != null) {
            return OfficeSecurityService.instance().findEmployee(empIdBuilder.toString().toLowerCase());
        } else {
            //TODO do advanced queries and search to find perfect employee match
        }
        return employee;
    }

    public static EmployeeFinder instance() {
        return SpringContext.getBean(EmployeeFinder.class);
    }
}
