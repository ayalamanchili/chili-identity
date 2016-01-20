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
import info.yalamanchili.office.dao.hr.ResumeDao;
import info.yalamanchili.office.entity.hr.Resume;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/resume")
@Component
@Transactional
@Scope("request")
public class ResumeResource extends CRUDResource<Resume> {

    @Autowired
    public ResumeDao resumeDao;

    @Override
    public CRUDDao getDao() {
        return resumeDao;
    }
    
}
