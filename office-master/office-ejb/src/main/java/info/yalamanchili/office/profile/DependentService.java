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
        dependent.setSalutation(dto.getSalutation());
        dependent.setDfirstName(dto.getDfirstName());
        dependent.setDmiddleName(dto.getDmiddleName());
        dependent.setDlastName(dto.getDlastName());
        dependent.setDdateOfBirth(dto.getDdateOfBirth());
        dependent.setRelationship(dto.getRelationship());
        dependent.setGender(dto.getGender());
        dependent.setEmail(dto.getEmail());
        dependent.setPhoneNumber(dto.getPhoneNumber());
        dependent.setTargetEntityId(empId);
        dependent.setTargetEntityName(emp.getClass().getCanonicalName());
        em.merge(dependent);
    }

    public void addDependent(Long targetId, String targetClassName, DependentDto dto) {
        
        //dependent
        Dependent dependent = new Dependent();
        dependent.setSalutation(dto.getSalutation());
        dependent.setDmiddleName(dto.getDmiddleName());
        dependent.setDfirstName(dto.getDfirstName());
        dependent.setDlastName(dto.getDlastName());
        dependent.setDdateOfBirth(dto.getDdateOfBirth());
        dependent.setRelationship(dto.getRelationship());
        dependent.setGender(dto.getGender());
        dependent.setEmail(dto.getEmail());
        dependent.setPhoneNumber(dto.getPhoneNumber());
        dependent.setTargetEntityId(targetId);
        dependent.setTargetEntityName(targetClassName);
        em.merge(dependent);
    }
    
    public Dependent update(DependentDto dependentDto) {
        //TODO user dozer mapping?
        Dependent ecEntity = em.find(Dependent.class, dependentDto.getId());
        ecEntity = (Dependent) BeanMapper.merge(dependentDto, ecEntity);
        //Contact
        ecEntity.setDfirstName(dependentDto.getDfirstName());
        ecEntity.setDlastName(dependentDto.getDlastName());
        ecEntity.setDdateOfBirth(dependentDto.getDdateOfBirth());
        ecEntity.setRelationship(dependentDto.getRelationship());
        em.merge(ecEntity);
        return ecEntity;
    }

    public Dependent read(Long id) {
         return dependentDao.findById(id);
    }
}