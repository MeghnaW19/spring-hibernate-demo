package com.stackroute.springdao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//dispatcher-servlet.xml
@Configuration
@EnableWebMvc
/*Adding this annotation to a @Configuration class imports the Spring MVC configuration 
 * from WebMvcConfigurationSupport which is the main 
 * class providing the configuration behind the MVC Java config.
 * 
 * 
 * If you don't use this annotation you might not initially notice any 
 * difference but things like content-type 
 * and accept header, generally content negotiation won't work
 * 
 */
@ComponentScan(basePackages="com.stackroute.springdao")
public class WebMVCConfig implements WebMvcConfigurer  {
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	

}
