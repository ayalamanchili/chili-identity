/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.invite;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("prototype")
@Transactional
public class InviteCodeValidationService {

    public String inviteCodeValidator(InviteCode code) {
        InviteCode inviteCode = InviteCodeDao.instance().find(code.getInvitationCode());
        Date todayDate = new Date();
        if ((todayDate.compareTo(inviteCode.getValidFromDate()) >= 0)
                && (todayDate.compareTo(inviteCode.getExpiryDate()) <= 0)) {
            return code.getInvitationCode();
        }
        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.invitationcode", "Invalid Invitation Code");
    }

    public static InviteCodeValidationService instance() {
        return SpringContext.getBean(InviteCodeValidationService.class);
    }
}
