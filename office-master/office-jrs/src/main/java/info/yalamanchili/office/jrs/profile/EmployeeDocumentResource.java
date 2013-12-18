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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author raghu.l
 */
public class EmployeeDocumentResource extends CRUDResource<EmployeeDocument>{

    @Autowired
    public EmployeeDocumentDao employeeDocumentDao;

    @Override
    public CRUDDao getDao() {
        return employeeDocumentDao;
    }
    
}
