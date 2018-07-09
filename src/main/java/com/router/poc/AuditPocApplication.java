package com.router.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author 617150
 *
 */
//@SpringBootApplication(scanBasePackages="com.router.poc")
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories("com.router.poc.repo")
@ImportResource("classpath:camel-route-spring.xml")
public class AuditPocApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(AuditPocApplication.class, args);
	}
}
