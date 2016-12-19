/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.resource;

import info.chili.identity.jpa.CUser;
import info.chili.identity.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ayalamanchili
 */
@RestController("/identity/users/")
public class IdentityResource {

    @Autowired
    protected UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public CUser createUser(@RequestBody CUser user) {
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CUser> getUsers() {
        return userRepository.findAll();
    }
}
