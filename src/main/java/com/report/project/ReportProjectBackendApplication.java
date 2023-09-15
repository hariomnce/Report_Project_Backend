package com.report.project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition
		(info = @Info(
				version = "2.0",
				license = @License(name = "Apache 2.0"),
				contact = @Contact(url = "https://www.abc.com/")
		))
public class ReportProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportProjectBackendApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET","PUT","POST","PATCH","DELETE","OPTIONS");
			}
		};
	}

}
