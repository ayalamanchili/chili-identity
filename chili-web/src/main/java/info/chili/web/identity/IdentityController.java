/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.web.identity;

import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author phani
 */
@Controller
public class IdentityController {

    @Autowired
    protected RestTemplate restTemplate;

    @GetMapping("/identity")
    String identity(Model model) {
        JsonArray users = restTemplate.getForObject("http://localhost:8080/api/identity/users", JsonArray.class);
        System.out.println("ddddddddddddddd" + users);
        model.addAttribute("users", users);
        return "identity";
    }
}
