package sds.example.client.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class PrivateController {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    @GetMapping("/private")
    public String displayPrivatePage(){
        return "private";
    }

    @GetMapping("/private/resource")
    public String displayPrivatePageWithResource(Model model,
                                                 @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient){
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();
        var token = authorizedClient.getAccessToken().getTokenValue();
        headers.add(AUTHORIZATION_HEADER, "Bearer " + token);
        var entity = new HttpEntity<>("", headers);

        var resp = restTemplate.exchange("http://localhost:8090/message", HttpMethod.GET, entity, String.class);
        model.addAttribute("resourceResponse", resp.getBody());

        return "private";
    }
}
