package com.iteye.wwwcomy.webdiary2;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class Swagger3Configration {
	@Value("${swagger3.enable:false}")
	private Boolean enable;
	@Value("${swagger3.title}")
	private String title;
	@Value("${swagger3.description}")
	private String description;
	@Value("${swagger3.authHeaderKey:token}")
	private String authHeaderKey;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.OAS_30).enable(enable).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.iteye.wwwcomy.webdiary2.controller"))
				.paths(PathSelectors.any()).build().securitySchemes(securitySchemes());
	}

	private List<SecurityScheme> securitySchemes() {
		ApiKey apiKey = new ApiKey(authHeaderKey, authHeaderKey, In.HEADER.toValue());
		return Collections.singletonList(apiKey);
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("wwwcomy", "", "wwwcomy@gmail.com");
		return new ApiInfoBuilder().title(title).description(description).version("1.0").contact(contact).build();
	}
}
