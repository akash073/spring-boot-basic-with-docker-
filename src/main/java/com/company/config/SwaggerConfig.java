package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Ui  api")
                .description("Please check the documents.")
                .license("01719461643")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("Syed Mhamudul Hasan", "http://akash365.com/", "akash073@gmail.com"))
                .build();
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Authorization")
                                .description("Eg. Bearer token")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.controller"))

                //.paths(regex("/product.*"))

                .build()
                .enable(true)
                .apiInfo(apiInfo());

                //.apiInfo(metaData());
    }
}
