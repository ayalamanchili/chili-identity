/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dao.profile.EmployeeDocumentDao;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghu.l
 */
@Path("secured/employeedocument")
@Component
@Transactional
@Scope("request")
public class EmployeeDocumentResource extends CRUDResource<EmployeeDocument>{

    @Autowired
    public EmployeeDocumentDao employeeDocumentDao;

    @Override
    public CRUDDao getDao() {
        return employeeDocumentDao;
    }
    
}
