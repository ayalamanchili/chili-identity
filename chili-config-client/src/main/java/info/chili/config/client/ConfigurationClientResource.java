/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ayalamanchili
 */
@RefreshScope
@RestController
public class ConfigurationClientResource {

    @Autowired
    private Environment environment;

    @Value("${property.1:failed!}")
    String property1;

    @RequestMapping("/")
    public String query(@RequestParam("key") String key) {
        return environment.getProperty(key);
    }
}
