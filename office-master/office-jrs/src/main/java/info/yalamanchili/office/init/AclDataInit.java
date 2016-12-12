/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.init;

import info.chili.commons.EntityQueryUtils;
import info.chili.security.domain.CUser;
import info.chili.security.domain.acl.AclClass;
import info.chili.security.domain.acl.AclSid;
import info.yalamanchili.office.entity.profile.SkillSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.EntityType;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class AclDataInit {

    @PersistenceContext
    protected EntityManager em;

    @ManagedOperation
    public void initAclRefData() {
        initAclClassData();
        initAclSids();
    }

    @ManagedOperation
    public void initAclSids() {
        TypedQuery<CUser> getUsersQuery = em.createQuery("from CUser", CUser.class);
        for (CUser user : getUsersQuery.getResultList()) {
            AclSid aclSid = EntityQueryUtils.findEntity(em, AclSid.class, "sid", user.getUsername());
            if (aclSid == null) {
                AclSid newAclSid = new AclSid();
                newAclSid.setSid(user.getUsername());
                newAclSid.setPrincipal(true);
                em.persist(newAclSid);
            }
        }
    }

    @ManagedOperation
    public void initAclClassData() {
        Set<String> entityClassNames = new HashSet<String>();
        for (EntityType<?> entity : em.getMetamodel().getEntities()) {
            entityClassNames.add(entity.getName());
        }
        entityClassNames.addAll(aclClassMap);
        for (String entityClassName : entityClassNames) {
            AclClass aclClass = EntityQueryUtils.findEntity(em, AclClass.class, "clazz", entityClassName);
            if (aclClass == null) {
                AclClass newAclClass = new AclClass();
                newAclClass.setClazz(entityClassName);
                em.persist(newAclClass);
            }
        }
    }
    protected static Set<String> aclClassMap = new HashSet<String>();

    static {
        //add more class for acl_class that are not inherited from AbstractEntity
        aclClassMap.add(SkillSet.class.getCanonicalName());
    }
}
