/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.ext;

import info.yalamanchili.office.dao.ext.NotifyEmployeeDao;
import info.yalamanchili.office.entity.ext.NotifyEmployee;
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
@Path("secured/notify-employee")
@Component
@Transactional
@Scope("request")
//TODO create abstractREsource for ext
public class NotifyEmployeeResource {

    @Autowired
    protected NotifyEmployeeDao notifyEmployeeDao;

    @PUT
    @Path("{targetClassName}/{id}")
    public void save(@PathParam("targetClassName") String targetClassName, @PathParam("id") Long id, NotifyEmployee entity) {
        notifyEmployeeDao.save(entity, id, targetClassName);
    }
}
