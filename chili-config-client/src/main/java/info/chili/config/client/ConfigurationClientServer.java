/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ayalamanchili
 */
@SpringBootApplication
public class ConfigurationClientServer {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationClientServer.class, args);
    }
}
