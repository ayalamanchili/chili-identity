/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.jms.adapter.CMessage;
import info.chili.jms.adapter.CMessagingService;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
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

    public void sendOnBoardingEmployeeRequestSubmittedEmail(Employee emp) {
    }

    public void sendOnBoardingEmployeeRequestCompletedEmail(Employee employee, Address address) {
    }

}
