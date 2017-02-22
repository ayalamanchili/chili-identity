/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 * @author ayalamanchili
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigurationServer {
    
    public static void main(String[] args) {
		SpringApplication.run(ConfigurationServer.class, args);
	}
}
