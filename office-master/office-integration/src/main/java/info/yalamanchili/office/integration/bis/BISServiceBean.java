/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.bis;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.entity.profile.Employee;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component("bisService")
@Scope("request")
public class BISServiceBean {

    public String getBisInformation(Long employeeId) {
        String bisEmployeeId = ExternalRefDao.instance().getExternalRefId("BIS", Employee.class, employeeId.toString());

        //call bis service with bis id to get the response json.
        //convert the json data to html and return.
        return null;
    }

    public static BISServiceBean instance() {
        return (BISServiceBean) SpringContext.getBean("bisService");
    }

}
