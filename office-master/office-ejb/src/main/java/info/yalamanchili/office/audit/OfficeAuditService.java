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

//    public LoginActivityTable getLoginActivity(int start, int limit) {
//        List<LoginActivityDto> dtos = new ArrayList<LoginActivityDto>();
//        LoginActivityTable tableObj = new LoginActivityTable();
//        for (Object loginActivityObj : LoginActivityDao.instance().query(start, limit)) {
//            LoginActivityDto dto = mapper.map(loginActivityObj, LoginActivityDto.class);
//            dto.setLoginCount(LoginActivityDao.instance().getLoginCount(dto.getEmployeeId()));
//            dtos.add(dto);
//        }
//        tableObj.setEntities(dtos);
//        tableObj.setSize(LoginActivityDao.instance().size());
//        return tableObj;
//    }

    public static OfficeAuditService instance() {
        return SpringContext.getBean(OfficeAuditService.class);
    }
}
