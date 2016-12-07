/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author ayalamanchili
 */
@Configuration
@ComponentScan
@EntityScan("info.chili.identity.jpa")
@EnableJpaRepositories("info.chili.identity.repository")
@PropertySource("classpath:db-config.properties")
public class IdentityConfiguration {

}
