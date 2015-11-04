/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.deactivate;

import info.chili.email.Email;
import info.chili.security.domain.CUser;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("prototype")
@Transactional
public class EmployeeDeactivationProcessBean {

    @Autowired
    protected MailUtils mailUtils;
    @PersistenceContext
    protected EntityManager em;

    public void sendDeactivationCompletedEmail(Employee entity) {
        OfficeBPMIdentityService.instance().deleteUser(entity.getEmployeeId());
        CUser user1 = entity.getUser();
        user1.setEnabled(false);
        em.merge(user1);
        Employee curUser = OfficeSecurityService.instance().getCurrentUser();
        String[] roles = {OfficeRoles.OfficeRole.ROLE_ADMIN.name(), OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name(), OfficeRoles.OfficeRole.ROLE_CONSULTANT_TIME_ADMIN.name()};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject("Employee Deactivated ");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String messageText = "Employee  " + entity.getFirstName() + "," + entity.getLastName() + " Account Is Deactivated by:" + curUser.getFirstName() + " " + curUser.getLastName() + "\n End Date: " + sdf.format(entity.getEndDate());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
        
    }
}
