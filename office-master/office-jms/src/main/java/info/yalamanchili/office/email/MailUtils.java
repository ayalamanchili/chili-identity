/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.chili.security.domain.CUser;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
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
import org.springframework.cache.annotation.Cacheable;
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
//TODO this is not getting cached
    @Cacheable(value = OfficeCacheKeys.EMAILS, key = "{#root.methodName,#employeeId}")
    public Employee findEmployeWithEmpId(String employeeId) {
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where user.enabled=true and employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", employeeId);
        if (getUserQuery.getResultList().size() > 0) {
            return getUserQuery.getResultList().get(0);
        } else {
            return null;
        }
    }
    //TODO this is not getting cached
    @Cacheable(value = OfficeCacheKeys.EMAILS, key = "{#root.methodName,#roles}")
    public Set<String> getEmailsAddressesForRoles(String... roles) {
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
        email.setSubject(subject.toString());
        email.setBody(ExceptionUtils.getStackTrace(e));
        MessagingService.instance().sendEmail(email);
    }

    public static MailUtils instance() {
        return SpringContext.getBean(MailUtils.class);
    }
}
