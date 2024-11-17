package dev.astrx.productserviceapp.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for creating and configuring a RestTemplate bean.
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Creates and configures a RestTemplate bean.
     *
     * @return a configured RestTemplate instance
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
