package info.chili.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(messageConverter);
        RestTemplate template = builder.build();
        template.setMessageConverters(messageConverters);
        return template;
    }
}
