/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.messages;

import info.chili.i18n.CDatabaseMessages;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeFeatureFlipper;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
public class MessagesUtils {
//TODO move to commons and make the default bundle name 

    protected String bundleName;

    protected MessageSource messageSource = null;
    protected CDatabaseMessages databaseMessages = null;

    @Autowired
    OfficeFeatureFlipper OfficeFeatureFlipper;

    public String get(String key) {
        String message = null;
        message = getDatabaseMessageSource().getMessage(key, null, Locale.getDefault());
        if (message == null) {
            try {
                message = getStaticMessageSource().getMessage(key, null, null);
            } catch (NoSuchMessageException e) {
                message = key;
            }
        }
        return message;
    }

    //Add resolver with Specified Locale
    protected String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    protected MessageSource getStaticMessageSource() {
        if (messageSource == null) {
            messageSource = (MessageSource) SpringContext.getBean(bundleName);
        }
        return messageSource;
    }

    protected CDatabaseMessages getDatabaseMessageSource() {
        if (databaseMessages == null) {
            databaseMessages = CDatabaseMessages.instance(bundleName);
        }
        return databaseMessages;
    }

    public static MessagesUtils instance(String bundleName) {
        MessagesUtils res = SpringContext.getBean(MessagesUtils.class);
        res.setBundleName(bundleName);
        return res;
    }

}
