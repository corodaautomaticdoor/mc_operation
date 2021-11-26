package com.coroda.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class DocumentationWithSwagger {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build()
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfo("MICROSERVICIO OPERATION", "Microservicio desarrollado para Administrar las Cotizaciones y Ventas",
				"1.0", "Terms of Service", "", "Apache License Version 2.0", "https://www.apache.org"

		);

		return apiInfo;
	}
}
