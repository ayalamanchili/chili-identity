/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OfficeAclService {

    @Autowired
    JdbcMutableAclService aclSercice;

    public JdbcMutableAclService getAclService() {
        return aclSercice;
    }

    public void insertBasicPermissions(Class entitycls, Long id) {
        ObjectIdentity oi = new ObjectIdentityImpl(entitycls, id);
        Sid sid = new PrincipalSid(SecurityUtils.getCurrentUser());
        Permission p = BasePermission.READ;
        MutableAcl acl = null;
        try {
            acl = (MutableAcl) aclSercice.readAclById(oi);
        } catch (NotFoundException nfe) {
            acl = aclSercice.createAcl(oi);
        }
        acl.setOwner(sid);
        acl.insertAce(acl.getEntries().size(), p, sid, true);
        aclSercice.updateAcl(acl);
    }

    public static OfficeAclService instance() {
        return SpringContext.getBean(OfficeAclService.class);
    }
}
