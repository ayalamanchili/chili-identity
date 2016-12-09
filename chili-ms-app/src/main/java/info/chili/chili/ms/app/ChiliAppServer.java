/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.chili.ms.app;

import info.chili.eureka.server.RegistrationServer;
import info.chili.identity.IdentityServer;
import info.chili.identity.client.IdentityClientServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author ayalamanchili
 */
@SpringBootApplication
public class ChiliAppServer {

    public static void main(String... args) {
        RegistrationServer.main(args);
        IdentityServer.main(args);
        IdentityClientServer.main(args);
    }
}
