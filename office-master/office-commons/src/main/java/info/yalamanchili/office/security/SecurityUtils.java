/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import info.chili.commons.EntityQueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.security.acl.AclClass;
import info.yalamanchili.office.entity.security.acl.AclSid;
import javax.persistence.EntityManager;
import org.jasypt.digest.StandardStringDigester;
import org.jasypt.hibernate.encryptor.HibernatePBEStringEncryptor;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;

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

    /*
     * used for hasing encrypted string properties used for querying data
     */
    public static String hash(String string) {
        StandardStringDigester officeStringDigester = (StandardStringDigester) SpringContext.getBean("officeStringDigester");
        return officeStringDigester.digest(string);
    }

    public static String encrypt(String string) {
        HibernatePBEStringEncryptor encryptor = (HibernatePBEStringEncryptor) SpringContext.getBean("hibernateStringEncryptor");
        return encryptor.encrypt(string);
    }

    public static String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static AclClass getAclClassFor(EntityManager em, Class cls) {
        //TODO cache this
        return EntityQueryUtils.findEntity(em, AclClass.class, "clazz", cls.getCanonicalName());
    }

    public static AclSid getCurrentAclSid(EntityManager em) {
        return EntityQueryUtils.findEntity(em, AclSid.class, "sid", getCurrentUser());
    }
}
