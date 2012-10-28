/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import info.chili.commons.EntityQueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.security.acl.AclClass;
import info.yalamanchili.office.entity.security.acl.AclSid;
import javax.persistence.EntityManager;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
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
