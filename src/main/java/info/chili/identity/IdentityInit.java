/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity;

import info.chili.identity.dao.RoleRepository;
import info.chili.identity.dao.UserRepository;
import info.chili.identity.domain.CRole;
import info.chili.identity.domain.CUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 *
 * @author phani.y
 */
@Controller
public class IdentityInit implements CommandLineRunner {

    protected final String ADMIN_ROLE = "ROLE_ADMIN";
    protected final String USER_ROLE = "ROLE_USER";
    protected final String CHILI_ADMIN_ROLE = "ROLE_CHILI_ADMIN";

    protected final String ADMIN = "adminadmin";
    protected final String USER = "useruser";

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        CRole adminRole = roleRepository.save(new CRole(ADMIN_ROLE));
        CRole userRole = roleRepository.save(new CRole(USER_ROLE));
        CRole chiliAdminRole = roleRepository.save(new CRole(CHILI_ADMIN_ROLE));

        CUser adminUser = new CUser(ADMIN, ADMIN, true, adminRole, userRole, chiliAdminRole);
        userRepository.save(adminUser);

        CUser userUser = new CUser(USER, USER, true, userRole);
        userRepository.save(userUser);
    }
}
