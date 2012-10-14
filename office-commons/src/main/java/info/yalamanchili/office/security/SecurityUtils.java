/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import info.chili.spring.SpringContext;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 *
 * @author ayalamanchili
 */
public class SecurityUtils {

    /**
     * this is a method that takes unencrypted password and returns encrypted
     * one
     */
    public static String encodePassword(String password, String salt) {
        ShaPasswordEncoder encoder = (ShaPasswordEncoder) SpringContext.getBean("passwordEncoder");
        return encoder.encodePassword(password, null);
    }
}
