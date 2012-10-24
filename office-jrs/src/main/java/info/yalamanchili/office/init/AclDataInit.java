/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.init;

import info.chili.commons.EntityQueryUtils;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.entity.security.acl.AclClass;
import info.yalamanchili.office.entity.security.acl.AclSid;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ayalamanchili
 */
public class AclDataInit {

    public static void initAclSids(EntityManager em) {
        TypedQuery<CUser> getUsersQuery = em.createQuery("from CUser", CUser.class);
        for (CUser user : getUsersQuery.getResultList()) {
            AclSid aclSid = EntityQueryUtils.findEntity(em, AclSid.class, "sid", user.getUsername());
            if (aclSid == null) {
                AclSid newAclSid = new AclSid();
                newAclSid.setSid(user.getUsername());
                //TODO this is this?
                newAclSid.setPrincipal(true);
                em.persist(newAclSid);
            }
        }
    }

    public static void initAclClassData(EntityManager em) {
        for (Class cls : aclClassMap) {
            AclClass aclClass = EntityQueryUtils.findEntity(em, AclClass.class, "clazz", cls.getCanonicalName());
            if (aclClass == null) {
                AclClass newAclClass = new AclClass();
                newAclClass.setClazz(cls.getCanonicalName());
                em.persist(newAclClass);
            }
        }
    }
    protected static List<Class> aclClassMap = new ArrayList<Class>();

    static {
        aclClassMap.add(SkillSet.class);
        aclClassMap.add(EmployeeType.class);
    }
}
