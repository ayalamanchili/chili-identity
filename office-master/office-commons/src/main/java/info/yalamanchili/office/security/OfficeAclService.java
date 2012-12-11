/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import info.chili.spring.SpringContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class OfficeAclService {

    @Autowired
    JdbcMutableAclService aclSercice;

    public JdbcMutableAclService getAclService() {
        return aclSercice;
    }

    public void insertBasicPermissions(String className, Long id, List<String> permissions) {
        Class entityCls;
        try {
            entityCls = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            //TODO throw service exception with code 400 (invalid request)
            throw new RuntimeException(ex);
        }
        ObjectIdentity oi = new ObjectIdentityImpl(entityCls, id);
        Sid sid = new PrincipalSid(SecurityUtils.getCurrentUser());
        MutableAcl acl = null;
        try {
            acl = (MutableAcl) aclSercice.readAclById(oi);
        } catch (NotFoundException nfe) {
            acl = aclSercice.createAcl(oi);
        }
        acl.setOwner(sid);
        for (String permString : permissions) {
            Permission p = null;
            if (permString.trim().equalsIgnoreCase("READ")) {
                p = BasePermission.READ;
            }
            if (permString.trim().equalsIgnoreCase("WRITE")) {
                p = BasePermission.WRITE;
            }
            if (permString.trim().equalsIgnoreCase("CREATE")) {
                p = BasePermission.CREATE;
            }
            if (permString.trim().equalsIgnoreCase("DELETE")) {
                p = BasePermission.DELETE;
            }
            if (p != null) {
                acl.insertAce(acl.getEntries().size(), p, sid, true);
                aclSercice.updateAcl(acl);
            }
        }

    }

    public static OfficeAclService instance() {
        return SpringContext.getBean(OfficeAclService.class);
    }
}
