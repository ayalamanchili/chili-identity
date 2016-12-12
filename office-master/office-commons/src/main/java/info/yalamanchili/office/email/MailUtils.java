/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.chili.email.Email;
import info.chili.security.domain.CUser;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheManager;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class MailUtils {

    private final static Logger logger = Logger.getLogger(MailUtils.class.getName());
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    @Autowired
    protected OfficeCacheManager officeCacheManager;

    public Employee findEmployeWithEmpId(String employeeId) {
        if (officeCacheManager.contains(Email.EMAILS_CACHE_KEY, employeeId)) {
            return (Employee) officeCacheManager.get(Email.EMAILS_CACHE_KEY, employeeId);
        }
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where user.enabled=true and employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", employeeId);
        if (getUserQuery.getResultList().size() > 0) {
            Employee emp = getUserQuery.getResultList().get(0);
            officeCacheManager.put(Email.EMAILS_CACHE_KEY, employeeId, emp);
            return emp;
        } else {
            return null;
        }
    }

    public Set<String> getEmailsAddressesForRoles(String... roles) {
        if (officeCacheManager.contains(Email.EMAILS_CACHE_KEY, Arrays.toString(roles))) {
            return (Set<String>) officeCacheManager.get(Email.EMAILS_CACHE_KEY, Arrays.toString(roles));
        }
        Set<String> emails = new HashSet<String>();
        Query getUsersInRoleQuery = em.createQuery("select user from CUser user join user.roles role where user.enabled=true and role.rolename in (:roles)", CUser.class);
        getUsersInRoleQuery.setParameter("roles", Arrays.asList(roles));
        List<CUser> users = getUsersInRoleQuery.getResultList();
        //TODO improve the query into a single query
        for (CUser user : users) {
            TypedQuery<Employee> getEmployeeQuery = em.createQuery("from Employee where user=:userParam", Employee.class);
            getEmployeeQuery.setParameter("userParam", user);
            Employee emp = getEmployeeQuery.getSingleResult();
            emails.add(emp.getPrimaryEmail().getEmail());
        }
        logger.info("emails:" + emails);
        officeCacheManager.put(Email.EMAILS_CACHE_KEY, Arrays.toString(roles), emails);
        return emails;
    }

    public static void logExceptionDetials(Throwable e) {
        if (!OfficeServiceConfiguration.instance().isEmailExceptionDetials()) {
            return;
        }
        Email email = new Email();
        email.setTos(OfficeServiceConfiguration.instance().getErrorLogsEmailsAsSet());
        StringBuilder subject = new StringBuilder();
        subject.append("Portal Error Details: Host: ");
        try {
            subject.append(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException ex) {
            subject.append("UNKNOWN");
        }
        subject.append(e.getMessage());
        email.setSubject(subject.toString());
        email.setBody(ExceptionUtils.getStackTrace(e));
        MessagingService.instance().sendEmail(email);
    }

    public static MailUtils instance() {
        return SpringContext.getBean(MailUtils.class);
    }
}
