package sds.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that expose only private endpoint.
 * Access to JWT is needed here
 *
 * @author Sébastien De Santis
 */
@RestController
public class ResourceServerPrivateController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getSubject());
    }

    @GetMapping("/message")
    public String message() {
        return "secret message";
    }
}
