/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.social.notification;

import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.chili.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.entity.social.PostFile;
import info.yalamanchili.office.jms.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bapuji
 */
@Component
@Scope("request")
public class SocialNotificationService {

    @Autowired
    protected MessagingService messagingService;
    @Autowired
    protected MailUtils mailUtils;

    @Async
    public void sendNewCompanyPostNotification(Post post) {
        String[] roles = {OfficeRole.ROLE_USER.name(), OfficeRole.ROLE_HR.name(), OfficeRole.ROLE_ADMIN.name()};
        Email email = new Email();
        email.setHtml(true);
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject("New Post in company feed");
        email.setBody(post.getPostContent());
        if (post.getPostFiles().size() > 0) {
            for (PostFile file : post.getPostFiles()) {
                String path = file.getFileURL().replace("entityId", file.getId().toString());
                email.addAttachment(path);
            }
        }
        messagingService.sendEmail(email);

    }
}
