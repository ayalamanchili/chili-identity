/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.bis;

import info.chili.service.jrs.exception.ServiceException;
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
@Component("bisClientInformationService")
@Scope("request")
public class BISClientInformationServiceBean {

    @Autowired
    protected RestTemplate restTemplate;
    protected final String BIS_CONTEXT_ROOT = "/BISRESTFUL/api/Billing";

    public String getClientInformation(Long employeeId) {
        String bisEmployeeId = ExternalRefDao.instance().getExternalRefId("BIS", Employee.class, employeeId);
        if (bisEmployeeId == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "NO.EXTERNAL.REF.PRESENT", "cannot fetch bis information for this employee");
            //TODO create a manual task or admin email
        }
        //TODO externalize the values
        String url = OfficeServiceConfiguration.instance().getBisEndpoint() + BIS_CONTEXT_ROOT + "/GetCPDDetailsbyId/" + bisEmployeeId;
        ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
        return res.getBody();
    }

    public static BISClientInformationServiceBean instance() {
        return (BISClientInformationServiceBean) SpringContext.getBean("bisClientInformationService");
    }

}
