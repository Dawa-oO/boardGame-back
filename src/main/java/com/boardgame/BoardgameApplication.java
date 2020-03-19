package com.boardgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

@Import({ BeanValidatorPluginsConfiguration.class})
@SpringBootApplication
public class BoardgameApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(BoardgameApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("uploadDirectory=" + env.getProperty("picture.path"));
		registry.addResourceHandler("/**").addResourceLocations("file:" + env.getProperty("picture.path"));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BoardgameApplication.class);
	}

}
