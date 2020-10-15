package poc.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
	
	@Primary
	@Bean
	public Person defaultPerson() {
		return new Person(3, "DP");
	}
}
