/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.init;

import info.chili.identity.jpa.CRole;
import info.chili.identity.jpa.CUser;
import info.chili.identity.repository.RoleRepository;
import info.chili.identity.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ayalamanchili
 */
@Controller
public class IdentityInit implements CommandLineRunner {

    protected static List<String> roles = Arrays.asList(new String[]{"ROLE_CHILI_ADMIN", "ROLE_ADMIN", "ROLE_USER"});
    protected static List<String> users = Arrays.asList(new String[]{"adminadmin", "useruser"});
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        roles.stream().forEach(role -> roleRepository.save(new CRole(role)));
        users.stream().forEach(username -> userRepository.save(new CUser(username, username)));
    }
}
