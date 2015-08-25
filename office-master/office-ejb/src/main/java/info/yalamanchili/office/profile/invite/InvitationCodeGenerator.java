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
import info.yalamanchili.office.dao.invite.InvitationTypeDao;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashMap;
import java.util.Map;
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
public class InvitationCodeGenerator {

    @Autowired
    protected InviteCodeDao inviteCodeDao;

    @Autowired
    protected MailUtils mailUtils;

    public void invite(InviteCode entity) {
        Map<String, Object> vars = new HashMap<>();
        entity.setInvitationCode(uuidGen());
        InvitationType type = InvitationTypeDao.instance().find(entity.getInvitationType().getTypeOfInvitation());
        entity.setInvitationType(type);
        vars.put("entity", entity);
        inviteCodeDao.save(entity);
        sendInvitationRequestEmail(entity);
    }

    public void sendInvitationRequestEmail(InviteCode entity) {
        Email email = new Email();
        email.addTo(entity.getEmail());
        StringBuilder subject = new StringBuilder();
        subject.append("System Soft Invitation");
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<>();
//        emailCtx.put("employeeName", address.getContact().getFirstName() + " " + address.getContact().getLastName());
        email.setTemplateName(entity.getInvitationType().getEmailTemplateName());
//        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        MessagingService.instance().sendEmail(email);
    }

    private String uuidGen() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static InvitationCodeGenerator instance() {
        return SpringContext.getBean(InvitationCodeGenerator.class);
    }

}
