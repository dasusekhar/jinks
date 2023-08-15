package com.example.CrudeApplication;

import com.example.CrudeApplication.entity.MyBean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@OpenAPIDefinition
@ComponentScan
public class CrudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudeApplication.class, args);
	}





}
