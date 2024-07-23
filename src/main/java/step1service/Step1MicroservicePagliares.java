package step1service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * - Don’t annotate an entry-point Step1MicroservicePagliares class with
 * @EnableEurekaClient - This annotation was removed in spring cloud 2022.0.0
 * and provided auto-configuration.
 *
 * @EnableEurekaClient
 */
@SpringBootApplication
public class Step1MicroservicePagliares {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(Step1MicroservicePagliares.class, args);
	}

}
