package br.com.peoplemanagement.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ConfigProperties {

    @Value("${spring.application.name}")
    private String contextPath;

}
