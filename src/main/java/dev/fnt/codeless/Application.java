package dev.fnt.codeless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "dev.fnt.codeless.persist.entity")
@EnableJpaRepositories(basePackages = "dev.fnt.codeless.persist.repo")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}