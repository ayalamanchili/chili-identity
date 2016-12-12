/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.hr;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.hr.ClientInfoHandleEntityDao;
import info.yalamanchili.office.entity.profile.ClientInfoHandleEntity;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/cpd-info")
@Component
@Scope("prototype")
@Transactional
public class ClientInfoHandleEntityResource extends CRUDResource<ClientInfoHandleEntity> {

    @Autowired
    public ClientInfoHandleEntityDao cpdEntityDao;

    @Override
    public CRUDDao getDao() {
        return null;
    }
   
    @PUT
    @Path("/save")
    @Validate
    @Override
    public ClientInfoHandleEntity save(ClientInfoHandleEntity cpdEntity) {
        return cpdEntityDao.save(cpdEntity);
    }
}