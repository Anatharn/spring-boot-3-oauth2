package sds.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Public Controller that expose only public endpoints.
 * You should see these endpoint without any authentication
 *
 * @author Sébastien De Santis
 */
@RestController
public class ResourceServerPublicController {

    @GetMapping("/public")
    public String displayPublicMessage(){
        return "public message";
    }
}
