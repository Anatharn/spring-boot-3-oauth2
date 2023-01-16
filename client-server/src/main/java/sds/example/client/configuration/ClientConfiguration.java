package sds.example.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Client server configuration
 *
 * @author Sébastien De Santis
 */
@Configuration
@EnableWebSecurity
public class ClientConfiguration {

    @Bean
    public SecurityFilterChain standardSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // @formatter:off
        httpSecurity
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET, "/public").permitAll()
                        .requestMatchers(HttpMethod.GET, "/public/*").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login();
        // @formatter:on

        return httpSecurity.build();
    }
}
