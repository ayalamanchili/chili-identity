/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time.notification;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dto.profile.Employee;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
@Scope("prototype")
public class TimeNotificationService {

    @Autowired
    protected MailUtils mailUtils;
    @Autowired
    protected MessagingService messagingService;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    public EntityManager em;

    public void sendAdjustmenthoursNotification(Employee emp) {
        Email email = new Email();
        Map<String, String> tos = new HashMap<String, String>();
//        tos.add(info.yalamanchili.office.config.OfficeServiceConfiguration.instance().getAdminEmail());
//        email.setTos(tos);
        email.setSubject("Employee adjustment hours from ");
        email.setBody(emp.getUsername());
        messagingService.sendEmail(email);
    }

    public static TimeNotificationService instance() {
        return SpringContext.getBean(TimeNotificationService.class);
    }
}
