/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.chkreq;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.expense.chkreq.CheckRequisitionItemDao;
import info.yalamanchili.office.entity.expense.CheckRequisitionItem;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/check-requisition-item")
@Component
@Transactional
@Scope("request")
public class CheckRequisitionItemResource extends CRUDResource<CheckRequisitionItem> {

    @Autowired
    public CheckRequisitionItemDao checkRequisitionItemDao;

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        checkRequisitionItemDao.delete(id);
    }

    @Override
    public CRUDDao getDao() {
        return checkRequisitionItemDao;
    }

}
