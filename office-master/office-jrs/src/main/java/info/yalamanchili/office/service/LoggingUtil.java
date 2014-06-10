/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.service;

import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.jms.MessagingService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ayalamanchili
 */
//TODO move to commons
public class LoggingUtil {

    private static final Log log = LogFactory.getLog(LoggingUtil.class);

    public static void logExceptionDetials(Throwable e) {
        if (log.isErrorEnabled()) {
            e.printStackTrace();
            log.error(e);
        }
        if (!OfficeServiceConfiguration.instance().isEmailExceptionDetials()) {
            return;
        }
        Email email = new Email();
        email.setTos(OfficeServiceConfiguration.instance().getErrorLogsEmailsAsSet());
        StringBuilder subject = new StringBuilder();
        subject.append("Portal Error Details: Host: ");
        try {
            subject.append(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException ex) {
            subject.append("UNKNOWN");
        }
        email.setSubject(subject.toString());
        email.setBody(ExceptionUtils.getStackTrace(e));
        MessagingService.instance().sendEmail(email);
    }
}
