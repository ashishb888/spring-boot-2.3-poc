package poc.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import poc.springboot.domain.Person;

@Configuration
public class BeansConfig {

	@Bean
	public Person abPerson() {
		return new Person(1, "AB");
	}

	@Bean
	public Person sbPerson() {
		return new Person(2, "SB");
	}
}
