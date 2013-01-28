/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.security;

import info.chili.commons.EntityQueryUtils;
import info.yalamanchili.office.entity.security.acl.AclSid;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class ACLDao {

    @PersistenceContext
    protected EntityManager em;

    public void createSid(String sid) {
        AclSid aclSid = EntityQueryUtils.findEntity(em, AclSid.class, "sid", sid);
        if (aclSid == null) {
            AclSid newAclSid = new AclSid();
            newAclSid.setSid(sid);
            newAclSid.setPrincipal(true);
            em.persist(newAclSid);
        }
    }
}
