package org.epita.tpfacture.exposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan(basePackages = {"org.epita.tpfacture"})
@EnableWebSecurity
public class Run {

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);

	}

}
