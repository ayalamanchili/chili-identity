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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;

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

    protected String token = "";

    @Override
    public void process(Address address) {
        if (paylocityConfigurtion.getEnabled()) {
            Employee employee = ((Employee) address.getContact());
            //TODO if company is null should we create a admin task to fix?
            String paylocityCompanyId = ExternalRefDao.instance().getExternalRefId(PaylocityConfigurtion.PAYLOCITY, Company.class, employee.getCompany().getId());
            String paylocityEmployeeId = ExternalRefDao.instance().getExternalRefId(PaylocityConfigurtion.PAYLOCITY, Employee.class, employee.getId());
            //headers
            MultiValueMap<String, String> headers = new LinkedMultiValueMap();
            headers.add("Authorization", "Bearer " + token);
            //body
            JsonObject updateEmployee = new JsonObject();
            updateEmployee.addProperty("companyId", paylocityCompanyId);
            updateEmployee.addProperty("employeeId", paylocityEmployeeId);
            updateEmployee.addProperty("address1", address.getStreet1());
            updateEmployee.addProperty("address1", address.getStreet2());
            updateEmployee.addProperty("city", address.getCity());
            updateEmployee.addProperty("state", address.getState());
            updateEmployee.addProperty("zip", address.getZip());
            updateEmployee.addProperty("country", address.getCountry());
            HttpEntity<JsonObject> entity = new HttpEntity<>(updateEmployee, headers);
            ResponseEntity<String> response = restTemplate.exchange(paylocityConfigurtion.getPaylocityApiEnpoint() + "company/" + paylocityCompanyId + "/employee/" + paylocityEmployeeId, HttpMethod.POST, entity, String.class);
            if (null != response.getStatusCode()) {
                switch (response.getStatusCode()) {
                    case UNAUTHORIZED:
                        refreshToken();
                        break;
                    case OK:
                        Gson gson = new Gson();
                        JsonObject updateEmployeeResp = gson.fromJson(response.getBody(), JsonObject.class);
                        break;
                    default:
                        break;
                }
            }
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
        if (null != response.getStatusCode()) {
            switch (response.getStatusCode()) {
                case OK:
                    Gson gson = new Gson();
                    JsonObject tokenObj = gson.fromJson(response.getBody(), JsonObject.class);
                    token = tokenObj.get("token").getAsString();
                    break;
                default:
                    break;
            }
        }
    }

}
