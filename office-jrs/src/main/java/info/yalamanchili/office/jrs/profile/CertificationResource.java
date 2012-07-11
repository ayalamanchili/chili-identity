/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dao.profile.CertificationDao;
import info.yalamanchili.office.entity.profile.Certification;


import javax.ws.rs.Consumes;
import info.yalamanchili.office.dao.CRUDDao;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanthi
 */
public class CertificationResource extends CRUDResource<Certification> {
     @Autowired
    public CertificationDao certificationDao;

    @Override
    public CRUDDao getDao() {
        return certificationDao;
    }
}
