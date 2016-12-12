/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.BillingRateDao;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/billing-rate")
@Component
@Scope("request")
@Transactional
public class BillingRateResource extends CRUDResource<BillingRate> {

    @Autowired
    public BillingRateDao billingRateDao;
    @PersistenceContext
    protected EntityManager em;

    @Override
    public CRUDDao getDao() {
        return billingRateDao;
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONTRACTS_ADMIN')")
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }
}
