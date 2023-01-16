package sds.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Client Server for Oauth2 application
 *
 * @author Sébastien De Santis
 */
@SpringBootApplication
public class ClientServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientServerApplication.class, args);
    }
}