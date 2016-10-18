/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.onboarding;

import info.chili.email.Email;
import info.chili.security.domain.CUser;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.dao.drive.FileDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("prototype")
@Transactional
public class OnBoardingEmployeeProcessBean {

    @Autowired
    protected MailUtils mailUtils;
    @Autowired
    FileDao fileDao;

    protected final String[] EMPLOYEE_ORIENTATION_FORMS_LIST_SSTECH = {"CorporatePoliciesHandbook", "FamilyAndMedicalLeave", "HolidaySchedule", "SSTOrientationCorporateEmployee", "WorkFromHomePolicy"};
    protected final String[] EMPLOYEE_ORIENTATION_FORMS_LIST_CGS = {"CorporatePoliciesHandbook", "FamilyAndMedicalLeave", "HolidaySchedule", "CGSOrientationCorporateEmployee", "WorkFromHomePolicy"};
    protected final String[] EMPLOYEE_ORIENTATION_FORMS_LIST_TECHPILLARS = {"CorporatePoliciesHandbook", "FamilyAndMedicalLeave", "HolidaySchedule", "TechpillarsOrientationCorporateEmployee", "WorkFromHomePolicy"};

    public void sendEmployeeOnBoardingProcessStartEmail(Employee emp) {
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.addTo(emp.getPrimaryEmail().getEmail());
        email.setSubject("Welcome to System Soft Portal");
        String messageTextforuser = "Hai " + "<b>" + emp.getFirstName() + "</b>" + " " + "<b>" + emp.getLastName() + "</b>" + " \n";
        messageTextforuser = messageTextforuser.concat(" <br> Thank you for completing the onboarding form. </br> \n <br> Our <b> Onboarding Manager </b> will get in touch with you once the process is completed or for any additional information. </br> \n <br> Please login to portal and update it in profile tab</br> \n <br> Instruction: https://apps.sstech.us/site/office/profile/profile.html </br>");
        email.setBody(messageTextforuser);
        MessagingService.instance().sendEmail(email);
    }

    public void sendEmployeeOnBoardingProcessCompleteEmail(Employee emp) {
        Email email = new Email();
        String strSubject = "";
        String[] EMPLOYEE_ORIENTATION_FORMS_LIST = null;
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        if (emp.getCompany().getName().equalsIgnoreCase(Company.CGS_INC)) {
            EMPLOYEE_ORIENTATION_FORMS_LIST = EMPLOYEE_ORIENTATION_FORMS_LIST_CGS;
            strSubject = "CGS INC New Employee Orientation";
        } else if (emp.getCompany().getName().equalsIgnoreCase(Company.TECHPILLARS)) {
            EMPLOYEE_ORIENTATION_FORMS_LIST = EMPLOYEE_ORIENTATION_FORMS_LIST_TECHPILLARS;
            strSubject = "TechPillars New Employee Orientation";
        } else {
            EMPLOYEE_ORIENTATION_FORMS_LIST = EMPLOYEE_ORIENTATION_FORMS_LIST_SSTECH;
            strSubject = "SSTech New Employee Orientation";
        }

        email.addTo(emp.getPrimaryEmail().getEmail());
        email.setSubject(strSubject);
        String messageText = "Hi " + "<b>" + emp.getFirstName() + "</b>" + " " + "<b>" + emp.getLastName() + "</b>" + " \n \n";
        messageText = messageText.concat("<br>Thank you for completing your Orientation. If you have any questions and need help with anything at all, please reach out to HR and we are glad to help for any clarifications."
                + "</br> \n <br> Have an awesome first week! You will receive your paylocity credentials to log in your hours by the end of this week.</br>"
                + "\n <br>Remember we will need a screen shot or something of your approved timesheet from client sent to tms@sstech.us weekly.</br> \n <br>You are all good to go. Let me know if you have any questions!</br>");
        //String messageTxt = messageText.replaceAll("[^a-zA-Z0-9\\.;:_ ,]+", " ");
        email.setBody(messageText);
        for (String fileName : EMPLOYEE_ORIENTATION_FORMS_LIST) {
            if (fileDao.getFilePath(fileName) != null) {
                email.getAttachments().add(fileDao.getFilePath(fileName));
            }
        }
        MessagingService.instance().sendEmail(email);

    }

    public void deleteEmployee(Employee emp) {
        Employee employee = EmployeeDao.instance().getEntityManager().find(Employee.class, emp.getId());
        employee.setEndDate(new Date());
        employee = EmployeeDao.instance().getEntityManager().merge(employee);
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findByEmployeeId(employee.getId());
        empOnBoarding.setStatus(OnBoardingStatus.Rejected);
        CUser user1 = employee.getUser();
        user1.setEnabled(false);
        employee.setUser(user1);
        EmployeeDao.instance().getEntityManager().merge(user1);
        //OfficeBPMTaskService.instance().deleteAllTasksForProcessId(empOnBoarding.getBpmProcessId(), false);
        //TODO this should be only done in case of a corporate employee since for others bpm user is not created.
        OfficeBPMIdentityService.instance().deleteUser(employee.getUser().getUsername());
    }

    public void notifyBackgroundCheckTeam(EmployeeOnBoarding onboarding) {
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        String[] empDetails = onboarding.getEmpName().split("-");
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_BACKGROUND_SCREENING_MGR.name()));
        email.setSubject("New Employee Onboarding initiated please start Background Screening for " + empDetails[0]);
        String messageText = "New Hire Onboarding process started. Please initiate background check for the employee";
        messageText = messageText.concat("<table border='1'>");
        messageText = messageText.concat("<tr><td><b>Employee </b></td> <td>" + empDetails[0] + "</td></tr>");
        messageText = messageText.concat("<tr><td><b>Employee Type </b></td> <td>" + empDetails[1] + "</td></tr>");
        messageText = messageText.concat("<tr><td><b>Job Title <b></td> <td>" + empDetails[2] + "</td></tr>");
        messageText = messageText.concat("<tr><td><b>Email </b> </td> <td>" + onboarding.getEmail() + "</td></tr>");
        messageText = messageText.concat("<tr><td><b>Start Date </b> </td> <td>" + onboarding.getStartedDate() + "</td></tr>");
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }
}
