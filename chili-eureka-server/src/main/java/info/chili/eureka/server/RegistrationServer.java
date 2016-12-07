/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author ayalamanchili
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {
 
    public static void main(String[] args) {
        SpringApplication.run(RegistrationServer.class, args);
    }
}