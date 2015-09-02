/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.invite;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.email.MailUtils;
import info.chili.email.Email;
import info.yalamanchili.office.dao.invite.InviteTypeDao;
import info.yalamanchili.office.entity.profile.invite.InviteType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.jms.MessagingService;
import org.springframework.stereotype.Component;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("prototype")
@Transactional
public class InviteCodeGeneratorService {

    @Autowired
    protected InviteCodeDao inviteCodeDao;

    @Autowired
    protected MailUtils mailUtils;

    public void inviteCodeGeneration(InviteCode entity) {
        entity.setInvitationCode(uuidGen());
        InviteType type = InviteTypeDao.instance().find(entity.getInviteType().getInvitationType());
        entity.setInviteType(type);
        inviteCodeDao.save(entity);
        //send email
        sendInvitationRequestEmail(entity);
    }

    public void sendInvitationRequestEmail(InviteCode entity) {
        Email email = new Email();
        email.addTo(entity.getEmail());
        email.setSubject("System Soft Invitation");
        String messageText = "http://localhost:9090/office-web/?inviteCode=" + entity.getInvitationCode();
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

    private String uuidGen() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static InviteCodeGeneratorService instance() {
        return SpringContext.getBean(InviteCodeGeneratorService.class);
    }

}
