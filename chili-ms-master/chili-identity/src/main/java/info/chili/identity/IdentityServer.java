/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 *
 * @author ayalamanchili
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(IdentityConfiguration.class)
@SpringBootApplication
public class IdentityServer {

    public static void main(String[] args) {
        SpringApplication.run(IdentityServer.class, args);
    }
}
