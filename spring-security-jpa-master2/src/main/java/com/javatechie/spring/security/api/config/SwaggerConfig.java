package com.javatechie.spring.security.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
	  ParameterBuilder aParameterBuilder = new ParameterBuilder();
      aParameterBuilder.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
      List<Parameter> aParameters = new ArrayList<Parameter>();
      aParameters.add(aParameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.mediApiInfo()).globalOperationParameters(aParameters).select()
				.apis(RequestHandlerSelectors.basePackage("com.medi.web.controller")).paths(PathSelectors.any())
				.build();
  }
  
  private ApiInfo mediApiInfo() {
		return new ApiInfoBuilder().title("Medicare Service API").description("Provides Application Services").license("")
				.licenseUrl("").termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("", "", "")).build();
	}
}