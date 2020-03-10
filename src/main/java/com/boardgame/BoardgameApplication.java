package com.boardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

@Import({ BeanValidatorPluginsConfiguration.class})
@SpringBootApplication
public class BoardgameApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BoardgameApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BoardgameApplication.class);
	}

}
