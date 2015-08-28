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
import info.yalamanchili.office.entity.profile.invite.InviteCode;
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
    
     public void inviteCodeValidator(String code) {
         InviteCode inviteCode = InviteCodeDao.instance().find(code);
         System.out.println(inviteCode.toString());

    }
    
    public static InviteCodeValidationService instance() {
        return SpringContext.getBean(InviteCodeValidationService.class);
    }
}
