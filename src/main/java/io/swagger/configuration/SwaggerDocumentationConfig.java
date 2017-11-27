package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("X100 API Core")
            .description("This document provides overview of the functionalities x100 API (Application Programming Interface). It clearly spells out the various methods listed below with their request and response in JSON. # Introduction This API is documented in **OpenAPI format** and is based on specification available on X100 provided by [unionsg.com](http://unionsg.com) team. This API documentation is provided upon the basis that the above institution has provided access and authorization of use.  # Authentication X-API offers this forms of authentication:   A successful registration requires a **static IP** from the user as well as   a generated unique **API_KEY** and **API_SECRET** from the server. The unique keys   are sent with every subsequent request from the header. And core(api) would only accept   such keys from the registered Static IP in the system.   - API Key - API Secret created from the server  - API SECRET - API Secret created from the server <!-- ReDoc-Inject: <security-definitions> -->")
            .license("UNION SG")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("","", "philip.nunoo@unionsg.com"))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                    .build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}
