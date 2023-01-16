package sds.example.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class PublicController {

    @GetMapping("/public")
    public String displayPublicPage(){
        return "public";
    }

    @GetMapping("/public/resource")
    public String getResourcePublic(Model model){
        RestTemplate restTemplate = new RestTemplate();
        var resp = restTemplate.getForObject("http://localhost:8090/public", String.class);
        model.addAttribute("resourceResponse", resp);
        return "public";
    }
}
