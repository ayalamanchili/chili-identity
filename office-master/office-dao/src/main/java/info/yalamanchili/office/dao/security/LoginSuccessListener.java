/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.security;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.audit.LoginActivityDao;
import info.yalamanchili.office.entity.audit.LoginActivity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Transactional
//TODO move this along with SecurityService to EJB layer
public class LoginSuccessListener {

    public void logLogin() {
        Employee emp = SecurityService.instance().getCurrentUser();
        LoginActivity loginActivity = new LoginActivity();
        loginActivity.setName(emp.getFirstName() + " " + emp.getLastName());
        loginActivity.setEmployeeId(emp.getEmployeeId());
        loginActivity.setLoginTimeStamp(new Date());
        LoginActivityDao.instance().save(loginActivity);
    }

    public static LoginSuccessListener instance() {
        return SpringContext.getBean(LoginSuccessListener.class);
    }
}
