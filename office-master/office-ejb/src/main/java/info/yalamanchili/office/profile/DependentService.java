/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.BeanMapper;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dto.profile.DependentDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("request")
public class DependentService {
    @PersistenceContext
    protected EntityManager em;
    
    @Autowired
    protected Mapper mapper;
    
    @Autowired
    protected DependentDao dependentDao;

    //TODO try to consolidate add and update
    public void addDependent(Long empId, DependentDto dto) {
        Employee emp = (Employee) em.find(Employee.class, empId);
        //dependent
        Dependent dependent = new Dependent();
        dependent.setDfirstName(dto.getDfirstName());
        dependent.setDlastName(dto.getDlastName());
        dependent.setDdateOfBirth(dto.getDdateOfBirth());
        dependent.setRelationship(dto.getRelationship());
        dependent.setTargetEntityId(empId);
        dependent.setTargetEntityName(emp.getClass().getCanonicalName());
        em.merge(dependent);
    }

    public Dependent update(DependentDto ec) {
        //TODO user dozer mapping?
        Dependent ecEntity = em.find(Dependent.class, ec.getId());
        ecEntity = (Dependent) BeanMapper.merge(ec, ecEntity);
        //Contact
        ecEntity.setDfirstName(ec.getDfirstName());
        ecEntity.setDlastName(ec.getDlastName());
        ecEntity.setDdateOfBirth(ec.getDdateOfBirth());
        ecEntity.setRelationship(ec.getRelationship());
        em.merge(ecEntity);
        return ecEntity;
    }

    public Dependent read(Long id) {
         return dependentDao.findById(id);
    }
}