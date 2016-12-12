/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.audit;

import info.chili.spring.SpringContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
//TODO move the common stuff to chili-commons
public class OfficeAuditService {

    @Autowired
    protected Mapper mapper;


    public static OfficeAuditService instance() {
        return SpringContext.getBean(OfficeAuditService.class);
    }
}
