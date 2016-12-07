/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.client;

import info.chili.identity.jpa.CUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ayalamanchili
 */
@RestController("/identity/user/")
public class IdentityClientResource {

    protected IdentityClient identityClient;

    //constructor
    public IdentityClientResource(IdentityClient identityClient) {
        this.identityClient = identityClient;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CUser createUser(@RequestBody CUser user) {
        return identityClient.createUser(user);
    }
}
