/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.bis;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.entity.profile.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ayalamanchili
 */
@Component("bisService")
@Scope("request")
public class BISServiceBean {

    @Autowired
    protected RestTemplate restTemplate;

    public String getBisInformation(Long employeeId) {
        String bisEmployeeId = ExternalRefDao.instance().getExternalRefId("BIS", Employee.class, employeeId);
        String url = OfficeServiceConfiguration.instance().getBisEndpoint() + "/BISRESTFUL/api/Billing/GetCPDDetailsbyId/" + bisEmployeeId;
        ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
        return res.getBody();
    }

    public static BISServiceBean instance() {
        return (BISServiceBean) SpringContext.getBean("bisService");
    }

}
