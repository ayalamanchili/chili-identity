/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ayalamanchili
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class IdentityClientServer {

    public static final String SERVICE_URL = "http://CHILI-IDENTITY-SERVICE";

    public static void main(String[] args) {
        SpringApplication.run(IdentityClientServer.class, args);
    }

    //A customized RestTemplate that has the ribbon load balancer build in
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // The service encapsulates the interaction with the micro-service.
    @Bean
    public IdentityClient identityClient() {
        return new IdentityClient(SERVICE_URL);
    }

    @Bean
    public IdentityClientResource identityClientResource() {
        return new IdentityClientResource(identityClient());
    }

}
