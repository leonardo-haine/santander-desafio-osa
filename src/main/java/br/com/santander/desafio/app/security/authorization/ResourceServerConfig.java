package br.com.santander.desafio.app.security.authorization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
    	.csrf(csrf      ->          csrf.ignoringRequestMatchers("/h2-console/**").ignoringRequestMatchers("/actuator/**")
                )
                .headers(headers -> headers
                    .frameOptions(frame -> frame
                        .disable()
                    )
                );

    	
        http
            .authorizeHttpRequests(authorize -> authorize
            		.requestMatchers("/h2-console/**").permitAll()
            		.requestMatchers("/actuator/**").permitAll()
            	.requestMatchers("/desafio/**").authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
    
}
