/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.paylocity;

import com.google.common.base.Strings;
import info.yalamanchili.office.config.PaylocityConfigurtion;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author ayalamanchili
 */
@Service
@Transactional
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
            //TODO if ext emp id is null should we create a admin task to fix?
            String paylocityCompanyId = ExternalRefDao.instance().getExternalRefId(PaylocityConfigurtion.PAYLOCITY, Company.class, employee.getCompany().getId());
            String paylocityEmployeeId = ExternalRefDao.instance().getExternalRefId(PaylocityConfigurtion.PAYLOCITY, Employee.class, employee.getId());
            refreshToken();
            //headers
            MultiValueMap<String, String> headers = new LinkedMultiValueMap();
            headers.add("Authorization", "Bearer " + token);
            headers.add("Content-Type", "application/json");
            //body
            JsonObject updateEmployee = new JsonObject();
            updateEmployee.addProperty("companyNumber", paylocityCompanyId);
            updateEmployee.addProperty("employeeId", paylocityEmployeeId);
            updateEmployee.addProperty("address1", address.getStreet1());
            if (!Strings.isNullOrEmpty(address.getStreet2())) {
                updateEmployee.addProperty("address2", address.getStreet2());
            }
            updateEmployee.addProperty("city", address.getCity());
            updateEmployee.addProperty("state", address.getState());
            updateEmployee.addProperty("zip", address.getZip());
            updateEmployee.addProperty("country", address.getCountry());

            JsonObject requestBody = new JsonObject();
            requestBody.add("updateEmployee", updateEmployee);
            HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
            ResponseEntity<String> response = null;
            try {
                response = restTemplate.exchange(paylocityConfigurtion.getPaylocityApiEnpoint() + "update-employee", HttpMethod.POST, entity, String.class);
            } catch (HttpClientErrorException ex) {
                switch (ex.getStatusCode()) {
                    case BAD_REQUEST:
                        System.out.println("dddddddddddddddddddddddddddddddddd" + ex.getResponseBodyAsString());
                        break;
                    default:
                        //error bpm process
                        break;
                }
            }
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
                    token = tokenObj.get("access_token").getAsString();
                    break;
                default:
                    break;
            }
        }
    }

    protected static final String AES_KEY = "asdasda";
    protected static final String INIT_VECTOR = "sdasd";

    public SecuredContent getSecuredRequest(String unsecuredPayload) {
        SecuredContent sc = new SecuredContent();
        IvParameterSpec iv = null;
        SecretKeySpec skeySpec = null;
        sc.setIv(INIT_VECTOR);
        //generate aes key with iv
        try {
            iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            skeySpec = new SecretKeySpec(AES_KEY.getBytes("UTF-8"), "AES");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PaylocityAddressPublishService.class.getName()).log(Level.SEVERE, null, ex);
        }
        // encrypt payload with aes
        sc.setContent(Encryptor.encrypt(skeySpec, iv, unsecuredPayload));
        // encrypt aes key with public key.
        //populate secured content and return
        return sc;
    }

    public String securePayload(String unsecuredPayload) {
        return "";
    }
}
