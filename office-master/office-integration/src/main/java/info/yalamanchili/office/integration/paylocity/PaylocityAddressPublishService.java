/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.paylocity;

import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.integration.address.AddressPublishService;
import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ayalamanchili
 */
@Component
public class PaylocityAddressPublishService implements AddressPublishService {

    @Autowired
    protected PaylocityConfigurtion paylocityConfigurtion;

    @Autowired
    protected RestTemplate restTemplate;

    protected String token;

    @Override
    public void process(Address address) {
        if (paylocityConfigurtion.getEnabled()) {
            Employee employee = ((Employee) address.getContact());
            //TODO if company is null should we create a admin task to fix?
            String paylocityCompanyId = ExternalRefDao.instance().getExternalRefId(PaylocityConfigurtion.PAYLOCITY, Company.class, employee.getCompany().getId());
            String paylocityEmployeeId = ExternalRefDao.instance().getExternalRefId(PaylocityConfigurtion.PAYLOCITY, Employee.class, employee.getId());
            MultiValueMap<String, String> headers = new LinkedMultiValueMap();
            headers.add("Authorization", "Bearer " + token);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(paylocityConfigurtion.getPaylocityApiEnpoint() + "company/" + paylocityCompanyId + "/employee/" + paylocityEmployeeId, HttpMethod.GET, entity, String.class);
            response.getBody();
        }

    }

    protected void refreshToken() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap();
        String auth = paylocityConfigurtion.getPaylocityClientId() + ":" + paylocityConfigurtion.getPaylocityClientSecret();
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.add("Authorization", authHeader);
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        String body = "scope=WebLinkAPI&grant_type=client_credentials";
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(paylocityConfigurtion.getPaylocityTokenEndpoint(), HttpMethod.POST, entity, String.class);
    }

}
