package br.com.peoplemanagement.config.swagger;

import br.com.peoplemanagement.config.properties.ConfigProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@AllArgsConstructor
public class SwaggerConfig {

    private final ConfigProperties configProperties;

    @Bean
    public Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.people-management"))
            .paths(regex("/.*"))
            .build()
            .useDefaultResponseMessages(false)
            .pathMapping(configProperties.getContextPath())
            .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
            .title("Gerenciamento pessoa")
            .description("Serviço gerenciamento pessoa")
            .version("v1")
            .contact(this.contact())
            .build();
    }

    private Contact contact() {
        return new Contact(
            "Emerson Lourenzi",
            "https://github.com/emersonlourenzi/people-management",
            "emersonl.lourenzi@gmail.com");
    }

}
