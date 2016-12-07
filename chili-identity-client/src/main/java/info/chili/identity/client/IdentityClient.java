/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.client;

import info.chili.identity.jpa.CUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ayalamanchili
 */
@Service
public class IdentityClient {

    @Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public IdentityClient(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    //invoke to greeting-service and return a Greeting object
    public CUser createUser(CUser user) {
        return restTemplate.postForEntity(serviceUrl + "/identity/user", user, CUser.class).getBody();
    }
}
