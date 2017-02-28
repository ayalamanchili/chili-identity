/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.jrs;

import info.chili.identity.dao.UserRepository;
import info.chili.identity.domain.CUser;
import info.chili.identity.dto.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phani.y
 */
@RestController
public class UsersResource {

    @Autowired
    protected UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(@RequestAttribute("start") Integer start, @RequestAttribute("limit") Integer limit) {
        List<User> users = new ArrayList<>();
        for (CUser cuser : userRepository.findAll(new PageRequest(start, limit))) {
            User user = new User(cuser.getUserId(), cuser.getUsername(), cuser.isEnabled(), cuser.isLocked());
            users.add(user);
        }
        return users;
    }
}
