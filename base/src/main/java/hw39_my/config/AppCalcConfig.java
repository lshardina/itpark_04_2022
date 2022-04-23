package hw39_my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppCalcConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
p