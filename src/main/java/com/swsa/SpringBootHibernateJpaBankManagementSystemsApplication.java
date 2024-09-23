package com.swsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootHibernateJpaBankManagementSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateJpaBankManagementSystemsApplication.class, args);
	}

}
