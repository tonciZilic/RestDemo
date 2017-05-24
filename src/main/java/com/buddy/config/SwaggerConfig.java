package com.buddy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;


@Configuration
@EnableSwagger
public class SwaggerConfig
{
private SpringSwaggerConfig springSwaggerConfig;

@Autowired
public void setSpringSwaggerConfig( SpringSwaggerConfig springSwaggerConfig )
{
	this.springSwaggerConfig = springSwaggerConfig;
}

@Bean //Don't forget the @Bean annotation
public SwaggerSpringMvcPlugin customImplementation()
{
	return new SwaggerSpringMvcPlugin( this.springSwaggerConfig )
			.apiInfo( apiInfo() )
			.includePatterns( ".*api.*" );
}

private ApiInfo apiInfo()
{
	ApiInfo apiInfo = new ApiInfo(
			"Title",
			"My Apps API Description",
			"My Apps API terms of service",
			"myemail@example.com",
			"My Apps API Licence Type",
			"My Apps API License URL"
	);
	return apiInfo;
}



/************** working config *************************/
	/* 
	@Configuration
	@EnableSwagger
	public class SwaggerConfig {
	 
	 private SpringSwaggerConfig springSwaggerConfig;
	  
	 @Autowired
	 public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
	  this.springSwaggerConfig = springSwaggerConfig;
	 }
	  
	 @Bean
	 public SwaggerSpringMvcPlugin swaggerSpringMvcPluginFactory() {
	  ApiInfo apiInfo = new ApiInfo("Spring RESTful Greeting Service with Swagger integration", "", "", "", "", "");
	  return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo).includePatterns("/.*");
	 }*/
}