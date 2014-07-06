/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.messages;

import java.util.Locale;
import javax.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
public class MessagesUtils {

    @Resource(name = "officeMessages")
    private MessageSource messageSource;

    public String get(String key) {
        String message;
        try {
            message = messageSource.getMessage(key, null, null);
        } catch (NoSuchMessageException e) {
            message = key;
        }
        return message;
    }
}
