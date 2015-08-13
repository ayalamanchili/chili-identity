/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.security;

import info.chili.commons.DateUtils;
import info.chili.jpa.QueryUtils;
import info.chili.security.SecurityService;
import info.chili.security.dao.CRoleDao;
import info.chili.security.domain.CRole;
import info.chili.security.domain.CUser;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.security.SecurityUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.*;
import org.bouncycastle.jce.X509Principal;
import org.dozer.Mapper;
import org.jasypt.digest.StandardStringDigester;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("prototype")
@Transactional
public class OfficeSecurityService {

    private final static Logger logger = Logger.getLogger(OfficeSecurityService.class.getName());
    @PersistenceContext
    protected EntityManager em;

//TODO move to chili-security OfficeSecurityService
    public CUser createCuser(CUser user) {
        return em.merge(user);
    }

    public EmployeeLoginDto login(CUser user) {
        TypedQuery<Employee> query = em.createQuery("from Employee emp where emp.user.username=:userNameParam", Employee.class);
        query.setParameter("userNameParam", user.getUsername().toLowerCase());
//        query.setParameter("passwordParam", SecurityUtils.encodePassword(user.getPasswordHash(), null));
        try {
            Mapper mapper = (Mapper) SpringContext.getBean("mapper");
            Employee emp = query.getSingleResult();
            EmployeeLoginDto res = mapper.map(emp, EmployeeLoginDto.class);
            res.setUsername(emp.getUser().getUsername());
            res.setRoles(getCurrentUserRoles());
            return res;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getName();
        }
        return null;
    }

    public Employee getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", auth.getName());
        try {
            return getUserQuery.getSingleResult();
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e);
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<String> getCurrentUserRoles() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return Collections.emptyList();
        }
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return Collections.emptyList();
        }
        List<String> roles = new ArrayList();
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            roles.add(auth.getAuthority());
        }
        return roles;
    }

    public boolean hasAnyRole(String... roles) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return false;
        }
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return false;
        }

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            for (String role : roles) {
                if (role.equals(auth.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasRole(String role) {
        return hasAnyRole(role);
    }

    public boolean isValidEmployeeId(String employeeId) {
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", employeeId);
        if (getUserQuery.getResultList().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Employee findEmployee(String employeeId) {
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", employeeId);
        if (getUserQuery.getResultList().size() > 0) {
            return getUserQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

    public Employee findEmployeeBySSN(String ssn) {
        StandardStringDigester officeStringDigester = (StandardStringDigester) SpringContext.getBean("officeStringDigester");
        return QueryUtils.findEntity(em, Employee.class, "ssnHash", officeStringDigester.digest(ssn));
    }

    public List<String> getUserRoles(Employee employee) {
        List<String> roles = new ArrayList<String>();
        if (employee.getUser() != null) {
            for (CRole role : employee.getUser().getRoles()) {
                roles.add(role.getRolename());
            }
        }
        return roles;
    }

    public List<Employee> getUsersWithRoles(int start, int limit, String role) {
        CRole crole = QueryUtils.findEntity(em, CRole.class, "rolename", role);
        Query query = em.createNativeQuery("SELECT * from CONTACT emp INNER JOIN CUSER cuser ON cuser.userId=emp.user_userId INNER JOIN USERROLES userRoles ON userRoles.UserId=cuser.userId where cuser.enabled= TRUE and userRoles.RoleId=" + crole.getRoleId(), Employee.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public void syncOfficeRoles() {
        for (OfficeRole role : OfficeRole.values()) {
            CRoleDao.instance().createRole(role.name());
        }
    }

    public CRole getRole(OfficeRole role) {
        return QueryUtils.findEntity(em, CRole.class, "rolename", role.name());
    }

    @Async
    @Transactional
    public void syncUserCerts() {
        List<String> empTypes = new ArrayList<String>();
        empTypes.add("Employee");
        empTypes.add("Corporate Employee");
        TypedQuery<Employee> empQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where employeeType.name in (:empTypeParam) and user.enabled=true", Employee.class);
        empQuery.setParameter("empTypeParam", empTypes);
        OfficeSecurityConfiguration securityconfig = OfficeSecurityConfiguration.instance();
        SecurityService securityService = SecurityService.instance();
        for (Employee emp : empQuery.getResultList()) {
            createUserCert(emp, securityconfig, securityService);
        }

    }

    @Transactional
    public void createUserCert(String employeeId) {
        createUserCert(EmployeeDao.instance().findEmployeWithEmpId(employeeId), null, null);
    }

    @Async
    @Transactional
    public void createUserCert(Employee emp, OfficeSecurityConfiguration securityconfig, SecurityService securityService) {
        if (securityService == null) {
            securityService = SecurityService.instance();
        }
        if (securityconfig == null) {
            securityconfig = OfficeSecurityConfiguration.instance();
        }
        String employeeId = emp.getEmployeeId();
        String email = EmployeeDao.instance().getPrimaryEmail(emp);
        String subjectCN = emp.getFirstName() + " " + emp.getLastName();
        X509Principal issuer = new X509Principal("CN=System Soft Technologies, O=System Soft Technologies, OU=System Soft Portal, L=Tampa, ST=FL, C=US");
        //TODO use address and branch information from employee
        X509Principal subject = new X509Principal("CN=" + subjectCN + ",EmailAddress=" + email + ", O=System Soft Technologies");
        securityService.createAndSaveCertToKS(securityconfig.getKeyStoreName(), securityconfig.getKeyStorePath(), employeeId, DateUtils.getNextYear(new Date(), 0), DateUtils.getNextYear(new Date(), 10),
                securityconfig.getKeyStorePassword(), issuer, subject, securityconfig.getCertSignatureAlgorithm(), securityconfig.getKeyAlgorithm(), securityconfig.getKeySize());
        securityService.initKeyStore(securityconfig.getKeyStoreType(), securityconfig.getKeyStoreName(), securityconfig.getKeyStorePassword(), securityconfig.getKeyStorePath());
    }

    public static OfficeSecurityService instance() {
        return SpringContext.getBean(OfficeSecurityService.class);
    }
}
