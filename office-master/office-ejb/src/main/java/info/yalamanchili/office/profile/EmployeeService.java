/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.EntityQueryUtils;
import info.chili.security.SecurityUtils;
import info.chili.security.dao.CRoleDao;
import info.chili.security.domain.CRole;
import info.chili.security.domain.CUser;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.EmployeeTypeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.EmployeeCreateDto;
import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Preferences;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang.time.DateUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import info.yalamanchili.office.dto.profile.EmployeeCompanyTransferDto;
import info.yalamanchili.office.dto.profile.EmployeeDeptTransferDto;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author raghu
 */
@Component
@Scope("request")
public class EmployeeService {

    private final static Logger logger = Logger.getLogger(EmployeeService.class.getName());
    //TODO remove extended
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected ProfileNotificationService profileNotificationService;
    @Autowired
    protected Mapper mapper;

    public String createUser(EmployeeCreateDto employee) {
        Employee emp = mapper.map(employee, Employee.class);
        emp.setEmployeeType(em.find(EmployeeType.class, emp.getEmployeeType().getId()));
        if (emp.getCompany() != null) {
            emp.setCompany(em.find(Company.class, employee.getCompany().getId()));
        }
        emp = createCUser(emp);
        //Create employee with basic information
        emp = createEmailAndOtherDefaults(emp, employee.getEmail());
        //Create BPM User
        if (emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType.CORPORATE_EMPLOYEE)) {
            createBPMUser(emp, true);
        }
        //create cert
        OfficeSecurityService.instance().createUserCert(emp, null, null);
        //Email notification
        sendNewEmployeeNotifiaction(emp);
        return emp.getId().toString();
    }

    public void createProject(CreateProjectEmployeeDto project) {
        Employee projectEmp = new Employee();
        projectEmp.setFirstName(project.getName());
        projectEmp.setLastName(project.getName());
        projectEmp.setDateOfBirth(DateUtils.addDays(new Date(), -1));
        projectEmp.setStartDate(project.getStartDate());
        projectEmp.setEmployeeType(EmployeeTypeDao.instance().findByName(EmployeeType.EMPLOYEE));
        projectEmp.setCompany(CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC));
        projectEmp.setSex(Sex.MALE);
        createCUser(projectEmp);
        em.persist(projectEmp);
    }

    protected Employee createEmailAndOtherDefaults(Employee emp, String emailA) {
        //Email
        Email email = new Email();
        email.setEmail(emailA);
        email.setPrimaryEmail(true);
        emp.addEmail(email);
        emp = EmployeeDao.instance().save(emp);
        emp = em.merge(emp);
        //Preferences
        Preferences prefs = new Preferences();
        prefs.setEnableEmailNotifications(Boolean.TRUE);
        emp.setPreferences(prefs);
        return emp;
    }

    public void sendNewEmployeeNotifiaction(Employee emp) {
        if (emp.getEmployeeType().getName().equals(EmployeeType.CORPORATE_EMPLOYEE) || emp.getEmployeeType().getName().equals(EmployeeType.EMPLOYEE) || emp.getEmployeeType().getName().equals(EmployeeType.W2_CONTRACTOR) || emp.getEmployeeType().getName().equals(EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            Employee currentEmp = OfficeSecurityService.instance().getCurrentUser();
            profileNotificationService.sendNewUserCreatedNotification(currentEmp, emp);
        }
    }

    public void createBPMUser(Employee employee, boolean startprocess) {
        OfficeBPMIdentityService.instance().createUser(employee.getEmployeeId());
        if (startprocess) {
            startNewCorporateEmployeeProcess(employee);
        }
    }

    protected void startNewCorporateEmployeeProcess(Employee employee) {
        Map<String, Object> obj = new HashMap<>();
        obj.put("employee", employee);
        OfficeBPMService.instance().startProcess("new_corp_employee_process", obj);
    }

    public Employee createCUser(Employee employee) {
        String empType = employee.getEmployeeType().getName();
        String username = generateEmployeeId(employee.getFirstName(), employee.getLastName(), employee.getDateOfBirth());
        if (empType.equals(EmployeeType.CORPORATE_EMPLOYEE) || empType.equals(EmployeeType.EMPLOYEE) || empType.equals(EmployeeType.W2_CONTRACTOR) || empType.equals(EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            //Create CUser
            CUser user = mapper.map(employee, CUser.class);
            user.setPasswordHash(generatepassword());
            //TODO fix dup user name ussue
            user.setUsername(username);
            user.setEnabled(true);
            if (empType.equals(EmployeeType.CORPORATE_EMPLOYEE)) {
                user.addRole(CRoleDao.instance().findRoleByName(OfficeRole.ROLE_CORPORATE_EMPLOYEE.name()));
            }
            user.addRole((CRole) EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRole.ROLE_USER.name()));
            user = OfficeSecurityService.instance().createCuser(user);
            employee.setUser(user);
        }
        employee.setEmployeeId(username);
        return employee;
    }

    public String generateEmployeeId(String firstName, String lastName, Date dateofBirth) {
        String empId = firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
        javax.persistence.Query findUserQuery = em.createQuery("from Employee where employeeId=:empIdParam");
        findUserQuery.setParameter("empIdParam", empId);
        if (findUserQuery.getResultList().size() > 0) {
            if (dateofBirth != null) {
                empId = empId + Integer.toString(dateofBirth.getDate());
            } else {
                Random random = new Random();
                empId = empId + Integer.toString(random.nextInt(100) + 1);
            }
        }
        if (empId.contains(" ")) {
            empId = empId.replace(" ", "_");
        }
        return empId;
    }

    public CUser changePassword(Long empId, User user) {
        CUser user1 = getEmployee(empId).getUser();
        String oldpswd = SecurityUtils.encodePassword(user.getOldPassword(), null);
        if (oldpswd.equals(user1.getPasswordHash())) {
            user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
            return em.merge(user1);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.password", "Old Password Doesn't Match");
        }

    }

    public CUser resetPassword(Long empId, User user) {
        CUser user1 = getEmployee(empId).getUser();
        user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
        profileNotificationService.sendResetPasswordNotification(getEmployee(empId), user.getNewPassword());
        return em.merge(user1);

    }

    public void deactivateUser(Long empId, EmployeeCreateDto dto) {
        Employee emp = getEmployee(empId);
        if(emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType.SUBCONTRACTOR) || emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType._1099_CONTRACTOR)){
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.deactivate", "Subcontractors and 1099 contractors can not be deactivated");
        }
        if (!emp.isActive()) {
            emp.setEndDate(dto.getEndDate());
            em.merge(emp);
            return;
        }
        if (dto.getEndDate() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.request", "End Date is required to deactivate the employee");
        }
        if (emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType.CORPORATE_EMPLOYEE)) {
            for (Employee employee : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE)) {
                for (CompanyContact contact : CompanyContactDao.instance().getEmployeeCompanyContacts(employee.getId())) {
                    if (contact.getContact().getEmployeeId().equals(emp.getEmployeeId())) {
                        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.deactivate", "This employee is listed as a company contact for other employees. Please verify and remove");
                    }
                }
            }
        }
        emp.setEndDate(dto.getEndDate());
        emp = em.merge(emp);
        CUser user1 = emp.getUser();
        user1.setEnabled(false);
        Employee curUser = OfficeSecurityService.instance().getCurrentUser();
        profileNotificationService.sendEmployeeDeactivationNotification(curUser.getFirstName(), getEmployee(empId));
        em.merge(user1);
        OfficeBPMIdentityService.instance().deleteUser(emp.getUser().getUsername());
    }

    public String generatepassword() {
        final int PASSWORD_LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < PASSWORD_LENGTH; x++) {
            sb.append((char) ((int) (Math.random() * 26) + 97));
        }
        return sb.toString();
    }

    private Employee getEmployee(Long empId) {
        Employee employee = em.find(Employee.class, empId);
        if (employee
                == null) {
            logger.warning("employee not found" + employee.getEmployeeId());
            return null;
        } else {
            return employee;
        }
    }
    
    public void internalCompanyTransfer(Employee emp, EmployeeCompanyTransferDto dto) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("employee", emp);
        obj.put("transferCompany", emp.getCompany().getName());
        obj.put("previousCompany", dto.getPreviousCompany().getName());
        obj.put("workStatus", emp.getWorkStatus());
        obj.put("transferDate", sdf.format(dto.getTransferDate()));
        OfficeBPMService.instance().startProcess("internal_company_transfer_process", obj);
    }
    
    public void departmentTransfer(Long id, EmployeeDeptTransferDto dto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(dto.getTransferDate());
        c.add(Calendar.DATE, 52);
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("employeeId", id);
        obj.put("probEvalProcessStartDate", sdf.format(c.getTime()));
        OfficeBPMService.instance().startProcess("department_transfer_probabtion_period_evaluation", obj);
    }

    public static EmployeeService
            instance() {
        return SpringContext.getBean(EmployeeService.class
        );
    }
}
