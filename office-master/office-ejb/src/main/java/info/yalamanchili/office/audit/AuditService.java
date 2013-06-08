/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.audit;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.audit.LoginActivityDao;
import info.yalamanchili.office.dto.audit.LoginActivityDto;
import info.yalamanchili.office.dto.audit.LoginActivityDto.LoginActivityTable;
import java.util.ArrayList;
import java.util.List;
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
public class AuditService {
    
    @Autowired
    protected Mapper mapper;
    
    public LoginActivityTable getLoginActivity(int start, int limit) {
        List<LoginActivityDto> dtos = new ArrayList<LoginActivityDto>();
        LoginActivityTable tableObj = new LoginActivityTable();
        for (Object loginActivityObj : LoginActivityDao.instance().query(start, limit)) {
            LoginActivityDto dto = mapper.map(loginActivityObj, LoginActivityDto.class);
            dto.setLoginCount(LoginActivityDao.instance().getLoginCount(dto.getEmployeeId()));
            dtos.add(dto);
        }
        tableObj.setEntities(dtos);
        tableObj.setSize(LoginActivityDao.instance().size());
        return tableObj;
    }
    
    public static AuditService instance() {
        return SpringContext.getBean(AuditService.class);
    }
}
