/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @author phani
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServer {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServer.class, args);
    }
}
