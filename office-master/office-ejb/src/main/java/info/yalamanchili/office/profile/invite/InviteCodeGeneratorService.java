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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.drive.FileDao;
import info.yalamanchili.office.dao.invite.InviteTypeDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dto.onboarding.InitiateOnBoardingDto;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.entity.profile.invite.InviteType;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Date;
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
public class InviteCodeGeneratorService {

    @Autowired
    protected InviteCodeDao inviteCodeDao;
    @Autowired
    FileDao fileDao;

    @Autowired
    protected MailUtils mailUtils;

    public InviteCode generate(InvitationType type, String email, Date vaidDate, Date expiryDate, boolean sendEmail, InitiateOnBoardingDto dto) {
        InviteCode code = new InviteCode();
        code.setInviteType(InviteTypeDao.instance().find(type));
        code.setValidFromDate(vaidDate);
        code.setExpiryDate(expiryDate);
        code.setEmail(email);
        return generate(code, sendEmail, dto);
    }

    public InviteCode generate(InvitationType type, String email, Date vaidDate, Date expiryDate, boolean sendEmail, ImmigrationCase immigrationCase) {
        InviteCode code = new InviteCode();
        if (InviteTypeDao.instance().find(type) == null) {
            InviteType inviteType = new InviteType();
            inviteType.setInvitationType(type);
            inviteType.setDescription(type.name());
            InviteTypeDao.instance().save(inviteType);
            code.setInviteType(inviteType);
        } else {
            code.setInviteType(InviteTypeDao.instance().find(type));
        }
        code.setValidFromDate(vaidDate);
        code.setExpiryDate(expiryDate);
        code.setEmail(email);
        return generate(code, sendEmail, immigrationCase);
    }

    public InviteCode generate(InviteCode entity, boolean sendEmail, InitiateOnBoardingDto dto) {
        entity.setInvitationCode(uuidGen());
        inviteCodeDao.save(entity);
        if (sendEmail) {
            sendInviteCodeEmail(entity, dto);
        }
        return entity;
    }

    public InviteCode generate(InviteCode entity, boolean sendEmail, ImmigrationCase immigrationCase) {
        entity.setInvitationCode(uuidGen());
        inviteCodeDao.save(entity);
        return entity;
    }
    protected final String[] ON_BOARDING_FORMS_LIST = {"W4_On_Boarding", "I9_On_Boarding", "I9_New_Version_Example"};

//TODO remove specific code for employee on boarding
    public void sendInviteCodeEmail(InviteCode entity, InitiateOnBoardingDto dto) {
        Email email = new Email();
        email.addTo(entity.getEmail());
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_ON_BOARDING_MGR.name()));
        StringBuilder subject = new StringBuilder();
        Company cmp = CompanyDao.instance().findById(dto.getCompany().getId());
        subject.append(cmp.getName() + " Joining Forms - " + dto.getFirstName() + " " + dto.getLastName());
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<>();
        emailCtx.put("invitationCode", OfficeServiceConfiguration.instance().getPortalWebUrl() + "?inviteCode=" + entity.getInvitationCode());
        emailCtx.put("employeeName", dto.getFirstName() + " " + dto.getLastName());
        emailCtx.put("companyName", cmp.getName());
        email.setTemplateName("send_onboarding_invitation_eamil_template.html");
        String messageText = OfficeServiceConfiguration.instance().getPortalWebUrl() + "?inviteCode=" + entity.getInvitationCode();
        email.setContext(emailCtx);
        email.setBody(messageText);
        for (String fileName : ON_BOARDING_FORMS_LIST) {
            if (fileDao.getFilePath(fileName) != null) {
                email.getAttachments().add(fileDao.getFilePath(fileName));
            }
        }
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
