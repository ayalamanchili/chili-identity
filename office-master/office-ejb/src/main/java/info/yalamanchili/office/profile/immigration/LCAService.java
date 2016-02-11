/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.entity.immigration.LCA;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("request")
public class LCAService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected LCADao lcaDao;
    @Autowired
    protected EmployeeDao employeeDao;

    public LCA saveLCA(LCA dto) {
        LCA lca = mapper.map(dto, LCA.class);
        lcaDao.save(lca);
        return lca;
    }

}
