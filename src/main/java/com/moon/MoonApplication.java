package com.moon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class MoonApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(MoonApplication.class, args);
	}

	@Autowired
	MoonIntercebper moonIntercebper;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
				.addInterceptor(moonIntercebper).addPathPatterns("/api/**") //api 이하만 모두 포함
				.excludePathPatterns("/swagger-ui.html"); //스웨거는 제외
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
